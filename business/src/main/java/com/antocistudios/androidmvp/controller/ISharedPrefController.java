package com.antocistudios.androidmvp.controller;

/**
 * Created by Adrian Antoci.
 *
 * 14/09/2015
 */
public interface ISharedPrefController {
    /**
     * Stores a string in the local storage
     * @param key
     * @param value
     * @return
     */
    boolean putString(String key, String value);

    /**
     * Retrieves a string from local storage by key
     * @param key
     * @return
     */
    String getString(String key);

    /**
     * Removes the string from the local storage
     * @param key
     * @return
     */
    boolean removeString(String key);
}
