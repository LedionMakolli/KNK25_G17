package models.Dto;

public class CreateVleresimetDto {
    private int idKlienti;
    private int idVetura;
    private int rating;
    private String text;
    private String data;

    public CreateVleresimetDto(int idKlienti, int idVetura, int rating, String text, String data) {
        this.idKlienti = idKlienti;
        this.idVetura = idVetura;
        this.rating = rating;
        this.text = text;
        this.data = data;
    }

    public void setIdKlienti(int idKlienti) {
        this.idKlienti = idKlienti;
    }

    public void setIdVetura(int idVetura) {
        this.idVetura = idVetura;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdKlienti() {
        return idKlienti;
    }

    public int getIdVetura() {
        return idVetura;
    }

    public int getRating() {
        return rating;
    }

    public String getText() {
        return text;
    }

    public String getData() {
        return data;
    }
}
