package com.example.hibernate.model;

import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

/** Класс, реализующий взаимодействие с БД
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Repository
public class ProductRepository {

    /** При старте приложения инициализируем entityManager через Factory */
    EntityManagerFactory factory = new Configuration()
            .configure("mysql.cfg.xml")
            .buildSessionFactory();
    EntityManager entityManager = factory.createEntityManager();

    /** Метод, возвращающий конкретный продукт по его ID */
    public Product findById(Long id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();
        return product;
    }

    /** Метод, возвращающий все данные из БД */
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        list = entityManager.createQuery("From Product").getResultList();
        return list;
    }

    /** Метод, удаляющий продукт из БД по его ID */
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
    }

    /** Метод, сохраняющий новый продукт в БД */
    public void save(Product product) {
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }
}
