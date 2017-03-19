package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 1/3/2017.
 */
public class DanaAdapter extends RecyclerView.Adapter<DanaAdapter.ViewHolder> {

    private DanaData[] danaData;
    private Context context;

    public DanaAdapter(DanaData[] danaData, Context context) {
        this.danaData = danaData;
        this.context = context;
    }

    @Override
    public DanaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dana, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DanaAdapter.ViewHolder holder, int position) {
        holder.question.setText(danaData[position].getQuestion());
        holder.answer.setText(danaData[position].getAnswer());
    }

    @Override
    public int getItemCount() {
        return danaData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView question,answer;


        public ViewHolder(View danaView) {
            super(danaView);

            question = (TextView) danaView.findViewById(R.id.text_Dana);
            answer = (TextView) danaView.findViewById(R.id.tv_dana);
        }
    }
}
