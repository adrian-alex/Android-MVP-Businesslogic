package com.antocistudios.androidmvp;


import com.antocistudios.androidmvp.controller.ISharedPrefController;
import com.antocistudios.androidmvp.view.LoginView;

import java.util.concurrent.Executors;

/**
 * Created by Adrian Antoci.
 *
 * 14/09/2015
 *
 * The logic is the only part of the app that can take decisions.
 *
 * The logic events can be of two types:
 *  - view events(activity life cycle or fragment or other view related events)
 *  - internal events(internal callbacks)
 *  - external events(events from external sources e.g other logic implementations, broadcast receivers, etc)
 */
public class LoginLogic {

    private LoginView mView;
    private ISharedPrefController mSharedPrefController;


    /**
     * Default constructor
     *
     * Add all the dependencies or inject them
     * @param view The host view
     */
    public LoginLogic(LoginView view, ISharedPrefController sharedPrefController){
        mView = view;
        mSharedPrefController = sharedPrefController;
    }

    /**
     * View event
     */
    public void onActivityCreate(){

    }

    /**
     * View event
     */
    public void onActivityDestroy(){

    }

    /**
     * View event
     */
    public void onActivityPause(){

    }

    /**
     * View event
     */
    public void onActivityResume(){

    }

    /**
     * View event
     *
     * @param email
     * @param password
     */
    public void onLoginButtonTap(final String email, final String password) {

        mView.showProgressBar();

        if (!isEmailValid(email)){
            mView.hiddProgressBar();
            mView.showInvalidParametersMessage("invalid email, please try again");
        }else if (!isPasswordValid(password)){
            mView.hiddProgressBar();
            mView.showInvalidParametersMessage("invalid password, please try again");
        }else {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    //simulate a network delay
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String backendToken = "aa-bb-cc-dd-ee-ff";

                    //here we save some data that we might need later
                    mSharedPrefController.putString(Const.KEY_BACKEND_TOKEN, backendToken);
                    mSharedPrefController.putString(Const.KEY_USER_EMAIL, email);

                    mView.hiddProgressBar();
                    mView.showMessage("Login successful!");
                }
            });
        }
        
    }

    /**
     * Simple check
     * @param password
     * @return {@code true} if valid
     */
    private boolean isPasswordValid(String password) {
        return !(password.length() < 6);
    }

    /**
     * Simple check
     * @param email
     * @return {@code true} if valid
     */
    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

}
