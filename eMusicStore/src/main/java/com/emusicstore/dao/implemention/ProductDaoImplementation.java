package com.emusicstore.dao.implemention;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alexander on 023 10 23 2016 .
 */
@Repository
@Transactional
public class ProductDaoImplementation implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query productsQuery = session.createQuery("from Product");

        List<Product> products = productsQuery.list();
        session.flush();
        return products;
    }

    public void deleteProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }
}
