package models.Dto;

public class CreateOfertatDto {
    private int ID_Vetura;
    private int zbritja;
    private String Data_Fillimit;
    private String Data_Mbarimit;

    public CreateOfertatDto(int ID_Vetura, int zbritja, String data_Fillimit, String data_Mbarimit) {
        this.ID_Vetura = ID_Vetura;
        this.zbritja = zbritja;
        Data_Fillimit = data_Fillimit;
        Data_Mbarimit = data_Mbarimit;
    }

    public void setID_Vetura(int ID_Vetura) {
        this.ID_Vetura = ID_Vetura;
    }

    public void setZbritja(int zbritja) {
        this.zbritja = zbritja;
    }

    public void setData_Fillimit(String data_Fillimit) {
        Data_Fillimit = data_Fillimit;
    }

    public void setData_Mbarimit(String data_Mbarimit) {
        Data_Mbarimit = data_Mbarimit;
    }

    public int getID_Vetura() {
        return ID_Vetura;
    }

    public int getZbritja() {
        return zbritja;
    }

    public String getData_Fillimit() {
        return Data_Fillimit;
    }

    public String getData_Mbarimit() {
        return Data_Mbarimit;
    }
}
