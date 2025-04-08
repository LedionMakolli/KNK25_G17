package repository;

import models.Dto.CreateOfertatDto;
import models.Dto.UpdateOfertatDto;
import models.Ofertat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            pstm.setDate(3, ofertatDto.getDataFillimit());
            pstm.setDate(4, ofertatDto.getDataMbarimit());
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

//    public Ofertat update(UpdateOfertatDto ofertatDto) {
//
//    }

}
