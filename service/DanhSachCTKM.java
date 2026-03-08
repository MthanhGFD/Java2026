package service;

import java.util.Arrays;
import java.io.*;
import model.CTKM;

public class DanhSachCTKM {

    private CTKM[] dsCTKM;
    private int soLuong;

    public DanhSachCTKM() {
        this.dsCTKM = new CTKM[100];
        this.soLuong = 0;
    }

    public void them(CTKM ctkm) {
        if (soLuong < dsCTKM.length) {
            dsCTKM[soLuong] = ctkm;
            soLuong++;
        } else {
            System.out.println("Danh sách CTKM đã đầy.");
        }
    }

    public boolean sua(String maCTKM, CTKM ctkm) {
        int vt = timViTri(maCTKM);
        if (vt != -1) {
            dsCTKM[vt] = ctkm;
            return true;
        } else return false;
    }

    public boolean xoa(String maCTKM) {
        int vt = timViTri(maCTKM);
        if (vt != -1) {
            for (int i = vt; i < soLuong - 1; i++) {
                dsCTKM[i] = dsCTKM[i + 1];
            }
            dsCTKM[soLuong - 1] = null;
            soLuong--;
            return true;
        } else return false;
    }

    public int timViTri(String maCTKM) {
        for (int i = 0; i < soLuong; i++) {
            if (dsCTKM[i].getMaCTKM().equalsIgnoreCase(maCTKM)) {
                return i;
            }
        }
        return -1;
    }

    public CTKM[] getDanhSach() {
        return Arrays.copyOf(dsCTKM, soLuong);
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
                if (parts.length >= 5) {
                    String ma = parts[0];
                    String ten = parts[1];
                    String bd = parts[2];
                    String kt = parts[3];
                    String nd = parts[4].replace("\"", ""); // remove quotes
                    CTKM ctkm = new CTKM(ma, ten, bd, kt, nd);
                    them(ctkm);
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

}
