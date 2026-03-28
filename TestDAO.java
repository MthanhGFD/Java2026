import DAO.ChuyenBayDAO;
import model.ChuyenBay;
import java.util.ArrayList;

public class TestDAO {
    public static void main(String[] args) {
        System.out.println("Đang kiểm tra DAO...");
        ChuyenBayDAO dao = new ChuyenBayDAO();
        ArrayList<ChuyenBay> list = dao.selectAll();
        System.out.println("Số chuyến bay: " + list.size());
        if (!list.isEmpty()) {
            System.out.println("Chuyến bay đầu tiên: " + list.get(0).getMaChuyenBay());
        }
    }
}