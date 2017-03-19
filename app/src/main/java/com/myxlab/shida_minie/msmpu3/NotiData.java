package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 12/19/2016.
 */
public class NotiData {

    String nama,status;
    int icon;

    public NotiData(int icon, String nama, String status) {
        this.icon = icon;
        this.nama= nama;
        this.status = status;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
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
