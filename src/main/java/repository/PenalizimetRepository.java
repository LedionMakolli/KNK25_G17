package repository;

import models.Dto.CreatePenalizimetDto;
import models.Dto.UpdatePenalizimetDto;
import models.Penalizimet;
import java.sql.*;

public class PenalizimetRepository extends BaseRepository<Penalizimet, CreatePenalizimetDto, UpdatePenalizimetDto> {
    public PenalizimetRepository() throws SQLException {
        super("penalizimet");
    }
    @Override
    public Penalizimet fromResultSet(ResultSet rs) {
        try {
            return Penalizimet.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Penalizimet create(CreatePenalizimetDto penalizimetDto) {
        String query = """
                INSERT INTO PENALIZIMET (IDREZERVIMET, ARSYEJA, SHUMA, DATA, PAGUAR)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, penalizimetDto.getIdRezervimet());
            preparedStatement.setString(2, penalizimetDto.getArsyeja());
            preparedStatement.setBigDecimal(3, penalizimetDto.getShuma());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(penalizimetDto.getData()));
            preparedStatement.setBoolean(5, penalizimetDto.isPaguar());
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
    public Penalizimet updatePaguar(UpdatePenalizimetDto penalizimetDto) {
        String query = "UPDATE PENALIZIMET SET PAGUAR = ? WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, penalizimetDto.isPaguar());
            preparedStatement.setInt(2, penalizimetDto.getId());
            int rowsEffected = preparedStatement.executeUpdate();

            if(rowsEffected==1) {
                return this.getById(penalizimetDto.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Gabim gjate perditesimit te penalizimit!", e);
        }
        return null;
    }
}
