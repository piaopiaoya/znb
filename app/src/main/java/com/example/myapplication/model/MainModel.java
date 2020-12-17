package com.example.myapplication.model;

import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.net.Apiservice;
import com.example.myapplication.presenter.MainPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    private MainPresenter mainPresenter;

    public MainModel(MainPresenter mainPresenter) {

        this.mainPresenter = mainPresenter;
    }

   //new Retrofit.Builder()
    //                .baseUrl(Apiservice.sUrl)
    //                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    //                .addConverterFactory(GsonConverterFactory.create())
    //                .build()
    //                .create(Apiservice.class)
    //                .getBanner()
    //                .subscribeOn(Schedulers.io())
    //                .observeOn(AndroidSchedulers.mainThread())
    //                .subscribeWith(new ResourceSubscriber<BannerBean>() {
    //                    @Override
    //                    public void onNext(BannerBean bannerBean) {
    //
    //                    }
    //
    //                    @Override
    //                    public void onError(Throwable t) {
    //
    //                    }
    //
    //                    @Override
    //                    public void onComplete() {
    //
    //                    }
    //                });
}
