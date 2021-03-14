package com.example.uoftbiohacks2021.logic;

import java.io.Serializable;

public class Condition implements Listable, Serializable {
    private String condition;
    private int riskFactor;

    private String[] highRisk = {"Cancer", "Chronic kidney disease", "Chronic obstructive pulmonary disease", "Down syndrome", "Heart conditions", "Immunocompromised (organ transplant)", "Obesity (BMI from 30 to 40)",
            "Severe Obesity (BMI over 40)", "Pregnancy", "Sickle cell anemia", "Smoking", "Type 2 diabetes (pancreatic)"};
    private String[] lowRisk = {"Asthma", "Cerebrovascular disease", "Cystic fibrosis", "High blood pressure (Hypertension)", "Immunocompromised (blood or marrow transplant)", "Neurological condition (e.g. dementia)",
            "Liver disease", "Overweight (BMI between 25 and 30)", "Pulmonary fibrosis", "Thalassemia", "Type 1 diabetes (pancreatic)"};


    public Condition(String name) {
        this.condition = name;
        if (inHighRisk(name)) {
            this.riskFactor = 15;
        }
        if (inLowRisk(name)) {
            this.riskFactor = 10;
        }
    }

    public String getCondition() {
        return this.condition;
    }

    public Condition returnCondition() {
        return this;
    }

    public int getRiskFactor() {
        return riskFactor;
    }

    private boolean inHighRisk(String str) {
        for (int i = 0; i < highRisk.length; i++) {
            if (str.matches(highRisk[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean inLowRisk(String str) {
        for (int i = 0; i < lowRisk.length; i++) {
            if (str.matches(lowRisk[i])) {
                return true;
            }
        }
        return false;
    }
}
