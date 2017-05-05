package com.duuple.ui.splash;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.duuple.R;
import com.duuple.application.DuupleApplication;
import com.duuple.base.BaseActivity;
import com.duuple.data.model.common.Post;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

public class SplashActivity extends BaseActivity implements SplashActivityContract.View {

    @Inject
    SplashActivityPresenter mSplashPresenter;

    TextView subtitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);
        subtitle =(TextView)findViewById(R.id.splash_act_txtHello);
        //  Component creating
        DaggerSplashActivityComponent.builder()
                .netComponent(((DuupleApplication) getApplicationContext()).getNetComponent())
                .splashActivityModule(new SplashActivityModule(this))
                .build().inject(this);
        // load from Api Service
      mSplashPresenter.load();
    }

    @Override
    public void show(List<Post> posts) {

        try{
            int sizes= posts.size();
        }catch (Throwable th)
        {
            String str = th.toString();
        }
    }

    @Override
    public void showError(String message) {
       try{
           subtitle.setText(message);
       }catch (Throwable th)
       {
           String str = th.toString();
       }

    }

    @Override
    public void showComplete() {

        try{
            subtitle.setText("Completed");
        }catch (Throwable th)
        {
           String str = th.toString();
        }

    }
}
