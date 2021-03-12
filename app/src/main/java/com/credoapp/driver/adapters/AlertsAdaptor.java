package com.credoapp.driver.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.credoapp.driver.R;
import com.credoapp.driver.models.DashBoardModel;
import com.credoapp.driver.models.alertsModels.AlertResults;

import java.util.List;

public class AlertsAdaptor extends RecyclerView.Adapter<AlertsAdaptor.MyViewHolder> {

    private List<AlertResults> alertResults;
    Context mContext;
    public AlertsAdaptor(Context applicationContext, List<AlertResults> alertResults) {
        this.alertResults=alertResults;
        this.mContext = applicationContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.alert_activity_adaptor, viewGroup, false);

        return new AlertsAdaptor.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
//        AlertResults list = alertResults.get(i);
//        myViewHolder.titleAlerts.setText(list.getTextView());

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleAlerts,alertsDate,descriptionAlert;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleAlerts = itemView.findViewById(R.id.titleAlerts);
            alertsDate = itemView.findViewById(R.id.alertsDate);
            descriptionAlert = itemView.findViewById(R.id.descriptionAlert);

        }
    }
}
