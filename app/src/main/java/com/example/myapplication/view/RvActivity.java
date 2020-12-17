package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.adapter.VpAdapter;
import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.fragment.CollFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.presenter.BannerPresenter;
import com.example.myapplication.presenter.MainPresenter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RvActivity extends AppCompatActivity  implements MainContrart.getBannerView{

    private Banner banner;
    private TabLayout tl;
    private ArrayList<BannerBean.BannerlistBean> list;
    private ViewPager vp;
    private HomeFragment homeFragment;
    private CollFragment collFragment;
    private BannerPresenter bannerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        initView();
        initData();
        bannerPresenter = new BannerPresenter(this);
        bannerPresenter.getBannerPresenter();
    }

    private void initData() {
        homeFragment = new HomeFragment();
        collFragment = new CollFragment();

        ArrayList<String> titles = new ArrayList<>();
        titles.add("学校新闻");
        titles.add("班级成绩查询");

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(collFragment);

        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), titles, fragments);
        vp.setAdapter(adapter);
        tl.setupWithViewPager(vp);

    }

    private void initView() {
        banner = findViewById(R.id.banner);
        tl = findViewById(R.id.tl);
        vp = findViewById(R.id.vp);
        list = new ArrayList<>();
    }


    @Override
    public void BannerOk(BannerBean bannerBean) {
        list.addAll(bannerBean.getBannerlist());
        banner.setImages(list);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.BannerlistBean db = (BannerBean.BannerlistBean) path;
                Glide.with(context).load(db.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void BannerNo(String fail) {
        Log.d("TAG","banner错误解析："+fail.toString());
    }
}