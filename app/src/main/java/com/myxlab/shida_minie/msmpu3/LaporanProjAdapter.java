package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 12/26/2016.
 */
public class LaporanProjAdapter extends RecyclerView.Adapter<LaporanProjAdapter.ViewHolder> {

    List<LaporanprojData>laporanprojDataList;
    Context contextLaporanProj;

    public LaporanProjAdapter(List<LaporanprojData>laporanprojDataList, Context contextLaporanProj) {
        this.laporanprojDataList = laporanprojDataList;
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
        final LaporanprojData laporanprojData = laporanprojDataList.get(position);

        holder.text_kodP.setText(laporanprojData.getText_kodP());
        holder.tv_kodP.setText(laporanprojData.getTv_kodP());
        holder.text_namaDana.setText(laporanprojData.getText_namaDana());
        holder.tv_namaDana.setText(laporanprojData.getTv_namaDana());
        holder.text_tajuk.setText(laporanprojData.getText_tajuk());
        holder.tv_tajuk.setText(laporanprojData.getTv_tajuk());
        holder.text_tmula.setText(laporanprojData.getText_tmula());
        holder.tv_tmula.setText(laporanprojData.getTv_tmula());
        holder.text_ttamat.setText(laporanprojData.getText_ttamat());
        holder.tv_ttamat.setText(laporanprojData.getTv_ttamat());
        holder.text_statusP.setText(laporanprojData.getText_statusP());
        holder.tv_statusP.setText(laporanprojData.getTv_statusP());
        holder.text_tempohlaporan1.setText(laporanprojData.getText_tempohlaporan1());
        holder.tv_tempohlaporan1.setText(laporanprojData.getTv_tempohlaporan1());
        holder.text_tpenghantaran1.setText(laporanprojData.getText_tpenghantaran1());
        holder.tv_tpenghantaran1.setText(laporanprojData.getTv_tpenghantaran1());
        holder.text_statuslaporan1.setText(laporanprojData.getText_statuslaporan1());
        holder.tv_statuslaporan1.setText(laporanprojData.getTv_statuslaporan1());
        holder.text_tempohlaporan2.setText(laporanprojData.getText_tempohlaporan2());
        holder.tv_tempohlaporan2.setText(laporanprojData.getTv_tempohlaporan2());
        holder.text_tpenghantaran2.setText(laporanprojData.getText_tpenghantaran2());
        holder.tv_tpenghantaran2.setText(laporanprojData.getTv_tpenghantaran2());
        holder.text_statuslaporan2.setText(laporanprojData.getText_statuslaporan2());
        holder.tv_statuslaporan2.setText(laporanprojData.getTv_statuslaporan2());
        holder.text_tempohlaporan3.setText(laporanprojData.getText_tempohlaporan3());
        holder.tv_tempohlaporan3.setText(laporanprojData.getTv_tempohlaporan3());
        holder.text_tpenghantaran3.setText(laporanprojData.getText_tpenghantaran3());
        holder.tv_tpenghantaran3.setText(laporanprojData.getTv_tpenghantaran3());
        holder.text_statuslaporan3.setText(laporanprojData.getText_statuslaporan3());
        holder.tv_statuslaporan3.setText(laporanprojData.getTv_statuslaporan3());

    }

    @Override
    public int getItemCount() {
        return laporanprojDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView text_kodP,tv_kodP,text_namaDana,tv_namaDana,text_tajuk,tv_tajuk,text_tmula,tv_tmula,text_ttamat,tv_ttamat,text_statusP,tv_statusP,text_tempohlaporan1,tv_tempohlaporan1,text_tpenghantaran1,tv_tpenghantaran1,text_statuslaporan1,tv_statuslaporan1,text_tempohlaporan2,tv_tempohlaporan2,text_tpenghantaran2,tv_tpenghantaran2,text_statuslaporan2,tv_statuslaporan2,text_tempohlaporan3,tv_tempohlaporan3,text_tpenghantaran3,tv_tpenghantaran3,text_statuslaporan3,tv_statuslaporan3;

        public ViewHolder(View laporanprojView) {
            super(laporanprojView);

            text_kodP = (TextView) laporanprojView.findViewById(R.id.text_kodP);
            tv_kodP = (TextView) laporanprojView.findViewById(R.id.tv_kodP);
            text_namaDana = (TextView) laporanprojView.findViewById(R.id.text_namaDana);
            tv_namaDana = (TextView) laporanprojView.findViewById(R.id.tv_namaDana);
            text_tajuk = (TextView) laporanprojView.findViewById(R.id.text_tajuk);
            tv_tajuk = (TextView) laporanprojView.findViewById(R.id.tv_tajuk);
            text_tmula = (TextView) laporanprojView.findViewById(R.id.text_tmula);
            tv_tmula = (TextView) laporanprojView.findViewById(R.id.tv_tmula);
            text_ttamat = (TextView) laporanprojView.findViewById(R.id.text_ttamat);
            tv_ttamat = (TextView) laporanprojView.findViewById(R.id.tv_ttamat);
            text_statusP = (TextView) laporanprojView.findViewById(R.id.text_statusP);
            tv_statusP = (TextView) laporanprojView.findViewById(R.id.tv_statusP);
            text_tempohlaporan1 = (TextView) laporanprojView.findViewById(R.id.text_tempohlaporan1);
            tv_tempohlaporan1 = (TextView) laporanprojView.findViewById(R.id.tv_tempohlaporan1);
            text_tpenghantaran1 = (TextView) laporanprojView.findViewById(R.id.text_tpenghantaran1);
            tv_tpenghantaran1 = (TextView) laporanprojView.findViewById(R.id.tv_tpenghantaran1);
            text_statuslaporan1 = (TextView) laporanprojView.findViewById(R.id.text_statuslaporan1);
            tv_statuslaporan1 = (TextView) laporanprojView.findViewById(R.id.tv_statuslaporan1);
            text_tempohlaporan2 = (TextView) laporanprojView.findViewById(R.id.text_tempohlaporan2);
            tv_tempohlaporan2 = (TextView) laporanprojView.findViewById(R.id.tv_tempohlaporan2);
            text_tpenghantaran2 = (TextView) laporanprojView.findViewById(R.id.text_tpenghantaran2);
            tv_tpenghantaran2 = (TextView) laporanprojView.findViewById(R.id.tv_tpenghantaran2);
            text_statuslaporan2 = (TextView) laporanprojView.findViewById(R.id.text_statuslaporan2);
            tv_statuslaporan2 = (TextView) laporanprojView.findViewById(R.id.tv_statuslaporan2);
            text_tempohlaporan3 = (TextView) laporanprojView.findViewById(R.id.text_tempohlaporan3);
            tv_tempohlaporan3 = (TextView) laporanprojView.findViewById(R.id.tv_tempohlaporan3);
            text_tpenghantaran3 = (TextView) laporanprojView.findViewById(R.id.text_tpenghantaran3);
            tv_tpenghantaran3= (TextView) laporanprojView.findViewById(R.id.tv_tpenghantaran3);
            text_statuslaporan3 = (TextView) laporanprojView.findViewById(R.id.text_statuslaporan3);
            tv_statuslaporan3 = (TextView) laporanprojView.findViewById(R.id.tv_statuslaporan3);

        }
    }
}
