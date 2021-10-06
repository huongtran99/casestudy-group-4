package com.codegym.model;

public class UserRole {
    private int user_role_id;
    private String name_role;
    private String user_id;

    public UserRole() {

    }

    public UserRole(int user_role_id, String name_role, String user_id) {
        this.user_role_id = user_role_id;
        this.name_role = name_role;
        this.user_id = user_id;
    }

    public int getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }

    public String getName_role() {
        return name_role;
    }

    public void setName_role(String name_role) {
        this.name_role = name_role;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
