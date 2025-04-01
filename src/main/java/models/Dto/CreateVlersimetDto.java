package models.Dto;

public class CreateVlersimetDto {
    private int id_klienti;
    private int id_vetura;
    private String text;
    private String data;

    public CreateVlersimetDto(int id_klienti, int id_vetura, String text, String data) {
        this.id_klienti = id_klienti;
        this.id_vetura = id_vetura;
        this.text = text;
        this.data = data;
    }

    public void setId_klienti(int id_klienti) {
        this.id_klienti = id_klienti;
    }

    public void setId_vetura(int id_vetura) {
        this.id_vetura = id_vetura;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_klienti() {
        return id_klienti;
    }

    public int getId_vetura() {
        return id_vetura;
    }

    public String getText() {
        return text;
    }

    public String getData() {
        return data;
    }
}
