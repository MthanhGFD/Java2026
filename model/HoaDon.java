package model;

public class HoaDon {
    private String maHoaDon;
    private String maKhachHang;   
    private int tongSoVeDat;      
    private double tongTienVe;    
    private String maChuyenBay;   
    private String ngayDat;
    private String maKhuyenMai;   
    private double giaSauKhiGiam; 
    private String ghiChu;

    // 1. Constructor rỗng
    public HoaDon() {
    }

    // 2. Constructor đầy đủ
    public HoaDon(String maHoaDon, String maKhachHang, int tongSoVeDat, double tongTienVe, String maChuyenBay, String ngayDat, String maKhuyenMai, double giaSauKhiGiam, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.tongSoVeDat = tongSoVeDat;
        this.tongTienVe = tongTienVe;
        this.maChuyenBay = maChuyenBay;
        this.ngayDat = ngayDat;
        this.maKhuyenMai = maKhuyenMai;
        this.giaSauKhiGiam = giaSauKhiGiam;
        this.ghiChu = ghiChu;
    }

    // 3. Getter & Setter
    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public int getTongSoVeDat() { return tongSoVeDat; }
    public void setTongSoVeDat(int tongSoVeDat) { this.tongSoVeDat = tongSoVeDat; }

    public double getTongTienVe() { return tongTienVe; }
    public void setTongTienVe(double tongTienVe) { this.tongTienVe = tongTienVe; }

    public String getMaChuyenBay() { return maChuyenBay; }
    public void setMaChuyenBay(String maChuyenBay) { this.maChuyenBay = maChuyenBay; }

    public String getNgayDat() { return ngayDat; }
    public void setNgayDat(String ngayDat) { this.ngayDat = ngayDat; }

    public String getMaKhuyenMai() { return maKhuyenMai; }
    public void setMaKhuyenMai(String maKhuyenMai) { this.maKhuyenMai = maKhuyenMai; }

    public double getGiaSauKhiGiam() { return giaSauKhiGiam; }
    public void setGiaSauKhiGiam(double giaSauKhiGiam) { this.giaSauKhiGiam = giaSauKhiGiam; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    @Override
    public String toString() {
        return "HoaDon{" +
                "Mã HĐ='" + maHoaDon + '\'' +
                ", Khách='" + maKhachHang + '\'' +
                ", Tổng tiền=" + giaSauKhiGiam +
                '}';
    }
}