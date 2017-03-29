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
import android.widget.Toast;

import java.util.List;

/**
 * Created by User on 1/3/2017.
 */
public class iklanAdapter extends RecyclerView.Adapter<iklanAdapter.ViewHolder> {


    public static final String KEY_NAME = "KEY_NAME";
    public Context contextIklan;
    List<IklanData> iklanDataList;
    //private IklanData[] iklanDatas;

    String v = "";
    String s= "Sedang Iklan";
    String t= "Telah Tamat";

    public iklanAdapter(Context context,List<IklanData> iklanDataList)
    {
        this.contextIklan = context;
        this.iklanDataList = iklanDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_iklan, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
/*        holder.tv_dana.setText(iklanDatas[position].getNama());
        holder.tv_statusDana.setText(iklanDatas[position].getStatus());*/

        final IklanData iklanData = iklanDataList.get(position);

        //holder.tv_idDana.setText(IklanData.getId_dana());
        holder.tv_dana.setText(iklanData.getNama());
        holder.tv_statusDana.setText(iklanData.getStatus());

       v = holder.tv_statusDana.getText().toString();
        Log.i("TV VALUE:" , v);

        if (v.equals(s))
        {
            holder.tv_statusDana.setTextColor(Color.parseColor("#218905"));
        } else  if (v.equals(t))
        {
            holder.tv_statusDana.setTextColor(Color.parseColor("#DA1322"));
        }


    }

    @Override
    public int getItemCount() {
        return iklanDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_dana,tv_statusDana,tv_idDana;

        public ViewHolder(View iklanView) {
            super(iklanView);

            tv_idDana =(TextView) iklanView.findViewById(R.id.id_dana);
            tv_dana = (TextView) iklanView.findViewById(R.id.dana_title);
            tv_statusDana = (TextView) iklanView.findViewById(R.id.status_dana_title);

            iklanView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Intent i = new Intent(contextIklan,DanaActivity2.class);
                    i.putExtra(KEY_NAME,iklanDataList.get(position).getId_dana());
                    view.getContext().startActivity(i);
                }
            });

        }
    }
}
