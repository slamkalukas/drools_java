package com.sctrcd.buspassws;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DecisionApp {

	private static Logger log = LoggerFactory.getLogger(DecisionApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DecisionApp.class, args);

    }

    @Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

}
