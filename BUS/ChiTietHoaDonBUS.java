package BUS;

import DAO.ChiTietHoaDonDAO;
import model.ChiTietHoaDon;
import java.util.ArrayList;

public class ChiTietHoaDonBUS {
    private ArrayList<ChiTietHoaDon> listCTHD;
    private ChiTietHoaDonDAO cthdDAO = new ChiTietHoaDonDAO();

    public ChiTietHoaDonBUS() {
        listCTHD = cthdDAO.selectAll();
    }

    public ArrayList<ChiTietHoaDon> getAll() {
        return listCTHD;
    }

    // Lay danh sach chi tiet cua mot hoa don cu the
    public ArrayList<ChiTietHoaDon> getByMaHoaDon(String maHD) {
        ArrayList<ChiTietHoaDon> kq = new ArrayList<>();
        for (ChiTietHoaDon ct : listCTHD) {
            if (ct.getMaHoaDon().equalsIgnoreCase(maHD)) {
                kq.add(ct);
            }
        }
        return kq;
    }

    public String add(ChiTietHoaDon cthd) {
        // Co the them logic kiem tra maVe da ton tai trong hoa don nay chua o day
        if (cthdDAO.insert(cthd)) {
            listCTHD.add(cthd);
            return "Them chi tiet hoa don thanh cong!";
        }
        return "Them chi tiet hoa don that bai!";
    }

    // Xoa tat ca chi tiet khi xoa hoa don tong
    public String deleteByHoaDon(String maHD) {
        if (cthdDAO.deleteByHoaDon(maHD)) {
            listCTHD.removeIf(ct -> ct.getMaHoaDon().equalsIgnoreCase(maHD));
            return "Xoa chi tiet thanh cong!";
        }
        return "Xoa chi tiet that bai!";
    }
}