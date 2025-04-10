package repository;

import models.Dto.CreateMirembajtjaDto;
import models.Dto.UpdateMirembajtjaDto;
import models.Mirembajtja;

import java.sql.*;

public class MirembajtjaRepository extends BaseRepository<Mirembajtja, CreateMirembajtjaDto, UpdateMirembajtjaDto> {

    public MirembajtjaRepository() throws SQLException {
        super("Mirembajtja");
    }

    @Override
    Mirembajtja fromResultSet(ResultSet rs) {
        try{
            return Mirembajtja.getInstance(rs);
        }catch (SQLException e){
            return null;
        }
    }

    // metoda create
    public Mirembajtja create(CreateMirembajtjaDto Mirembajtjadto) {
        String query = "INSERT INTO MIREMBAJTJA (idVetura,pershkrimi,dataFillimit,dataMbarimit,kosto,statusi,idStafi) Values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, Mirembajtjadto.getIdVetura());
            preparedStatement.setString(2, Mirembajtjadto.getPershkrimi());
            preparedStatement.setDate(3, Mirembajtjadto.getDataFillimit());
            preparedStatement.setDate(4, Mirembajtjadto.getDataMbarimit());
            preparedStatement.setBigDecimal(5, Mirembajtjadto.getKosto());
            preparedStatement.setObject(6, Mirembajtjadto.getStatusi(), Types.OTHER);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
