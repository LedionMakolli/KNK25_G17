package models.Dto;

public class CreateKerkesatSpecialeDto {
    private int idRezervimet;
    private String kerkese;
    private boolean plotesuar;

    public CreateKerkesatSpecialeDto(int idRezervimet, String kerkese, boolean plotesuar){
        this.idRezervimet=idRezervimet;
        this.kerkese=kerkese;
        this.plotesuar=plotesuar;
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
    public boolean isPlotesuar(){
        return plotesuar;
    }
    public void setPlotesuar(boolean plotesuar){
        this.plotesuar=plotesuar;
    }
}

