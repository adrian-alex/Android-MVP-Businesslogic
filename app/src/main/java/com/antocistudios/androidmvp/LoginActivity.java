package com.antocistudios.androidmvp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.antocistudios.androidmvp.presenter.LoginActivityPresenter;
import com.antocistudios.androidmvp.view.LoginView;

/**
 * Created by Adrian Antoci.
 *
 * 14/09/2015
 *
 */

public class LoginActivity extends Activity implements LoginView {

    private LoginActivityPresenter mPresenter;//could be injected as well

    private EditText vEditextPassword;
    private EditText vEditextEmail;
    private Button vButtonLogin;
    private ProgressBar vProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        loadViews();

        mPresenter = new LoginActivityPresenter(LoginActivity.this, this);

        mPresenter.onActivityCreate();
    }

    private void loadViews() {
        vEditextEmail = (EditText) findViewById(R.id.login_edittext_email);
        vEditextPassword = (EditText) findViewById(R.id.login_edittext_password);
        vProgressBar = (ProgressBar) findViewById(R.id.login_progressBar);
        vButtonLogin = (Button) findViewById(R.id.login_button_login);
        vButtonLogin.setOnClickListener(onLoginButtonListener);
    }

    private View.OnClickListener onLoginButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mPresenter.onLoginButtonTap(vEditextEmail.getText().toString(), vEditextPassword.getText().toString());
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onActivityDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onActivityPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onActivityResume();
    }

    @Override
    public void showProgressBar() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    vProgressBar.setVisibility(View.VISIBLE);
                }
            });
        }else{
            vProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hiddProgressBar() {
        if(Looper.myLooper() != Looper.getMainLooper()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    vProgressBar.setVisibility(View.GONE);
                }
            });
        }else{
            vProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showInvalidParametersMessage(String message) {//could be a dialog
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
