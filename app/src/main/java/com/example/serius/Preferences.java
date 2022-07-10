package com.example.serius;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    static final String KEY= "key";

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setbitmap(Context context,String bitmap ){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(KEY,bitmap);
        editor.apply();
    }

    public  String getRegisteredUser(Context context){
        return getSharedPreference(context).getString(KEY,"");
    }
}


