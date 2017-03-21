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

        holder.text_idPermohonan.setText(permohonanData.getText_idPermohonan());
        holder.tv_idPermohonan.setText(permohonanData.getTv_idPermohonan());
        holder.text_namaDana.setText(permohonanData.getText_namaDana());
        holder.tv_namaDana.setText(permohonanData.getTv_namaDana());
        holder.text_tajuk.setText(permohonanData.getText_tajuk());
        holder.tv_tajuk.setText(permohonanData.getTv_tajuk());
        holder.text_jangkaMasa.setText(permohonanData.getText_jangkaMasa());
        holder.tv_jangkaMasa.setText(permohonanData.getTv_jangkaMasa());
        holder.text_status.setText(permohonanData.getText_status());
        holder.tv_status.setText(permohonanData.getTv_status());
    }

    @Override
    public int getItemCount() {
        return permohonanDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text_idPermohonan,tv_idPermohonan,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_jangkaMasa,tv_jangkaMasa,text_status,tv_status;


        public ViewHolder(View permohonanView) {
            super(permohonanView);

            text_idPermohonan = (TextView) permohonanView.findViewById(R.id.text_idPermohonan);
            tv_idPermohonan = (TextView) permohonanView.findViewById(R.id.tv_idPermohonan);
            text_namaDana = (TextView) permohonanView.findViewById(R.id.text_namaDana);
            tv_namaDana= (TextView) permohonanView.findViewById(R.id.tv_namaDana);
            text_tajuk = (TextView) permohonanView.findViewById(R.id.text_tajuk);
            tv_tajuk = (TextView) permohonanView.findViewById(R.id.tv_tajuk);
            text_jangkaMasa = (TextView) permohonanView.findViewById(R.id.text_jangkaMasa);
            tv_jangkaMasa = (TextView) permohonanView.findViewById(R.id.tv_jangkaMasa);
            text_status = (TextView) permohonanView.findViewById(R.id.text_status);
            tv_status = (TextView) permohonanView.findViewById(R.id.tv_status);


        }
    }
}
