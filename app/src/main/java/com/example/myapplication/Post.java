package com.example.myapplication;

public class Post {
    private String name;
    private String date;
    private String content;
    private int imageResId;

    public Post(String name, String date, String content, int imageResId) {
        this.name = name;
        this.date = date;
        this.content = content;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getContent() { return content; }
    public int getImageResId() { return imageResId; }
}
