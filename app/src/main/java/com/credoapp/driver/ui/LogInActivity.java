package com.credoapp.driver.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.credoapp.driver.MainActivity;
import com.credoapp.driver.R;
import com.credoapp.driver.common.Constants;
import com.credoapp.driver.models.loginModels.LogInRequest;
import com.credoapp.driver.models.loginModels.LogInResponse;
import com.credoapp.driver.retrofit.CredoSource;

import java.net.SocketTimeoutException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    private static final String TAG = LogInActivity.class.getSimpleName();
    private Boolean exit = false;
    private ProgressDialog progress;
    private ImageView passwordImageShowLogin,passwordImageHideLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log_in);


        final EditText passwordEditText = findViewById(R.id.password_editText);
        final EditText mobileNoEditText = findViewById(R.id.mobile_no_editText);

        passwordImageHideLogin = findViewById(R.id.passwordImageHideLogin);
        passwordImageShowLogin = findViewById(R.id.passwordImageShowLogin);


        Button logInButton = findViewById(R.id.logInButton);

        passwordImageShowLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordEditText.setTransformationMethod(null);
                passwordImageShowLogin.setVisibility(View.GONE);
                passwordImageHideLogin.setVisibility(View.VISIBLE);
            }
        });

        passwordImageHideLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
                passwordImageShowLogin.setVisibility(View.VISIBLE);
                passwordImageHideLogin.setVisibility(View.GONE);
            }
        });


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);

//                String mobile = mobileNoEditText.getText().toString();
//                String password = passwordEditText.getText().toString();
//                if (mobile.length() > 0){
//                    Log.d("","");
//                }else {
//                    Toast.makeText(LogInActivity.this, R.string.enterMobileNo, Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (mobile.matches(Constants.MobilePattern)) {Log.d("","");
//                } else {
//                    Toast.makeText(LogInActivity.this, R.string.enterValidMobileNo, Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (password.length() > 0){Log.d("","");
//                }else {
//                    Toast.makeText(LogInActivity.this, R.string.enterPassword, Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (Constants.haveInternet(getApplicationContext())) {
//                    logInProcess(mobile,password);
//                }else {
//                    Constants.IntenetSettings(LogInActivity.this);
//                }
            }
        });


    }

    private void logInProcess(String mobile, String password) {
        showLoadingDialog();
        LogInRequest request = new LogInRequest();
        request.setUserdata(mobile);
        request.setPassword(password);
        CredoSource.getRestAPI().userLogin(request).enqueue(new Callback<LogInResponse>() {
            @Override
            public void onResponse(@NonNull Call<LogInResponse> call, @NonNull Response<LogInResponse> response) {
                Log.d(TAG, "onResponse : login " + response);


                if (response.isSuccessful()) {
                    logInResponseRetro(Objects.requireNonNull(response.body()));
                }else {
                    dismissLoadingDialog();
                    switch (response.code()) {
                        case 404:
                            Toast.makeText(LogInActivity.this, "not found", Toast.LENGTH_SHORT).show();
                            break;
                        case 500:
                            Toast.makeText(LogInActivity.this, "server broken", Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(LogInActivity.this, R.string.unexpected_error, Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<LogInResponse> call, @NonNull Throwable t) {
                Log.d(TAG, "====>" + t+", "+call);
                t.printStackTrace();
                if (t instanceof SocketTimeoutException){
                    Snackbar.make(findViewById(android.R.id.content),"Server internal error try again",Snackbar.LENGTH_SHORT).show();
                }
                dismissLoadingDialog();
            }
        });
    }

    private void logInResponseRetro(LogInResponse body) {
        dismissLoadingDialog();
        String response = body.getResponseCode();
        String description_ = body.getDescription();
        Log.d(TAG, "responseCode  : " + response);
        switch (response) {
            case "200":
                String user_id = body.getUserId();
                SharedPreferences preferences = getSharedPreferences(Constants.PREFERENCE_NAME, 0);
                preferences.edit().putString(Constants.USER_ID, user_id).apply();
                preferences.edit().putString(Constants.NAME, body.getName()).apply();
                preferences.edit().putString(Constants.MOBILE_NO, body.getMobile()).apply();
                preferences.edit().putString(Constants.EMAIL_ID, body.getEmail()).apply();
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
                finish();
                Toast.makeText(this, "Welcome "+body.getName(), Toast.LENGTH_SHORT).show();
                break;
            case "204":
                Snackbar.make(findViewById(android.R.id.content),description_,Snackbar.LENGTH_SHORT).show();
                break;
            default:
                Snackbar.make(findViewById(android.R.id.content),description_,Snackbar.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        } else {
            Toast.makeText(this, R.string.pressAgainToExit, Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 2 * 1000);
        }
    }


    public  void showLoadingDialog() {

        if (progress == null) {
            progress = new ProgressDialog(this);
            progress.setTitle(R.string.loading_title);
            progress.setMessage("Loading......");
        }
        progress.show();
        progress.setCancelable(false);
    }

    public  void dismissLoadingDialog() {

        if (progress != null && progress.isShowing()) {
            progress.dismiss();
        }
    }
    @Override
    // disable keyboard out side the edit text
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(ev);
    }



}
