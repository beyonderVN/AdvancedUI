package com.longngohoang.twitter.mobile;

import android.app.Application;
import android.content.Context;

import com.longngohoang.twitter.mobile.di.DaggerMainComponent;
import com.longngohoang.twitter.mobile.di.MainComponent;
import com.longngohoang.twitter.mobile.di.MainModule;

import io.realm.Realm;


/**
 * Created by Long on 10/5/2016.
 */

public class MainApplication extends Application {



    public static Context mContext;
    static MainComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        mContext = getApplicationContext();
        setupGraph();
    }

    void setupGraph(){
        applicationComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();


    }

    public static MainComponent getMainComponent() {
        return applicationComponent;
    }

}
