package BUS;

import DAO.VeDAO;

import java.util.ArrayList;

import DAL.Ve;

public class VeBUS {
    private ArrayList<Ve> listVe;
    private VeDAO veDAO = new VeDAO();

    public VeBUS() {
        listVe = veDAO.docTatCa();
    }

    public ArrayList<Ve> getAll() {
        return listVe;
    }

    public ArrayList<Ve> findByChuyenBay(String maCB) {
        ArrayList<Ve> kq = new ArrayList<>();
        for (Ve v : listVe) {
            if (v.getMaChuyenBay().equalsIgnoreCase(maCB)) {
                kq.add(v);
            }
        }
        return kq;
    }
}