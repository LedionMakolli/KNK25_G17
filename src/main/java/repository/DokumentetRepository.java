package repository;

import models.Dokumentet;
import models.Dto.CreateDokumentetDto;
import models.Dto.UpdateDokumentetDto;
import models.Dto.UpdateKontrataDto;
import models.Kontrata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DokumentetRepository extends BaseRepository<Dokumentet, CreateDokumentetDto, UpdateDokumentetDto> {

    public DokumentetRepository() throws SQLException{
        super("Dokumentet");
    }
    @Override
    public Dokumentet fromResultSet(ResultSet rs){
        try{
            return Dokumentet.getInstance(rs);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // metoda create
    public Dokumentet create(CreateDokumentetDto dokumentetDtodto){
        String query = "INSERT INTO KONTRATA (idKontrata,lloji,path,dateUpLoad) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, dokumentetDtodto.getIdKontrata());
            preparedStatement.setString(2, dokumentetDtodto.getLloji());
            preparedStatement.setString(3, dokumentetDtodto.getPath());
            preparedStatement.setDate(4,dokumentetDtodto.getDataUpload());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
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

    public Dokumentet update(UpdateDokumentetDto DokemntetDto){
        StringBuilder query = new StringBuilder("UPDATE DOKUMENTET SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (DokemntetDto.getDataUpload() != null){
            query.append("dataUpload = ?, ");
            parametrat.add(DokemntetDto.getDataUpload());
            hasUpdates = true;
        }
        if (DokemntetDto.getLloji() != null){
            query.append("lloji = ?, ");
            parametrat.add(DokemntetDto.getLloji());
            hasUpdates = true;
        }
        if (DokemntetDto.getPath() != null){
            query.append("path = ?, ");
            parametrat.add(DokemntetDto.getPath());
            hasUpdates = true;
        }
        if (!hasUpdates){
            return getById(DokemntetDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id = ?");
        parametrat.add(DokemntetDto.getId());
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++){
                preparedStatement.setObject(i+1, parametrat.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(DokemntetDto.getId());
        }catch (SQLException e){
            throw new RuntimeException("Gabim gjate perditesimit! ", e);
        }
    }
}
