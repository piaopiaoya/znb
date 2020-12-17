package com.example.myapplication.net;

import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.bean.NumberBean;
import com.example.myapplication.bean.RvBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface Apiservice {
    String sUrl = "http://cdwan.cn:7000/exam2003/";
    @GET("abannerlist.json")
    Flowable<BannerBean> getBanner();

    @GET("anewslist.json")
    Flowable<RvBean> getList();

    @GET("astudent.json")
    Flowable<NumberBean> getNumber();
}
