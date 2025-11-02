package com.finplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * FinPlus - Financial Pulse Monitor
 * 
 * Мультибанковское приложение для управления личными финансами
 * с проактивным мониторингом финансового здоровья.
 * 
 * @author FinPlus Team
 * @version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class FinPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinPlusApplication.class, args);
    }
}

