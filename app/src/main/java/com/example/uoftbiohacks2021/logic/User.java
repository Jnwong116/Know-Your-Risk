package com.example.uoftbiohacks2021.logic;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class User extends Observable implements Serializable {
    private String username;
    private String password;
    private transient Context context;
    private static final long serialVersionUID = 42L;
    private int riskFactor;
    private ArrayList<Condition> conditions;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.riskFactor = 0;
        this.conditions = new ArrayList<>();
        this.age = 0;
        this.exercise = 0;
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

    public int getRiskFactor() {
        return riskFactor;
    }

    public void resetRiskFactor() {
        this.riskFactor = 0;
        signalChanges();
    }

    public void updateRiskFactor(int riskFactor) {
        this.riskFactor += riskFactor;
        signalChanges();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Condition> getConditions() {
        return conditions;
    }

    public void addCondition(Condition cond) {
        this.conditions.add(cond);
        signalChanges();
    }

    public void removeCondition(Condition cond) {
        this.conditions.remove(cond);
        signalChanges();
    }
}
