package models.Dto;

public class CreateRezervimetDto {
    private int id_klienti;
    private int id_vetura;
    private String data_fillimit;
    private String data_mbarimit;
    private String statusi;

    public CreateRezervimetDto(int id_klienti, int id_vetura, String data_fillimit, String data_mbarimit, String statusi){
        this.id_klienti=id_klienti;
        this.id_vetura=id_vetura;
        this.data_fillimit=data_fillimit;
        this.data_mbarimit=data_mbarimit;
        this.statusi=statusi;
    }
    public int getId_klienti(){
        return id_klienti;
    }

    public void setId_klienti(int id_klienti){
        this.id_klienti=id_klienti;
    }

    public int getId_vetura(){
        return id_vetura;
    }

    public void setId_vetura(int id_vetura){
      this.id_vetura=id_vetura;
    }

    public String getData_fillimit(){
        return data_fillimit;
    }

    public void setData_fillimit(String data_fillimit){
        this.data_fillimit=data_fillimit;
    }

    public String getData_mbarimit(){
        return data_mbarimit;
    }

    public void setData_mbarimit(String data_mbarimit){
        this.data_mbarimit=data_mbarimit;
    }

    public String getStatusi(){
        return statusi;
    }

    public void setStatusi(String statusi){
        this.statusi=statusi;
    }

}
