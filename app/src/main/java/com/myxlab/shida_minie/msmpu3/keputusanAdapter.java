package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
public class keputusanAdapter extends RecyclerView.Adapter<keputusanAdapter.ViewHolder> {

    public Context contextKeputusan;
    List<keputusanData> keputusanDataList;

    String v = "";
    String x = "Tindakan Urusetia";
    String y = "Tidak Lulus";
    String z = "Lulus";

    public keputusanAdapter(Context contextKeputusan, List<keputusanData>keputusanDataList) {
        this.contextKeputusan = contextKeputusan;
        this.keputusanDataList = keputusanDataList;
    }

    @Override
    public keputusanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_keputusan, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(keputusanAdapter.ViewHolder holder, int position) {
        final keputusanData keputusandata = keputusanDataList.get(position);

        holder.tv_keputusan.setText(keputusandata.getNama());
        holder.tv_statusKeputusan.setText(keputusandata.getStatus());


        v=holder.tv_statusKeputusan.getText().toString();
        Log.i("TV VALUE:" , v);

        if (v.equals(x))
        {
            holder.tv_statusKeputusan.setTextColor(Color.parseColor("#ffffff"));
        }
        else if (v.equals(y))
        {
            holder.tv_statusKeputusan.setTextColor(Color.parseColor("#DA1322"));

        }else if (v.equals(z))
        {
            holder.tv_statusKeputusan.setTextColor(Color.parseColor("#218905"));
        }
    }

    @Override
    public int getItemCount() {
        return keputusanDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_keputusan, tv_statusKeputusan;

        public ViewHolder(View keputusanView) {
            super(keputusanView);

            tv_keputusan = (TextView) keputusanView.findViewById(R.id.keputusan_title);
            tv_statusKeputusan = (TextView) keputusanView.findViewById(R.id.status_keputusan_title);



            keputusanView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();

                    Snackbar.make(view,"item has been click" +position, Snackbar.LENGTH_LONG).setAction("Action",null).show();

                    if (position == 0)
                    {
                        Intent i = new Intent(contextKeputusan,PermohonanActivity.class);

                        view.getContext().startActivity(i);
                    }
                }
            });
        }
    }

}
