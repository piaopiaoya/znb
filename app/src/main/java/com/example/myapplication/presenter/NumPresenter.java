package com.example.myapplication.presenter;

import com.example.myapplication.bean.NumberBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.fragment.CollFragment;
import com.example.myapplication.model.NumModel;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.UrlContarct;

public class NumPresenter implements MainContrart.getNumberPresenter {

    private CollFragment collFragment;
    private final NumModel numModel;

    public NumPresenter(CollFragment collFragment) {
        numModel = new NumModel(this);
        this.collFragment = collFragment;
    }


    @Override
    public void getNumberPresenter() {
        numModel.getNumModel(UrlContarct.NUMBER, new HttpCallBack<NumberBean>() {
            @Override
            public void OnSuccess(NumberBean numberBean) {
                collFragment.OnNumberOk(numberBean);
            }

            @Override
            public void OnFail(String err) {
                collFragment.OnNumberNO(err);
            }
        });
    }
}
