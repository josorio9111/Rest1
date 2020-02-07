package com.example.admin.rest1;

/**
 * Created by admin on 31/12/2019.
 */

public class Post {

    private String title;
    private boolean completed;

    public Post(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

