package com.credoapp.driver.common;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constants {

    public static final String USER_ID = "userId";
    public static final String REFERRAL_CODE = "referralCode";
    public static final String PROFILE = "profileFilled";
    public static String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static String MobilePattern = "[6-9][0-9]{9}";
    public static String PREFERENCE_NAME = "itutor";
    public static final String MOBILE_NO = "mobileNo";
    public static final String REFER_CODE = "referCode";
    public static final String EMAIL_ID = "emailId";
    public static final String NAME = "name";
    public static final String PUSH_NOTIFICATION_TOKEN = "pushNotificationToken";
    public static final String PUSH_NOTIFICATION_STATUS = "no";
    public static final String CUSTOMER_CARE_MOBILE_NO = "7032676767";
    public static final String CUSTOMER_CARE_TEXT = "Need help? Call to our customer support team";
    public static final String MOBILE_NO_FORGOT_PASSWORD = "forgot_password_mobile";
    public static final String Error_occurred_try_again="Unexpected error occurred please try again";
    public static final String enter_valid_mobile_no="Enter valid mobile number";
    public static final String enter_valid_email_id="Enter valid email id";
    public static final String passwords_not_matched="New Password and Repeat password dose not match";
    public static String dateSelected;
    public static final String API_KEY = "AIzaSyDIXbH-G7A64qlBz4ScbouPsCrc_OhPl8Q";


    private static ProgressDialog progress;


    public static boolean haveInternet(Context ctx) {
        try {
            NetworkInfo info = ((ConnectivityManager) ctx
                    .getSystemService(Context.CONNECTIVITY_SERVICE))
                    .getActiveNetworkInfo();

            if (info == null || !info.isConnected()) {
                return false;
            }
        } catch (Exception e) {
            Log.d("err", e.toString());
        }
        return true;
    }


    public static void IntenetSettings(final Context ctx) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
        alertDialogBuilder
                .setMessage("No internet connection on your device. Would you like to enable it?")
                .setTitle("No Internet Connection")
                .setCancelable(false)
                .setPositiveButton(" Enable Internet ",
                        new DialogInterface.OnClickListener()
                        {

                            public void onClick(DialogInterface dialog, int id)
                            {
                                Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                ctx.startActivity(dialogIntent);

                            }
                        });

        alertDialogBuilder.setNegativeButton(" Cancel ", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public static String getCurrentTime() {
        @SuppressLint("SimpleDateFormat") DateFormat dateFormat = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }



    public static void ToastShort(Context context,String string){
        Toast.makeText(context, string, Toast.LENGTH_SHORT).show();
    }
    public static void ToastLong(Context context,String string){
        Toast.makeText(context, string, Toast.LENGTH_LONG).show();
    }

    public static Bitmap getRecyclerViewScreenshot(RecyclerView view) {
        int size = view.getAdapter().getItemCount();
        Log.d("size====>", String.valueOf(size));
        RecyclerView.ViewHolder holder = view.getAdapter().createViewHolder(view, 0);
        view.getAdapter().onBindViewHolder(holder, 0);
        holder.itemView.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(), holder.itemView.getMeasuredHeight());
        Bitmap bigBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), holder.itemView.getMeasuredHeight() * size,
                Bitmap.Config.ARGB_8888);
        Canvas bigCanvas = new Canvas(bigBitmap);
        bigCanvas.drawColor(Color.WHITE);
        Paint paint = new Paint();
        int iHeight = 0;
        holder.itemView.setDrawingCacheEnabled(true);
        holder.itemView.buildDrawingCache();
        bigCanvas.drawBitmap(holder.itemView.getDrawingCache(), 0f, iHeight, paint);
        holder.itemView.setDrawingCacheEnabled(false);
        holder.itemView.destroyDrawingCache();
        iHeight += holder.itemView.getMeasuredHeight();
        for (int i = 1; i < size; i++) {
            view.getAdapter().onBindViewHolder(holder, i);
            holder.itemView.setDrawingCacheEnabled(true);
            holder.itemView.buildDrawingCache();
            bigCanvas.drawBitmap(holder.itemView.getDrawingCache(), 0f, iHeight, paint);
            iHeight += holder.itemView.getMeasuredHeight();
            holder.itemView.setDrawingCacheEnabled(false);
            holder.itemView.destroyDrawingCache();
        }
        return bigBitmap;
    }


//    public static class DatePickerDialogThemeTo extends DialogFragment implements DatePickerDialog.OnDateSetListener {
//        private MonthlyActivity.Listener listener;
//
//        public DatePickerDialogThemeTo(MonthlyActivity.Listener listener) {
//
//            this.listener = listener;
//        }
//
//        public String getDate() {
//            return date;
//        }
//
//        private  String date;
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            final Calendar calendar = Calendar.getInstance();
//            int year = calendar.get(Calendar.YEAR);
//            int month = calendar.get(Calendar.MONTH);
//            int day = calendar.get(Calendar.DAY_OF_MONTH);
//            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(),
//                    android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day);
//            //datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//            //datepickerdialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
//            return datepickerdialog;
//        }
//
//        @SuppressLint("SetTextI18n")
//        public void onDateSet(DatePicker view, int Year, int Month, int Day) {
//           date = Day + "/" + (Month + 1) + "/" + Year;
//           listener.onDateSeleted(date);
//        }
////            TextView toDateText = getActivity().findViewById(R.id.toDateText);
////            toDateText.setText(Day + "/" + (Month + 1) + "/" + Year);
////        }
//    }



//    public static String getSelectedDate(final Context ctx) {
//
//
//        @SuppressLint("ValidFragment")
//        class DatePickerDialogThemeTwo extends DialogFragment implements DatePickerDialog.OnDateSetListener {
//            @NonNull
//            @Override
//            public Dialog onCreateDialog(Bundle savedInstanceState) {
//                final Calendar calendar = Calendar.getInstance();
//                int year = calendar.get(Calendar.YEAR);
//                int month = calendar.get(Calendar.MONTH);
//
//                //calendar.add(Calendar.YEAR, -18);                //Goes 18 Year Back in time ^^
//                long upperLimit = calendar.getTimeInMillis();
//
//
//                int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog datepickerdialog;
//                datepickerdialog = new DatePickerDialog(ctx, android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day);
//                //datepickerdialog.getDatePicker().setMaxDate(upperLimit);
//                //datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
//                return datepickerdialog;
//            }
//
//            @SuppressLint("SetTextI18n")
//            public void onDateSet(DatePicker view, int Year, int Month, int Day) {
//                dateSelected =  (Day + "/" + (Month + 1) + "/" + Year);
//
//            }
//        }
//
//        return dateSelected;
//    }


//    public static String getStartDate(String date) {
//        Calendar calendar = Calendar.getInstance();
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        int year = calendar.get(Calendar.YEAR);
//        date = String.valueOf(new StringBuilder().append(year)
//                .append("-").append(month + 1).append("-").append(day)
//                .append(" "));
//        return  date;
//    }









}
