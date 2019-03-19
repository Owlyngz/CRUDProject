package com.myproject.webshop;

import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages={"com.service.something","com.service.application"})
//@ComponentScan({"com.myproject.webshop"})
//@EntityScan("com.myproject.webshop")
//@EnableJpaRepositories("com.myproject.webshop")
@EnableTransactionManagement

//public class com.myproject.webshop.WebshopApplication extends SpringBootServletInitializer
public class WebshopApplication  {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}

}
