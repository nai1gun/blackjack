package com.korvyakov.insightdataengineering.blackjack.service;

import com.korvyakov.insightdataengineering.blackjack.controller.Controller;
import jline.console.ConsoleReader;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * @author nailgun
 * @since 12.07.14
 */
@Component
public class ConsoleEngine {

    @Autowired private Controller controller;
	@Autowired private PrintStream printStream;

	public ConsoleEngine() {
		AnsiConsole.systemInstall();
		//TODO: check 'chcp'
	}

    public void print(String output, boolean exit) {
	    printStream.println(ansi().eraseScreen().render(output));
        if (exit) {
            System.exit(0);
        }
        ConsoleReader reader;
        try {
            reader = new ConsoleReader();
            String input = reader.readLine();
            controller.input(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
