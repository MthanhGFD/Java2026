package BUS;

import DAO.ChiTietHoaDonDAO;
import java.util.ArrayList;
import DAL.ChiTietHoaDon;

public class ChiTietHoaDonBUS {
    private ArrayList<ChiTietHoaDon> listCTHD;
    private ChiTietHoaDonDAO dao = new ChiTietHoaDonDAO();

    public ChiTietHoaDonBUS() {
        listCTHD = dao.docTatCa();
    }

    public ArrayList<ChiTietHoaDon> getAll() {
        return listCTHD;
    }

    public ChiTietHoaDon getById(String ma) {
        for (ChiTietHoaDon ct : listCTHD) {
            if (ct.getMaHoaDon().equalsIgnoreCase(ma)) {
                return ct;
            }
        }
        return null;
    }

    public String themCTHD(ChiTietHoaDon ct) {
        if (ct.getMaHoaDon().trim().isEmpty()) {
            return "Mã hóa đơn không được để trống!";
        }

        if (ct.getMaVe().trim().isEmpty()) {
            return "Mã vé không được để trống!";
        }

        if (getById(ct.getMaHoaDon()) != null) {
            return "Mã hóa đơn đã tồn tại!";
        }

        if (dao.them(ct)) {
            listCTHD.add(ct);
            return "Thêm chi tiết hóa đơn thành công!";
        }

        return "Lỗi CSDL: Không thể thêm!";
    }

    public boolean xoaCTHD(String ma) {
        if (dao.xoa(ma)) {
            listCTHD.removeIf(ct -> ct.getMaHoaDon().equalsIgnoreCase(ma));
            return true;
        }
        return false;
    }

    public String suaCTHD(ChiTietHoaDon ctMoi) {
        if (dao.sua(ctMoi)) {
            for (int i = 0; i < listCTHD.size(); i++) {
                if (listCTHD.get(i).getMaHoaDon().equalsIgnoreCase(ctMoi.getMaHoaDon())) {
                    listCTHD.set(i, ctMoi);
                    return "Cập nhật thành công!";
                }
            }
        }
        return "Lỗi CSDL: Không thể cập nhật!";
    }
}