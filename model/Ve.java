package model;

public class Ve {

    protected String MaVe;
    protected String MaChuyenBay;
    protected String MaGhe;
    protected double GiaVe;
    protected String LoaiVe;

    public Ve() {
    }

    public Ve(String MaVe, String MaChuyenBay, String MaGhe, double GiaVe, String LoaiVe) {
        this.MaVe = MaVe;
        this.MaChuyenBay = MaChuyenBay;
        this.MaGhe = MaGhe;
        this.GiaVe = GiaVe;
        this.LoaiVe = LoaiVe;
    }

    public String getMaVe() {
        return MaVe;
    }

    public void setMaVe(String MaVe) {
        this.MaVe = MaVe;
    }

    public String getMaChuyenBay() {
        return MaChuyenBay;
    }

    public void setMaChuyenBay(String MaChuyenBay) {
        this.MaChuyenBay = MaChuyenBay;
    }

    public String getMaGhe() {
        return MaGhe;
    }

    public void setMaGhe(String MaGhe) {
        this.MaGhe = MaGhe;
    }

    public double getGiaVe() {
        return GiaVe;
    }

    public void setGiaVe(double GiaVe) {
        this.GiaVe = GiaVe;
    }

    public String getLoaiVe() {
        return LoaiVe;
    }

    public void setLoaiVe(String LoaiVe) {
        this.LoaiVe = LoaiVe;
    }

    @Override
    public String toString() {
        return "Ve{" +
                "MaVe='" + MaVe + '\'' +
                ", MaChuyenBay='" + MaChuyenBay + '\'' +
                ", MaGhe='" + MaGhe + '\'' +
                ", GiaVe=" + GiaVe +
                ", LoaiVe='" + LoaiVe + '\'' +
                '}';
    }
}
