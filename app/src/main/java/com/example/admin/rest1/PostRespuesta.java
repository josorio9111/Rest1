package com.example.admin.rest1;

import java.util.ArrayList;

/**
 * Created by admin on 10/1/2020.
 */

public class PostRespuesta {
    private ArrayList<Post> data;
    private String message;
    private int status;

    public ArrayList<Post> getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}

