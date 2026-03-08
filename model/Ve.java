package model;

public class Ve {

    private String maVe;           
    private String maChuyenBay;   
    private String tenHanhKhach;   
    private String cccd;           
    private String loaiVe;         
    private String soGhe;          
    private double giaVe;          
    private String trangThai;      

    // ===== Constructor rỗng =====
    public Ve() {
    }

    // ===== Constructor đầy đủ =====
    public Ve(String maVe, String maChuyenBay, String tenHanhKhach,
              String cccd, String loaiVe, String soGhe,
              double giaVe, String trangThai) {

        this.maVe = maVe;
        this.maChuyenBay = maChuyenBay;
        this.tenHanhKhach = tenHanhKhach;
        this.cccd = cccd;
        this.loaiVe = loaiVe;
        this.soGhe = soGhe;
        this.giaVe = giaVe;
        this.trangThai = trangThai;
    }

    // ===== Getter & Setter =====

    public String getMaVe() { return maVe; }
    public void setMaVe(String maVe) { this.maVe = maVe; }

    public String getMaChuyenBay() { return maChuyenBay; }
    public void setMaChuyenBay(String maChuyenBay) { this.maChuyenBay = maChuyenBay; }

    public String getTenHanhKhach() { return tenHanhKhach; }
    public void setTenHanhKhach(String tenHanhKhach) { this.tenHanhKhach = tenHanhKhach; }

    public String getCccd() { return cccd; }
    public void setCccd(String cccd) { this.cccd = cccd; }

    public String getLoaiVe() { return loaiVe; }
    public void setLoaiVe(String loaiVe) { this.loaiVe = loaiVe; }

    public String getSoGhe() { return soGhe; }
    public void setSoGhe(String soGhe) { this.soGhe = soGhe; }

    public double getGiaVe() { return giaVe; }
    public void setGiaVe(double giaVe) { this.giaVe = giaVe; }

    public String getTrangThai() { return trangThai; }
    public void setTrangThai(String trangThai) { this.trangThai = trangThai; }

    // ===== Hiển thị =====
    @Override
    public String toString() {
        return "Ve{" +
                "Mã vé='" + maVe + '\'' +
                ", Hành khách='" + tenHanhKhach + '\'' +
                ", Ghế='" + soGhe + '\'' +
                ", Giá=" + giaVe +
                ", Trạng thái='" + trangThai + '\'' +
                '}';
    }

}
