package service;

import java.io.*;
import java.util.Arrays;
import model.KhachHang;

public class DanhSachKhachHang {

    private KhachHang[] dsKhachHang;
    private int soLuong;

    public DanhSachKhachHang() {
        dsKhachHang = new KhachHang[0];
        soLuong = 0;
    }

    public KhachHang[] getDHangs() {
        return dsKhachHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // đọc file
    public void docFile(String tenFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] tokens = line.split(",");

                KhachHang kh = new KhachHang();

                kh.setMaKhachHang(tokens[0]);

                String tenDayDu = tokens[1];
                String ten = tenDayDu.substring(tenDayDu.lastIndexOf(" ") + 1);
                String ho = tenDayDu.substring(0, tenDayDu.length() - ten.length());

                kh.setHo(ho);
                kh.setTen(ten);
                kh.setMaKhachHang(tokens[2]);
                kh.setEmail(tokens[3]);
                kh.setNgaySinh(tokens[4]);
                kh.setSoDienThoai(tokens[5]);

                them(kh);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ghi file
    public void ghiFile(String tenFile) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {

            for (int i = 0; i < soLuong; i++) {
                bw.write(dsKhachHang[i].toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // thêm
    public void them(KhachHang hk) {

        if (tim(hk.getMaKhachHang()) != null)
            return;

        dsKhachHang = Arrays.copyOf(dsKhachHang, soLuong + 1);
        dsKhachHang[soLuong] = hk;
        soLuong++;
    }

    // xóa
    public boolean xoa(String maKhachHang) {

        int vitri = timViTri(maKhachHang);

        if (vitri == -1)
            return false;

        for (int i = vitri; i < soLuong - 1; i++) {
            dsKhachHang[i] = dsKhachHang[i + 1];
        }

        dsKhachHang = Arrays.copyOf(dsKhachHang, soLuong - 1);
        soLuong--;

        return true;
    }

    // sửa
    public boolean sua(KhachHang hkMoi) {

        int vitri = timViTri(hkMoi.getMaKhachHang());

        if (vitri == -1)
            return false;

        dsKhachHang[vitri] = hkMoi;

        return true;
    }

    // tìm theo mã
    public KhachHang tim(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsKhachHang[i].getMaKhachHang().equals(ma)) {
                return dsKhachHang[i];
            }
        }

        return null;
    }

    // tìm vị trí
    public int timViTri(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsKhachHang[i].getMaKhachHang().equals(ma)) {
                return i;
            }
        }

        return -1;
    }

    // tìm theo tên
    public KhachHang[] timTen(String ten) {

        KhachHang[] ds = new KhachHang[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsKhachHang[i].getTen().equalsIgnoreCase(ten)) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsKhachHang[i];
                j++;
            }
        }
        return ds;
    }

    public KhachHang[] timNgaySinh(String ngaySinh) {

        KhachHang[] ds = new KhachHang[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsKhachHang[i].getNgaySinh().equals(ngaySinh)) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsKhachHang[i];
                j++;
            }
        }

        return ds;
    }

    // tìm SĐT
    public KhachHang timSDT(String sdt) {

        for (int i = 0; i < soLuong; i++) {

            if (dsKhachHang[i].getSoDienThoai().equals(sdt)) {
                return dsKhachHang[i];
            }
        }

        return null;
    }
}