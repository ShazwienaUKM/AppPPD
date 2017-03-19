package com.myxlab.shida_minie.msmpu3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 1/15/2017.
 */
public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.ViewHolder> {

    Context notiContext;
    NotiData[] notiData;

    public NotiAdapter(NotiData[] notiData, Context notiContext) {
        this.notiData = notiData;
        this.notiContext = notiContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_noti, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.icon.setImageResource(notiData[position].getIcon());
        holder.tvName.setText(notiData[position].getNama());
        holder.tvStatus.setText(notiData[position].getStatus());

    }

    @Override
    public int getItemCount() {
        return notiData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView icon;
        public TextView tvName,tvStatus;

        public ViewHolder(View itemView) {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.iconnoti);
            tvName = (TextView) itemView.findViewById(R.id.noti_title);
            tvStatus = (TextView) itemView.findViewById(R.id.status_noti_title);

        }
    }
}
