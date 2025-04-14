package repository;

import models.Documents;
import models.Dto.CreateDocumentsDto;
import models.Dto.UpdateDocumentsDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocumentsRepository extends BaseRepository<Documents, CreateDocumentsDto, UpdateDocumentsDto> {

    public DocumentsRepository() throws SQLException{
        super("Documents");
    }
    @Override
    public Documents fromResultSet(ResultSet rs){
        try{
            return Documents.getInstance(rs);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // metoda create
    public Documents create(CreateDocumentsDto dokumentetDto){
        String query = "INSERT INTO Documents (idContract,type,path,dataUpLoad) VALUES (?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // per AUTO_INCREMENT
            preparedStatement.setInt(1, dokumentetDto.getIdContract());
            preparedStatement.setString(2, dokumentetDto.getType());
            preparedStatement.setString(3, dokumentetDto.getPath());
            preparedStatement.setDate(4,dokumentetDto.getDataUpload());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // metoda update

    public Documents update(UpdateDocumentsDto DokemntetDto){
        StringBuilder query = new StringBuilder("UPDATE DOCUMENTS SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (DokemntetDto.getDataUpload() != null){
            query.append("dataUpload = ?, ");
            parametrat.add(DokemntetDto.getDataUpload());
            hasUpdates = true;
        }
        if (DokemntetDto.getType() != null){
            query.append("type = ?, ");
            parametrat.add(DokemntetDto.getType());
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
