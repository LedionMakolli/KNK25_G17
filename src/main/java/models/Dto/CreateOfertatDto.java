package models.Dto;

public class CreateOfertatDto {
    private int idVetura;
    private double zbritja;
    private String dataFillimit;
    private String dataMbarimit;

    public CreateOfertatDto(int idVetura, double zbritja, String dataFillimit, String dataMbarimit) {
        this.idVetura = idVetura;
        this.zbritja = zbritja;
        this.dataFillimit = dataFillimit;
        this.dataMbarimit = dataMbarimit;
    }

    public void setIdVetura(int idVetura) {
        this.idVetura = idVetura;
    }

    public void setZbritja(double zbritja) {
        this.zbritja = zbritja;
    }

    public void setDataFillimit(String dataFillimit) {
        this.dataFillimit = dataFillimit;
    }

    public void setDataMbarimit(String dataMbarimit) {
        this.dataMbarimit = dataMbarimit;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public double getZbritja() {
        return zbritja;
    }

    public String getDataFillimit() {
        return dataFillimit;
    }

    public String getDataMbarimit() {
        return dataMbarimit;
    }
}
