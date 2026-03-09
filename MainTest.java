import BUS.MayBayBUS;
import model.MayBay;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("--- DANG KIEM TRA KET NOI ---");
        MayBayBUS mbBus = new MayBayBUS();
        
        if(mbBus.getAll().isEmpty()) {
            System.out.println("Danh sach trong hoac loi ket noi.");
        } else {
            System.out.println("Lay du lieu thanh cong!");
            for(MayBay mb : mbBus.getAll()) {
                System.out.println(mb.toString());
            }
        }
    }
}