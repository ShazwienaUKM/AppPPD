package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 1/13/2017.
 */
public class LaporanData {

    String nama,status;

    public LaporanData() {
    }

    public LaporanData(String question, String answer) {
        this.nama = question;
        this.status = answer;
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
