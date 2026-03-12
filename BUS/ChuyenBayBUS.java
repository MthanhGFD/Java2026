package BUS;

import DAO.ChuyenBayDAO;
import model.ChuyenBay;
import java.util.ArrayList;

public class ChuyenBayBUS {
    private ArrayList<ChuyenBay> listCB;
    private ChuyenBayDAO cbDAO = new ChuyenBayDAO();

    public ChuyenBayBUS() { listCB = cbDAO.selectAll(); }

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
}