package service;

import model.SanBay;
import java.util.Arrays;

public class DanhSachSanBay {

    private SanBay[] dsSanBay;
    private int soLuong;

    public DanhSachSanBay() {
        dsSanBay = new SanBay[0];
        soLuong = 0;
    }

    public SanBay tim(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsSanBay[i].getMaSanBay().equalsIgnoreCase(ma)) {
                return dsSanBay[i];
            }
        }
        return null;
    }

    public void them(SanBay sb) {
        if (tim(sb.getMaSanBay()) != null) return;

        dsSanBay = Arrays.copyOf(dsSanBay, soLuong + 1);
        dsSanBay[soLuong] = sb;
        soLuong++;
    }

    public void xoa(String ma) {
        int vt = timViTri(ma);

        if (vt == -1) return;

        for (int i = vt; i < soLuong - 1; i++) {
            dsSanBay[i] = dsSanBay[i + 1];
        }

        dsSanBay = Arrays.copyOf(dsSanBay, soLuong - 1);
        soLuong--;
    }

    public int timViTri(String ma) {
        for (int i = 0; i < soLuong; i++) {
            if (dsSanBay[i].getMaSanBay().equalsIgnoreCase(ma))
                return i;
        }
        return -1;
    }

    public SanBay[] getDanhSach() {
        return Arrays.copyOf(dsSanBay, soLuong);
    }
}