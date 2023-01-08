package ru.gb.lesson6_hibernate.repositories;

import ru.gb.lesson6_hibernate.data.Customer;
import ru.gb.lesson6_hibernate.data.Order;
import ru.gb.lesson6_hibernate.data.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {

    List<Order> boughtBy(Long id);
    ProductDao addNewProduct(Product product);
    ProductDao getProductById(Long id);
    BigDecimal getPrice(Long id);
}
