package repository;

import models.Dto.CreateVleresimetDto;
import models.Dto.UpdateVleresimetDto;
import models.Vleresimet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VleresimetRepository extends BaseRepository<Vleresimet, CreateVleresimetDto, UpdateVleresimetDto> {
    public VleresimetRepository() throws SQLException {
        super("vleresimet");
    }

    @Override
    public Vleresimet fromResultSet(ResultSet rs) {
        try {
            return Vleresimet.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vleresimet create(CreateVleresimetDto vleresimetDto) {
        String query = """
                INSERT INTO VLERESIMET (IDKLIENTI, IDVETURA, RATING, TEXT, DATA)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, vleresimetDto.getIdKlienti());
            pstm.setInt(2, vleresimetDto.getIdVetura());
            pstm.setInt(3, vleresimetDto.getRating());
            pstm.setString(4, vleresimetDto.getText());
            pstm.setTimestamp(5, vleresimetDto.getData());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
