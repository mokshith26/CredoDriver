package com.credoapp.driver.models.loginModels;

import com.google.gson.annotations.SerializedName;

public class LogInResponse {

    @SerializedName("code")
    private String responseCode;
    private String description;
    private String message;
    @SerializedName("institute_id")
    private String userId;
    @SerializedName("institute_email")
    private String email;
    @SerializedName("institute_name")
    private String name;
    @SerializedName("institute_mobile")
    private String mobile;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
