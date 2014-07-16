package com.korvyakov.insightdataengineering.blackjack;

import com.korvyakov.insightdataengineering.blackjack.service.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameApp {

	/**
	 * Application entry point
	 * @param args command line arguments
	 */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.start();
    }

}
