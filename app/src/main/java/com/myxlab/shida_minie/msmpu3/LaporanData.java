package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 1/13/2017.
 */
public class LaporanData {

    String nama,status,id_laporan;

    public LaporanData() {
    }

    public LaporanData(String question, String answer,String id_laporan) {
        this.nama = question;
        this.status = answer;
        this.id_laporan = id_laporan;
    }

    public String getId_laporan() {
        return id_laporan;
    }

    public void setId_laporan(String id_laporan) {
        this.id_laporan = id_laporan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
