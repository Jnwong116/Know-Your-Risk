package com.example.uoftbiohacks2021.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uoftbiohacks2021.R;
import com.example.uoftbiohacks2021.RiskFactorQuestions;
import com.example.uoftbiohacks2021.logic.Condition;
import com.example.uoftbiohacks2021.logic.Listable;

import java.util.ArrayList;

public class GenericAdapter extends RecyclerView.Adapter<GenericAdapter.GenericViewHolder> {

    private ArrayList<Listable> nameables;
    private OnItemClickListener listener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int i);
    }

    public void setOnClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public static class GenericViewHolder extends RecyclerView.ViewHolder {

        public TextView titleView;

        public GenericViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            this.titleView = itemView.findViewById(R.id.titleView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public GenericAdapter (ArrayList<Listable> nameables) {
        this.nameables = nameables;
    }

    public void addContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.generic_item, viewGroup, false);
        GenericViewHolder genericViewHolder = new GenericViewHolder(v, this.listener);
        return genericViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder genericViewHolder, int i) {
        Listable currentItem = nameables.get(i);
        String cond = currentItem.getCondition();

        if (cond == null) {
            genericViewHolder.titleView.setVisibility(View.GONE);
        }
        else {
            genericViewHolder.titleView.setText(cond);
        }
    }

    @Override
    public int getItemCount() {
        return nameables.size();
    }

    public void deleteItem(int position) {
        Condition recentlyDeletedItem = nameables.get(position).returnCondition();
        int recentlyDeletedItemPosition = position;
        nameables.remove(position);
        notifyItemRemoved(position);
        //showUndoSnackBar();
    }

    /*private void showUndoSnackBar() {
        View view = ((RiskFactorQuestions) context).findViewById(R.id.)
    }*/
}
