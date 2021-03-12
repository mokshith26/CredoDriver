package com.credoapp.driver;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.credoapp.driver.adapters.MainActivityAdaptor;
import com.credoapp.driver.common.Constants;
import com.credoapp.driver.common.RecyclerTouchListen;
import com.credoapp.driver.interfaces.ClickListener;
import com.credoapp.driver.models.DashBoardModel;
import com.credoapp.driver.ui.AlertsActivity;
import com.credoapp.driver.ui.ChangePasswordActivity;
import com.credoapp.driver.ui.HelpActivity;
import com.credoapp.driver.ui.LogInActivity;
import com.credoapp.driver.ui.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ProgressDialog progress;

    private final List<DashBoardModel> dashBoardModelList = new ArrayList<>();
    RecyclerView recyclerViewMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerViewMain = findViewById(R.id.recyclerViewMain);

        int numberOfColumns = 3;
        recyclerViewMain.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        MainActivityAdaptor mAdaptor = new MainActivityAdaptor(MainActivity.this,dashBoardModelList);
        recyclerViewMain.setAdapter(mAdaptor);


        recyclerViewMain.addOnItemTouchListener(new RecyclerTouchListen(this,
                recyclerViewMain, new ClickListener() {

            @Override
            public void onClick(View view, final int position) {

                Log.d("position=====>",position+"");

                if (position== 0){
//                    Intent in = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(in);
                } if (position==1){
                    Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(in);
                }if (position== 2){
                    Intent in = new Intent(getApplicationContext(), AlertsActivity.class);
                    startActivity(in);
                } if (position==3){
                    Intent in = new Intent(getApplicationContext(), HelpActivity.class);
                    startActivity(in);
                }if (position== 4){
                    Intent in = new Intent(getApplicationContext(), ChangePasswordActivity.class);
                    startActivity(in);
                } if (position==5){
                   logoutProcess();
                }
            }
            @Override
            public void onLongClick(View view, int position) {
            }

        }));



        getDashBoardList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void logoutProcess() {
        showLoadingDialog();
        SharedPreferences preferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent in = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(in);
                finish();

            }
        }, 2000);
    }

    private void getDashBoardList() {


        DashBoardModel list = new DashBoardModel("Trips",R.drawable.trips_svg);
        dashBoardModelList.add(list);

        list = new DashBoardModel("Profile",  R.drawable.profile_svg);
        dashBoardModelList.add(list);

        list = new DashBoardModel("Alerts",  R.drawable.alerts_svg);
        dashBoardModelList.add(list);

        list = new DashBoardModel("Help",  R.drawable.help_svg);
        dashBoardModelList.add(list);

        list = new DashBoardModel("Change Password",  R.drawable.change_password);
        dashBoardModelList.add(list);

        list = new DashBoardModel("Logout",  R.drawable.logout_svg);
        dashBoardModelList.add(list);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            finish();
            startActivity(getIntent());
//            Intent in = new Intent(getApplicationContext(), ChangePasswordActivity.class);
//            startActivity(in);
        } else if (id == R.id.nav_trips) {
//            Intent in = new Intent(getApplicationContext(), ChangePasswordActivity.class);
//            startActivity(in);
        } else if (id == R.id.nav_profile) {
            Intent in = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_alerts) {
            Intent in = new Intent(getApplicationContext(), AlertsActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_help) {
            Intent in = new Intent(getApplicationContext(), HelpActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_change_password) {
            Intent in = new Intent(getApplicationContext(), ChangePasswordActivity.class);
            startActivity(in);
        } else if (id == R.id.nav_logout) {
            logoutProcess();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}
