package com.ll.mango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ll.mango.admin"})
public class MangoAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

}
