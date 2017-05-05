package com.duuple.ui.splash;

import com.duuple.application.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

@Module
public class SplashActivityModule {
    private final SplashActivityContract.View mView;


    public SplashActivityModule(SplashActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    SplashActivityContract.View providesSplashActivityContractView() {
        return mView;
    }
}