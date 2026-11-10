package br.com.market.controller;

import br.com.market.model.Product;
import br.com.market.service.ProductService;

import java.util.Optional;

public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    public void save(Product product){
        productService.save(product);
    }

    public void deleteById(Long idProduct){
        productService.deleteById(idProduct);
    }

    public Optional<Product> findProductById(Long id){
        return productService.findById(id);
    }

    public void updateProduct(Product product){
        productService.update(product);
    }


}
