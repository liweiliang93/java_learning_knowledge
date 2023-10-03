package com.itweiiliang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisplusDemoApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(MybatisplusDemoApplication.class, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
