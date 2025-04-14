package repository;

import models.Dto.CreatePenaltyDto;
import models.Dto.UpdatePenaltyDto;
import models.Penalties;
import java.sql.*;

public class PenaltiesRepository extends BaseRepository<Penalties, CreatePenaltyDto, UpdatePenaltyDto> {
    public PenaltiesRepository() throws SQLException {
        super("penalties");
    }
    @Override
    public Penalties fromResultSet(ResultSet rs) {
        try {
            return Penalties.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Penalties create(CreatePenaltyDto penaltyDto) {
        String query = """
                INSERT INTO PENALIZIMET (RESERVATIONID, REASONOFPENALTY, MONEYAMOUNT, DATE, PAID)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, penaltyDto.getReservationId());
            preparedStatement.setString(2, penaltyDto.getReasonOfPenalty());
            preparedStatement.setBigDecimal(3, penaltyDto.getMoneyAmount());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(penaltyDto.getDate()));
            preparedStatement.setBoolean(5, penaltyDto.isPaid());
            preparedStatement.execute();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Penalties updatePaguar(UpdatePenaltyDto penaltyDto) {
        String query = "UPDATE PENALTIES SET PAID = ? WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, penaltyDto.isPaid());
            preparedStatement.setInt(2, penaltyDto.getId());
            int rowsEffected = preparedStatement.executeUpdate();

            if(rowsEffected==1) {
                return this.getById(penaltyDto.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating penalty!", e);
        }
        return null;
    }
}
