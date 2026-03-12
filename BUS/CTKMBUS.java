package BUS;

import DAO.CTKMDAO;
import model.CTKM;
import java.util.ArrayList;

public class CTKMBUS {
    private ArrayList<CTKM> listCTKM;
    private CTKMDAO dao = new CTKMDAO();

    public CTKMBUS() { listCTKM = dao.selectAll(); }

    public ArrayList<CTKM> getAll() { return listCTKM; }

    public CTKM getById(String ma) {
        for (CTKM ct : listCTKM) {
            if (ct.getMaCTKM().equalsIgnoreCase(ma)) return ct;
        }
        return null;
    }
}