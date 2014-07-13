package com.korvyakov.insightdataengineering.blackjack.controller;

import com.korvyakov.insightdataengineering.blackjack.domain.Output;
import com.korvyakov.insightdataengineering.blackjack.service.ConsoleEngine;
import com.korvyakov.insightdataengineering.blackjack.service.GameService;
import com.korvyakov.insightdataengineering.blackjack.template.TemplateEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author nailgun
 * @since 13.07.14
 */
@Component
public class Controller {

    @Autowired private GameService gameService;
    @Autowired private ConsoleEngine consoleEngine;
    @Autowired private TemplateEngine templateEngine;

    private Output currentOutput;

    public void start() {
        currentOutput = gameService.newGame();
        String print = templateEngine.render(currentOutput.getTemplate(), currentOutput.getTemplateModel());
        consoleEngine.print(print, false);
    }

    public void input(String input) {
        boolean matches;
        boolean number = false;
        if (currentOutput.getExpect().isNumber()) {
            try {
                int inputNumber = Integer.parseInt(input);
                number = true;
                matches = (inputNumber >= currentOutput.getExpect().getNumberMin() && inputNumber <= currentOutput.getExpect().getNumberMax());
            } catch(NumberFormatException e) {
                matches = false;
            }
        } else {
            matches = input.matches(currentOutput.getExpect().getRegexp());
        }
        if (matches) {
            currentOutput = gameService.action(number? Integer.parseInt(input): input);
        } else {
            String mistype = String.format("You entered '%s' Please enter %s",
                    input, currentOutput.getExpect().getPrompt());
            currentOutput.getTemplateModel().put("mistype", mistype);
        }
        String print = templateEngine.render(currentOutput.getTemplate(), currentOutput.getTemplateModel());
        consoleEngine.print(print, currentOutput.isExit());
    }


}
