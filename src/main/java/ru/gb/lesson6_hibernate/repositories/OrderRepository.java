package ru.gb.lesson6_hibernate.repositories;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.lesson6_hibernate.data.Customer;
import ru.gb.lesson6_hibernate.data.Order;
import ru.gb.lesson6_hibernate.data.Product;
import ru.gb.lesson6_hibernate.factory.DBservice;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRepository implements OrderDao {
    private DBservice dBservice;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Autowired
    public void setdBservice(DBservice dBservice) {
        this.dBservice = dBservice;
    }

    public List<Product> productListByCustomer(Customer customer) {
        try(Session session = dBservice.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT ord FROM Order ord where customer_id = :customer_id")
                    .setParameter("customer_id", customer.getId()).getResultList();
            List<Product> prods = new ArrayList<>();
            for (Order o : orders) {
                prods.add(o.getProduct());
            }
            session.getTransaction().commit();
            return prods;
        }
    }


}
