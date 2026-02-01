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

    public String getMaDiaDiem(){return maDiaDiem;}
    public void setMaDiaDiem(String maDD){this.maDiaDiem = maDD;}

    public String getTenDiaDiem(){return this.tenDiaDiem;}
    public void setTenDiaDiem(String tenDD){this.tenDiaDiem = tenDD;}   
    
    public String getQuocGia(){return QuocGia;}
    public void setQuocGia(String QuocGia){this.QuocGia = QuocGia;}

}
