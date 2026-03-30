package BUS;

import DAO.MayBayDAO;

import java.util.ArrayList;

import DAL.MayBay;

public class MayBayBUS {
    private ArrayList<MayBay> listMB;
    private MayBayDAO mbDAO = new MayBayDAO();

    public MayBayBUS() { listMB = mbDAO.docTatCa(); }

    public ArrayList<MayBay> getAll() { return listMB; }

    public String add(MayBay mb) {
        if (getById(mb.getMaMayBay()) != null) return "Mã máy bay đã tồn tại!";
        if (mbDAO.them(mb)) {
            listMB.add(mb);
            return "Thêm thành công!";
        }
        return "Thêm thất bại!";
    }

    public MayBay getById(String ma) {
        for (MayBay mb : listMB) {
            if (mb.getMaMayBay().equalsIgnoreCase(ma)) return mb;
        }
        return null;
    }
}