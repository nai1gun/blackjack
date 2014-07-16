package com.korvyakov.insightdataengineering.blackjack;

import com.korvyakov.insightdataengineering.blackjack.domain.ShuffleResult;
import com.korvyakov.insightdataengineering.blackjack.service.GameContext;
import com.korvyakov.insightdataengineering.blackjack.service.Shoe;
import com.korvyakov.insightdataengineering.blackjack.service.stage.DealStage;
import com.korvyakov.insightdataengineering.blackjack.service.stage.NewGameStartStage;
import com.korvyakov.insightdataengineering.blackjack.service.stage.NextGameStartStage;
import com.korvyakov.insightdataengineering.blackjack.service.stage.Stage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * @author nailgun
 * @since 17.07.14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class StageTests {

    @Autowired
    @InjectMocks
    private NewGameStartStage newGameStartStage;

    @Autowired
    @InjectMocks
    private DealStage dealStage;

    @Mock private Shoe shoe;
    @Mock private GameContext gameContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void playerBlackjackTest() {
        when(gameContext.getTotalChips()).thenReturn(100);
        when(gameContext.getBet()).thenReturn(60);
        when(gameContext.isPlayerBlackjack()).thenReturn(true);
        when(gameContext.isDealerBlackjack()).thenReturn(false);

        Stage stage = newGameStartStage.action("d");

        Assert.assertTrue(stage instanceof NextGameStartStage);
        verify(gameContext).setTotalChips(40);
        verify(gameContext).isDealerBlackjack();
        verify(gameContext).isPlayerBlackjack();
        verify(gameContext).setTotalChips(220);
    }

    @Test
    public void playerwinsTest() {
        when(gameContext.getTotalChips()).thenReturn(100);
        when(gameContext.getBet()).thenReturn(40);
        when(gameContext.isPlayerBusted()).thenReturn(false);
        when(gameContext.getDealerPoints()).thenReturn(18);
        when(gameContext.getPlayerPoints()).thenReturn(19);
        when(gameContext.getShuffleResult()).thenReturn(ShuffleResult.WIN);

        Stage stage = dealStage.action("s");

        Assert.assertTrue(stage instanceof NextGameStartStage);
        verify(gameContext).setTotalChips(180);
    }

}
