package DAL;

public class SanBay {
    String maSanBay;
    String maDiaDiem;
    String tenSanBay;

    public SanBay(){}

    public SanBay(String maSB, String maDD, String tenCB){
        this.maSanBay = maSB;
        this.maDiaDiem = maDD;
        this.tenSanBay = tenCB;
    }
    
    public String getMaSanBay(){return maSanBay;}
    public void setMaSanBay( String maSB ){this.maSanBay = maSB;}

    public String getMaDiaDiem(){return maDiaDiem;}
    public void setMaDiaDiem(String maDD) {this.maDiaDiem = maDD;}
    
    public String getTenSanBay(){return tenSanBay;}
    public void setTenSanBay(String tenCB){this.tenSanBay = tenCB;}

    @Override
    public String toString(){   
        return "SanBay{" +
                "maSanBay='" + maSanBay + '\'' +
                ", maDiaDiem='" + maDiaDiem + '\'' +
                ", tenChuyenBay='" + tenSanBay + '\'' +
                '}';
    }
}

