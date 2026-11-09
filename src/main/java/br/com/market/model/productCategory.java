package br.com.market.model;

public enum productCategory {

    DRINK("Drink"), // -> Bebidas
    CLEANING("Cleaning"), // -> Limpeza
    CEREAIS("Cereais"), // -> Grãos
    BAKERY("Bakery"), // -> Padaria
    SWEET("Sweet"); // -> Doces

    private final String category;

    productCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

}
