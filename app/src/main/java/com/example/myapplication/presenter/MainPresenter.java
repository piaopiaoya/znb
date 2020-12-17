package com.example.myapplication.presenter;

import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.model.MainModel;
import com.example.myapplication.view.RvActivity;

public class MainPresenter {
    private final MainModel mainModel;

    public MainPresenter(RvActivity view) {
        mainModel = new MainModel(this);
    }
}
