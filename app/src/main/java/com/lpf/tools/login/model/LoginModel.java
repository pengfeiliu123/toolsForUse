package com.lpf.tools.login.model;

import android.text.TextUtils;

import com.lpf.tools.login.contract.LoginContract;

/**
 * Created by lpf on 2018/7/30 07:56.
 */
public class LoginModel implements LoginContract.ILoginModel {

    String name;
    String password;

    public LoginModel(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int checkUserValidity(String name, String password) {
        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(password)
                || !name.equals(getName())|| !password.equals(getPassword())){
            return -1;
        }
        return 0;
    }
}
