package models.Dto;

import java.sql.Date;

public class UpdateRezervimetDto {
    private int id_rezervimet;
    private int id_vetura;
    private Date data_fillimit;
    private Date data_mbarimit;

    public UpdateRezervimetDto(int id_vetura, Date data_fillimit, Date data_mbarimit){
        this.id_vetura = id_vetura;
        this.data_fillimit = data_fillimit;
        this.data_mbarimit= data_mbarimit;
    }
 public UpdateRezervimetDto(){}


    public int getId_rezervimet() {
        return id_rezervimet;
    }

    public int getId_vetura(){
        return id_vetura;
    }
    public Date getData_fillimit(){
        return data_fillimit;
    }
    public Date getData_mbarimit(){
        return data_mbarimit;
    }
    public void setData_fillimit(Date data_fillimit){
        this.data_fillimit = data_fillimit;
    }
    public void setData_mbarimit(Date data_mbarimit){
        this.data_mbarimit=data_mbarimit;
    }
}
