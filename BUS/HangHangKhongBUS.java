package BUS;

import DAO.HangHangKhongDAO;

import java.util.ArrayList;

import DAL.HangHangKhong;

public class HangHangKhongBUS {
    private ArrayList<HangHangKhong> listHHK;
    private HangHangKhongDAO dao = new HangHangKhongDAO();

    public HangHangKhongBUS() { listHHK = dao.docTatCa(); }

    public ArrayList<HangHangKhong> getAll() { return listHHK; }

    public HangHangKhong getByTen(String ten) {
        for (HangHangKhong h : listHHK) {
            if (h.getTenHangHK().equalsIgnoreCase(ten)) return h;
        }
        return null;
    }
}