package service;

import model.HangHangKhong;
import java.io.*;
import java.util.Arrays;

public class DanhSachHangHangKhong {

    private HangHangKhong[] dsHangHangKhong;
    private int soLuong;

    public DanhSachHangHangKhong() {
        dsHangHangKhong = new HangHangKhong[0];
        soLuong = 0;
    }

    public HangHangKhong[] getDanhSach() {
        return dsHangHangKhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // =========================
    // Đọc file
    // =========================
    public void docFile(String tenFile) {

        try{
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String line;

            while ((line = br.readLine()) != null) {

                String[] tokens = line.split(",");

                HangHangKhong hhk = new HangHangKhong();
                hhk.setMaHang(tokens[0]);
                hhk.setTenHang(tokens[1]);
                hhk.setQuocGia(tokens[2]);

                them(hhk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =========================
    // Ghi file
    // =========================
    public void ghiFile(String tenFile) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {

            for (int i = 0; i < soLuong; i++) {
                bw.write(dsHangHangKhong[i].toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Them sua xoa tim kiem
    public void them(HangHangKhong hhk) {

        dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong + 1);
        dsHangHangKhong[soLuong] = hhk;
        soLuong++;
    }

    public boolean xoa(String ma) {

        int vitri = timViTri(ma);

        if (vitri == -1)
            return false;

        for (int i = vitri; i < soLuong - 1; i++) {
            dsHangHangKhong[i] = dsHangHangKhong[i + 1];
        }

        dsHangHangKhong = Arrays.copyOf(dsHangHangKhong, soLuong - 1);
        soLuong--;

        return true;
    }

    public boolean sua(HangHangKhong hhkMoi) {

        int vitri = timViTri(hhkMoi.getMaHang());

        if (vitri == -1)
            return false;

        dsHangHangKhong[vitri] = hhkMoi;

        return true;
    }

    public HangHangKhong tim(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsHangHangKhong[i].getMaHang().equals(ma)) {
                return dsHangHangKhong[i];
            }
        }

        return null;
    }

    public HangHangKhong timTheoTen(String tenHang) {

        for (int i = 0; i < soLuong; i++) {
            if (dsHangHangKhong[i].getTenHang().equalsIgnoreCase(tenHang)) {
                return dsHangHangKhong[i];
            }
        }

        return null;
    }

    public HangHangKhong[] timTheoQuocGia(String quocGia) {

        HangHangKhong[] ketQua = new HangHangKhong[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHangHangKhong[i].getQuocGia().equalsIgnoreCase(quocGia)) {

                ketQua = Arrays.copyOf(ketQua, j + 1);
                ketQua[j] = dsHangHangKhong[i];
                j++;
            }
        }

        return ketQua;
    }

    public int timViTri(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsHangHangKhong[i].getMaHang().equals(ma)) {
                return i;
            }
        }

        return -1;
    }
}