package br.com.market.model;

import br.com.market.exceptions.EmptyFieldException;
import br.com.market.exceptions.InvalidPriceException;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Entity
@Table( indexes = {
        @Index(name = "index_name_product", columnList = "name")
})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(unique = true, length = 13)
    private String barcode;

    @Column(nullable = false, precision = 10, scale = 2 )
    private BigDecimal price;

    @Column(nullable = false, precision = 10, scale = 2 )
    private BigDecimal constPrice;

    @Column(nullable = false)
    @Check(constraints = "stockQuantity > 0")
    private Integer stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductCategory productCategory;

    public Product(){}

    public Product(String name, String barcode, BigDecimal price, BigDecimal constPrice, Integer stockQuantity, ProductCategory productCategory){
        if(barcode == null || barcode.isBlank()){
            throw new EmptyFieldException("Barcode is empty");
        }
        setName(name);
        this.barcode = barcode;
        setPrice(price);
        setConstPrice(constPrice);
        setStockQuantity(stockQuantity);
        setCategory(productCategory);
    }

    @Override
    public String toString(){
        return String.format(
                "Name: %s%n"+
                "BarCode: %s%n"+
                "Price: %.2f%n"+
                "ProductCategory: %s%n",name,barcode,price, productCategory.toString());
    }

    public Long getId(){
        return id;
    }

    public BigDecimal getConstPrice(){
        return constPrice;
    }

    public Integer getStockQuantity(){
        return stockQuantity;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public String getBarCode(){
        return barcode;
    }

    public ProductCategory getCategory(){
        return productCategory;
    }

    // Setters ->

    public void setPrice(BigDecimal price){
        if(price == null || price.compareTo(BigDecimal.ZERO) <= 0 ){
            throw new InvalidPriceException("Invalited Price");
        }
        this.price = price;
    }

    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new EmptyFieldException("Empty be cannot field");
        }
        this.name = name;
    }

    public void setConstPrice(BigDecimal constPrice){
        if(constPrice == null || constPrice.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidPriceException("Invalid price");
        }
        this.constPrice = constPrice;
    }

    public void setStockQuantity(Integer stockQuantity){
        if(stockQuantity == null || stockQuantity<=0){
            throw new InvalidPriceException("Invalid price");
        }
        this.stockQuantity = stockQuantity;
    }

    public void setCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
    }



}
