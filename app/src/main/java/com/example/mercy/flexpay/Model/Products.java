package com.example.mercy.flexpay.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Products implements Serializable
{

    @SerializedName("data")
    public List<Datum> data = new ArrayList();
    @SerializedName("errors")
    private List<Object> errors = null;
    @SerializedName("success")
    private boolean success;
    @SerializedName("status_code")
    private long status_code;
    private final static long serialVersionUID = 4200776686822887819L;

    public Products() {
    }

    public Products(List<Datum> data, List<Object> errors, boolean success, long status_code) {
        super();
        this.data = data;
        this.errors = errors;
        this.success = success;
        this.status_code = status_code;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Products withData(List<Datum> data) {
        this.data = data;
        return this;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Products withErrors(List<Object> errors) {
        this.errors = errors;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Products withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public long getStatus_code() {
        return status_code;
    }

    public void setStatus_code(long status_code) {
        this.status_code = status_code;
    }

    public Products withStatus_code(long status_code) {
        this.status_code = status_code;
        return this;
    }

    public class Datum {
            @SerializedName("id")
            @Expose
            private long id;
            @SerializedName("merchant_id")
            @Expose
            private long merchant_id;
            @SerializedName("product_category_id")
            @Expose
            private long product_category_id;
            @SerializedName("product_name")
            @Expose
            private String product_name;
            @SerializedName("product_code")
            @Expose
            private String product_code;
            @SerializedName("product_short_description")
            @Expose
            private String product_short_description;
            @SerializedName("product_long_description")
            @Expose
            private String product_long_description;
            @SerializedName("product_images")
            @Expose
            private Object product_images;
            @SerializedName("product_attribute")
            @Expose
            private String product_attribute;
            @SerializedName("product_booking_days")
            @Expose
            private long product_booking_days;
            @SerializedName("merchant_price")
            @Expose
            private double merchant_price;
            @SerializedName("flexpay_price")
            @Expose
            private double flexpay_price;
            @SerializedName("product_discount")
            @Expose
            private long product_discount;
            @SerializedName("deleted_at")
            @Expose
            private Object deleted_at;
            @SerializedName("created_at")
            @Expose
            private String created_at;
            @SerializedName("updated_at")
            @Expose
            private String updated_at;
            @SerializedName("product_category")
            @Expose
            private ProductCategory product_category;
            private final static long serialVersionUID = 1787355544171134148L;

            /**
             * No args constructor for use in serialization
             *
             */
            public Datum() {
            }

            /**
             *
             * @param product_attribute
             * @param product_name
             * @param deleted_at
             * @param product_short_description
             * @param product_category_id
             * @param id
             * @param updated_at
             * @param product_category
             * @param product_code
             * @param flexpay_price
             * @param created_at
             * @param product_images
             * @param merchant_id
             * @param product_long_description
             * @param merchant_price
             * @param product_booking_days
             * @param product_discount
             */
            public Datum(long id, long merchant_id, long product_category_id, String product_name, String product_code, String product_short_description, String product_long_description, Object product_images, String product_attribute, long product_booking_days, double merchant_price, double flexpay_price, long product_discount, Object deleted_at, String created_at, String updated_at, ProductCategory product_category) {
                super();
                this.id = id;
                this.merchant_id = merchant_id;
                this.product_category_id = product_category_id;
                this.product_name = product_name;
                this.product_code = product_code;
                this.product_short_description = product_short_description;
                this.product_long_description = product_long_description;
                this.product_images = product_images;
                this.product_attribute = product_attribute;
                this.product_booking_days = product_booking_days;
                this.merchant_price = merchant_price;
                this.flexpay_price = flexpay_price;
                this.product_discount = product_discount;
                this.deleted_at = deleted_at;
                this.created_at = created_at;
                this.updated_at = updated_at;
                this.product_category = product_category;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public Datum withId(long id) {
                this.id = id;
                return this;
            }

            public long getMerchant_id() {
                return merchant_id;
            }

            public void setMerchant_id(long merchant_id) {
                this.merchant_id = merchant_id;
            }

            public Datum withMerchant_id(long merchant_id) {
                this.merchant_id = merchant_id;
                return this;
            }

            public long getProductCategory_id() {
                return product_category_id;
            }

            public void setProductCategory_id(long product_category_id) {
                this.product_category_id = product_category_id;
            }

            public Datum withProductCategory_id(long product_category_id) {
                this.product_category_id = product_category_id;
                return this;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public Datum withProduct_name(String product_name) {
                this.product_name = product_name;
                return this;
            }

            public String getProduct_code() {
                return product_code;
            }

            public void setProduct_code(String product_code) {
                this.product_code = product_code;
            }

            public Datum withProduct_code(String product_code) {
                this.product_code = product_code;
                return this;
            }

            public String getProduct_short_description() {
                return product_short_description;
            }

            public void setProduct_short_description(String product_short_description) {
                this.product_short_description = product_short_description;
            }

            public Datum withProduct_short_description(String product_short_description) {
                this.product_short_description = product_short_description;
                return this;
            }

            public String getProduct_long_description() {
                return product_long_description;
            }

            public void setProduct_long_description(String product_long_description) {
                this.product_long_description = product_long_description;
            }

            public Datum withProduct_long_description(String product_long_description) {
                this.product_long_description = product_long_description;
                return this;
            }

            public Object getProduct_images() {
                return product_images;
            }

            public void setProduct_images(Object product_images) {
                this.product_images = product_images;
            }

            public Datum withProduct_images(Object product_images) {
                this.product_images = product_images;
                return this;
            }

            public String getProduct_attribute() {
                return product_attribute;
            }

            public void setProduct_attribute(String product_attribute) {
                this.product_attribute = product_attribute;
            }

            public Datum withProduct_attribute(String product_attribute) {
                this.product_attribute = product_attribute;
                return this;
            }

            public long getProduct_booking_days() {
                return product_booking_days;
            }

            public void setProduct_booking_days(long product_booking_days) {
                this.product_booking_days = product_booking_days;
            }

            public Datum withProduct_booking_days(long product_booking_days) {
                this.product_booking_days = product_booking_days;
                return this;
            }

            public double getMerchant_price() {
                return merchant_price;
            }

            public void setMerchant_price(double merchant_price) {
                this.merchant_price = merchant_price;
            }

            public Datum withMerchant_price(double merchant_price) {
                this.merchant_price = merchant_price;
                return this;
            }

            public double getFlexpay_price() {
                return flexpay_price;
            }

            public void setFlexpay_price(double flexpay_price) {
                this.flexpay_price = flexpay_price;
            }

            public Datum withFlexpay_price(double flexpay_price) {
                this.flexpay_price = flexpay_price;
                return this;
            }

            public long getProduct_discount() {
                return product_discount;
            }

            public void setProduct_discount(long product_discount) {
                this.product_discount = product_discount;
            }

            public Datum withProduct_discount(long product_discount) {
                this.product_discount = product_discount;
                return this;
            }

            public Object getDeleted_at() {
                return deleted_at;
            }

            public void setDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
            }

            public Datum withDeleted_at(Object deleted_at) {
                this.deleted_at = deleted_at;
                return this;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public Datum withCreated_at(String created_at) {
                this.created_at = created_at;
                return this;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public Datum withUpdated_at(String updated_at) {
                this.updated_at = updated_at;
                return this;
            }

            public ProductCategory getProductCategory() {
                return product_category;
            }

            public void setProductCategory(ProductCategory product_category) {
                this.product_category = product_category;
            }

            public Datum withProductCategory(ProductCategory product_category) {
                this.product_category = product_category;
                return this;
            }

    }
}