package com.credoapp.driver.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.credoapp.driver.R;
import com.credoapp.driver.adapters.AlertsAdaptor;
import com.credoapp.driver.common.Constants;
import com.credoapp.driver.models.DashBoardModel;
import com.credoapp.driver.models.alertsModels.AlertRequest;
import com.credoapp.driver.models.alertsModels.AlertResults;

import java.util.ArrayList;
import java.util.List;

public class AlertsActivity extends AppCompatActivity {

    RecyclerView recyclerLayoutAlerts;
    ProgressDialog progress;
    private final List<AlertResults> alertResults = new ArrayList<>();
    AlertsAdaptor mAdapter;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sp = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        userId = sp.getString(Constants.USER_ID, userId);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.statusBarColor));
        }


        getSupportActionBar().setTitle("ALERTS");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        recyclerLayoutAlerts = findViewById(R.id.recyclerLayoutAlerts);


        mAdapter = new AlertsAdaptor(getApplicationContext(), alertResults);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerLayoutAlerts.setLayoutManager(mLayoutManager);
        recyclerLayoutAlerts.setItemAnimator(new DefaultItemAnimator());
        recyclerLayoutAlerts.setAdapter(mAdapter);
    }
}
