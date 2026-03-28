package model;

public class CTKMChuyenBay {
    private String maCTKM;
    private String maCB;
    private double giaTriKM;

    public CTKMChuyenBay() {
    }

    public CTKMChuyenBay(String maCTKM, String maCB, double giaTriKM) {
        this.maCTKM = maCTKM;
        this.maCB = maCB;
        this.giaTriKM = giaTriKM;
    }

    public String getMaCTKM() { return maCTKM; }
    public void setMaCTKM(String maCTKM) { this.maCTKM = maCTKM; }

    public String getMaCB() { return maCB; }
    public void setMaCB(String maCB) { this.maCB = maCB; }

    public double getGiaTriKM() { return giaTriKM; }
    public void setGiaTriKM(double giaTriKM) { this.giaTriKM = giaTriKM; }

    @Override
    public String toString() {
        return "CTKMChuyenBay{maCTKM='" + maCTKM + "', maCB='" + maCB + "'}";
    }
}