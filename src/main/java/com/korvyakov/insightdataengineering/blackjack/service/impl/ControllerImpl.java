package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.domain.Output;
import com.korvyakov.insightdataengineering.blackjack.service.ConsoleEngine;
import com.korvyakov.insightdataengineering.blackjack.service.Controller;
import com.korvyakov.insightdataengineering.blackjack.service.GameService;
import com.korvyakov.insightdataengineering.blackjack.service.TemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class ControllerImpl implements Controller {

	private static final String MISTYPE_TEMPLATE = "You entered '%s' Please enter %s";

    @Autowired private GameService gameService;
    @Autowired private ConsoleEngine consoleEngine;
    @Autowired private TemplateEngine templateEngine;

    private Output currentOutput;

    @Override public void start() {
        currentOutput = gameService.newGame();
        String print = templateEngine.render(currentOutput.getTemplate(), currentOutput.getTemplateModel());
        consoleEngine.print(print, false);
    }

    @Override public void input(String input) {
        boolean matches;
        boolean number = false;
        if (currentOutput.getExpect().isNumber()) {
            try {
                int inputNumber = Integer.parseInt(input);
                number = true;
                matches = (inputNumber >= currentOutput.getExpect().getNumberMin()
                        && inputNumber <= currentOutput.getExpect().getNumberMax());
            } catch(NumberFormatException e) {
                matches = false;
            }
        } else {
            matches = input.matches(currentOutput.getExpect().getRegexp());
        }
        if (matches) {
            currentOutput = gameService.action(number? Integer.parseInt(input): input);
        } else {
            String mistype = String.format(MISTYPE_TEMPLATE, input, currentOutput.getExpect().getPrompt());
            currentOutput.getTemplateModel().put("mistype", mistype);
        }
        String print = templateEngine.render(currentOutput.getTemplate(), currentOutput.getTemplateModel());
        consoleEngine.print(print, currentOutput.isExit());
    }

    /**
     * For usage is unit tests only
     * @param currentOutput current output
     */
    public void setCurrentOutput(Output currentOutput) {
        this.currentOutput = currentOutput;
    }
}
