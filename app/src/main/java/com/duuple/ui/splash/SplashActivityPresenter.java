package com.duuple.ui.splash;

import com.duuple.data.model.common.Post;
import com.duuple.data.remote.common.PostService;

import java.util.List;

import javax.inject.Inject;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

public class SplashActivityPresenter  implements SplashActivityContract.Presenter {
    Retrofit retrofit;
    SplashActivityContract.View mView;

    @Inject
    public SplashActivityPresenter(Retrofit retrofit, SplashActivityContract.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void load() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.show(posts);
                    }
                });
    }
}

