package model;

public class DiaDiem {
    String maDiaDiem;
    String tenDiaDiem;
    String QuocGia;

    public DiaDiem(){}

    public DiaDiem(String maDD, String tenDD,String QuocGia){
        this.maDiaDiem = maDD;
        this.tenDiaDiem = tenDD;
        this.QuocGia = QuocGia;

    }

    public String getmaDiaDiem(){return maDiaDiem;}
    public void setmaDiaDiem(String maDD){this.maDiaDiem = maDD;}

    public String gettenDiaDiem(){return this.tenDiaDiem;}
    public void settenDiaDiem(String tenDD){this.tenDiaDiem = tenDD;}

    public String getQuocGia(){return QuocGia;}
    public void setQuocGia(String QuocGia){this.QuocGia = QuocGia;}

}
