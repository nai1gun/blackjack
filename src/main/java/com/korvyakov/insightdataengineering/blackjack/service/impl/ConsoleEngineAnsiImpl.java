package com.korvyakov.insightdataengineering.blackjack.service.impl;

import com.korvyakov.insightdataengineering.blackjack.service.Controller;
import com.korvyakov.insightdataengineering.blackjack.service.ConsoleEngine;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * @author nailgun
 * @since 12.07.14
 */
@Component
public class ConsoleEngineAnsiImpl implements ConsoleEngine {

    @Autowired private Controller controller;
	@Autowired private PrintStream printStream;
    @Autowired private Scanner scanner;

	public ConsoleEngineAnsiImpl() {
		AnsiConsole.systemInstall();
	}

    @Override public void print(String output, boolean exit) {
	    printStream.println(ansi().eraseScreen().render(output));
        if (exit) {
            System.exit(0);
        }
        String input = scanner.nextLine();
        controller.input(input);
    }

}
