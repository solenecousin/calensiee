package com.example.calensiee;

import com.google.firebase.auth.FirebaseUser;

public class UserUtil{

    String userId;
    boolean isAdmin;

    public UserUtil(String userId, boolean isAdmin) {
        this.userId = userId;
        this.isAdmin = isAdmin;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
