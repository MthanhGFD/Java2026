package BUS;

import DAO.DiaDiemDAO;
import java.util.ArrayList;
import DAL.DiaDiem;

public class DiaDiemBUS {
    private ArrayList<DiaDiem> listDiaDiem;
    private DiaDiemDAO ddDAO = new DiaDiemDAO();

    public DiaDiemBUS() { 
        listDiaDiem = ddDAO.docTatCa(); 
    }

    public ArrayList<DiaDiem> getAll() { 
        return listDiaDiem; 
    }

    // Lấy địa điểm theo Mã
    public DiaDiem getById(String ma) {
        for (DiaDiem dd : listDiaDiem) {
            if (dd.getMaDiaDiem().equalsIgnoreCase(ma)) return dd;
        }
        return null;
    }

    public ArrayList<DiaDiem> timKiemTheoTen(String tenDD) {
        ArrayList<DiaDiem> kq = new ArrayList<>();
        for (DiaDiem dd : listDiaDiem) {
            if (dd.getTenDiaDiem().toLowerCase().contains(tenDD.toLowerCase())) kq.add(dd);
        }
        return kq;
    }

    // Thêm Địa Điểm
    public String themDiaDiem(DiaDiem dd) {
        if (dd.getMaDiaDiem().trim().isEmpty()) {
            return "Mã địa điểm không được để trống!";
        }

        if (getById(dd.getMaDiaDiem()) != null) {
            return "Mã địa điểm này đã tồn tại trong hệ thống!";
        }

        boolean isSuccess = ddDAO.them(dd);
        if (isSuccess) {
            listDiaDiem.add(dd);
            return "Thêm địa điểm thành công!";
        } else {
            return "Lỗi CSDL: Không thể thêm địa điểm!";
        }
    }

    // Xóa Địa Điểm
    public boolean xoaDiaDiem(String maDD) {
        if (ddDAO.xoa(maDD)) {
            listDiaDiem.removeIf(dd -> dd.getMaDiaDiem().equalsIgnoreCase(maDD));
            return true;
        }
        return false;
    }
}