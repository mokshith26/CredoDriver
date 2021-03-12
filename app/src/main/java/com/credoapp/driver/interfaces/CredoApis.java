package com.credoapp.driver.interfaces;

import com.credoapp.driver.common.Urls;
import com.credoapp.driver.models.changePasswordModels.ChangePassRequest;
import com.credoapp.driver.models.changePasswordModels.ChangePassResponse;
import com.credoapp.driver.models.loginModels.LogInRequest;
import com.credoapp.driver.models.loginModels.LogInResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CredoApis {
    @POST(Urls.LOGIN_)
    Call<LogInResponse> userLogin(@Body LogInRequest request);

    @POST(Urls.CHANGE_PWD_)
    Call<ChangePassResponse> changePassword(@Body ChangePassRequest request);
}
