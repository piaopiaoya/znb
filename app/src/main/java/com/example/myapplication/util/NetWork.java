package com.example.myapplication.util;

import java.util.HashMap;

public interface NetWork {
    <T> void get(String url,HttpCallBack<T> callBack);
    <T> void post(String url, HashMap<String,String> map,HttpCallBack<T> callBack);
}

