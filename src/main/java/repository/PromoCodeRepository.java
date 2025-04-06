package repository;

import models.Dto.CreateKerkesatSpecialeDto;
import models.Dto.CreatePromoCodeDto;
import models.Dto.UpdatePromoCodeDto;
import models.Dto.UpdateRezervimetDto;
import models.PromoCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PromoCodeRepository extends BaseRepository<PromoCode, CreatePromoCodeDto, UpdatePromoCodeDto>{
    public PromoCodeRepository() throws SQLException{
        super("PromoCode");
    }
    @Override
    public PromoCode fromResulSet(ResultSet resultSet){
        try{
            return PromoCode.getInstance(resultSet);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public PromoCode create(CreatePromoCodeDto promoCodeDto){
        String query= """
                INSERT INTO PROMOCODE (kodi, zbritja, dataSkadimit, aktiv) VALUES(?,?,?.?)""";

        try{
            PreparedStatement pstm= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, promoCodeDto.getKodi());
            pstm.setDouble(2, promoCodeDto.getZbritja());
            pstm.setDate(3, java.sql.Date.valueOf(promoCodeDto.getDataSkadimit()));
            pstm.setBoolean(4, promoCodeDto.setAktiv());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.next()){
                int id=rs.getInt(1);
                return this.getById(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } return null;
    }
}
