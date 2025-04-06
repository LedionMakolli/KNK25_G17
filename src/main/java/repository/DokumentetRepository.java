package repository;

import models.Dokumentet;
import models.Dto.CreateDokumentetDto;
import models.Dto.UpdateDokumentetDto;
import models.Kontrata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            preparedStatement

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
