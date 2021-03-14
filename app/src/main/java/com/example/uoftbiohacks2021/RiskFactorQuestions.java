package com.example.uoftbiohacks2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ArrayAdapter;

import com.example.uoftbiohacks2021.adapters.GenericAdapter;
import com.example.uoftbiohacks2021.dialogs.addConditionDialog;
import com.example.uoftbiohacks2021.logic.Condition;
import com.example.uoftbiohacks2021.logic.SwipeToDeleteCallback;
import com.example.uoftbiohacks2021.logic.User;
import com.example.uoftbiohacks2021.logic.UserWriter;

import java.util.ArrayList;

public class RiskFactorQuestions extends AppCompatActivity implements addConditionDialog.addConditionDialogListener{

    private User currentUser;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private GenericAdapter adapter;

    private ArrayList<Condition> conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_risk_factor_questions);

        Intent intent = getIntent();
        currentUser = (User) intent.getSerializableExtra("currentUser");
        currentUser.setContext(getApplicationContext());
        UserWriter userWriter = new UserWriter();
        currentUser.addObserver(userWriter);

        this.conditions = currentUser.getConditions();

        setRecyclerView();
    }

    public void setRecyclerView() {
        this.recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        this.layoutManager = new LinearLayoutManager(this);
        this.adapter = new GenericAdapter((ArrayList) currentUser.getConditions());
        adapter.addContext(RiskFactorQuestions.this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(adapter));

        recyclerView.setLayoutManager(this.layoutManager);
        recyclerView.setAdapter(this.adapter);
        itemTouchHelper.attachToRecyclerView(recyclerView);

    }

    public void addCondition(View view) {
        addConditionDialog dialog = new addConditionDialog();
        dialog.show(getSupportFragmentManager(), "Add Condition Dialog");
    }

    @Override
    public void addNewCondition(String cond) {
        Condition condition = new Condition(cond);
        currentUser.addCondition(condition);
        adapter.notifyItemInserted(currentUser.getConditions().size() - 1);
    }

    public void next(View view) {
        for (int i = 0; i < conditions.size(); i++) {
            currentUser.updateRiskFactor(conditions.get(i).getRiskFactor());
        }

        Intent intent = new Intent(this, MainPage.class);
        currentUser.setContext(getApplicationContext());
        intent.putExtra("currentUser", currentUser);
        startActivity(intent);
    }
}