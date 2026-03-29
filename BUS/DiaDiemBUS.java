package BUS;

import DAO.DiaDiemDAO; // Nhớ đổi import thành DiaDiemDAO
import model.DiaDiem;
import java.util.ArrayList;

public class DiaDiemBUS {
    // Đổi tên biến cho đúng ngữ cảnh
    private ArrayList<DiaDiem> listDiaDiem;
    private DiaDiemDAO ddDAO = new DiaDiemDAO(); // Đã sửa lại đúng kiểu dữ liệu DAO

    public DiaDiemBUS() { 
        listDiaDiem = ddDAO.docTatCa(); 
    }

    public ArrayList<DiaDiem> getAll() { 
        return listDiaDiem; 
    }

    // Lấy địa điểm theo Mã
    public DiaDiem getById(String ma) {
        for (DiaDiem dd : listDiaDiem) {
            // Giả sử thuộc tính trong model của bạn là MaDiaDiem
            if (dd.getMaDiaDiem().equalsIgnoreCase(ma)) return dd;
        }
        return null;
    }

    // ĐỊA ĐIỂM thì thường tìm theo Tên thay vì "Điểm đến" như Chuyến Bay
    public ArrayList<DiaDiem> timKiemTheoTen(String tenDD) {
        ArrayList<DiaDiem> kq = new ArrayList<>();
        for (DiaDiem dd : listDiaDiem) {
            // Tìm kiếm tương đối (chứa từ khóa, không phân biệt hoa thường)
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

        // Đã xóa logic kiểm tra Sân bay đi/đến vì không phù hợp với Địa Điểm

        boolean isSuccess = ddDAO.insert(dd);
        if (isSuccess) {
            listDiaDiem.add(dd);
            return "Thêm địa điểm thành công!";
        } else {
            return "Lỗi CSDL: Không thể thêm địa điểm!";
        }
    }

    // Xóa Địa Điểm
    public boolean xoaDiaDiem(String maDD) {
        if (ddDAO.delete(maDD)) {
            listDiaDiem.removeIf(dd -> dd.getMaDiaDiem().equalsIgnoreCase(maDD));
            return true;
        }
        return false;
    }
}