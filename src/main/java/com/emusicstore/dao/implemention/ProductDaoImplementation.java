package com.emusicstore.dao.implemention;

import com.emusicstore.dao.ProductDao;
import com.emusicstore.model.Product;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addProduct(Product product) {
        getCurrentSession().save(product);
        getCurrentSession().flush();
    }

    public void editProduct(Product product) {
        getCurrentSession().update(product);
        getCurrentSession().flush();
    }

    public Product getProductById(int productId) {
        Product product = getCurrentSession().get(Product.class, productId);
        getCurrentSession().flush();
        return product;
    }

    public List<Product> getAllProducts() {
        Query productsQuery = getCurrentSession().createQuery("from Product");

        List<Product> products = productsQuery.list();
        getCurrentSession().flush();
        return products;
    }

    @Deprecated
    public void deleteProduct(int id) {
        getCurrentSession().delete(getProductById(id));
        getCurrentSession().flush();
    }
}
