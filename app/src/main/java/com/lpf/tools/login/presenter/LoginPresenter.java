package com.lpf.tools.login.presenter;

import android.os.Handler;
import android.os.Looper;

import com.lpf.tools.login.contract.LoginContract;
import com.lpf.tools.login.model.LoginModel;

/**
 * Created by lpf on 2018/7/30 07:57.
 */
public class LoginPresenter implements LoginContract.ILoginPresenter {

    LoginContract.ILoginView loginView;
    LoginContract.ILoginModel loginModel;

    Handler handler;

    public LoginPresenter(LoginContract.ILoginView loginView) {
        this.loginView = loginView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String userName, String password) {
        boolean isLoginSuccess = true;
        loginModel = new LoginModel("lpf","123");
        final int code = loginModel.checkUserValidity(userName,password);
        if(code != 0) isLoginSuccess = false;
        final boolean result = isLoginSuccess;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(loginView!=null){
                    loginView.onLogin(result,code);
                }
            }
        },3000);
    }

    @Override
    public void doShowLoginProgress() {
        loginView.onShowLoginProgress();
    }

    @Override
    public void doHideLoginProgress() {
        loginView.onHideLoginProgress();
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }
}
