package com.credoapp.driver.models.loginModels;

import com.google.gson.annotations.SerializedName;

public class LogInRequest {

    @SerializedName("mobile")
    private String userdata;
    private String password;

    public String getUserdata() {
        return userdata;
    }

    public void setUserdata(String userdata) {
        this.userdata = userdata;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
