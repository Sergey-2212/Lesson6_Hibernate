package ru.gb.lesson6_hibernate.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lesson6_hibernate.data.Product;
import ru.gb.lesson6_hibernate.factory.DBservice;

import java.util.List;

@Component
public class CustomerRepository implements CustomerDao{

    private DBservice dBservice;

    @Autowired
    public void setdBservice(DBservice dBservice) {
        this.dBservice = dBservice;
    }

    @Override
    public List<Product> getOrderedProducts(Long id) {
        return null;
    }
}
