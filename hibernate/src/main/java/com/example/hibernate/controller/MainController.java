package com.example.hibernate.controller;


import com.example.hibernate.model.Product;
import com.example.hibernate.model.ProductRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/** Класс-контролллер. Пока не работает.
 *
 * @author Andrey Pomelov
 * @version 1.0-SNAPSHOT
 * Класс пока не реализован (задание под звёздочкой).
 * Если успею до момента проверки, реализую.
 */
@Controller
@RequestMapping("/")
public class MainController {

    /** Ссылка на экземпляр класса, реализующий взаимодействие с БД */
    private final ProductRepositoryImpl repository;

    /** Конструктор
     *
     * @param repository ссылка на экземпляр класса, реализующий взаимодействие с БД
     */
    public MainController(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String find(Model model, @RequestParam Long id) {
        Product product = repository.findById(id);
        return "find";
    }
}
