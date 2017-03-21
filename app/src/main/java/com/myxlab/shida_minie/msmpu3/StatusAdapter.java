package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 12/22/2016.
 */
public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {

    StatusData[] statusData;
    Context statusContext;
    View view;
    List<StatusData>statusDataList;

    public StatusAdapter(List<StatusData>statusDataList, Context statusContext) {
        this.statusDataList = statusDataList;
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

        final StatusData statusData = statusDataList.get(position);

        holder.text_kodP.setText(statusData.getText_kodP());
        holder.tv_kodP.setText(statusData.getTv_kodP());
        holder.text_namaDana.setText(statusData.getText_namaDana());
        holder.tv_namaDana.setText(statusData.getTv_namaDana());
        holder.text_tajuk.setText(statusData.getText_tajuk());
        holder.tv_tajuk.setText(statusData.getTv_tajuk());
        holder.text_peranan.setText(statusData.getText_peranan());
        holder.tv_peranan.setText(statusData.getTv_peranan());
        holder.text_ketuaP.setText(statusData.getText_ketuaP());
        holder.tv_ketuaP.setText(statusData.getTv_ketuaP());
        holder.text_tmula.setText(statusData.getText_tmula());
        holder.tv_tmula.setText(statusData.getTv_tmula());
        holder.text_ttamat.setText(statusData.getText_ttamat());
        holder.tv_ttamat.setText(statusData.getTv_ttamat());
        holder.text_status.setText(statusData.getText_status());
        holder.tv_status.setText(statusData.getTv_status());

    }

    @Override
    public int getItemCount() {
        return statusDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_kodP,tv_kodP,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_peranan,tv_peranan,text_ketuaP,tv_ketuaP,text_tmula,tv_tmula,text_ttamat,tv_ttamat,text_status,tv_status;

        public ViewHolder(View statusView) {
            super(statusView);

            text_kodP = (TextView) statusView.findViewById(R.id.text_kodP);
            tv_kodP = (TextView) statusView.findViewById(R.id.tv_kodP);
            text_namaDana = (TextView) statusView.findViewById(R.id.text_namaDana);
            tv_namaDana = (TextView) statusView.findViewById(R.id.tv_namaDana);
            text_tajuk = (TextView) statusView.findViewById(R.id.text_tajuk);
            tv_tajuk = (TextView) statusView.findViewById(R.id.tv_tajuk);
            text_peranan = (TextView) statusView.findViewById(R.id.text_peranan);
            tv_peranan = (TextView) statusView.findViewById(R.id.tv_peranan);
            text_ketuaP = (TextView) statusView.findViewById(R.id.text_ketuaP);
            tv_ketuaP = (TextView) statusView.findViewById(R.id.tv_ketuaP);
            text_tmula = (TextView) statusView.findViewById(R.id.text_tmula);
            tv_tmula = (TextView) statusView.findViewById(R.id.tv_tmula);
            text_ttamat = (TextView) statusView.findViewById(R.id.text_ttutup);
            tv_ttamat = (TextView) statusView.findViewById(R.id.tv_ttamat);
            text_status = (TextView) statusView.findViewById(R.id.text_status);
            tv_status = (TextView) statusView.findViewById(R.id.tv_status);

        }
    }
}
