package com.example.myapplication.contrart;

public class LoginContreact {

    public interface Login{
        String getName();
        String getPaw();
        void getResule(Boolean isLogin,String result);
    }

    public interface LoginPresenter{
        void getPyp(String name,String paw);
        void getLoginResult(boolean isLogin,String result);
    }
    public interface LoginModel{
        void resule(String name,String paw);
    }

}
