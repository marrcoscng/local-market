package br.com.market.controller;

import br.com.market.exceptions.EmptyFieldException;
import br.com.market.model.Product;
import br.com.market.model.ProductCategory;
import br.com.market.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    public void save(String name, String barcode, BigDecimal price, BigDecimal constPrice, Integer stockQuantity, ProductCategory productCategory){
            Product product = new Product(name, barcode, price, constPrice, stockQuantity, productCategory);
            productService.save(product);
    }

    public void deleteById(Long idProduct){
        productService.deleteById(idProduct);
    }

    public void deleteProduct(Product product){
        productService.deleteProduct(product);
    }

    public Optional<Product> findProductById(Long id){
        return productService.findById(id);
    }

    public void updateProduct(Product product){
        productService.update(product);
    }

    public List<Product> findAll(){
        return productService.findAll();
    }


}
