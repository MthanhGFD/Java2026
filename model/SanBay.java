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
    
    public String getmaSanBay(){return maSanBay;}
    public void setmaSanBay( String maSB ){this.maSanBay = maSB;}

    public String getmaDiaDiem(){return maDiaDiem;}
    public void setmaDiaDiem(String maDD) {this.maDiaDiem = maDD;}

    public String gettenChuyenBay(){return tenChuyenBay;}
    public void settenChuyenBay(String tenCB){this.tenChuyenBay = tenCB;}
}