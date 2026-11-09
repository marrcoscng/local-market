package br.com.market.dao;

import br.com.market.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class HibernateProductDao implements ProductDao<Product, Long> {

    private final EntityManager em;

    public HibernateProductDao(EntityManager entityManager){
        em = entityManager;
    }

    @Override
    public void save(Product product) {
            em.persist(product);
    }

    @Override
    public void update(Product product) {
            em.merge(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
            Product product = em.find(Product.class, id);
            return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findAll() {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
            return query.getResultList();
    }

    @Override
    public void delete(Product product) {
            Product managedProduct = em.merge(product);
            em.remove(managedProduct);
    }

    @Override
    public void deleteById(Long id) {
            Product product = em.find(Product.class, id);
            if (product != null) {
                em.remove(product);
            }
    }
    @Override
    public boolean isBarcodeCheckAvaliable(Product product){
        Long verified = em.createQuery(
                "SELECT COUNT(p.barcode) FROM Product p WHERE p.barcode = :barCode",Long.class
        ).setParameter("barCode",product.getBarCode()).getSingleResult();
        return !(verified == 0);
    }


}