package repository;

import models.Dto.CreateVleresimetDto;
import models.Dto.UpdateVleresimetDto;
import models.Vleresimet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
        }
        return null;
    }

    public Vleresimet update(UpdateVleresimetDto vleresimetDto) {
        StringBuilder query = new StringBuilder("UPDATE VLERESIMET SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdates = false;

        if(vleresimetDto.getIdKlienti() != null) {
            query.append("IDKLIENTI = ?, ");
            params.add(vleresimetDto.getIdKlienti());
            hasUpdates = true;
        }
        if(vleresimetDto.getIdVetura() != null) {
            query.append("IDVETURA = ?, ");
            params.add(vleresimetDto.getIdVetura());
            hasUpdates = true;
        }
        if(vleresimetDto.getRating() != null) {
            query.append("RATING = ?, ");
            params.add(vleresimetDto.getRating());
            hasUpdates = true;
        }
        if(vleresimetDto.getText() != null) {
            query.append("TEXT = ?, ");
            params.add(vleresimetDto.getText());
            hasUpdates = true;
        }
        if(vleresimetDto.getData() != null) {
            query.append("DATA = ?");
            params.add(vleresimetDto.getData());
            hasUpdates = true;
        }

        if(!hasUpdates) {
            return getById(vleresimetDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE IDK = ?");
        params.add(vleresimetDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for(int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }
            pstm.executeUpdate();
            return getById(vleresimetDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
