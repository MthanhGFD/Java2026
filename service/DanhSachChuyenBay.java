package service;

import model.ChuyenBay;
import java.io.*;
import java.util.Arrays;

public class DanhSachChuyenBay {

    private ChuyenBay[] dsChuyenBay;
    private int soLuong;

    public DanhSachChuyenBay() {
        dsChuyenBay = new ChuyenBay[0];
        soLuong = 0;
    }

    public ChuyenBay[] getDanhSach() {
        return dsChuyenBay;
    }

    public int getSoLuong() {
        return soLuong;
    }

    // Đọc file (chưa có file nên để tạm tenFile)
    public void docFile(String tenFile) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(tenFile));
            String line;

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                ChuyenBay cb = new ChuyenBay();
                cb.setMaChuyenBay(tokens[0]);
                cb.setMaSanBayDi(tokens[1]);
                cb.setMaSanBayDen(tokens[2]);
                cb.setGioBay(tokens[3]);
                cb.setGioDen(tokens[4]);

                them(cb);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ghi file
    public void ghiFile(String tenFile) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));

            for (int i = 0; i < soLuong; i++) {
                bw.write(dsChuyenBay[i].toString());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thêm/xóa/sửa/tìm kiếm
    public void them(ChuyenBay cb) {

        dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong + 1);
        dsChuyenBay[soLuong] = cb;
        soLuong++;
    }

    public boolean xoa(String ma) {
        int viTri = timViTri(ma);

        if (viTri == -1)
            return false;

        for (int i = viTri; i < soLuong - 1; i++) {
            dsChuyenBay[i] = dsChuyenBay[i + 1];
        }

        dsChuyenBay = Arrays.copyOf(dsChuyenBay, soLuong - 1);
        soLuong--;

        return true;
    }

    public boolean sua(ChuyenBay cbMoi) {

        int viTri = timViTri(cbMoi.getMaChuyenBay());

        if (viTri == -1)
            return false;

        dsChuyenBay[viTri] = cbMoi;

        return true;
    }
    // Tìm theo mã
    public ChuyenBay tim(String ma) {

        for (int i = 0; i < soLuong; i++) {
            if (dsChuyenBay[i].getMaChuyenBay().equals(ma)) {
                return dsChuyenBay[i];
            }
        }

        return null;
    }

    // Tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsChuyenBay[i].getMaChuyenBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // Tìm theo điểm đến
    public ChuyenBay[] timSanBayDen(String sbDen) {

        ChuyenBay[] ketQua = new ChuyenBay[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsChuyenBay[i].getMaSanBayDen().equalsIgnoreCase(sbDen)) {

                ketQua = Arrays.copyOf(ketQua, j + 1);
                ketQua[j] = dsChuyenBay[i];
                j++;
            }
        }

        return ketQua;
    }

    // Tìm theo ngày
    public ChuyenBay[] timNgay(String ngay) {

        ChuyenBay[] ketQua = new ChuyenBay[0];
        int j = 0;

        for (int i = 0; i < soLuong; i++) {

            if (dsChuyenBay[i].getNgayBay().equals(ngay)) {

                ketQua = Arrays.copyOf(ketQua, j + 1);
                ketQua[j] = dsChuyenBay[i];
                j++;
            }
        }

        return ketQua;
    }
}