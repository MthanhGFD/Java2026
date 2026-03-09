package service;

import model.MayBay;
import java.io.*;
import java.util.Arrays;

public class DanhSachMayBay {

    private MayBay[] dsMayBay;
    private int soLuong;

    public DanhSachMayBay() {
        dsMayBay = new MayBay[0];
        soLuong = 0;
    }

    public MayBay[] getDsMayBay() {
        return dsMayBay;
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
                MayBay mb = new MayBay();
                int soLuong = Integer.parseInt(tokens[1]);
                mb.setMaMayBay(tokens[0]);
                mb.setSoGhe(soLuong);
                mb.setTenMayBay((tokens[2]));

                them(mb);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ghi file
    public void ghiFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < soLuong; i++) {

                bw.write(dsMayBay[i].toString());
                bw.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // thêm
    public void them(MayBay mb) {
        if (tim(mb.getMaMayBay()) != null)
            return;
        dsMayBay = Arrays.copyOf(dsMayBay, soLuong + 1);
        dsMayBay[soLuong] = mb;
        soLuong++;
    }

    // xóa
    public boolean xoa(String maMayBay) {
        int vitri = timViTri(maMayBay);
        if (vitri == -1)
            return false;
        for (int i = vitri; i < soLuong - 1; i++) {
            dsMayBay[i] = dsMayBay[i + 1];
        }
        dsMayBay = Arrays.copyOf(dsMayBay, soLuong - 1);
        soLuong--;
        return true;
    }

    // sửa
    public boolean sua(MayBay mbMoi) {
        int vitri = timViTri(mbMoi.getMaMayBay());
        if (vitri == -1)
            return false;

        dsMayBay[vitri] = mbMoi;

        return true;
    }

    // tìm theo mã
    public MayBay tim(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsMayBay[i].getMaMayBay().equals(ma)) {
                return dsMayBay[i];
            }
        }

        return null;
    }

    // tìm vị trí
    public int timViTri(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsMayBay[i].getMaMayBay().equals(ma)) {
                return i;
            }
        }
        return -1;
    }
}