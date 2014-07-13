package com.korvyakov.insightdataengineering.blackjack;

import com.korvyakov.insightdataengineering.blackjack.controller.Controller;
import jline.console.ConsoleReader;
import jline.console.completer.Completer;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.*;

public class GameApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.start();
        /*HelloService helloService = context.getBean(HelloService.class);
        AnsiConsole.systemInstall();
        int terminalWidth = jline.TerminalFactory.get().getWidth();
        int terminalHeight = jline.TerminalFactory.get().getHeight();
        System.out.println(ansi().eraseScreen().render(helloService.sayHello()
            + " " + terminalWidth + " " + terminalHeight));*/
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userName = null;

        try {
            userName = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read your name!");
            System.exit(1);
        }*/
//        Scanner in = new Scanner(System.in);
//
//        String y = in.next("y");
//
//        System.out.println("Thanks for the " + y);

        /*ConsoleReader reader = null;
        try {
            reader = new ConsoleReader();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }*/

    }
}
