package com.example.mercy.flexpay.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

}