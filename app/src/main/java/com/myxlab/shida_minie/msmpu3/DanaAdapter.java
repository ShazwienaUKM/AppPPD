package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static com.myxlab.shida_minie.msmpu3.iklanAdapter.KEY_NAME;

/**
 * Created by User on 1/3/2017.
 */
public class DanaAdapter extends RecyclerView.Adapter<DanaAdapter.ViewHolder> {

    public Context context;
    List<DanaData>danaDataList;


    public DanaAdapter(List<DanaData>danaDataList, Context context) {
        this.danaDataList = danaDataList;
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
        final DanaData danaData = danaDataList.get(position);

        holder.text_dana.setText(danaData.getText_dana());
        holder.tv_dana.setText(danaData.getTv_dana());
        holder.text_status.setText(danaData.getText_status());
        holder.tv_status.setText(danaData.getTv_status());
        holder.text_panduan.setText(danaData.getText_panduan());
        holder.tv_panduan.setText(danaData.getTv_panduan());
        holder.text_tbuka.setText(danaData.getText_tbuka());
        holder.tv_tbuka.setText(danaData.getTv_tbuka());
        holder.text_ttutup.setText(danaData.getText_ttutup());
        holder.tv_ttutup.setText(danaData.getTv_ttutup());
        holder.text_urusetia.setText(danaData.getText_urusetia());
        holder.tv_urusetia.setText(danaData.getTv_urusetia());
        holder.text_fon.setText(danaData.getText_fon());
        holder.tv_fon.setText(danaData.getTv_fon());

    }

    @Override
    public int getItemCount() {
        return danaDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text_dana,tv_dana,text_status,tv_status,text_panduan,tv_panduan,text_tbuka,tv_tbuka,text_ttutup,tv_ttutup,text_urusetia,tv_urusetia,text_fon,tv_fon;


        public ViewHolder(View danaView) {
            super(danaView);

            text_dana = (TextView) danaView.findViewById(R.id.text_Dana);
            tv_dana = (TextView) danaView.findViewById(R.id.tv_dana);
            text_status = (TextView) danaView.findViewById(R.id.text_statusIklan);
            tv_status = (TextView) danaView.findViewById(R.id.tv_statusIklan);
            text_panduan = (TextView) danaView.findViewById(R.id.text_panduan);
            tv_panduan = (TextView) danaView.findViewById(R.id.tv_panduan);
            text_tbuka = (TextView) danaView.findViewById(R.id.text_tbuka);
            tv_tbuka = (TextView) danaView.findViewById(R.id.tv_tbuka);
            text_ttutup = (TextView) danaView.findViewById(R.id.text_ttutup);
            tv_ttutup = (TextView) danaView.findViewById(R.id.tv_ttutup);
            text_urusetia = (TextView) danaView.findViewById(R.id.text_urusetia);
            tv_urusetia = (TextView) danaView.findViewById(R.id.tv_urusetia);
            text_fon = (TextView) danaView.findViewById(R.id.text_fon);
            tv_fon = (TextView) danaView.findViewById(R.id.tv_fon);


            /*int position = getAdapterPosition();
            String KEY_SNAME = danaDataList.get(position).getTv_dana();*/


        }
    }
}
