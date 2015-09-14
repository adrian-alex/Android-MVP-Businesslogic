package com.antocistudios.androidmvp.view;

/**
 * Created by Adrian Antoci.
 *
 * 14/09/2015
 */
public interface LoginView {

    void showProgressBar();
    void hiddProgressBar();
    void showInvalidParametersMessage(String msg);

    void showMessage(String msg);
}
