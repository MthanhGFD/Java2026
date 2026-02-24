package model;

public class MayBay {
    private String maMayBay;
    private String tenMayBay;
    private int soGhe;

    // 1. Constructor rỗng
    public MayBay() {
    }

    // 2. Constructor đầy đủ
    public MayBay(String maMayBay, String tenMayBay, int soGhe) {
        this.maMayBay = maMayBay;
        this.tenMayBay = tenMayBay;
        this.soGhe = soGhe;
    }

    // 3. Getter & Setter
    public String getMaMayBay() { return maMayBay; }
    public void setMaMayBay(String maMayBay) { this.maMayBay = maMayBay; }

    public String getTenMayBay() { return tenMayBay; }
    public void setTenMayBay(String tenMayBay) { this.tenMayBay = tenMayBay; }

    public int getSoGhe() { return soGhe; }
    public void setSoGhe(int soGhe) { this.soGhe = soGhe; }

    @Override
    public String toString() {
        return "MayBay{" +
                "Mã='" + maMayBay + '\'' +
                ", Tên='" + tenMayBay + '\'' +
                ", Số Chỗ Ngồi=" + soGhe +
                '}';
    }
}