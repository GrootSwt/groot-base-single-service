package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SingleBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleBlogApplication.class, args);
    }

}
