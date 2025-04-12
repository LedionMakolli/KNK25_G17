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
    public Penalties create(CreatePenaltyDto penalizimetDto) {
        String query = """
                INSERT INTO PENALIZIMET (RESERVATIONID, REASONOFPENALTY, MONEYAMOUNT, DATE, PAID)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, penalizimetDto.getReservationId());
            preparedStatement.setString(2, penalizimetDto.getReasonOfPenalty());
            preparedStatement.setBigDecimal(3, penalizimetDto.getMoneyAmount());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(penalizimetDto.getDate()));
            preparedStatement.setBoolean(5, penalizimetDto.isPaid());
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
    public Penalties updatePaguar(UpdatePenaltyDto penalizimetDto) {
        String query = "UPDATE PENALTIES SET PAID = ? WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, penalizimetDto.isPaid());
            preparedStatement.setInt(2, penalizimetDto.getId());
            int rowsEffected = preparedStatement.executeUpdate();

            if(rowsEffected==1) {
                return this.getById(penalizimetDto.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while updating penalty!", e);
        }
        return null;
    }
}
