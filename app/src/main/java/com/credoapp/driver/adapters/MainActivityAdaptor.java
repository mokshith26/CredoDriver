package com.credoapp.driver.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.credoapp.driver.MainActivity;
import com.credoapp.driver.R;
import com.credoapp.driver.models.DashBoardModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivityAdaptor extends RecyclerView.Adapter<MainActivityAdaptor.MyViewHolder> {

    private List<DashBoardModel> dashBoardModelList;
    private Context mContext;
    public MainActivityAdaptor(MainActivity mainActivity, List<DashBoardModel> dashBoardModelList) {
        this.mContext=mainActivity;
        this.dashBoardModelList = dashBoardModelList;

    }

    @NonNull
    @Override
    public MainActivityAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_activity_modol, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MainActivityAdaptor.MyViewHolder myViewHolder, int i) {
        DashBoardModel dash = dashBoardModelList.get(i);
        myViewHolder.textViewMainAdaptor.setText(dash.getTextView());
        myViewHolder.circleImageViewMainAdaptor.setImageResource(dash.getImages());
    }

    @Override
    public int getItemCount() {
        return dashBoardModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageViewMainAdaptor;
        TextView textViewMainAdaptor;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageViewMainAdaptor = itemView.findViewById(R.id.circleImageViewMainAdaptor);
            textViewMainAdaptor = itemView.findViewById(R.id.textViewMainAdaptor);
        }
    }
}
