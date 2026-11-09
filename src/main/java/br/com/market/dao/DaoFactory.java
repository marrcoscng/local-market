package br.com.market.dao;

import jakarta.persistence.EntityManager;

public class DaoFactory {

    public static ProductDao getHibernateProductDao(EntityManager entityManager){
        return new HibernateProductDao(entityManager);
    }
}
