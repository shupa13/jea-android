package com.seoho.jeaproto.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.seoho.jeaproto.activity.HomeActivity;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.model.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter <CategoryAdapter.CategoryViewHolder> {

    ArrayList<CategoryModel> items = new ArrayList<>();
    public static int categorySelected;
    private static final int [] CATEGORY_ICONS = {
            R.mipmap.button1,
            R.mipmap.button2,
            R.mipmap.button3,
            R.mipmap.button4,
            R.mipmap.button5,
            R.mipmap.button6,
            R.mipmap.button7,
            R.mipmap.button8,
            R.mipmap.button9,
            R.mipmap.button10
    };

    public void setItem(ArrayList<CategoryModel> items){
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.bindItem(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView ivCateogry;
        TextView tvCategory;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ivCateogry = itemView.findViewById(R.id.iv_category);
            tvCategory = itemView.findViewById(R.id.tv_category);

            DisplayMetrics metrics = itemView.getContext().getResources().getDisplayMetrics();
            int size = metrics.widthPixels / 5;
            itemView.setLayoutParams(new RecyclerView.LayoutParams(size, (int) (size * 0.85)));
        }
        public void bindItem(CategoryModel item){
            ivCateogry.setImageResource(CATEGORY_ICONS[item.getPositon()]);
            ivCateogry.setId(item.getPositon());
            tvCategory.setText(item.getTitle());

            ivCateogry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    categorySelected = ivCateogry.getId();
                    HomeActivity.buttonapply.performClick();
                    MenuAdapter.isSelected = categorySelected;
                }
            });

                }

    }
}
