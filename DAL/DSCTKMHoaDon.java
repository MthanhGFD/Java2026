package model;

import java.util.ArrayList;

public class DSCTKMHoaDon {
    private ArrayList<CTKMHoaDon> dsCTKMHoaDon;

    public DSCTKMHoaDon() {
        this.dsCTKMHoaDon = new ArrayList<>();
    }

    public ArrayList<CTKMHoaDon> getDsCTKMHoaDon() {
        return dsCTKMHoaDon;
    }

    public void setDsCTKMHoaDon(ArrayList<CTKMHoaDon> dsCTKMHoaDon) {
        this.dsCTKMHoaDon = dsCTKMHoaDon;
    }

    public boolean them(CTKMHoaDon kmhd) {
        return dsCTKMHoaDon.add(kmhd);
    }

    public boolean xoa(String maCTKM, String maHD) {
        for (CTKMHoaDon kmhd : dsCTKMHoaDon) {
            if (kmhd.getMaCTKM().equals(maCTKM) && kmhd.getMaHD().equals(maHD)) {
                return dsCTKMHoaDon.remove(kmhd);
            }
        }
        return false;
    }
}