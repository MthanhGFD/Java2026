package service;

import java.util.Arrays;
import java.io.*;
import model.DiaDiem;


public class DanhSachDiaDiem {

    private DiaDiem[] dsDiaDiem;
    private int soLuong;

    public DanhSachDiaDiem() {
        this.dsDiaDiem = new DiaDiem[100];
        this.soLuong = 0;
    }

    public void them(DiaDiem diaDiem) {
        if (soLuong < dsDiaDiem.length) {
            dsDiaDiem[soLuong] = diaDiem;
            soLuong++;
        } else {
            System.out.println("Danh sách địa điểm đã đầy.");
        }
    }

    public boolean sua(String maDiaDiem, DiaDiem diaDiem) {
        int vt = timViTri(maDiaDiem);
        if (vt != -1) {
            dsDiaDiem[vt] = diaDiem;
            return true;
        } else return false;
    }

    public boolean xoa(String maDiaDiem) {
        int vt = timViTri(maDiaDiem);
        if (vt != -1) {
            for (int i = vt; i < soLuong - 1; i++) {
                dsDiaDiem[i] = dsDiaDiem[i + 1];
            }
            dsDiaDiem[soLuong - 1] = null;
            soLuong--;
            return true;
        } else return false;
    }

    public int timViTri(String maDiaDiem) {
        for (int i = 0; i < soLuong; i++) {
            if (dsDiaDiem[i].getMaDiaDiem().equalsIgnoreCase(maDiaDiem)) {
                return i;
            }
        }
        return -1;
    }

    public DiaDiem[] getDanhSach() {
        return Arrays.copyOf(dsDiaDiem, soLuong);
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
                if (parts.length >= 3) {
                    String ma = parts[0];
                    String ten = parts[1];
                    String qg = parts[2];
                    DiaDiem dd = new DiaDiem(ma, ten, qg);
                    them(dd);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

}
