package com.example.admin.rest1;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 11/1/2020.
 */

public class PostModel {
    private String title;
    private int completed;

    public PostModel(String title, int completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
