package com.credoapp.driver.ui;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.credoapp.driver.MainActivity;
import com.credoapp.driver.R;
import com.credoapp.driver.common.Constants;
import com.credoapp.driver.models.changePasswordModels.ChangePassRequest;
import com.credoapp.driver.models.changePasswordModels.ChangePassResponse;
import com.credoapp.driver.retrofit.CredoSource;

import java.net.SocketTimeoutException;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {


    private static final String TAG = ChangePasswordActivity.class.getSimpleName();
    private EditText oldPasswordChangePassword, newPasswordChangePassword, repeatPasswordChangePassword;
    private ImageView oldPasswordImageShow, newPasswordImageShow, repeatPasswordImageShow,
            oldPasswordImageHide, newPasswordImageHide, repeatPasswordImageHide;
    String userId;
    ProgressDialog progress;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences sp = getSharedPreferences(Constants.PREFERENCE_NAME , Context.MODE_PRIVATE);

        userId  = sp.getString(Constants.USER_ID,userId);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.statusBarColor));
        }


        getSupportActionBar().setTitle("CHANGE PASSWORD");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        oldPasswordChangePassword = findViewById(R.id.oldPasswordChangePassword);
        newPasswordChangePassword = findViewById(R.id.newPasswordChangePassword);
        repeatPasswordChangePassword = findViewById(R.id.repeatPasswordChangePassword);


        oldPasswordImageShow = findViewById(R.id.old_password_image_show_);
        newPasswordImageShow = findViewById(R.id.new_password_image_show);
        repeatPasswordImageShow = findViewById(R.id.repeat_password_image_show);


        oldPasswordImageHide = findViewById(R.id.old_password_image_hide_);
        newPasswordImageHide = findViewById(R.id.new_password_image_hide);
        repeatPasswordImageHide = findViewById(R.id.repeat_password_image_hide);


        Button buttonChangePassword = findViewById(R.id.button_change_password);


        oldPasswordImageShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPasswordChangePassword.setTransformationMethod(null);
                oldPasswordImageShow.setVisibility(View.GONE);
                oldPasswordImageHide.setVisibility(View.VISIBLE);
            }
        });

        newPasswordImageShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPasswordChangePassword.setTransformationMethod(null);
                newPasswordImageShow.setVisibility(View.GONE);
                newPasswordImageHide.setVisibility(View.VISIBLE);
            }
        });

        repeatPasswordImageShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatPasswordChangePassword.setTransformationMethod(null);
                repeatPasswordImageShow.setVisibility(View.GONE);
                repeatPasswordImageHide.setVisibility(View.VISIBLE);
            }
        });

        oldPasswordImageHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oldPasswordChangePassword.setTransformationMethod(new PasswordTransformationMethod());
                oldPasswordImageHide.setVisibility(View.GONE);
                oldPasswordImageShow.setVisibility(View.VISIBLE);
            }
        });

        newPasswordImageHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPasswordChangePassword.setTransformationMethod(new PasswordTransformationMethod());
                newPasswordImageHide.setVisibility(View.GONE);
                newPasswordImageShow.setVisibility(View.VISIBLE);
            }
        });

        repeatPasswordImageHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repeatPasswordChangePassword.setTransformationMethod(new PasswordTransformationMethod());
                repeatPasswordImageHide.setVisibility(View.GONE);
                repeatPasswordImageShow.setVisibility(View.VISIBLE);
            }
        });



        oldPasswordChangePassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        newPasswordChangePassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });
        repeatPasswordChangePassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });




        buttonChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String old_password = oldPasswordChangePassword.getText().toString();
//                String new_password = newPasswordChangePassword.getText().toString();
//                String repeat_password = repeatPasswordChangePassword.getText().toString();
//
//
//                if (old_password.equals("")){
//                    Toast.makeText(ChangePasswordActivity.this, "Enter the old password", Toast.LENGTH_SHORT).show();
//                }else if (new_password.equals("")){
//                    Toast.makeText(ChangePasswordActivity.this, "Enter the new password", Toast.LENGTH_SHORT).show();
//                }else if (repeat_password.equals("")){
//                    Toast.makeText(ChangePasswordActivity.this, "Enter the repeat password", Toast.LENGTH_SHORT).show();
//                }else {
//                    ChangePasswordMethod(old_password,new_password,repeat_password);
//
//                }


            }
        });


    }



    private void ChangePasswordMethod(String old_password, String new_password, String repeat_password) {

        if (old_password.equals(new_password)||old_password.equals(repeat_password)){
            Toast.makeText(ChangePasswordActivity.this, "Old password and New password are same", Toast.LENGTH_SHORT).show();

        }else if (!new_password.equals(repeat_password)){
            Toast.makeText(ChangePasswordActivity.this, "New Password and Repeat password dose not match", Toast.LENGTH_SHORT).show();
        }else {
            showLoadingDialog();
            ChangePassRequest request = new ChangePassRequest();

            request.setUserId(userId);
            request.setOldPassword(old_password);
            request.setNewPassword(new_password);
            request.setRepeatPassword(repeat_password);

            if (Constants.haveInternet(getApplicationContext())) {
                CredoSource.getRestAPI().changePassword(request).enqueue(new Callback<ChangePassResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<ChangePassResponse> call, @NonNull Response<ChangePassResponse> response) {
                        Log.d(TAG, "onResponse:  " + response);

                        if (response.isSuccessful()) {
                            Log.d(TAG, "onResponse  : " + response);
                            changePasswordResponseRetro(Objects.requireNonNull(response.body()));
                            dismissLoadingDialog();
                        }else {
                            dismissLoadingDialog();
                            switch (response.code()) {
                                case 404:
                                    Toast.makeText(ChangePasswordActivity.this, "not found", Toast.LENGTH_SHORT).show();
                                    break;
                                case 500:
                                    Toast.makeText(ChangePasswordActivity.this, "server broken try again", Toast.LENGTH_SHORT).show();
                                    break;
                                default:
                                    Toast.makeText(ChangePasswordActivity.this, R.string.unexpected_error, Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }

                    }
                    @Override
                    public void onFailure(@NonNull Call<ChangePassResponse> call, @NonNull Throwable t) {
                        t.printStackTrace();
                        dismissLoadingDialog();
                        if (t instanceof SocketTimeoutException){
                            Toast.makeText(ChangePasswordActivity.this, "Server internal error try again", Toast.LENGTH_SHORT).show();
                            Snackbar.make(findViewById(android.R.id.content),"Server internal error try again",Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });
            }
            else {
                dismissLoadingDialog();
                Constants.IntenetSettings(ChangePasswordActivity.this);
            }
        }
    }

    private void changePasswordResponseRetro(ChangePassResponse body) {
        String response = body.getResponseCode();
        String description = body.getDescription();
        switch (response) {
            case "200":
                Toast.makeText(this, description + "", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                Toast.makeText(this, description, Toast.LENGTH_SHORT).show();
                break;
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
