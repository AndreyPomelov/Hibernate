package com.example.hibernate.model;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/** Класс, автоматически тестирующий методы класса ProductRepository
 * при старте приложения. К непосредственной работе приложения
 * отношения не имеет, подлежит удалению.
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 * @see ProductRepository
 */
@Component
public class Test {

    /** Ссылка на класс, реализующий взаимодействие с БД */
    private final ProductRepository repository;

    /** Конструктор
     *
     * @param repository ссылка на класс, реализующий взаимодействие с БД
     */
    public Test(ProductRepository repository) {
        this.repository = repository;
    }

    /** Метод, автоматически вызываемый при старте приложения
     * и тестирующий методы класса, реализующиего взаимодействие с БД
     */
    @PostConstruct
    public void test() {

        // Тестируем метод findById
        Product product = repository.findById(1L);
        System.out.println(product.getId() + " " + product.getTitle() + " " + product.getPrice());

        // Тестируем метод findAll
        List<Product> list = repository.findAll();
        list.forEach(x -> System.out.println(x.getId() + " " + x.getTitle() + " " + x.getPrice()));

        // Тестируем метод deleteById
        repository.deleteById(4L);

        // Тестируем метод save
        Product product1 = new Product();
        product1.setTitle("Honda Accord");
        product1.setPrice(1900000);
        repository.save(product1);
    }
}
