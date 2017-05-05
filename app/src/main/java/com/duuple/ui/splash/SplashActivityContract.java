package com.duuple.ui.splash;

import com.duuple.data.model.common.Post;

import java.util.List;

/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

public interface SplashActivityContract {
    interface View {
        void show(List<Post> posts);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void load();
    }
}
