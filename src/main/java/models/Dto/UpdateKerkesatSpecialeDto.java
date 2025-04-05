package models.Dto;

public class UpdateKerkesatSpecialeDto {
    private int id;
    private int idRezervimet;
    private String kerkese;
    private boolean plotesuar;

    public UpdateKerkesatSpecialeDto(int id, int idRezervimet, String kerkese, boolean plotesuar){
        this.id=id;
        this.idRezervimet=idRezervimet;
        this.kerkese=kerkese;
        this.plotesuar=plotesuar;
    }
  public UpdateKerkesatSpecialeDto(){}

}
