package br.com.market.service;

import br.com.market.dao.DaoFactory;
import br.com.market.dao.ProductDao;
import br.com.market.exceptions.ProductNotRegisterException;
import br.com.market.exceptions.RegisteredAlreadyProductException;
import br.com.market.model.Product;
import br.com.market.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class ProductService {

    public void save(Product product){
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao<Product,Long> tool = DaoFactory.getHibernateProductDao(em);
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
            if(em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    public void deleteById(Long idProduct){
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao<Product,Long> tool = DaoFactory.getHibernateProductDao(em);
        try{
            em.getTransaction().begin();

            Optional<Product> productRemoved = tool.findById(idProduct);
            if(productRemoved.isEmpty()){
                throw new ProductNotRegisterException("Product Not Found!");
            }
            tool.deleteById(productRemoved.get().getId());
            em.getTransaction().commit();
        }catch(ProductNotRegisterException e){
            System.err.println("Error - "+e.getMessage());
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }catch(Exception e){
            System.err.println("Error on the remover product in database - "+e.getMessage());
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }finally{
            if(em != null && em.isOpen()){
                em.close();
            }
        }
    }

    /**
     * @param idProduct;
     * @throws ProductNotRegisterException;
     */
    public Optional<Product> findById(Long idProduct){
        try(EntityManager em = JPAUtil.getEntityManager()){
            ProductDao<Product,Long> tool = DaoFactory.getHibernateProductDao(em);
            return tool.findById(idProduct);
        }
    }



}
