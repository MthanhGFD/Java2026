package BUS;

import DAO.DiaDiemDAO;
import model.DiaDiem;
import java.util.ArrayList;

public class DiaDiemBUS {
    private ArrayList<DiaDiem> listDD;
    private DiaDiemDAO dao = new DiaDiemDAO();

    public DiaDiemBUS() { listDD = dao.selectAll(); }

    public ArrayList<DiaDiem> getAll() { return listDD; }
}