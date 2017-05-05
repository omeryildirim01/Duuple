package com.duuple.application;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

public class DuupleApplication extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
