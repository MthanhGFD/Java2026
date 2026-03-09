package model;

public class ChiTietHoaDon {
    private String maHD;
    private String maKH;
    private String maVe;
    private double giaVe;
    private double giaSauKhiGiam;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHD, String maKH, String maVe, double giaVe, double giaSauKhiGiam) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maVe = maVe;
        this.giaVe = giaVe;
        this.giaSauKhiGiam = giaSauKhiGiam;
    }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public String getMaKH() { return maKH; }
    public void setMaKH(String maKH) { this.maKH = maKH; }

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    public double getGiaSauKhiGiam() { return giaSauKhiGiam; }
    public void setGiaSauKhiGiam(double giaSauKhiGiam) { this.giaSauKhiGiam = giaSauKhiGiam; }
    
    @Override
    public String toString() {
        return maHD + "," + maKH + "," + maVe + "," + giaVe + "," + giaSauKhiGiam;
    }
}
