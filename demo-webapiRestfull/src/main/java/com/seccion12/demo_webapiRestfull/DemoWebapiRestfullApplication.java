package com.seccion12.demo_webapiRestfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:message.properties")
public class DemoWebapiRestfullApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebapiRestfullApplication.class, args);
	}

}
