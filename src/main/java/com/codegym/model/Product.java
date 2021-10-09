package com.codegym.model;

public class Product {
    private int product_id;
    private String product_name;
    private String product_code;
    private String description;
    private double product_price;
    private String product_image;
    private int product_inventory;
    private int category_id;
    private int brand_id;
    private Category category;
    private Brand brand;

    public Product() {

    }

    public Product(String product_name, String product_code, String description, double product_price, String product_image, int product_inventory, int category_id, int brand_id) {
        this.product_name = product_name;
        this.product_code = product_code;
        this.description = description;
        this.product_price = product_price;
        this.product_image = product_image;
        this.product_inventory = product_inventory;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public Product(int product_id, String product_name, String product_code, String description, double product_price, String product_image,int product_inventory, int category_id, int brand_id) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_code = product_code;
        this.description = description;
        this.product_price = product_price;
        this.product_image = product_image;
        this.product_inventory = product_inventory;
        this.category_id = category_id;
        this.brand_id = brand_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public int getProduct_inventory() {
        return product_inventory;
    }

    public void setProduct_inventory(int product_inventory) {
        this.product_inventory = product_inventory;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
