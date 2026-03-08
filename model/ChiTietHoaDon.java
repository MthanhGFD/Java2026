package model;

public class ChiTietHoaDon {

    private String maChiTiet;     
    private String maHoaDon;      
    private String tenHanhKhach;  
    private String loaiVe;        
    private String soGhe;
    private double giaVe;
    private String ghiChu;

    // ===== Constructor rỗng =====
    public ChiTietHoaDon() {
    }

    // ===== Constructor đầy đủ =====
    public ChiTietHoaDon(String maChiTiet, String maHoaDon,
                         String tenHanhKhach, String loaiVe,
                         String soGhe, double giaVe, String ghiChu) {
        this.maChiTiet = maChiTiet;
        this.maHoaDon = maHoaDon;
        this.tenHanhKhach = tenHanhKhach;
        this.loaiVe = loaiVe;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
        this.ghiChu = ghiChu;
    }

    // ===== Getter & Setter =====

    public String getMaChiTiet() { return maChiTiet; }
    public void setMaChiTiet(String maChiTiet) { this.maChiTiet = maChiTiet; }

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getTenHanhKhach() { return tenHanhKhach; }
    public void setTenHanhKhach(String tenHanhKhach) { this.tenHanhKhach = tenHanhKhach; }

    public String getLoaiVe() { return loaiVe; }
    public void setLoaiVe(String loaiVe) { this.loaiVe = loaiVe; }

    public String getSoGhe() { return soGhe; }
    public void setSoGhe(String soGhe) { this.soGhe = soGhe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }

    // ===== Hiển thị chi tiết =====
    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "Mã CT='" + maChiTiet + '\'' +
                ", Mã HĐ='" + maHoaDon + '\'' +
                ", Hành khách='" + tenHanhKhach + '\'' +
                ", Loại vé='" + loaiVe + '\'' +
                ", Ghế='" + soGhe + '\'' +
                ", Giá vé=" + giaVe +
                '}';
    }

}
