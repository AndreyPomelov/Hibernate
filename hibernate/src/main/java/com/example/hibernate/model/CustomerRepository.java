package com.example.hibernate.model;

import java.util.List;

/** Интерфейс для репозитория покупателей
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 */
public interface CustomerRepository {

    /** Метод, возвращающий конкретного пользователя по его ID */
    public Customer findById(Long id);

    /** Метод, возвращающий все данные из таблицы пользователей */
    public List<Customer> findAll();

    /** Метод, удаляющий пользователя из БД по его ID */
    public void deleteById(Long id);

    /** Метод, сохраняющий нового пользователя в БД */
    public void save(Customer customer);
}
