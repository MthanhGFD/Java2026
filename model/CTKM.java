package model;

public class CTKM {
    String maCTKM;
    String tenCTKM;
    String ngayBD;
    String ngayKT;
    String noiDung;

    public CTKM() {
    }

    public CTKM(String maCTKM, String tenCTKM, String ngayBD, String ngayKT, String noiDung) {
        this.maCTKM = maCTKM;
        this.tenCTKM = tenCTKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.noiDung = noiDung;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }

    public String getTenCTKM() { return tenCTKM; }
    public void setTenCTKM(String tenCTKM) { this.tenCTKM = tenCTKM; }

    public String getNgayBD() { return ngayBD; }
    public void setNgayBD(String ngayBD) { this.ngayBD = ngayBD; }

    public String getNgayKT() { return ngayKT; }
    public void setNgayKT(String ngayKT) { this.ngayKT = ngayKT; }

    public String getNoiDung() { return noiDung; }
    public void setNoiDung(String noiDung) { this.noiDung = noiDung; }
    
}
