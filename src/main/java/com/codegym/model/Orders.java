package com.codegym.model;

public class Orders {
    private int order_id;
    private String customer_name;
    private String customer_phone;
    private String customer_email;
    private String discount_code;
    private int user_id;
    private User user;

    public Orders() {

    }

    public Orders(int order_id, String customer_name, String customer_phone, String customer_email, String discount_code) {
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.discount_code = discount_code;
    }

    public Orders(int order_id, String customer_name, String customer_phone, String customer_email, String discount_code, int user_id) {
        this.order_id = order_id;
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
        this.discount_code = discount_code;
        this.user_id = user_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getDiscount_code() {
        return discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
