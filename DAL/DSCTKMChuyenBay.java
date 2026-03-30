package DAL;

import java.util.ArrayList;

public class DSCTKMChuyenBay {
    private ArrayList<CTKMChuyenBay> dsCTKMChuyenBay;

    public DSCTKMChuyenBay() {
        this.dsCTKMChuyenBay = new ArrayList<>();
    }

    public ArrayList<CTKMChuyenBay> getDsCTKMChuyenBay() {
        return dsCTKMChuyenBay;
    }

    public void setDsCTKMChuyenBay(ArrayList<CTKMChuyenBay> dsCTKMChuyenBay) {
        this.dsCTKMChuyenBay = dsCTKMChuyenBay;
    }

    public boolean them(CTKMChuyenBay kmcb) {
        return dsCTKMChuyenBay.add(kmcb);
    }

    public boolean xoa(String maCTKM, String maCB) {
        for (CTKMChuyenBay kmcb : dsCTKMChuyenBay) {
            if (kmcb.getMaCTKM().equals(maCTKM) && kmcb.getMaCB().equals(maCB)) {
                return dsCTKMChuyenBay.remove(kmcb);
            }
        }
        return false;
    }
}