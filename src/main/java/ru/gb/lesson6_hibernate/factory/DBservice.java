package ru.gb.lesson6_hibernate.factory;

import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.hibernate.SessionFactory;

@Component
public class DBservice {

    private SessionFactory sessionFactory;

    @PostConstruct
    public void init() {
        sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
        System.out.println("init");
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void shutdown() {
        if(sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}
