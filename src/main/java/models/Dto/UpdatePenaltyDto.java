package models.Dto;

public class UpdatePenaltyDto {
    private int id;
    private boolean paid;

    public UpdatePenaltyDto(int id, boolean paid) {
        this.id=id;
        this.paid=paid;
    }
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public boolean isPaid() {
        return paid;
    }
    public int getId() {
        return id;
    }
}
