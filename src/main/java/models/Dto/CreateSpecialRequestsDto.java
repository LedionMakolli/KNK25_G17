package models.Dto;

public class CreateSpecialRequestsDto {
    private int idReservation;
    private String request;
    private Boolean completed;

    public CreateSpecialRequestsDto(int idReservation, String request, boolean completed){
        this.idReservation=idReservation;
        this.request=request;
        this.completed=completed;
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

