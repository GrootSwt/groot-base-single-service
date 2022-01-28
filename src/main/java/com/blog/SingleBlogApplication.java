package com.blog;

import com.groot.base.log.annotation.EnableAuditLog;
import com.groot.base.web.annotation.EnableBaseWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableBaseWeb
@EnableAuditLog
public class SingleBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SingleBlogApplication.class, args);
    }

}
