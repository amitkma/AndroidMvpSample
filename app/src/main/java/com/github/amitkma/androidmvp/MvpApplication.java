package com.github.amitkma.androidmvp;

import android.app.Application;
import android.content.Context;

import com.github.amitkma.androidmvp.data.DataManager;

/**
 * Created by amit on 2/6/17.
 */

public class MvpApplication extends Application {

    private DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mDataManager = DataManager.getInstance();
    }

    public static MvpApplication get(Context context){
        return (MvpApplication) context.getApplicationContext();
    }

    public DataManager getDataManager(){
        return mDataManager;
    }
}
