package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.BottomModel;

import java.util.ArrayList;

public class BottomAdapter extends RecyclerView.Adapter<BottomAdapter.BottomViewHolder> {

    ArrayList<BottomModel>items = new ArrayList<>();
    private static final int [] BOTTOM_ICONS = {
            R.mipmap.bottom1,
            R.mipmap.bottom2,
            R.mipmap.bottom3,
            R.mipmap.bottom4,
            R.mipmap.bottom5
    };

    public void setItem(ArrayList<BottomModel>items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();

    }
    public BottomAdapter.BottomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_bottombar,parent,false);
        return new BottomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BottomAdapter.BottomViewHolder holder, int position) {
        holder.bindItem(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class BottomViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBottom;
        TextView tvBottom;

        public BottomViewHolder(View itemView) {
            super(itemView);
            ivBottom = (ImageView)itemView.findViewById(R.id.iv_bottom);
            tvBottom = (TextView)itemView.findViewById(R.id.tv_bottom);

            DisplayMetrics metrics = itemView.getContext().getResources().getDisplayMetrics();
            int size = metrics.widthPixels / 5;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(size, size));
        }

        public void bindItem(BottomModel item){
            ivBottom.setImageResource(BOTTOM_ICONS[item.getPosition()]);
            tvBottom.setText(item.getTitle());
        }
    }
}
