package models.Dto;

public class UpdatePenalizimetDto {
    private int id;
    private boolean paguar;

    public UpdatePenalizimetDto(int id, boolean paguar) {
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
