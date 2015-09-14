package com.antocistudios.androidmvp.presenter;

import android.content.Context;

import com.antocistudios.androidmvp.LoginLogic;
import com.antocistudios.androidmvp.controllerimpl.SharedPrefControllerImpl;
import com.antocistudios.androidmvp.view.LoginView;

/**
 * Created by Adrian Antoci.
 *
 * 14/09/2015
 */
public class LoginActivityPresenter {

    private LoginLogic mLoginLogic;

    public LoginActivityPresenter(Context context, LoginView view){
        mLoginLogic = new LoginLogic(view, new SharedPrefControllerImpl(context));//or inject
    }

    /**
     * Activity event
     */
    public void onActivityCreate(){
        mLoginLogic.onActivityCreate();

    }

    /**
     * Activity event
     */
    public void onActivityDestroy(){
        mLoginLogic.onActivityDestroy();
    }

    /**
     * Activity event
     */
    public void onActivityPause(){
        mLoginLogic.onActivityPause();
    }

    /**
     * Activity event
     */
    public void onActivityResume(){
        mLoginLogic.onActivityResume();
    }

    public void onLoginButtonTap(String email, String password) {
        mLoginLogic.onLoginButtonTap(email, password);
    }
}
