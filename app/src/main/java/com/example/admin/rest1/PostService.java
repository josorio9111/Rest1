package com.example.admin.rest1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by admin on 31/12/2019.
 */

public interface PostService {

    @GET("todos/")
    Call<PostRespuesta> getPost();


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("todos/")
    Call<PostIndertar> addPost(@Body PostModel postModel);

}
