package repository;

import models.Dto.*;
import models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KontrataRepository extends BaseRepository<Kontrata, CreateKontrataDto, UpdateKontrataDto> {

    public KontrataRepository() throws SQLException{
        super("kontrata");
    }

    @Override
    public Kontrata fromResultSet(ResultSet rs){
        try{
            return Kontrata.getInstance(rs);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // metoda create

    public Kontrata create(CreateKontrataDto KontrataDto){
        String query = "INSERT INTO Kontrata (idRezervimet,shuma, pagesa, data) VALUES (?, ?, ?,?)";

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1,KontrataDto.getIdRezervimet());
            pstm.setDouble(2,KontrataDto.getShuma());
            pstm.setObject(3,KontrataDto.getPagesa(), Types.OTHER);
            pstm.setDate(4,KontrataDto.getData());
            pstm.execute();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda update

    public Kontrata update(UpdateKontrataDto KontrataDto){
        StringBuilder query = new StringBuilder("UPDATE KONTRATA SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (KontrataDto.getShuma() > 0){
            query.append("shuma = ?, ");
            parametrat.add(KontrataDto.getShuma());
            hasUpdate = true;
        }
        if (KontrataDto.getPagesa() != null){
            query.append("pagesa = CAST(? AS PagesaEnum), ");
            parametrat.add(KontrataDto.getPagesa().name());
            hasUpdate = true;
        }
        if (KontrataDto.getData() != null){
            query.append("data = ?, ");
            parametrat.add(KontrataDto.getData());
            hasUpdate = true;
        }

        if (!hasUpdate){
            return getById(KontrataDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id = ?");
        parametrat.add(KontrataDto.getId());

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i<parametrat.size(); i++){
                if (parametrat.get(i) instanceof String && i == parametrat.size()-1){
                    pstm.setObject(i+1,parametrat.get(i), Types.OTHER);
                }else {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
            }
            pstm.execute();
            return getById(KontrataDto.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
