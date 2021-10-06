package com.codegym.model;

public class User {
    private int user_id;
    private String user_name;
    private String password;
    private String email;
    private String role;
    private String gender;
    private String phone;
    private String avatar;
    private String about;

    public User() {

    }

    public User(int user_id, String user_name, String password, String email, String role, String gender, String phone, String avatar, String about) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.gender = gender;
        this.phone = phone;
        this.avatar = avatar;
        this.about = about;
    }

    public User(String user_name, String password, String email, String gender, String phone, String about) {
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.gender = gender;
        this.phone = phone;
        this.about = about;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
