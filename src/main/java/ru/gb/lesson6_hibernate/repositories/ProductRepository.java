package ru.gb.lesson6_hibernate.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lesson6_hibernate.data.Customer;
import ru.gb.lesson6_hibernate.data.Order;
import ru.gb.lesson6_hibernate.data.Product;
import ru.gb.lesson6_hibernate.factory.DBservice;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ProductRepository implements ProductDao{

    private DBservice dBservice;

    @Autowired
    public void setdBservice(DBservice dBservice) {
        this.dBservice = dBservice;
    }

    @Override
    public List<Order> boughtBy(Long id) {
        try(Session session = dBservice.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT ord FROM Order ord")
                    .getResultList();
            session.getTransaction().commit();
            return orders;
        }

    }

    @Override
    public ProductDao addNewProduct(Product product) {
        try(Session session = dBservice.getSession()) {
            session.beginTransaction();
            ProductDao prod = (ProductDao) session.save(product);
            session.getTransaction().commit();
            return prod;
        }
    }

    @Override
    public ProductDao getProductById(Long id) {
        try(Session session = dBservice.getSession()) {
            session.beginTransaction();
            ProductDao prod = (ProductDao) session.get(Product.class, id);
            session.getTransaction().commit();
            return prod;
        }
    }

    @Override
    public BigDecimal getPrice(Long id) {
        try(Session session = dBservice.getSession()) {
            session.beginTransaction();
            Product prod = session.get(Product.class, id);
            session.getTransaction().commit();
            return prod.getPrice();
        }
    }
}
