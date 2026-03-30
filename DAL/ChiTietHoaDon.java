package DAL;

public class ChiTietHoaDon {
  
    private String maHoaDon;  
    private String maKhachHang;
    private String maVe;
    private double giaVe;
    private double giaVeGiam;

    // ===== Constructor rỗng =====
    public ChiTietHoaDon() {
    }

    // ===== Constructor đầy đủ =====
    public ChiTietHoaDon(String maHoaDon, String maKhachHang ,String maVe, double giaVe, double giaVeGiam) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maVe = maVe;
        this.giaVe = giaVe;
        this.giaVeGiam = giaVeGiam;
    }

    // ===== Getter & Setter =====

    public String getMaHoaDon() { return maHoaDon; }
    public void setMaHoaDon(String maHoaDon) { this.maHoaDon = maHoaDon; }

    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    public double getGiaVeGiam() { return giaVeGiam; }
    public void setGiaVeGiam(double giaVeGiam) { this.giaVeGiam = giaVeGiam; }

    // ===== Hiển thị chi tiết =====
    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", maVe='" + maVe + '\'' +
                ", giaVe=" + giaVe +
                ", giaVeGiam=" + giaVeGiam +
                '}';
    }

}
