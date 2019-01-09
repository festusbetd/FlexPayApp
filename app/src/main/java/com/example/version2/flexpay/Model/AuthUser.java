package com.example.version2.flexpay.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthUser {
    @SerializedName("expires_in")
    @Expose
    private Float expiresIn;

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;

    public AuthUser(Float expiresIn, String accessToken, String refreshToken) {
        this.expiresIn = expiresIn;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    public Float getExpiresIn() {
        return expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    /* @SerializedName("errors")
    @Expose
    private String errors;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private User data;
    @SerializedName("user_type")
    @Expose
    private int user_type;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("confirm_password")
    @Expose
    private String confirm_password;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("phone_number_1")
    @Expose
    private String phone_number_1;

    public AuthUser(String errors, Boolean success, User data, int user_type, String username, String email, String password, String confirm_password, String first_name, String last_name, String phone_number_1) {
        this.errors = errors;
        this.success = success;
        this.data = data;
        this.user_type = user_type;
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number_1 = phone_number_1;
    }

    public String getErrors() {
        return errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public User getData() {
        return data;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_number_1() {
        return phone_number_1;
    }*/
}
