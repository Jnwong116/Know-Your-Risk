package com.example.uoftbiohacks2021.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.uoftbiohacks2021.R;

public class addConditionDialog extends AppCompatDialogFragment {

    private AutoCompleteTextView autocomplete;
    private addConditionDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_condition_dialog, null);

        builder.setView(view).setTitle("Condition").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String cond = autocomplete.getText().toString();
                listener.addNewCondition(cond);
            }
        });

        String[] arr = { "Cancer", "Chronic kidney disease", "Chronic obstructive pulmonary disease", "Down syndrome", "Heart conditions", "Immunocompromised (organ transplant)", "Obesity (BMI from 30 to 40)",
                "Severe Obesity (BMI over 40)", "Pregnancy", "Sickle cell anemia", "Smoking", "Type 2 diabetes (pancreatic)", /* These all have risk values of 15 */
                "Asthma", "Cerebrovascular disease", "Cystic fibrosis", "High blood pressure (Hypertension)", "Immunocompromised (blood or marrow transplant)", "Neurological condition (e.g. dementia)",
                "Liver disease", "Overweight (BMI between 25 and 30)", "Pulmonary fibrosis", "Thalassemia", "Type 1 diabetes (pancreatic)" /* These all have risk values of 10*/
        };

        this.autocomplete = view.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getActivity(), android.R.layout.select_dialog_item, arr);

        autocomplete.setThreshold(2);
        autocomplete.setAdapter(adapter);


        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (addConditionDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement listener");
        }
    }

    public interface addConditionDialogListener {
        void addNewCondition(String cond);
    }
}
