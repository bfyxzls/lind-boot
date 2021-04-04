package com.lind.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Exrickx
 */
@SpringBootApplication
//启用缓存
@EnableCaching
//启用异步
@EnableAsync
public class LindBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(LindBootApplication.class, args);
    }

}
