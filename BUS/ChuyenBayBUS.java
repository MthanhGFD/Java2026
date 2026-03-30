package BUS;

import model.ChuyenBay;
import DAO.ChuyenBayDAO;
import java.util.ArrayList;

public class ChuyenBayBUS {
    private ArrayList<ChuyenBay> listCB;
    private ChuyenBayDAO cbDAO = new ChuyenBayDAO();

    public ChuyenBayBUS() { listCB = cbDAO.docTatCa(); }

    public ArrayList<ChuyenBay> getAll() { return listCB; }

    public ChuyenBay getById(String ma) {
        for (ChuyenBay cb : listCB) {
            if (cb.getMaChuyenBay().equalsIgnoreCase(ma)) return cb;
        }
        return null;
    }

    public ArrayList<ChuyenBay> getByDiemDen(String sbDen) {
        ArrayList<ChuyenBay> kq = new ArrayList<>();
        for (ChuyenBay cb : listCB) {
            if (cb.getMaSanBayDen().equalsIgnoreCase(sbDen)) kq.add(cb);
        }
        return kq;
    }

    public String themChuyenBay(ChuyenBay cb) {
        if (cb.getMaChuyenBay().trim().isEmpty()) {
            return "Mã chuyến bay không được để trống!";
        }

        if (getById(cb.getMaChuyenBay()) != null) {
            return "Mã chuyến bay này đã tồn tại trong hệ thống!";
        }

        if (cb.getMaSanBayDi().equalsIgnoreCase(cb.getMaSanBayDen())) {
            return "Sân bay cất cánh và hạ cánh không được trùng nhau!";
        }

        boolean isSuccess = cbDAO.them(cb);
        if (isSuccess) {
            listCB.add(cb);
            return "Thêm chuyến bay thành công!";
        } else {
            return "Lỗi CSDL: Không thể thêm chuyến bay!";
        }
    }

    public boolean xoaChuyenBay(String maCB) {
        if (cbDAO.xoa(maCB)) {
            listCB.removeIf(cb -> cb.getMaChuyenBay().equalsIgnoreCase(maCB));
            return true;
        }
        return false;
    }
}