package com.example.hibernate.model;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/** Класс, реализующий взаимодействие с БД
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private final EntityManager entityManager;

    public ProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /** Метод, возвращающий всех покупателей, купивших этот товар по его ID */
    public List<String> findAllCustomersByProductId(Long id) {
        entityManager.getTransaction().begin();
        List<String> list = entityManager.createNativeQuery("select name from customers as cu " +
                "join carts as ca on cu.id = ca.customer_id " +
                "join products_carts as pc on ca.id = pc.cart_id " +
                "join products as pr on pc.product_id = pr.id " +
                "where pr.id = " + id + ";").getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

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
