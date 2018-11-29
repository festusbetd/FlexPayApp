package com.example.mercy.flexpay.Model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductCategory implements Serializable
{

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("product_category_name")
    @Expose
    private String product_category_name;
    private final static long serialVersionUID = 3080142206059819899L;

    /**
     * No args constructor for use in serialization
     *
     */
    public ProductCategory() {
    }

    /**
     *
     * @param id
     * @param product_category_name
     */
    public ProductCategory(long id, String product_category_name) {
        super();
        this.id = id;
        this.product_category_name = product_category_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductCategory withId(long id) {
        this.id = id;
        return this;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }

    public ProductCategory withProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
        return this;
    }

}