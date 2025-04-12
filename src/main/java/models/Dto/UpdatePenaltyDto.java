package models.Dto;

public class UpdatePenaltyDto {
    private int id;
    private boolean paguar;

    public UpdatePenaltyDto(int id, boolean paguar) {
        this.id=id;
        this.paguar=paguar;
    }
    public void setPaguar(boolean paguar) {
        this.paguar = paguar;
    }
    public boolean isPaguar() {
        return paguar;
    }
    public int getId() {
        return id;
    }
}
