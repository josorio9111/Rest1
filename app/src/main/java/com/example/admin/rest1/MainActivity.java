package com.example.admin.rest1;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<String> titles = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, titles);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(arrayAdapter);
        swipe = (SwipeRefreshLayout) findViewById(R.id.refresh);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                titles.clear();
                swipe.setRefreshing(true);
                getPost();
            }
        });
        addPost();

    }

    private void getPost(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.191.1:8080/api/v1/").build();
        PostService postService = retrofit.create(PostService.class);
        Call<PostRespuesta> call = postService.getPost();

        call.enqueue(new Callback<PostRespuesta>() {
            @Override
            public void onResponse(Call<PostRespuesta> call, Response<PostRespuesta> response) {
                if(response.isSuccessful()){
                    PostRespuesta respuestalista = response.body();
                    ArrayList<Post> listapost = respuestalista.getData();
                    for (Post p : listapost){
                        titles.add(p.getTitle());
                    }
                    swipe.setRefreshing(false);
                    arrayAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<PostRespuesta> call, Throwable t) {
                System.out.println("Error: "+ t.getMessage());
            }

        });
    }

    private void addPost(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.191.1:8080/api/v1/").build();
        PostService postService = retrofit.create(PostService.class);
        PostModel postModel = new PostModel("prueba1000",1);
        Call<PostIndertar> call = postService.addPost(postModel);

        call.enqueue(new Callback<PostIndertar>() {
            @Override
            public void onResponse(Call<PostIndertar> call, Response<PostIndertar> response) {
                if(response.isSuccessful()){
                    System.out.println(response.body().getMessage());
                    System.out.println(response.body().getStatus());
                    System.out.println(response.body().getResourceId());
                }else{
                    System.out.println("Error: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<PostIndertar> call, Throwable throwable) {
                System.out.println("Error: "+ throwable.getMessage());
            }
        });

        // System.out.println("Code: "+ response.code());
    }
}
