package br.com.market.service;

import br.com.market.dao.DaoFactory;
import br.com.market.dao.ProductDao;
import br.com.market.exceptions.RegisteredAlreadyProductException;
import br.com.market.model.Product;
import br.com.market.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class ProductService {

    public void save(Product product){
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao tool = DaoFactory.getHibernateProductDao(em);
        try{
            em.getTransaction().begin();
            if(tool.isBarcodeCheckAvaliable(product)){
                throw new RegisteredAlreadyProductException("Product Already Registered!");
            }
            tool.save(product); // tool = ferramenta
            em.getTransaction().commit();
        }catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            throw new RegisteredAlreadyProductException("Product Already Cadastered In The System - "+e.getMessage());

        }finally{
            em.close();
        }
    }

}
