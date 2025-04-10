package repository;

import models.Dto.CreateMirembajtjaDto;
import models.Dto.UpdateMirembajtjaDto;
import models.Mirembajtja;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            preparedStatement.setInt(7, Mirembajtjadto.getIdStafi());
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

    //metoda update

    public Mirembajtja update(UpdateMirembajtjaDto Mirembajtjadto) {
        StringBuilder query = new StringBuilder("UPDATE MIREMBAJTJA SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (Mirembajtjadto.getPershkrimi() != null) {
            query.append("pershkrimi = ?, ");
            parametrat.add(Mirembajtjadto.getPershkrimi());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getDataFillimit() != null) {
            query.append("dataFillimit = ?, ");
            parametrat.add(Mirembajtjadto.getDataFillimit());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getDataMbarimit() != null) {
            query.append("dataMbarimit = ?, ");
            parametrat.add(Mirembajtjadto.getDataMbarimit());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getKosto() != null) {
            query.append("kosto = ?, ");
            parametrat.add(Mirembajtjadto.getKosto());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getStatusi() != null) {
            query.append("statusi = CAST(? AS StatusiMirembatjaEnum), ");
            parametrat.add(Mirembajtjadto.getStatusi().name());
            hasUpdate = true;
        }

        if (hasUpdate) {
            query.setLength(query.length() - 2);
        } else {
            return getById(Mirembajtjadto.getId());
        }

        query.append(" WHERE id = ?");
        parametrat.add(Mirembajtjadto.getId());

        try {
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                if (parametrat.get(i) instanceof String && i == parametrat.size() - 1) {
                    pstm.setObject(i + 1, parametrat.get(i), Types.OTHER);
                } else {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
            }

            pstm.executeUpdate();

            return getById(Mirembajtjadto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
