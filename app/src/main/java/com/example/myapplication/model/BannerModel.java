package com.example.myapplication.model;

import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.net.Apiservice;
import com.example.myapplication.presenter.BannerPresenter;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.RetsUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class BannerModel implements MainContrart.getBannerModel {

    private BannerPresenter bannerPresenter;

    public BannerModel(BannerPresenter bannerPresenter) {

        this.bannerPresenter = bannerPresenter;
    }

    @Override
    public <T> void getBannerModel(String url, HttpCallBack<T> callBack) {
        RetsUtil.getInstance().get(url,callBack);
    }

//    @Override
//    public void getBannerModel() {
//        new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(Apiservice.sUrl)
//                .build()
//                .create(Apiservice.class)
//                .getBanner()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new ResourceSubscriber<BannerBean>() {
//                    @Override
//                    public void onNext(BannerBean bannerBean) {
//                        bannerPresenter.OnBannerOk(bannerBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        bannerPresenter.OnBannerNo(t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
