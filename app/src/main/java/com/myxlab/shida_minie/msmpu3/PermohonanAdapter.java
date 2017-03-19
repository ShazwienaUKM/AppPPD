package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 1/4/2016.
 */
public class PermohonanAdapter extends RecyclerView.Adapter<PermohonanAdapter.ViewHolder> {

    private PermohonanData[] permohonanData;
    private Context context;

    public PermohonanAdapter(PermohonanData[] permohonanData, Context context) {
        this.permohonanData = permohonanData;
        this.context = context;
    }

    @Override
    public PermohonanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permohonan, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PermohonanAdapter.ViewHolder holder, int position) {
        holder.question.setText(permohonanData[position].getQuestion());
        holder.answer.setText(permohonanData[position].getAnswer());
    }

    @Override
    public int getItemCount() {
        return permohonanData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question,answer;


        public ViewHolder(View danaView) {
            super(danaView);

            question = (TextView) danaView.findViewById(R.id.text_permohonan);
            answer = (TextView) danaView.findViewById(R.id.tv_permohonan);
        }
    }
}
