package com.example.myapplication.util;

import com.example.myapplication.net.ApiBervice;
import com.example.myapplication.net.Apiservice;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetsUtil implements NetWork{

    private static volatile RetsUtil retsUtil;
    private final ApiBervice apiBervice;

    private RetsUtil(){
        Retrofit apiservices = new Retrofit.Builder()
                .baseUrl(UrlContarct.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiBervice = apiservices.create(ApiBervice.class);

    }

    public static RetsUtil getInstance() {
        if (retsUtil == null){
            synchronized (RetsUtil.class){
                if (retsUtil ==null){
                    retsUtil = new RetsUtil();
                }
            }
        }
        return retsUtil;
    }




    @Override
    public <T> void get(String url, HttpCallBack<T> callBack) {
       apiBervice.get(url)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<ResponseBody>() {
                   @Override
                   public void onSubscribe(@NonNull Disposable d) {

                   }

                   @Override
                   public void onNext(@NonNull ResponseBody responseBody) {
                       try {
                           String string = responseBody.string();
                           Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                           Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                           Type t = actualTypeArguments[0];
                           callBack.OnSuccess(new Gson().fromJson(string,t));


                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }

                   @Override
                   public void onError(@NonNull Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, HttpCallBack<T> callBack) {

    }
}

