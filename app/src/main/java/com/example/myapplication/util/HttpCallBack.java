package com.example.myapplication.util;

public interface HttpCallBack<T> {
    void OnSuccess(T t);
    void OnFail(String err);
}

