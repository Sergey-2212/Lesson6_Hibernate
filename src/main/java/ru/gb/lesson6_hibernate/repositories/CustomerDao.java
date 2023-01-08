package ru.gb.lesson6_hibernate.repositories;

import ru.gb.lesson6_hibernate.data.Product;

import java.util.List;

public interface CustomerDao {
    List<Product> getOrderedProducts(Long id);

}
