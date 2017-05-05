package com.duuple.ui.splash;

import com.duuple.application.CustomScope;
import com.duuple.application.NetComponent;

import dagger.Component;

/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    void inject(SplashActivity activity);
}