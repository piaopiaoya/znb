package com.example.myapplication.contrart;

import com.example.myapplication.bean.BannerBean;
import com.example.myapplication.bean.NumberBean;
import com.example.myapplication.bean.RvBean;
import com.example.myapplication.util.HttpCallBack;

public class MainContrart {
    public interface getBannerView{
        void BannerOk(BannerBean bannerBean);
        void BannerNo(String fail);
    }

    public interface getBannerModel{
//        void getBannerModel();
        <T> void getBannerModel(String url, HttpCallBack<T> callBack);
    }

    public interface getBannerPresenter{
//        void OnBannerOk(BannerBean bannerBean);
//        void OnBannerNo (String fail);
//        void getBannerPresenter();
        void getBannerPresenter();
    }
    public interface getRvView{
        void RvOk(RvBean rvBean);
        void RvNo(String fail);
    }
    public interface getRvModel{
//        void getRvModel();
<T> void getRvModel(String url, HttpCallBack<T> callBack);
    }
    public interface getRvPresenter{
//        void OnRvOk(RvBean rvBean);
//        void OnRvNo(String fail);
        void getRvPresenter();
    }

    public interface getNumberView{
        void OnNumberOk(NumberBean numberBean);
        void OnNumberNO(String fail);
    }
    public interface getNumberModel{
//        void getNumberModel();
        <T> void getNumModel(String url, HttpCallBack<T> callBack);
    }

    public interface getNumberPresenter{
//        void OnNumberOk(NumberBean numberBean);
//        void OnNumberNo(String fail);
        void getNumberPresenter();
    }

}
