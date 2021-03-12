package com.credoapp.driver.models.alertsModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlertResponse {


    @SerializedName("code")
    private String responseCode;
    private String description;
    private String message;

    @SerializedName("result")
    private List<AlertResults> results;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AlertResults> getResults() {
        return results;
    }

    public void setResults(List<AlertResults> results) {
        this.results = results;
    }

}
