package com.example.mercy.flexpay.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pivot {

    @SerializedName("model_id")
    @Expose
    private Integer modelId;
    @SerializedName("role_id")
    @Expose
    private Integer roleId;
    @SerializedName("model_type")
    @Expose
    private String modelType;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

}

