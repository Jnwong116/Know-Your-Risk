package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

public class RiskFactorQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_factor_questions);
        AutoCompleteTextView autocomplete;

        String[] arr = { "Cancer", "Chronic kidney disease", "Chronic obstructive pulmonary disease", "Down syndrome", "Heart conditions", "Immunocompromised (organ transplant)", "Obesity (BMI from 30 to 40)",
                "Severe Obesity (BMI over 40)", "Pregnancy", "Sickle cell anemia", "Smoking", "Type 2 diabetes (pancreatic)", /* These all have risk values of 15 */
                "Asthma", "Cerebrovascular disease", "Cystic fibrosis", "High blood pressure (Hypertension)", "Immunocompromised (blood or marrow transplant)", "Neurological condition (e.g. dementia)",
                "Liver disease", "Overweight (BMI between 25 and 30)", "Pulmonary fibrosis", "Thalassemia", "Type 1 diabetes (pancreatic)" /* These all have risk values of 10*/
        }


            autocomplete = (AutoCompleteTextView)
                    findViewById(R.id.autoCompleteTextView1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this,android.R.layout.select_dialog_item, arr);

            autocomplete.setThreshold(2);
            autocomplete.setAdapter(adapter);
        }
    }