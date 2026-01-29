package model;

public class KhachHang {
    private String maKhachHang;
    private String ho;
    private String ten;
    private String ngaySinh;    
    private String soDienThoai;
    private String email;

    // 1. Constructor rỗng
    public KhachHang() {
    }

    // 2. Constructor đầy đủ
    public KhachHang(String maKhachHang, String ho, String ten, String ngaySinh, String soDienThoai, String email) {
        this.maKhachHang = maKhachHang;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    // 3. Getter & Setter 
    public String getMaKhachHang() { return maKhachHang; }
    public void setMaKhachHang(String maKhachHang) { this.maKhachHang = maKhachHang; }

    public String getHo() { return ho; }
    public void setHo(String ho) { this.ho = ho; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // 4. toString để in ra màn hình cho đẹp
    @Override
    public String toString() {
        return "KhachHang{" +
                "Mã='" + maKhachHang + '\'' +
                ", Họ Tên='" + ho + " " + ten + '\'' +
                ", SĐT='" + soDienThoai + '\'' +
                '}';
    }
}