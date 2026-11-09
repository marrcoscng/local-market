package br.com.market.controller;

import br.com.market.model.Product;
import br.com.market.service.ProductService;

public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService){
        this.productService = productService;
    }

    public void save(Product product){
        productService.save(product);
    }

}
