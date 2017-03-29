package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 12/19/2016.
 */
public class laporanAdapter extends RecyclerView.Adapter<laporanAdapter.ViewHolder> {

    public static final String ID_LAPORAN ="ID_LAPORAN" ;
    public Context contextLaporan;
    List<LaporanData> laporanDataList;

    String v = "";
    String s = "Selesai";
    String b = "Belum Selesai";

    public laporanAdapter(Context contextLaporan,List<LaporanData> laporanDataList) {
        this.contextLaporan = contextLaporan;
        this.laporanDataList = laporanDataList;
    }

    @Override
    public laporanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_laporan, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(laporanAdapter.ViewHolder holder, int position) {
        final LaporanData laporanData = laporanDataList.get(position);

        holder.tv_laporan.setText(laporanData.getNama());
        holder.tv_statusLaporan.setText(laporanData.getStatus());


        v = holder.tv_statusLaporan.getText().toString();
        Log.i("tv_statusProject :",v);

        if (v.equals(s))
        {
            holder.tv_statusLaporan.setTextColor(Color.parseColor("#218905"));

        }else if (v.equals(b))
        {
            holder.tv_statusLaporan.setTextColor(Color.parseColor("#DA1322"));
        }
    }


    @Override
    public int getItemCount() {
        return laporanDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_laporan,tv_statusLaporan,tv_idlaporan;

        public ViewHolder(View laporanView) {
            super(laporanView);

            tv_laporan = (TextView) laporanView.findViewById(R.id.laporan_title);
            tv_statusLaporan = (TextView) laporanView.findViewById(R.id.status_laporan_title);
            tv_idlaporan = (TextView) laporanView.findViewById(R.id.id_laporan);

            laporanView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    Intent i = new Intent(contextLaporan,LaporanProjActivity.class);
                    i.putExtra(ID_LAPORAN,laporanDataList.get(position).getId_laporan());
                    view.getContext().startActivity(i);
                }
            });
        }
    }
}
