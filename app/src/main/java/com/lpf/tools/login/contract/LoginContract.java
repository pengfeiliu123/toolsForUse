package com.lpf.tools.login.contract;

/**
 * Created by lpf on 2018/7/30 07:53.
 */
public interface LoginContract {

    interface ILoginView {
        void onLogin(boolean result, int code);
        void onShowLoginProgress();
        void onHideLoginProgress();
    }

    interface ILoginPresenter{
        void doLogin(String userName,String password);
        void doShowLoginProgress();
        void doHideLoginProgress();
        void onDestroy();
    }

    interface ILoginModel{
        String getName();
        String getPassword();
        int checkUserValidity(String name,String password);
    }
}
