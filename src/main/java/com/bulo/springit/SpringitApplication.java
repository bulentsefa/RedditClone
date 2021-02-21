package com.bulo.springit;

import com.bulo.springit.config.SpringitProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    @Autowired
    private ApplicationContext applicationContext;
    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("Printing out all the bean names in the application context.");
            System.out.println("----------------------------------------------------");
            String[] beans = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beans);

            for(String bean: beans){

            }

            log.error("CommandLineRunner.run();");
            log.warn("CommandLineRunner.run();");
            log.info("CommandLineRunner.run();");
            log.debug("CommandLineRunner.run();");
            log.trace("CommandLineRunner.run();");
        };
    }
}
