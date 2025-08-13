package com.example.demo_clase01.UserModel.DTO;

import com.example.demo_clase01.UserModel.ModelUser;

public class ModelDTO {
    private String title;
    private ModelUser user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelUser getUser() {
        return user;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }
}
