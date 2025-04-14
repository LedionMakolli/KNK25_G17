package repository;

import models.Dto.CreateOfertatDto;
import models.Dto.UpdateOfertatDto;
import models.Ofertat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OfertatRepository extends BaseRepository<Ofertat, CreateOfertatDto, UpdateOfertatDto> {
    public OfertatRepository() throws SQLException {
        super("ofertat");
    }

    @Override
    public Ofertat fromResultSet(ResultSet rs) {
        try{
            return Ofertat.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Ofertat create(CreateOfertatDto ofertatDto) {
        String query = """
                INSERT INTO OFERTAT (IDVETURA, ZBRITJA, DATAFILLIMIT, DATAMBARIMIT)
                VALUES (?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, ofertatDto.getIdVetura());
            pstm.setDouble(2, ofertatDto.getZbritja());
//            pstm.setDate(3, ofertatDto.getDateStart());
//            pstm.setDate(4, ofertatDto.getDateFininsh());  ki error e bana koment deri te ndreqsh
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.next()) {
                int id = rs.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Ofertat update(UpdateOfertatDto ofertatDto) {
        StringBuilder query = new StringBuilder("UPDATE OFERTAT SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdates = false;

        if(ofertatDto.getIdVetura() != null) {
            query.append("IDVETURA = ?, ");
            params.add(ofertatDto.getIdVetura());
            hasUpdates = true;
        }
        if(ofertatDto.getZbritja() != null) {
            query.append("ZBRITJA = ?, ");
            params.add(ofertatDto.getZbritja());
            hasUpdates = true;
        }
        if(ofertatDto.getDataFillimit() != null) {
            query.append("DATAFILLIMIT = ?, ");
            params.add(ofertatDto.getDataMbarimit());
            hasUpdates = true;
        }
        if(ofertatDto.getDataMbarimit() != null) {
            query.append("DATAMBARIMIT = ?");
            params.add(ofertatDto.getDataMbarimit());
            hasUpdates = true;
        }

        if(!hasUpdates) {
            return getById(ofertatDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE ID = ?");
        params.add(ofertatDto.getId());

        try{
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }
            pstm.executeUpdate();
            return getById(ofertatDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
//            throw new RuntimeException("Gabim gjate perditesimit te ofertes!", e);
        }

    }

}
