package com.credoapp.driver.models.changePasswordModels;

import com.google.gson.annotations.SerializedName;

public class ChangePassResponse {

    @SerializedName("code")
    private String responseCode;
    private String message;
    private String description;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
