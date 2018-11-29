package com.example.mercy.flexpay.Api;

import com.example.mercy.flexpay.Model.AuthUser;
import com.example.mercy.flexpay.Model.Products;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    //The register call
    @FormUrlEncoded
    @POST("customer_signup")
    Call<AuthUser> createUser(
            @Field("user_type") int user_type,
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("confirm_password") String confirm_password,
            @Field("first_name") String first_name,
            @Field("last_name") String last_name,
            @Field("phone_number_1") String phone_number_1);

    //the signin call
    @FormUrlEncoded
    @POST("login")
    Call<AuthUser> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("products")
    Call<Products> doGetProductsList();

}
