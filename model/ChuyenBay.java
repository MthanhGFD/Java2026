package model;

public class ChuyenBay{
   String maChuyenBay;
   String maMayBay;
   String maHangHangKhong;
   String maSanBayDi;
   String maSanBayDen;
   String NgayBay;
   String GioBay;
   String GioDen; //Du Kien
   
   int TongSoVe;
    int SoVeDaBan;
    int SoVeConLai;
    long TienVeThuVe;

    public ChuyenBay(){}    
    
    public ChuyenBay(String maCB, String maMB, String maHHK, String maSBDi, String maSBDen, String NgayBay, String GioBay, String GioDen, int TongSoVe, int SoVeDaBan){
        this.maChuyenBay = maCB;
        this.maMayBay = maMB;
        this.maHangHangKhong = maHHK;
        this.maSanBayDi = maSBDi;
        this.maSanBayDen = maSBDen;
        this.NgayBay = NgayBay;
        this.GioBay = GioBay;
        this.GioDen = GioDen;
        this.TongSoVe = TongSoVe;
        this.SoVeDaBan = SoVeDaBan;
        
    }

    // Getters and setters
    public String getMaChuyenBay() { return maChuyenBay; }
    public void setMaChuyenBay(String maChuyenBay) { this.maChuyenBay = maChuyenBay; }

    public String getMaMayBay() { return maMayBay; }
    public void setMaMayBay(String maMayBay) { this.maMayBay = maMayBay; }

    public String getMaHangHangKhong() { return maHangHangKhong; }
    public void setMaHangHangKhong(String maHangHangKhong) { this.maHangHangKhong = maHangHangKhong; }

    public String getMaSanBayDi() { return maSanBayDi; }
    public void setMaSanBayDi(String maSanBayDi) { this.maSanBayDi = maSanBayDi; }

    public String getMaSanBayDen() { return maSanBayDen; }
    public void setMaSanBayDen(String maSanBayDen) { this.maSanBayDen = maSanBayDen; }

    public String getNgayBay() { return NgayBay; }
    public void setNgayBay(String NgayBay) { this.NgayBay = NgayBay; }

    public String getGioBay() { return GioBay; }
    public void setGioBay(String GioBay) { this.GioBay = GioBay; }

    public String getGioDen() { return GioDen; }
    public void setGioDen(String GioDen) { this.GioDen = GioDen; }

    public int getTongSoVe() { return TongSoVe; }
    public void setTongSoVe(int TongSoVe) { this.TongSoVe = TongSoVe;  }

    public int getSoVeDaBan() { return SoVeDaBan; }
    public void setSoVeDaBan(int SoVeDaBan) { this.SoVeDaBan = SoVeDaBan; }

    public int getSoVeConLai() { return this.TongSoVe - this.SoVeDaBan; }

    public long getTienVeThuVe(long giaVe){ 
        this.TienVeThuVe = giaVe * this.SoVeDaBan;
        return this.TienVeThuVe;
    }
}