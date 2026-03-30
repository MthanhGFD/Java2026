package BUS;

import DAO.CTKMDAO;
import java.util.ArrayList;
import DAL.CTKM;

public class CTKMBUS {
    private ArrayList<CTKM> listCTKM;
    private CTKMDAO dao = new CTKMDAO();

    public CTKMBUS() { listCTKM = dao.docTatCa(); }

    public ArrayList<CTKM> getAll() { return listCTKM; }

    public CTKM getById(String ma) {
        for (CTKM ct : listCTKM) {
            if (ct.getMaCTKM().equalsIgnoreCase(ma)) return ct;
        }
        return null;
    }
    public String themCTKM(CTKM ct) {
        if (ct.getMaCTKM().trim().isEmpty()) {
            return "Mã khuyến mãi không được để trống!";
        }

        if (getById(ct.getMaCTKM()) != null) {
            return "Mã khuyến mãi này đã tồn tại!";
        }
        if (dao.them(ct)) {
            listCTKM.add(ct);
            return "Thêm khuyến mãi thành công!";
        }
        return "Lỗi CSDL: Không thể thêm khuyến mãi!";
    }

    public boolean xoaCTKM(String ma) {
        if (dao.xoa(ma)) {
            listCTKM.removeIf(ct -> ct.getMaCTKM().equalsIgnoreCase(ma));
            return true;
        }
        return false;
    }

    public String suaCTKM(CTKM ctMoi) {
        if (dao.sua(ctMoi)) {
            for (int i = 0; i < listCTKM.size(); i++) {
                if (listCTKM.get(i).getMaCTKM().equalsIgnoreCase(ctMoi.getMaCTKM())) {
                    listCTKM.set(i, ctMoi);
                    return "Cập nhật khuyến mãi thành công!";
                }
            }
        }
        return "Lỗi CSDL: Không thể cập nhật khuyến mãi!";
    }
}