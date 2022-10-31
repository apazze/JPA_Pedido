package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class JpaClientePedidoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaClientePedidoApplication.class, args);
    }

}
