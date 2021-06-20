package com.example.hibernate.model;

import java.util.List;

/** Интерфейс для репозитория продуктов
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
public interface ProductRepository {

    /** Метод, возвращающий конкретный продукт по его ID */
    public Product findById(Long id);

    /** Метод, возвращающий все данные из таблицы продуктов */
    public List<Product> findAll();

    /** Метод, удаляющий продукт из БД по его ID */
    public void deleteById(Long id);

    /** Метод, сохраняющий новый продукт в БД */
    public void save(Product product);
}
