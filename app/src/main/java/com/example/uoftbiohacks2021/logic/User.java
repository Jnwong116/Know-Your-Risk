package com.example.uoftbiohacks2021.logic;

import android.content.Context;

import java.io.Serializable;
import java.util.Observable;

public class User extends Observable implements Serializable {
    private String username;
    private String password;
    private transient Context context;
    private static final long serialVersionUID = 42L;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void signalChanges() {
        setChanged();
        if (hasChanged()) {
            notifyObservers(context);
        }
        clearChanged();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
