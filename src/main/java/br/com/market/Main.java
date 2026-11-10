package br.com.market;

import br.com.market.controller.ProductController;
import br.com.market.exceptions.ProductAlreadyRegisteredException;
import br.com.market.exceptions.ProductNotRegisterException;
import br.com.market.model.Product;
import br.com.market.model.ProductCategory;
import br.com.market.service.ProductService;

import java.math.BigDecimal;
import java.util.Optional;

public class Main{
    public static void main(String[] args){
                                                           //1029489531192
        Product product = new Product("Itaipava","1029480000000",new BigDecimal("12.80"),new BigDecimal("6.99"),5, ProductCategory.DRINK);

        try {
            ProductService productService = new ProductService();
            ProductController productController = new ProductController(productService);

            Optional<Product> product1 = productController.findProductById(1L);

            product1.get().setName("Coke");
            product1.get().setCategory(ProductCategory.DRINK);
            product1.get().setPrice(new BigDecimal("12.99"));

            productController.updateProduct(product1.get());
        }catch(ProductNotRegisterException e){
            System.out.println(e.getMessage());
        }catch(ProductAlreadyRegisteredException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}