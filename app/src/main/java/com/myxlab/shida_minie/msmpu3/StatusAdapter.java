package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 12/22/2016.
 */
public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {
    StatusData[] statusData;
    Context statusContext;
    View view;

    public StatusAdapter(StatusData[] statusData, Context statusContext) {
        this.statusData = statusData;
        this.statusContext = statusContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_status,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.question.setText(statusData[position].getQuestion());
        holder.answer.setText(statusData[position].getAnswer());


    }

    @Override
    public int getItemCount() {
        return statusData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question,answer;

        public ViewHolder(View statusView) {
            super(statusView);

            question = (TextView) statusView.findViewById(R.id.text_StatusProjek);
            answer = (TextView) statusView.findViewById(R.id.tv_StatusProjek);
        }
    }
}
