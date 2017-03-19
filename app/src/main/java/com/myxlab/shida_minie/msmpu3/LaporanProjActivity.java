package com.myxlab.shida_minie.msmpu3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class LaporanProjActivity extends AppCompatActivity {

    RecyclerView rv_laporanProj;
    RecyclerView.Adapter laporanProj_adapter;
    RecyclerView.LayoutManager laporanProj_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan_proj);

        rv_laporanProj = (RecyclerView) findViewById(R.id.rv_laporanproj);

        LaporanprojData laporanprojData[]={new LaporanprojData("Kod Projek :","TD-2016-003"),new LaporanprojData("Nama Dana :","Dana Penyelidikan TopDown"),new LaporanprojData("Tajuk :","UKM MOBILE APP"),new LaporanprojData("Tarikh Mula","01/05/2016"),new LaporanprojData("Tarikh Tamat :","31/10/2017"),new LaporanprojData("Status Projek :","Aktif"),new LaporanprojData("Laporan Kemajuan 1 :\n(01/05/2016 - 30/06/2016)", "Telah Diterima (Selesai)"),new LaporanprojData("Tempoh Penghantaran 1 :","01/07/2016 - 31/07/2016"),new LaporanprojData("Laporan Kemajuan 2 :\n(01/07/2016 - 31/12/2016)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran 2 :","01/01/2017 - 31/01/2017"),new LaporanprojData("Laporan Kemajuan 3 :\n(01/01/2017 - 30/06/2017)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran 3 :","01/07/2017 - 31/07/2017"),new LaporanprojData("Laporan Kemajuan Akhir :\n(01/05/2016 - 31/10/2017)", "Belum Dihantar"),new LaporanprojData("Tempoh Penghantaran Akhir :","01/11/2017 - 29/01/2018")};

        laporanProj_layout = new LinearLayoutManager(this);
        rv_laporanProj.setLayoutManager(laporanProj_layout);



        laporanProj_adapter =new LaporanProjAdapter(laporanprojData,LaporanProjActivity.this);
        rv_laporanProj.setAdapter(laporanProj_adapter);


    }

    @Nullable
    @Override
    public Intent getSupportParentActivityIntent() {
        Log.e("Laporan Projek","back");
        onBackPressed();
        return null;
    }
}
