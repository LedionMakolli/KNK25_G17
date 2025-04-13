package models.Dto;

public class UpdateSpecialRequestsDto {
    private int id;
    private int idReservation;
    private String request;
    private Boolean completed;

    public UpdateSpecialRequestsDto(int id, int idReservation, String request, Boolean completed){
        this.id=id;
        this.idReservation=idReservation;
        this.request=request;
        this.completed=completed;
    }
  public UpdateSpecialRequestsDto(){}

    public int getId(){
        return id;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public Boolean isCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
