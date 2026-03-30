package model;

public class CTKMHoaDon {
    private String maCTKM;
    private String maHD;
    private double giaTriKM;

    public CTKMHoaDon() {
    }

    public CTKMHoaDon(String maCTKM, String maHD, double giaTriKM) {
        this.maCTKM = maCTKM;
        this.maHD = maHD;
        this.giaTriKM = giaTriKM;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }

    public String getMaHD() { return maHD; }
    public void setMaHD(String maHD) { this.maHD = maHD; }

    public double getGiaTriKM() { return giaTriKM; }
    public void setGiaTriKM(double giaTriKM) { this.giaTriKM = giaTriKM; }

    @Override
    public String toString() {
        return "CTKMHoaDon{maCTKM='" + maCTKM + "', maHD='" + maHD + "'}";
    }
}