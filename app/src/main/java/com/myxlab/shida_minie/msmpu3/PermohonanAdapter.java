package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 1/4/2016.
 */
public class PermohonanAdapter extends RecyclerView.Adapter<PermohonanAdapter.ViewHolder> {

    private Context context;
    List<PermohonanData>permohonanDataList;

    public PermohonanAdapter(List<PermohonanData>permohonanDataList, Context context) {
        this.permohonanDataList = permohonanDataList;
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
        final PermohonanData permohonanData = permohonanDataList.get(position);

        /*holder.question.setText(permohonanData.getQuestion());
        holder.answer.setText(permohonanData.getAnswer());*/
    }

    @Override
    public int getItemCount() {
        return permohonanDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text_idPermohonan,tv_idPermohonan,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_jangkaMasa,tv_jangkaMasa,text_status;


        public ViewHolder(View danaView) {
            super(danaView);

            text_idPermohonan = (TextView) danaView.findViewById(R.id.text_idPermohonan);
            tv_idPermohonan = (TextView) danaView.findViewById(R.id.tv_idPermohonan);

        }
    }
}
