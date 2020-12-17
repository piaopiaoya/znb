package com.example.myapplication.presenter;

import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.model.BannerModel;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.UrlContarct;
import com.example.myapplication.view.RvActivity;

public class BannerPresenter implements MainContrart.getBannerPresenter {

    private RvActivity rvActivity;
    private final BannerModel bannerModel;

    public BannerPresenter(RvActivity rvActivity) {
        bannerModel = new BannerModel(this);
        this.rvActivity = rvActivity;
    }


    @Override
    public void getBannerPresenter() {
        bannerModel.getBannerModel(UrlContarct.BANNER, new HttpCallBack<BannerBean>() {
            @Override
            public void OnSuccess(BannerBean bannerBean) {
                rvActivity.BannerOk(bannerBean);
            }

            @Override
            public void OnFail(String err) {
rvActivity.BannerNo(err);
            }
        });
    }
}
