package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.ServiceModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    ArrayList<ServiceModel>services = new ArrayList<>();

    public void setItem(ArrayList<ServiceModel> services){
        this.services.clear();
        this.services.addAll(services);
        notifyDataSetChanged();
    }

    public ServiceAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_service,parent,false);
        return new ServiceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceViewHolder holder, int position) {
        holder.bindItem(services.get(position));
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        ImageView ivService;
        TextView tvTitle;
        TextView tvDate;

        public ServiceViewHolder(View itemView) {
            super(itemView);

            ivService = (ImageView)itemView.findViewById(R.id.iv_service);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_title);
            tvDate = (TextView)itemView.findViewById(R.id.tv_date);
        }

        public void bindItem(ServiceModel service){
            Glide.with(itemView).load(service.getIMG_Url()).into(ivService);
            tvTitle.setText(service.getTitle());
            tvDate.setText(service.getDate());
        }
    }
}
