package com.korvyakov.insightdataengineering.blackjack;

import com.korvyakov.insightdataengineering.blackjack.domain.Expect;
import com.korvyakov.insightdataengineering.blackjack.domain.Output;
import com.korvyakov.insightdataengineering.blackjack.service.ConsoleEngine;
import com.korvyakov.insightdataengineering.blackjack.service.Controller;
import com.korvyakov.insightdataengineering.blackjack.service.GameService;
import com.korvyakov.insightdataengineering.blackjack.service.TemplateEngine;
import com.korvyakov.insightdataengineering.blackjack.service.impl.ControllerImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * @author nailgun
 * @since 17.07.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class ControllerTests {

    @Autowired
    @InjectMocks
    private Controller controller;

    @Mock private GameService gameService;
    @Mock private ConsoleEngine consoleEngine;
    @Mock private TemplateEngine templateEngine;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void newGameTest() {
        Map<String, Object> expectMap = new HashMap<>();
        String templateName = "testTemplate";
        String expectedPrint = "print";
        boolean isExit = false;

        when(gameService.newGame()).thenReturn(new Output(templateName, expectMap, null, isExit));
        when(templateEngine.render(templateName, expectMap)).thenReturn(expectedPrint);

        controller.start();

        verify(templateEngine).render(templateName, expectMap);
        verify(consoleEngine).print(expectedPrint, isExit);
    }

    @Test
    public void stringValidationTest() {
        String description = "Description";
        String mistype = "mistype";
        Expect expect = Expect.expectOptions(description, "a", "b");
        Map<String, Object> model = new HashMap<>();
        Output output = new Output("testTemplate", model, expect, false);

        when(gameService.action("a")).thenReturn(output);

        ((ControllerImpl) controller).setCurrentOutput(output);
        controller.input("c");
        Assert.assertNotNull(model.get(mistype));
        model.remove(mistype);
        controller.input("a");
        Assert.assertNull(model.get(mistype));
        verify(gameService).action("a");
    }

    @Test
    public void intValidationTest() {
        String description = "Description";
        String mistype = "mistype";
        Expect expect = Expect.expectNumber(description, 2, 10);
        Map<String, Object> model = new HashMap<>();
        Output output = new Output("testTemplate", model, expect, false);

        when(gameService.action(2)).thenReturn(output);

        ((ControllerImpl) controller).setCurrentOutput(output);
        controller.input("a");
        Assert.assertNotNull(model.get(mistype));
        model.remove(mistype);
        controller.input("1");
        Assert.assertNotNull(model.get(mistype));
        model.remove(mistype);
        controller.input("2");
        Assert.assertNull(model.get(mistype));

        verify(gameService).action(2);
    }

}
