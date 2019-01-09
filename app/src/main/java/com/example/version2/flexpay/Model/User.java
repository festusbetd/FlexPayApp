package com.example.version2.flexpay.Model;

/**
 * Created by Belal on 10/2/2017.
 */

public class User {
    private  int user_type;
    private String username;
    private String email;
    private String confirm_password;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_number_1;

    public User(int user_type, String username, String email, String confirm_password, String password, String first_name, String last_name, String phone_number_1) {
        this.user_type = user_type;
        this.username = username;
        this.email = email;
        this.confirm_password = confirm_password;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number_1 = phone_number_1;
    }

    public User(int user_type,String username, String email, String first_name, String last_name, String phone_number_1) {
        this.user_type = user_type;
        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number_1 = phone_number_1;
    }

    public int getUser_type() {
        return user_type;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number_1() {
        return phone_number_1;
    }
}
