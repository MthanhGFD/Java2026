package BUS;

import DAO.SanBayDAO;
import model.SanBay;
import java.util.ArrayList;

public class SanBayBUS {
    private ArrayList<SanBay> listSB;
    private SanBayDAO sbDAO = new SanBayDAO();

    public SanBayBUS() {
        listSB = sbDAO.selectAll();
    }

    public ArrayList<SanBay> getAll() {
        return listSB;
    }

    public SanBay getById(String ma) {
        for (SanBay sb : listSB) {
            if (sb.getMaSanBay().equalsIgnoreCase(ma)) return sb;
        }
        return null;
    }
}