import database.DBConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        System.out.println("Đang kiểm tra kết nối MySQL...");
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Kết nối thành công!");
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Kết nối thất bại. Vui lòng kiểm tra:");
            System.out.println("- MySQL server có đang chạy không?");
            System.out.println("- Database 'quanlychuyenbay' có tồn tại không?");
            System.out.println("- Thông tin đăng nhập (user/password) có đúng không?");
        }
    }
}