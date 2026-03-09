// package service;

// import model.Ve;
// import java.io.*;
// import java.util.Arrays;

// public class DanhSachVe {

//     private Ve[] dsVe;
//     private int soLuong;

//     public DanhSachVe() {
//         dsVe = new Ve[0];
//         soLuong = 0;
//     }

//     public int getSoLuong() {
//         return soLuong;
//     }

//     public Ve[] getDSVe() {
//         return Arrays.copyOf(dsVe, soLuong);
//     }

//     //DOC FILE

//     public void docFile(String tenFile) {
//         try {
//             BufferedReader br = new BufferedReader(new FileReader(tenFile));
//             String line;

//             while ((line = br.readLine()) != null) {

//                 String[] tokens = line.split(",");

//                 if (tokens[0].toLowerCase().startsWith("vvip")) {

//                     VeVIP v = new VeVIP();
//                     v.setMaVe(tokens[0]);
//                     v.setMaChuyenBay(tokens[1]);
//                     v.setMaGhe(tokens[2]);
//                     v.setGiaVe(Double.parseDouble(tokens[3]));
//                     v.setLoaiVe(tokens[4]);
//                     v.setPhongCho(tokens[5]);
//                     v.setQuaTang(tokens[6]);

//                     them(v);
//                 }

//                 else if (tokens[0].toLowerCase().startsWith("vth")) {

//                     VeThuong v = new VeThuong();
//                     v.setMaVe(tokens[0]);
//                     v.setMaChuyenBay(tokens[1]);
//                     v.setMaGhe(tokens[2]);
//                     v.setGiaVe(Double.parseDouble(tokens[3]));
//                     v.setLoaiVe(tokens[4]);
//                     v.setPhiHanhLy(Double.parseDouble(tokens[5]));
//                     v.setPhiDichVu(Double.parseDouble(tokens[6]));

//                     them(v);
//                 }
//             }

//             br.close();

//         } catch (Exception e) {
//             System.out.println("Loi doc file ve");
//         }
//     }

//     // ================= GHI FILE =================

//     public void ghiFile(String tenFile) {

//         try {
//             BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));

//             for (int i = 0; i < soLuong; i++) {
//                 bw.write(dsVe[i].toString());
//                 bw.newLine();
//             }

//             bw.close();

//         } catch (Exception e) {
//             System.out.println("Loi ghi file ve");
//         }
//     }

//     // ================= THEM =================

//     public void them(Ve ve) {

//         if (timVe(ve.getMaVe()) != null)
//             return;

//         dsVe = Arrays.copyOf(dsVe, soLuong + 1);

//         dsVe[soLuong] = ve;

//         soLuong++;
//     }

//     // ================= XOA =================

//     public void xoa(String maVe) {

//         int vt = timViTri(maVe);

//         if (vt == -1)
//             return;

//         for (int i = vt; i < soLuong - 1; i++) {
//             dsVe[i] = dsVe[i + 1];
//         }

//         dsVe = Arrays.copyOf(dsVe, soLuong - 1);

//         soLuong--;
//     }

//     // ================= SUA =================

//     public void suaGiaVe(String maVe, double giaMoi) {

//         Ve v = timVe(maVe);

//         if (v != null)
//             v.setGiaVe(giaMoi);
//     }

//     public void suaLoaiVe(String maVe, String loaiMoi) {

//         Ve v = timVe(maVe);

//         if (v != null)
//             v.setLoaiVe(loaiMoi);
//     }

//     // ================= TIM =================

//     public Ve timVe(String maVe) {

//         for (int i = 0; i < soLuong; i++) {

//             if (dsVe[i].getMaVe().equalsIgnoreCase(maVe))
//                 return dsVe[i];
//         }

//         return null;
//     }

//     public int timViTri(String maVe) {

//         for (int i = 0; i < soLuong; i++) {

//             if (dsVe[i].getMaVe().equalsIgnoreCase(maVe))
//                 return i;
//         }

//         return -1;
//     }

//     public DanhSachVe timTheoChuyenBay(String maCB) {

//         DanhSachVe kq = new DanhSachVe();

//         for (int i = 0; i < soLuong; i++) {

//             if (dsVe[i].getMaChuyenBay().equalsIgnoreCase(maCB))
//                 kq.them(dsVe[i]);
//         }

//         return kq;
//     }

//     public DanhSachVe timTheoLoaiVe(String loai) {
//         DanhSachVe kq = new DanhSachVe();

//         for (int i = 0; i < soLuong; i++) {

//             if (dsVe[i].getLoaiVe().equalsIgnoreCase(loai))
//                 kq.them(dsVe[i]);
//         }

//         return kq;
//     }

// }
