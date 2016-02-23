package com.backbone;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {
	private static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(false);
		app.setBanner(new Banner() {
			
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass,
					PrintStream out) {
				out.append("wooo~ such doge~ \n")
				   .append("░░░░░░░░▌▒█░░░░░░░░░░░▄▀▌ \n")
				   .append("░░░░░░░░▌▒▒█░░░░░░░░▄▀▒▒▒▌ \n")
				   .append("░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▌ \n")
				   .append("░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒   ▌ \n")
				   .append("░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌ \n")
				   .append("░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒▌ \n")
				   .append("░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▌ \n")
				   .append("░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄ \n")
				   .append("░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒▌\n")
				   .append("▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▌ \n");				
			}
		});
		ConfigurableApplicationContext ctx = app.run(args);
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				ctx.close();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					logger.error("context close interrupted {}",e);
				}
			}
		});
	}
}
