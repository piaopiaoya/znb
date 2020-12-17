package com.example.myapplication.presenter;

import com.example.myapplication.bean.RvBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.model.RvModel;
import com.example.myapplication.util.HttpCallBack;
import com.example.myapplication.util.UrlContarct;

public class RvPresenter implements MainContrart.getRvPresenter {

    private HomeFragment homeFragment;
    private final RvModel rvModel;

    public RvPresenter(HomeFragment homeFragment) {
        rvModel = new RvModel(this);
        this.homeFragment = homeFragment;
    }


    @Override
    public void getRvPresenter() {
        rvModel.getRvModel(UrlContarct.RV, new HttpCallBack<RvBean>() {
            @Override
            public void OnSuccess(RvBean rvBean) {
                homeFragment.RvOk(rvBean);
            }

            @Override
            public void OnFail(String err) {
                homeFragment.RvNo(err);
            }
        });
    }
}
