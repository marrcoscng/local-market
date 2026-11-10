package br.com.market;

import br.com.market.controller.ProductController;
import br.com.market.exceptions.ProductNotRegisterException;
import br.com.market.model.Product;
import br.com.market.model.productCategory;
import br.com.market.service.ProductService;

import java.math.BigDecimal;
import java.util.Optional;

public class Main{
    public static void main(String[] args){
                                                           //1029489531192
        Product product = new Product("Coke","1029489588192",new BigDecimal("7.99"),new BigDecimal("5.5"),12, productCategory.SWEET);

        try {
            ProductService productService = new ProductService();
            ProductController productController = new ProductController(productService);
            Optional<Product> prod = productController.findProductById(5L);
            if(prod.isEmpty()){
                System.out.println("Product is Null");
            }else{
                System.out.println(prod.get());
                productController.deleteById(4L);
                System.err.println("Success");
            }
            System.out.println("Code executed with success");
            productController.deleteById(4L);

        }catch(ProductNotRegisterException e){
            System.out.println(e.getMessage());
        }

    }
}