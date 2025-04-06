package models.Dto;

public class UpdateKerkesatSpecialeDto {
    private int id;
    private int idRezervimet;
    private String kerkese;
    private Boolean plotesuar;

    public UpdateKerkesatSpecialeDto(int id, int idRezervimet, String kerkese, Boolean plotesuar){
        this.id=id;
        this.idRezervimet=idRezervimet;
        this.kerkese=kerkese;
        this.plotesuar=plotesuar;
    }
  public UpdateKerkesatSpecialeDto(){}

    public int getId(){
        return id;
    }
public int getIdRezervimet(){
        return idRezervimet;
}
public void setIdRezervimet(int idRezervimet){
        this.idRezervimet=idRezervimet;
}
public String getKerkese(){
    return kerkese;
}
public void setKerkese(String kerkese){
        this.kerkese=kerkese;
}
public Boolean isPlotesuar(){
        return plotesuar;
}
public void setPlotesuar(Boolean plotesuar){
        this.plotesuar=plotesuar;
}

}
