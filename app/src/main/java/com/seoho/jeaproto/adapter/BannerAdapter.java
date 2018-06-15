package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.BannerModel;

import java.util.ArrayList;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    private static final String[] TEXTS = {"토익 시험접수 시작", "해커스 스타강사 XXX", "공무원 시험 최종결과 확인", "강성태 토익 공부 비법 공개"};
    private ArrayList<BannerModel>items =new ArrayList<>();

    public void setItems(ArrayList<BannerModel> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    public BannerAdapter.BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.viewholder_banner, parent, false);
        return new BannerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.BannerViewHolder holder, int position) {
        holder.bindItem(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBanner;
        public BannerViewHolder(View itemView) {
            super(itemView);
            ivBanner = itemView.findViewById(R.id.marketingBanner);
        }

        public void bindItem(BannerModel item) {
            Glide.with(itemView.getContext()).load(item.getImageUrl()).into(ivBanner);
        }
    }
}
