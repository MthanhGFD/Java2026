import service.DanhSachCTKM;
import service.DanhSachDiaDiem;
import service.DanhSachHoaDon;
import service.DanhSachVe;
import model.Ve;
import model.CTKM;
import model.DiaDiem;
import model.HoaDon;

public class Main {
    public static void main(String[] args) {
        // Load dữ liệu CTKM
        DanhSachCTKM dsCTKM = new DanhSachCTKM();
        dsCTKM.docDuLieuTuFile("manage/CTKM.csv");
        System.out.println("Danh sách CTKM:");
        for (CTKM c : dsCTKM.getDanhSach()) {
            System.out.println(c.getMaCTKM() + " - " + c.getTenCTKM());
        }

        // Load dữ liệu DiaDiem
        DanhSachDiaDiem dsDiaDiem = new DanhSachDiaDiem();
        dsDiaDiem.docDuLieuTuFile("manage/DiaDiem.csv");
        System.out.println("\nDanh sách Địa điểm:");
        for (DiaDiem d : dsDiaDiem.getDanhSach()) {
            System.out.println(d.getMaDiaDiem() + " - " + d.getTenDiaDiem() + ", " + d.getQuocGia());
        }

        // Load dữ liệu HoaDon
        DanhSachHoaDon dsHoaDon = new DanhSachHoaDon();
        dsHoaDon.docDuLieuTuFile("manage/HoaDon.csv");
        System.out.println("\nDanh sách Hóa đơn:");
        for (HoaDon h : dsHoaDon.getDanhSach()) {
            System.out.println(h.getMaHoaDon() + " - " + h.getMaKhachHang() + " - " + h.getGiaSauKhiGiam());
        }
     
       // Load dữ liệu Vé
        DanhSachVe dsVe = new DanhSachVe();
        dsVe.docFile("data/Ve.csv"); 
        System.out.println("\nDanh sách Vé Máy Bay (Chi tiết):");
        System.out.println("-------------------------");
        for (Ve v : dsVe.getDSVe()) {
            if (v != null) {
                System.out.println(v.toString());
            }
        }
        System.out.println("----------------------------");
        }
    }
}
