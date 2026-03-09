// import service.DanhSachCTKM;
// import service.DanhSachDiaDiem;
// import service.DanhSachHoaDon;
// import service.DanhSachVe;
// import service.DanhSachChiTietHoaDon;
// import model.ChiTietHoaDon;
// import model.Ve;
// import model.CTKM;
// import model.DiaDiem;
// import model.HoaDon;

// public class Main {
//     public static void main(String[] args) {
//         // Load dữ liệu CTKM
//         DanhSachCTKM dsCTKM = new DanhSachCTKM();
//         dsCTKM.docDuLieuTuFile("manage/CTKM.csv");
//         System.out.println("Danh sách CTKM:");
//         for (CTKM c : dsCTKM.getDanhSach()) {
//             System.out.println(c.getMaCTKM() + " - " + c.getTenCTKM());
//         }

//         // Load dữ liệu DiaDiem
//         DanhSachDiaDiem dsDiaDiem = new DanhSachDiaDiem();
//         dsDiaDiem.docDuLieuTuFile("manage/DiaDiem.csv");
//         System.out.println("\nDanh sách Địa điểm:");
//         for (DiaDiem d : dsDiaDiem.getDanhSach()) {
//             System.out.println(d.getMaDiaDiem() + " - " + d.getTenDiaDiem() + ", " + d.getQuocGia());
//         }

//         // Load dữ liệu HoaDon
//         DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
//         dsHoaDon.docDuLieuTuFile("manage/HoaDon.csv");
//         System.out.println("\nDanh sách Hóa đơn:");
//         for (HoaDon h : dsHoaDon.getDanhSach()) {
//             System.out.println(h.getMaHoaDon() + " - " + h.getMaKhachHang() + " - " + h.getGiaSauKhiGiam());
//         }
     
//        // Load dữ liệu Vé
//         DanhSachVe dsVe = new DanhSachVe();
//         dsVe.docFile("data/Ve.csv"); 
//         System.out.println("\nDanh sách Vé Máy Bay (Chi tiết):");
//         System.out.println("-------------------------");
//         for (Ve v : dsVe.getDSVe()) {
//                 System.out.println(v.toString());
//         System.out.println("----------------------------");
//         }
    
//     //load dữ liệu chitiethoadon
//     DanhSachChiTietHoaDon dsCTHD = new DanhSachChiTietHoaDon();
//         dsCTHD.docFile("data/ChiTietHoaDon.csv"); 
//         System.out.println("\nDanh sách Chi tiết Hóa đơn:");
//         for (ChiTietHoaDon ct : dsCTHD.getDanhSach()) {
//                 System.out.println(ct.getMaChiTiet() + " - " + ct.getMaHoaDon() + " - " 
//                                  + ct.getTenHanhKhach() + " - " + ct.getLoaiVe() + " - " 
//                                  + ct.getSoGhe() + " - " + ct.getGiaVe() + " - " + ct.getGhiChu());
//         }
//     }
// }
import java.sql.Connection;

import database.DBConnection;

public class Main {
    public static void main(String[] args) {

        Connection conn = DBConnection.getConnection();

        if(conn != null){
            System.out.println("Thanh cong");
        }
    }
}