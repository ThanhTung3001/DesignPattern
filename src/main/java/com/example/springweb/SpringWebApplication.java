package com.example.springweb;

import com.example.springweb.Service.imp.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebApplication {

    @Autowired
    private BillService billService;
    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }

}
