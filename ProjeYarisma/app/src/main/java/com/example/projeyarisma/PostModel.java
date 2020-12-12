package com.example.projeyarisma;

public class PostModel {
    int postPicture;
    String postContent;

    public PostModel(int postPicture, String postContent){
        this.postPicture=postPicture;
        this.postContent=postContent;

    }

    public int getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(int postPicture) {
        this.postPicture = postPicture;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}
