package repository;

import models.Dto.CreateKerkesatSpecialeDto;
import models.Dto.UpdateKerkesatSpecialeDto;
import models.KerkesaSpeciale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KerkesaSpecialeRepository extends BaseRepository<KerkesaSpeciale, CreateKerkesatSpecialeDto, UpdateKerkesatSpecialeDto> {
    public KerkesaSpecialeRepository() throws SQLException{
        super("kerkesaspeciale");
    }
    @Override
    public KerkesaSpeciale fromResultSet(ResultSet rs){
        try{
            return KerkesaSpeciale.getInstance(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public KerkesaSpeciale create(CreateKerkesatSpecialeDto kerkesatSpecialeDto){
        String query= """
                INSERT INTO KERKESASPECIALE (idRezervimet, kerkese, plotesuar) VALUES (?,?,?)""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, kerkesatSpecialeDto.getIdRezervimet());
            preparedStatement.setString(2, kerkesatSpecialeDto.getKerkese());
            preparedStatement.setBoolean(3, kerkesatSpecialeDto.isPlotesuar());
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return this.getById(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } return null;

    }


    public KerkesaSpeciale update(UpdateKerkesatSpecialeDto kerkesatSpecialeDto) {
        StringBuilder query = new StringBuilder("UPDATE KERKESASPECIALE SET");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (kerkesatSpecialeDto.getIdRezervimet() > 0) {
            query.append("idRezervimet=?");
            parameters.add(kerkesatSpecialeDto.getIdRezervimet());
            hasUpdates = true;
        }
        if (kerkesatSpecialeDto.getKerkese() != null) {
            query.append("kerkese=?");
            parameters.add(kerkesatSpecialeDto.getKerkese());
            hasUpdates = true;
        }
        if (kerkesatSpecialeDto.isPlotesuar() != null) {
            query.append("plotesuar=?");
            parameters.add(kerkesatSpecialeDto.isPlotesuar());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(kerkesatSpecialeDto.getId());

        }
        query.setLength(query.length() - 2);
        query.append("where id = ?");
        parameters.add(kerkesatSpecialeDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                pstm.setObject(i + 1, parameters.get(i));
            }
            pstm.executeUpdate();
            return getById(kerkesatSpecialeDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit", e);
        }
    }

}

