package com.example.myapplication.model;

import com.example.myapplication.bean.RvBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.net.Apiservice;
import com.example.myapplication.presenter.RvPresenter;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.RetsUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RvModel implements MainContrart.getRvModel {

    private RvPresenter rvPresenter;

    public RvModel(RvPresenter rvPresenter) {

        this.rvPresenter = rvPresenter;
    }

    @Override
    public <T> void getRvModel(String url, HttpCallBack<T> callBack) {
        RetsUtil.getInstance().get(url,callBack);
    }

//    @Override
//    public void getRvModel() {
//        new Retrofit.Builder()
//                .baseUrl(Apiservice.sUrl)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(Apiservice.class)
//                .getList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new ResourceSubscriber<RvBean>() {
//                    @Override
//                    public void onNext(RvBean rvBean) {
//                        rvPresenter.OnRvOk(rvBean);
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//rvPresenter.OnRvNo(t.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }
}
