package com.lpf.tools.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lpf.tools.R;
import com.lpf.tools.login.contract.LoginContract;
import com.lpf.tools.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginContract.ILoginView,View.OnClickListener{

    LoginContract.ILoginPresenter loginPresenter;

    private EditText userName,userPassword;
    private Button btnLogin;
    private TextView tvProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }

    private void initViews() {

        userName = findViewById(R.id.etUserName);
        userPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvProgress = findViewById(R.id.tvProgress);

        btnLogin.setOnClickListener(this);

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                loginPresenter.doShowLoginProgress();
                loginPresenter.doLogin(userName.getText().toString(),userPassword.getText().toString());
                break;
        }
    }

    @Override
    public void onLogin(boolean result, int code) {
        loginPresenter.doHideLoginProgress();
        if(result){
            Toast.makeText(this, "Login in success", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Login is failure", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onShowLoginProgress() {
        tvProgress.setText("Login....");
    }

    @Override
    public void onHideLoginProgress() {
        tvProgress.setText("Login is finished");
    }
}
