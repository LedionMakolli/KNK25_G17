package models.Dto;

public class UpdateVlersimetDto {
    private int ID_Klienti;
    private int ID_Vetura;
    private String text;
    private String data;

    public UpdateVlersimetDto(int ID_Klienti, int ID_Vetura, String text, String data) {
        this.ID_Klienti = ID_Klienti;
        this.ID_Vetura = ID_Vetura;
        this.text = text;
        this.data = data;
    }

    public void setID_Klienti(int ID_Klienti) {
        this.ID_Klienti = ID_Klienti;
    }

    public void setID_Vetura(int ID_Vetura) {
        this.ID_Vetura = ID_Vetura;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getID_Klienti() {
        return ID_Klienti;
    }

    public int getID_Vetura() {
        return ID_Vetura;
    }

    public String getText() {
        return text;
    }

    public String getData() {
        return data;
    }
}
