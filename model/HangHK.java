package model;

public class HangHangKhong {
    private String maHangHK;
    private String tenHangHK;
    private String quocGia;

    // 1. Constructor rỗng
    public HangHangKhong() {
    }

    // 2. Constructor đầy đủ
    public HangHangKhong(String maHangHK, String tenHangHK, String quocGia) {
        this.maHangHK = maHangHK;
        this.tenHangHK = tenHangHK;
        this.quocGia = quocGia;
    }

    // 3. Getter & Setter
    public String getMaHangHK() { return maHangHK; }
    public void setMaHangHK(String maHangHK) { this.maHangHK = maHangHK; }

    public String getTenHangHK() { return tenHangHK; }
    public void setTenHangHK(String tenHangHK) { this.tenHangHK = tenHangHK; }

    public String getQuocGia() { return quocGia; }
    public void setQuocGia(String quocGia) { this.quocGia = quocGia; }

    @Override
    public String toString() {
        return "HangHangKhong{" +
                "Mã='" + maHangHK + '\'' +
                ", Tên='" + tenHangHK + '\'' +
                ", Quốc Gia='" + quocGia + '\'' +
                '}';
    }
}