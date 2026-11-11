package br.com.market.model;

public enum ProductCategory {

    DRINK("Drink"), // -> Bebidas
    CLEANING("Cleaning"), // -> Limpeza
    CEREAIS("Cereais"), // -> Grãos
    BAKERY("Bakery"), // -> Padaria
    SWEET("Sweet"); // -> Doces

    private final String category;

    ProductCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public String toString(){
        return category;
    }

}
