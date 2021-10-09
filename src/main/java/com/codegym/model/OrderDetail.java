package com.codegym.model;

public class OrderDetail {
    private int order_detail_id;
    private int quantity;
    private double price;
    private int order_id;
    private int product_id;
    private Product product;
    private Orders orders;

    public OrderDetail() {

    }

    public OrderDetail(int order_detail_id, int quantity, double price, int order_id, int product_id) {
        this.order_detail_id = order_detail_id;
        this.quantity = quantity;
        this.price = price;
        this.order_id = order_id;
        this.product_id = product_id;
    }

    public OrderDetail(int quantity, double price, int order_id, int product_id) {
        this.quantity = quantity;
        this.price = price;
        this.order_id = order_id;
        this.product_id = product_id;
    }

    public OrderDetail(int quantity, double price, int product_id) {
        this.quantity = quantity;
        this.price = price;
        this.product_id = product_id;
    }


    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
