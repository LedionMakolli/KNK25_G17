package models.Dto;

public class UpdateOfertatDto {
    private int id_oferta;
    private int id_vetura;
    private int zbritja;
    private String data_fillimit;
    private String data_mbarimit;

    public UpdateOfertatDto(int id_oferta, int id_vetura, int zbritja, String data_fillimit, String data_mbarimit) {
        this.id_oferta = id_oferta;
        this.id_vetura = id_vetura;
        this.zbritja = zbritja;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit = data_mbarimit;
    }

    public void setId_vetura(int id_vetura) {
        this.id_vetura = id_vetura;
    }

    public void setZbritja(int zbritja) {
        this.zbritja = zbritja;
    }

    public void setData_Fillimit(String data_fillimit) {
        this.data_fillimit = data_fillimit;
    }

    public void setData_Mbarimit(String data_mbarimit) {
        this.data_mbarimit = data_mbarimit;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public int getId_vetura() {
        return id_vetura;
    }

    public int getZbritja() {
        return zbritja;
    }

    public String getData_fillimit() {
        return data_fillimit;
    }

    public String getData_mbarimit() {
        return data_mbarimit;
    }

}
