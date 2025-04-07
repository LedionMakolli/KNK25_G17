package repository;

import models.Dto.*;
import models.KerkesaSpeciale;
import models.PromoCode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
                INSERT INTO PROMOCODE (kodi, zbritja, dataSkadimit, aktiv) VALUES(?,?,?,?)""";

        try{
            PreparedStatement pstm= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, promoCodeDto.getKodi());
            pstm.setDouble(2, promoCodeDto.getZbritja());
            pstm.setDate(3, java.sql.Date.valueOf(promoCodeDto.getDataSkadimit()));
            pstm.setBoolean(4, promoCodeDto.isAktiv());
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
        StringBuilder query = new StringBuilder("UPDATE PROMOCODE SET");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (promoCodeDto.getDataSkadimit() != null) {
            query.append("dataSkadimit = ?,");
            parameters.add(promoCodeDto.getDataSkadimit());
            hasUpdates = true;
        }
        if (promoCodeDto.isAktiv() != null) {
            query.append("aktiv = ?,");
            parameters.add(promoCodeDto.isAktiv());
            hasUpdates = true;
        }

        query.setLength(query.length() - 2);
        query.append("WHERE ID = ?");
        parameters.add(promoCodeDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                pstm.setObject(i + 1, parameters.get(i));
            }
            pstm.executeUpdate();
            return getById(promoCodeDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit", e);
        }

    }
}
