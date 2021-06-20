package com.example.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/** Класс конфигурации приложения
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Configuration
@ComponentScan("com.example.hibernate")
public class Config {

    /** При старте приложения инициализируем entityManager через Factory */
    @Bean
    public EntityManager entityManager() {
        EntityManagerFactory factory = new org.hibernate.cfg.Configuration()
                .configure("mysql.cfg.xml")
                .buildSessionFactory();
        return factory.createEntityManager();
    }
}
