package com.example.hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("com.example.hibernate")
public class Config {

    private EntityManagerFactory factory;

    /** При старте приложения инициализируем entityManager через Factory */
    @Bean
    public EntityManagerFactory factory() {
        factory = new org.hibernate.cfg.Configuration()
                .configure("mysql.cfg.xml")
                .buildSessionFactory();
        return factory;
    }

    @Bean
    public EntityManager entityManager() {
        EntityManager entityManager = factory.createEntityManager();
        return entityManager;
    }
}
