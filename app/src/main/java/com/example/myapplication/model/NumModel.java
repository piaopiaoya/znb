package com.example.myapplication.model;

import com.example.myapplication.bean.NumberBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.net.Apiservice;
import com.example.myapplication.presenter.NumPresenter;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.RetsUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NumModel implements MainContrart.getNumberModel {

    private NumPresenter numPresenter;

    public NumModel(NumPresenter numPresenter) {

        this.numPresenter = numPresenter;
    }

    @Override
    public <T> void getNumModel(String url, HttpCallBack<T> callBack) {
        RetsUtil.getInstance().get(url,callBack);
    }

//    @Override
//    public void getNumberModel() {
//        new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(Apiservice.sUrl)
//                .build()
//                .create(Apiservice.class)
//                .getNumber()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new ResourceSubscriber<NumberBean>() {
//                    @Override
//                    public void onNext(NumberBean numberBean) {
//                        numPresenter.OnNumberOk(numberBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//                        numPresenter.OnNumberNo(t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
