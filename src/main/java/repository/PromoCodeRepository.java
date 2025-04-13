package repository;

import models.Dto.*;
import models.PromoCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromoCodeRepository extends BaseRepository<PromoCode, CreatePromoCodeDto, UpdatePromoCodeDto>{
    public PromoCodeRepository() throws SQLException{
        super("PromoCode");
    }

    @Override
    public PromoCode fromResultSet(ResultSet resultSet){
        try{
            return PromoCode.getInstance(resultSet);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public PromoCode create(CreatePromoCodeDto promoCodeDto){
        String query= """
                INSERT INTO PROMOCODE (code, discount, expiryDate, active) VALUES(?,?,?,?)""";

        try{
            PreparedStatement pstm= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, promoCodeDto.getCode());
            pstm.setDouble(2, promoCodeDto.getDiscount());
            pstm.setDate(3, promoCodeDto.getExpiryDate());
            pstm.setBoolean(4, promoCodeDto.isActive());
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


    public PromoCode update(UpdatePromoCodeDto promoCodeDto) {
        StringBuilder query = new StringBuilder("UPDATE PromoCode SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (promoCodeDto.getExpiryDate() != null) {
            query.append("dataSkadimit = ?, ");
            parameters.add(promoCodeDto.getExpiryDate());
            hasUpdates = true;
        }
        if (promoCodeDto.isActive() != null) {
            query.append("aktiv = ?, ");
            parameters.add(promoCodeDto.isActive());
            hasUpdates = true;
        }
        if(!hasUpdates){
            return getById(promoCodeDto.getId());
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE id = ?");
        parameters.add(promoCodeDto.getId());

        try {
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                    pstm.setObject(i + 1, parameters.get(i));
            }
            pstm.executeUpdate();
            return getById(promoCodeDto.getId());
        } catch (SQLException e) {
           e.printStackTrace();
        }
return null;
    }
}
