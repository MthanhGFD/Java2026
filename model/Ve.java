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


// ===== Vé thường =====
class VeThuong extends Ve {

    private double PhiHanhLy;
    private double PhiDichVu;

    public VeThuong() {
    }

    public VeThuong(String MaVe, String MaChuyenBay, String MaGhe, double GiaVe, String LoaiVe,
                    double PhiHanhLy, double PhiDichVu) {
        super(MaVe, MaChuyenBay, MaGhe, GiaVe, LoaiVe);
        this.PhiHanhLy = PhiHanhLy;
        this.PhiDichVu = PhiDichVu;
    }

    public double getPhiHanhLy() {
        return PhiHanhLy;
    }

    public void setPhiHanhLy(double PhiHanhLy) {
        this.PhiHanhLy = PhiHanhLy;
    }

    public double getPhiDichVu() {
        return PhiDichVu;
    }

    public void setPhiDichVu(double PhiDichVu) {
        this.PhiDichVu = PhiDichVu;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", PhiHanhLy=" + PhiHanhLy +
                ", PhiDichVu=" + PhiDichVu;
    }
}


// ===== Vé VIP =====
class VeVIP extends Ve {

    private String PhongCho;
    private String QuaTang;

    public VeVIP() {
    }

    public VeVIP(String MaVe, String MaChuyenBay, String MaGhe, double GiaVe, String LoaiVe,
                 String PhongCho, String QuaTang) {
        super(MaVe, MaChuyenBay, MaGhe, GiaVe, LoaiVe);
        this.PhongCho = PhongCho;
        this.QuaTang = QuaTang;
    }

    public String getPhongCho() {
        return PhongCho;
    }

    public void setPhongCho(String PhongCho) {
        this.PhongCho = PhongCho;
    }

    public String getQuaTang() {
        return QuaTang;
    }

    public void setQuaTang(String QuaTang) {
        this.QuaTang = QuaTang;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", PhongCho='" + PhongCho + '\'' +
                ", QuaTang='" + QuaTang + '\'';
    }
}
