package br.com.market.dao;

import br.com.market.model.Product;
import jakarta.persistence.EntityManager;

public class DaoFactory {

    public static ProductDao<Product,Long> getHibernateProductDao(EntityManager entityManager){
        return new HibernateProductDao(entityManager);
    }
}
