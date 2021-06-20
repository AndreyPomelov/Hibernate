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
public class CustomerRepositoryImpl implements CustomerRepository {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /** Метод возвращающий все продукты по ID покупателя */
    public List<String> findAllProductsByCustomerId(Long id) {
        entityManager.getTransaction().begin();
        List<String> list = entityManager.createNativeQuery("select title from products as pr " +
                "join products_carts as pc on pr.id = pc.product_id " +
                "join carts as ca on pc.cart_id = ca.id " +
                "join customers as cu on ca.customer_id = cu.id " +
                "where cu.id = " + id + ";").getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    @Override
    public Customer findById(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        list = entityManager.createQuery("From Customer").getResultList();
        return list;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }

    @Override
    public void save(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }
}
