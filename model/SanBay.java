package model;

public class SanBay {
    String maSanBay;
    String maDiaDiem;
    String tenChuyenBay;

    public SanBay(){}

    public SanBay(String maSB, String maDD, String tenCB){
        this.maSanBay = maSB;
        this.maDiaDiem = maDD;
        this.tenChuyenBay = tenCB;
    }
    
    public String getMaSanBay(){return maSanBay;}
    public void setMaSanBay( String maSB ){this.maSanBay = maSB;}

    public String getMaDiaDiem(){return maDiaDiem;}
    public void setMaDiaDiem(String maDD) {this.maDiaDiem = maDD;}
    
    public String getTenChuyenBay(){return tenChuyenBay;}
    public void setTenChuyenBay(String tenCB){this.tenChuyenBay = tenCB;}
}