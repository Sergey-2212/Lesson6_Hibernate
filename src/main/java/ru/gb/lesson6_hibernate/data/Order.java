package ru.gb.lesson6_hibernate.data;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "created_at")
    private Date created_at;

    @ManyToOne
   // @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    //@JoinColumn(name = "customer_id")
    private Customer customer;

    public Order() {
    }

    public Order(BigDecimal price, Product product, Customer customer) {
        this.price = price;
        this.product = product;
        this.customer = customer;
        this.created_at = Date.valueOf(LocalDate.now());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
