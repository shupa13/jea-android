package com.seoho.jeaproto.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.seoho.jeaproto.adapter.BannerAdapter;
import com.seoho.jeaproto.adapter.BottomAdapter;
import com.seoho.jeaproto.adapter.CategoryAdapter;
import com.seoho.jeaproto.adapter.NotifyAdapter;
import com.seoho.jeaproto.R;
import com.seoho.jeaproto.adapter.ServiceAdapter;
import com.seoho.jeaproto.model.BannerModel;
import com.seoho.jeaproto.model.BottomModel;
import com.seoho.jeaproto.model.CategoryModel;
import com.seoho.jeaproto.model.ServiceModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    public static Button buttonapply;
    private static final String [] IMG_URL =
            {"https://postfiles.pstatic.net/MjAxODA2MTFfMjAz/MDAxNTI4Njg3NjU0NjUz.fyfbyLB4nFWGLgVkDBgEn7P-BWugABEl0qUiJifDkikg.kVysWjI7kA7SOiNXo6g5CrZ_sy0eyVE8LxiAwvTy1L4g.PNG.passionistt/%ED%81%AC%EA%B8%B0%EB%B3%80%ED%99%98_11.png?type=w580",
            "https://postfiles.pstatic.net/MjAxODA2MTFfMTA5/MDAxNTI4Njg3NjczNzE2.nRJrwTMP2jQh_jTSZTSEV2vpO-q1u4sh2kl1npFLUWMg.pr3-77oH4GcS-qxUKxsK3NQHFphAAk45PfWXaWbnY1kg.PNG.passionistt/%ED%81%AC%EA%B8%B0%EB%B3%80%ED%99%98_22.png?type=w580",
            "https://postfiles.pstatic.net/MjAxODA2MTFfMjcg/MDAxNTI4Njg3Njg1MTU1.M-rY9Gbuvs-BwFBnuDQWpP2P7iKZB051sP9-GxGQTRQg.NTGAPsLd1MNM262nA5rBplkuqB_zLiRLnqbJaUYNUJgg.PNG.passionistt/%ED%81%AC%EA%B8%B0%EB%B3%80%ED%99%98_33.png?type=w580",
            "https://postfiles.pstatic.net/MjAxODA2MTFfMzAw/MDAxNTI4Njg3Njk1Njc5.BqiIjkvgf0843ux_j5GQUtGb2mExUVXa0yHTHhi_kcsg.sRi6k2VYd-1tXwR3c-C6o4p9FIbo4odDZ8gfkLfIeTkg.PNG.passionistt/%ED%81%AC%EA%B8%B0%EB%B3%80%ED%99%98_44.png?type=w580",
            "https://postfiles.pstatic.net/MjAxODA2MTFfMTQ4/MDAxNTI4Njg3NzA4OTA3.afNsNADxR4MpiiXNAfARToHCKmz__f6KhJC0mGUivwwg.422_x2JJ0xfAh7cVW5tDOzyfYFAVqxMBgssBk2I2Rv4g.PNG.passionistt/%ED%81%AC%EA%B8%B0%EB%B3%80%ED%99%98_55.png?type=w580"};

    private static final String[] RECOMMAND_URL = {
            "https://www.proprofs.com/quiz-school/topic_images/p197jdjt9p1n6s211m7dkrq1ctl3.jpg",
            "https://blog-001.west.edge.storage-yahoo.jp/res/blog-80-6a/nwoma/folder/1552451/93/63678993/img_0",
            "http://cfile22.uf.tistory.com/image/24027E40591D63DD15AB7A",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRwgGDpPWcHfas0ZKEK3FyWHvL3C2BoXHaIyKAIA6VonRyPdUJ",
            "https://teach-english-in-china.co.uk/wp-content/uploads/2017/11/HSK.png"
    };

    private static final String [] APPLY_SUBJECT = {"TOEIC", "한국어능력", "9급공무원", "한국사","HSK"};
    private static final String [] CATEGORY_TITLES = {"어학", "한자", "공무원", "기사", "기술사", "기능사", "기능장", "산업기사", "민간자격","기타"};
    private static final String [] BOTTOM_MENUS = {"홈", "시험리뷰", "공부채널", "지식쇼핑", "마이시험"};

    BannerAdapter bannerAdapter;
    CategoryAdapter categoryAdapter;
    BottomAdapter bottomAdapter;
    ServiceAdapter serviceAdapter;

    @BindView(R.id.rvCategory) RecyclerView rvCategory;
    @BindView(R.id.rvBanner) RecyclerView rvBanner;
    @BindView(R.id.rvBottom) RecyclerView rvBottom;
    @BindView(R.id.rvService) RecyclerView rvService;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        initBannerRecycler();
        initCategoryRecycler();
        initNotifyRecycler();
        initBottomRecycler();
        initServiceRecycler();

        setBannerItems();
        setCategoryItems();
        setBottomItems();
        setServiceItems();

        buttonapply = (Button)findViewById(R.id.buttonapply);
        buttonapply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ApplyActivity.class);
                startActivity(intent);
            }
        });
    }



    private void initNotifyRecycler() {
        RecyclerView rvNotify = (RecyclerView)findViewById(R.id.rvNotify);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        rvNotify.setLayoutManager(layoutManager2);

        rvNotify.setNestedScrollingEnabled(true);
        rvNotify.setHasFixedSize(true);

        NotifyAdapter notifyAdapter = new NotifyAdapter();
        rvNotify.setAdapter(notifyAdapter);
    }
    private void initCategoryRecycler(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 5, LinearLayoutManager.VERTICAL, false);
        rvCategory.setLayoutManager(gridLayoutManager);

        rvCategory.setNestedScrollingEnabled(true);
        rvCategory.setHasFixedSize(true);

        categoryAdapter = new CategoryAdapter();
        rvCategory.setAdapter(categoryAdapter);
    }
    private void initBannerRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL,false);
        rvBanner.setLayoutManager(layoutManager);

        rvBanner.setNestedScrollingEnabled(true);
        rvBanner.setHasFixedSize(true);

        PagerSnapHelper helper = new PagerSnapHelper();
        helper.attachToRecyclerView(rvBanner);

        bannerAdapter = new BannerAdapter();
        rvBanner.setAdapter(bannerAdapter);
    }
    private void initBottomRecycler(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvBottom.setLayoutManager(layoutManager);

        rvBottom.setNestedScrollingEnabled(true);
        rvBottom.setHasFixedSize(true);

        bottomAdapter = new BottomAdapter();
        rvBottom.setAdapter(bottomAdapter);
    }
    private void initServiceRecycler(){
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        rvService.setLayoutManager(layoutManager3);

        rvService.setNestedScrollingEnabled(true);
        rvService.setHasFixedSize(true);

        serviceAdapter = new ServiceAdapter();
        rvService.setAdapter(serviceAdapter);
    }

    private void setCategoryItems() {
        ArrayList<CategoryModel>categories = new ArrayList<>();
        for (int i=0; i<CATEGORY_TITLES.length;i++){
            CategoryModel category = new CategoryModel();
            category.setPositon(i);
            category.setTitle(CATEGORY_TITLES[i]);
            categories.add(category);
        }
        categoryAdapter.setItem(categories);
    }
    private void setBannerItems() {
        ArrayList<BannerModel>items = new ArrayList<>();
        for(int i=0; i<IMG_URL.length; i++){
            BannerModel item = new BannerModel();
            item.setImageUrl(IMG_URL[i]);
            item.setQuery("Query"+i);

            items.add(item);
        }
        bannerAdapter.setItems(items);
    }
    private void setBottomItems(){
        ArrayList<BottomModel> items = new ArrayList<>();
        for (int i=0; i<BOTTOM_MENUS.length; i++){
            BottomModel item = new BottomModel();
            item.setPosition(i);
            item.setTitle(BOTTOM_MENUS[i]);
            items.add(item);
        }
        bottomAdapter.setItem(items);
    }
    private void setServiceItems(){
        ArrayList<ServiceModel> services = new ArrayList<>();
        for (int i=0; i<RECOMMAND_URL.length; i++){
            ServiceModel service = new ServiceModel();
            service.setDate("~18.6/30");
            service.setIMG_Url(RECOMMAND_URL[i]);
            service.setTitle(APPLY_SUBJECT[i]);
            services.add(service);
        }
        serviceAdapter.setItem(services);
    }
}
