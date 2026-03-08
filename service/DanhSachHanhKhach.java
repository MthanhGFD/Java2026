package service;

import java.io.*;
import java.util.Arrays;
import model.HanhKhach;

public class DanhSachHanhKhach {

    private HanhKhach[] dsHanhKhach;
    private int soLuong;

    public DanhSachHanhKhach() {
        dsHanhKhach = new HanhKhach[0];
        soLuong = 0;
    }

    public HanhKhach[] getDsHanhKhach() {
        return dsHanhKhach;
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

                HanhKhach hk = new HanhKhach();

                hk.setMaHanhKhach(tokens[0]);

                String tenDayDu = tokens[1];
                String ten = tenDayDu.substring(tenDayDu.lastIndexOf(" ") + 1);
                String ho = tenDayDu.substring(0, tenDayDu.length() - ten.length());

                hk.setHo(ho);
                hk.setTen(ten);
                hk.setNgaysinh(tokens[2]);
                hk.setDanhxung(tokens[3]);
                hk.setCccd(tokens[4]);
                hk.setSdt(tokens[5]);
                hk.setLoaiHanhKhach(tokens[6]);

                them(hk);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ghi file
    public void ghiFile(String tenFile) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {

            for (int i = 0; i < soLuong; i++) {
                bw.write(dsHanhKhach[i].toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // thêm
    public void them(HanhKhach hk) {

        if (tim(hk.getMaHanhKhach()) != null)
            return;

        dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong + 1);
        dsHanhKhach[soLuong] = hk;
        soLuong++;
    }

    // xóa
    public boolean xoa(String maHanhKhach) {

        int vitri = timViTri(maHanhKhach);

        if (vitri == -1)
            return false;

        for (int i = vitri; i < soLuong - 1; i++) {
            dsHanhKhach[i] = dsHanhKhach[i + 1];
        }

        dsHanhKhach = Arrays.copyOf(dsHanhKhach, soLuong - 1);
        soLuong--;

        return true;
    }

    // sửa
    public boolean sua(HanhKhach hkMoi) {

        int vitri = timViTri(hkMoi.getMaHanhKhach());

        if (vitri == -1)
            return false;

        dsHanhKhach[vitri] = hkMoi;

        return true;
    }

    // tìm theo mã
    public HanhKhach tim(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsHanhKhach[i].getMaHanhKhach().equals(ma)) {
                return dsHanhKhach[i];
            }
        }

        return null;
    }

    // tìm vị trí
    public int timViTri(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsHanhKhach[i].getMaHanhKhach().equals(ma)) {
                return i;
            }
        }

        return -1;
    }

    // tìm theo tên
    public HanhKhach[] timTen(String ten) {

        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].getTen().equalsIgnoreCase(ten)) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }

        sortTen(ds);

        return ds;
    }

    // danh sách VIP
    public HanhKhach[] dsVip() {

        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].getLoaiHanhKhach().equalsIgnoreCase("vip")) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }

        sortTen(ds);

        return ds;
    }

    // danh sách thường
    public HanhKhach[] dsThuong() {

        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].getLoaiHanhKhach().equalsIgnoreCase("thuong")) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }

        sortTen(ds);

        return ds;
    }

    // tìm theo ngày sinh
    public HanhKhach[] timNgaySinh(String ngaySinh) {

        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].getNgaysinh().equals(ngaySinh)) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }

        return ds;
    }

    // tìm SĐT
    public HanhKhach timSDT(String sdt) {

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].getSdt().equals(sdt)) {
                return dsHanhKhach[i];
            }
        }

        return null;
    }

    // tìm theo tuổi
    public HanhKhach[] dsTuoi(int tuoi) {

        HanhKhach[] ds = new HanhKhach[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsHanhKhach[i].tuoi() == tuoi) {

                ds = Arrays.copyOf(ds, j + 1);
                ds[j] = dsHanhKhach[i];
                j++;
            }
        }

        return ds;
    }

    // thống kê tuổi
    public int[] thongKeTuoi() {
        int[] slTuoi = new int[100];

        for (int i = 0; i < soLuong; i++) {
            slTuoi[dsHanhKhach[i].tuoi()]++;
        }

        return slTuoi;
    }

    // sắp xếp theo tên
    private void sortTen(HanhKhach[] ds) {
        for (int i = 0; i < ds.length - 1; i++) {
            for (int j = i + 1; j < ds.length; j++) {
                if (ds[i].getTen().compareToIgnoreCase(ds[j].getTen()) > 0) {
                    HanhKhach temp = ds[i];
                    ds[i] = ds[j];
                    ds[j] = temp;
                }
            }
        }
    }
}