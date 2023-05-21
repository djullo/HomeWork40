package com.ua.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainDemoApplication.class, args);

        DataInitializer dataInitializer = SpringApplication
                .run(MainDemoApplication.class, args)
                .getBean(DataInitializer.class);

        dataInitializer.init();
    }
}