package BUS;

import DAO.HoaDonDAO;
import model.HoaDon;
import java.util.ArrayList;

public class HoaDonBUS {
    private ArrayList<HoaDon> listHD;
    private HoaDonDAO hdDAO = new HoaDonDAO();

    public HoaDonBUS() {
        listHD = hdDAO.docTatCa();
    }

    public ArrayList<HoaDon> getAll() {
        return listHD;
    }

    public String add(HoaDon hd) {
        if (getById(hd.getMaHoaDon()) != null) {
            return "Ma hoa don da ton tai!";
        }
        if (hdDAO.them(hd)) {
            listHD.add(hd);
            return "Them hoa don thanh cong!";
        }
        return "Them hoa don that bai!";
    }

    public String delete(String maHD) {
        if (hdDAO.xoa(maHD)) {
            listHD.removeIf(hd -> hd.getMaHoaDon().equalsIgnoreCase(maHD));
            return "Xoa thanh cong!";
        }
        return "Xoa that bai!";
    }

    public HoaDon getById(String maHD) {
        for (HoaDon hd : listHD) {
            if (hd.getMaHoaDon().equalsIgnoreCase(maHD)) return hd;
        }
        return null;
    }

    // Ham thong ke tong doanh thu (Logic nghiep vu)
    public double tinhTongDoanhThu() {
        double tong = 0;
        for (HoaDon hd : listHD) {
            tong += hd.getGiaSauKhiGiam();
        }
        return tong;
    }
}