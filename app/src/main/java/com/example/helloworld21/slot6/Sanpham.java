package com.example.helloworld21.slot6;

public class Sanpham {
    private String maSP;
    private String tenSP;
    private int soLuongSp;

    public Sanpham() {
    }

    public Sanpham(String maSP, String tenSP, int soLuongSp) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuongSp = soLuongSp;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuongSp() {
        return soLuongSp;
    }

    public void setSoLuongSp(int soLuongSp) {
        this.soLuongSp = soLuongSp;
    }
}
