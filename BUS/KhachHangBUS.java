package BUS;

import DAO.KhachHangDAO;

import java.util.ArrayList;

import DAL.KhachHang;

public class KhachHangBUS {
    private ArrayList<KhachHang> listKH;
    private KhachHangDAO khDAO = new KhachHangDAO();

    public KhachHangBUS() {
        // Load dữ liệu từ DB lên mảng khi khởi tạo
        listKH = khDAO.docTatCa();
    }

    public ArrayList<KhachHang> getAll() {
        return listKH;
    }

    public String add(KhachHang kh) {
        // Kiểm tra logic
        if (kh.getMaKhachHang().isEmpty()) return "Mã không được để trống";
        
        for (KhachHang item : listKH) {
            if (item.getMaKhachHang().equals(kh.getMaKhachHang())) return "Mã đã tồn tại";
        }

        if (khDAO.them(kh)) {
            listKH.add(kh); // Cập nhật mảng tạm
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    // Các hàm tìm kiếm
    public KhachHang timTheoMa(String ma) {
        for (KhachHang kh : listKH) {
            if (kh.getMaKhachHang().equals(ma)) return kh;
        }
        return null;
    }
}