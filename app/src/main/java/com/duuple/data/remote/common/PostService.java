package com.duuple.data.remote.common;

import com.duuple.data.model.common.Post;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by OMER YILDIRIM on 05.05.2017.
 */

public interface PostService {
    @GET("/posts")
    Observable<List<Post>> getPostList();
}
