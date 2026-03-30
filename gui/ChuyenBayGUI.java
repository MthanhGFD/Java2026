package gui;

import DAO.ChuyenBayDAO;
import model.ChuyenBay;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ChuyenBayGUI extends JFrame {

    private JTable tableChuyenBay;
    private DefaultTableModel tableModel;

    public ChuyenBayGUI() {
        // 1. Cài đặt các thông số cơ bản cho cửa sổ (JFrame)
        setTitle("Phần Mềm Quản Lý Chuyến Bay");
        setSize(1000, 500); // Chiều ngang 1000px, chiều cao 500px
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở chính giữa màn hình
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Tắt cửa sổ là tắt luôn chương trình
        setLayout(new BorderLayout());

        // 2. Khởi tạo giao diện
        initComponent();

        // 3. Đổ dữ liệu từ Database lên bảng
        loadDataToTable();
    }

    private void initComponent() {
        // Tạo tiêu đề (Label) ở phía trên cùng
        JLabel lblTitle = new JLabel("DANH SÁCH CHUYẾN BAY", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setForeground(Color.BLUE);
        lblTitle.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0)); // Tạo khoảng trống trên dưới
        add(lblTitle, BorderLayout.NORTH);

        // Khai báo tên các cột cho bảng
        String[] columnNames = {
            "Mã CB", "Mã Máy Bay", "Hãng HK", "Nơi Đi", "Nơi Đến", 
            "Ngày Bay", "Giờ Bay", "Giờ Đến", "Tổng Số Vé", "Vé Đã Bán"
        };

        // Khởi tạo Model và Bảng
        tableModel = new DefaultTableModel(columnNames, 0);
        tableChuyenBay = new JTable(tableModel);
        
        // Chỉnh cho chữ trong bảng to rõ hơn một chút
        tableChuyenBay.setRowHeight(25); 
        tableChuyenBay.setFont(new Font("Arial", Font.PLAIN, 14));

        // Bắt buộc phải cho bảng vào JScrollPane để có thanh cuộn lên xuống
        JScrollPane scrollPane = new JScrollPane(tableChuyenBay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadDataToTable() {
        // Gọi DAO để lấy danh sách từ MySQL lên
        // (Lưu ý: Nếu nhóm bạn bắt buộc dùng BUS, hãy đổi thành ChuyenBayBUS)
        ChuyenBayDAO cbDAO = new ChuyenBayDAO();
        ArrayList<ChuyenBay> dsChuyenBay = cbDAO.docTatCa();

        // Xóa sạch dữ liệu cũ trên bảng trước khi đổ dữ liệu mới vào
        tableModel.setRowCount(0);

        // Duyệt qua từng chuyến bay trong danh sách và thêm vào bảng
        for (ChuyenBay cb : dsChuyenBay) {
            Object[] row = new Object[]{
                cb.getMaChuyenBay(),
                cb.getMaMayBay(),
                cb.getMaHangHangKhong(),
                cb.getMaSanBayDi(),
                cb.getMaSanBayDen(),
                cb.getNgayBay(),
                cb.getGioBay(),
                cb.getGioDen(),
                cb.getTongSoVe(),
                cb.getSoVeDaBan()
            };
            tableModel.addRow(row); // Thêm 1 dòng vào model
        }
    }

    // Hàm main để chạy thử giao diện độc lập
    public static void main(String[] args) {
        // Chạy GUI trên một luồng (thread) an toàn của Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChuyenBayGUI().setVisible(true); // Hiển thị cửa sổ
            }
        });
    }
}