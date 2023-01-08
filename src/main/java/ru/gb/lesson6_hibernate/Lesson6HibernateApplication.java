package ru.gb.lesson6_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gb.lesson6_hibernate.repositories.ProductRepository;

@SpringBootApplication
public class Lesson6HibernateApplication {

    public static void main(String[] args) {

        SpringApplication.run(Lesson6HibernateApplication.class, args);

//        ProductRepository prod = new ProductRepository();
//        System.out.println(prod.getProductById(1L));
    }

}
