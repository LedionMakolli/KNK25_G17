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
        super("specialrequests");
    }

    @Override
    public SpecialRequests fromResultSet(ResultSet rs){
        try{
            return SpecialRequests.getInstance(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public SpecialRequests create(CreateSpecialRequestsDto specialRequestsDto){
        String query= """
                INSERT INTO specialrequests (idReservation, request, completed) VALUES (?,?,?)""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, specialRequestsDto.getIdReservation());
            preparedStatement.setString(2, specialRequestsDto.getRequest());
            preparedStatement.setBoolean(3, specialRequestsDto.isCompleted());
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


    public SpecialRequests update(UpdateSpecialRequestsDto specialRequestsDto) {
        StringBuilder query = new StringBuilder("UPDATE KerkesaSpeciale SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (specialRequestsDto.getIdReservation() > 0) {
            query.append("idRezervimet=?, ");
            parameters.add(specialRequestsDto.getIdReservation());
            hasUpdates = true;
        }
        if (specialRequestsDto.getRequest() != null) {
            query.append("kerkese=?, ");
            parameters.add(specialRequestsDto.getRequest());
            hasUpdates = true;
        }
        if (specialRequestsDto.isCompleted() != null) {
            query.append("plotesuar=?, ");
            parameters.add(specialRequestsDto.isCompleted());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(specialRequestsDto.getId());

        }
        query.setLength(query.length() - 2);
        query.append(" where id = ?");
        parameters.add(specialRequestsDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                pstm.setObject(i + 1, parameters.get(i));
            }
            pstm.executeUpdate();
            return getById(specialRequestsDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

