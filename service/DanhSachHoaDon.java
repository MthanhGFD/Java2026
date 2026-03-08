package service;

import java.util.Arrays;
import java.io.*;
import model.HoaDon;

public class DanhSachHoaDon {

    private HoaDon[] dsHoaDon;
    private int soLuong;

    public DanhSachHoaDon() {
        this.dsHoaDon = new HoaDon[100];
        this.soLuong = 0;
    }

    public void them(HoaDon hoaDon) {
        if (soLuong < dsHoaDon.length) {
            dsHoaDon[soLuong] = hoaDon;
            soLuong++;
        } else {
            System.out.println("Danh sách hóa đơn đã đầy.");
        }
    }

    public boolean sua(String maHoaDon, HoaDon hoaDon) {
        int vt = timViTri(maHoaDon);
        if (vt != -1) {
            dsHoaDon[vt] = hoaDon;
            return true;
        } else return false;
    }

    public boolean xoa(String maHoaDon) {
        int vt = timViTri(maHoaDon);
        if (vt != -1) {
            for (int i = vt; i < soLuong - 1; i++) {
                dsHoaDon[i] = dsHoaDon[i + 1];
            }
            dsHoaDon[soLuong - 1] = null;
            soLuong--;
            return true;
        } else  return false;
    }

    public int timViTri(String maHoaDon) {
        for (int i = 0; i < soLuong; i++) {
            if (dsHoaDon[i].getMaHoaDon().equalsIgnoreCase(maHoaDon)) {
                return i;
            }
        }
        return -1;
    }

    public HoaDon[] getDanhSach() {
        return Arrays.copyOf(dsHoaDon, soLuong);
    }

    public void docDuLieuTuFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // skip header
                }
                String[] parts = line.split(",");
                if (parts.length >= 9) {
                    String maHD = parts[0];
                    String maKH = parts[1];
                    int soVe = Integer.parseInt(parts[2]);
                    double tongTien = Double.parseDouble(parts[3]);
                    String maCB = parts[4];
                    String ngay = parts[5];
                    String maKM = parts[6].isEmpty() ? null : parts[6];
                    double giaGiam = Double.parseDouble(parts[7]);
                    String ghiChu = parts[8].replace("\"", "");
                    HoaDon hd = new HoaDon(maHD, maKH, soVe, tongTien, maCB, ngay, maKM, giaGiam, ghiChu);
                    them(hd);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

}

