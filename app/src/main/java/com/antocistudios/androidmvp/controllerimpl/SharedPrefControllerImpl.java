package com.antocistudios.androidmvp.controllerimpl;

import android.content.Context;
import android.content.SharedPreferences;

import com.antocistudios.androidmvp.controller.ISharedPrefController;

/**
 * Created by Adrian Antoci.
 */
public class SharedPrefControllerImpl implements ISharedPrefController {

    private SharedPreferences mSharedPref;

    public SharedPrefControllerImpl(Context context){
        mSharedPref = context.getSharedPreferences("com.antocistudios.androidmvp", 1);
    }

    @Override
    public boolean putString(String key, String value) {
        mSharedPref.edit().putString(key, value).apply();
        return true;
    }

    @Override
    public String getString(String key) {
        return mSharedPref.getString(key, null);
    }

    @Override
    public boolean removeString(String key) {
         mSharedPref.edit().putString(key, null).apply();
        return true;
    }
}
