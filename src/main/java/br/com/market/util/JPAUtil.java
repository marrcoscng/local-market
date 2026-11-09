package br.com.market.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    public static EntityManager getEntityManager() throws RuntimeException {
            EntityManagerFactory Factory = Persistence.createEntityManagerFactory("marcos");
            return Factory.createEntityManager();
    }

    public static void close(EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}