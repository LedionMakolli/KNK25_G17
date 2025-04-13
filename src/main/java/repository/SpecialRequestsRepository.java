package repository;

import models.Dto.CreateSpecialRequestsDto;
import models.Dto.UpdateSpecialRequestsDto;
import models.SpecialRequests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialRequestsRepository extends BaseRepository<SpecialRequests, CreateSpecialRequestsDto, UpdateSpecialRequestsDto> {
    public SpecialRequestsRepository() throws SQLException{
        super("kerkesaspeciale");
    }

    public SpecialRequests fromResultSet(ResultSet rs){
        try{
            return SpecialRequests.getInstance(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public SpecialRequests create(CreateSpecialRequestsDto kerkesatSpecialeDto){
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


    public SpecialRequests update(UpdateSpecialRequestsDto kerkesatSpecialeDto) {
        StringBuilder query = new StringBuilder("UPDATE KerkesaSpeciale SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (kerkesatSpecialeDto.getIdRezervimet() > 0) {
            query.append("idRezervimet=?, ");
            parameters.add(kerkesatSpecialeDto.getIdRezervimet());
            hasUpdates = true;
        }
        if (kerkesatSpecialeDto.getKerkese() != null) {
            query.append("kerkese=?, ");
            parameters.add(kerkesatSpecialeDto.getKerkese());
            hasUpdates = true;
        }
        if (kerkesatSpecialeDto.isPlotesuar() != null) {
            query.append("plotesuar=?, ");
            parameters.add(kerkesatSpecialeDto.isPlotesuar());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(kerkesatSpecialeDto.getId());

        }
        query.setLength(query.length() - 2);
        query.append(" where id = ?");
        parameters.add(kerkesatSpecialeDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                pstm.setObject(i + 1, parameters.get(i));
            }
            pstm.executeUpdate();
            return getById(kerkesatSpecialeDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

