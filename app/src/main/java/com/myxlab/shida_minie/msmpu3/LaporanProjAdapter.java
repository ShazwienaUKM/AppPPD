package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by User on 12/26/2016.
 */
public class LaporanProjAdapter extends RecyclerView.Adapter<LaporanProjAdapter.ViewHolder> {

    LaporanprojData[]laporanProjData;
    Context contextLaporanProj;

    public LaporanProjAdapter(LaporanprojData[] laporanProjData, Context contextLaporanProj) {
        this.laporanProjData = laporanProjData;
        this.contextLaporanProj = contextLaporanProj;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_laporan_proj,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.question.setText(laporanProjData[position].getQuestion());
        holder.answer.setText(laporanProjData[position].getAnswer());

    }

    @Override
    public int getItemCount() {
        return laporanProjData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView question,answer;

        public ViewHolder(View laporanprojView) {
            super(laporanprojView);

            question = (TextView) laporanprojView.findViewById(R.id.text_LaporanProjek);
            answer = (TextView) laporanprojView.findViewById(R.id.tv_LaporanProjek);

        }
    }
}
