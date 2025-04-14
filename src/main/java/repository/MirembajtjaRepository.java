package repository;

import models.Dto.CreateMaintenanceDto;
import models.Dto.UpdateMaintenanceDto;
import models.Maintenance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MirembajtjaRepository extends BaseRepository<Maintenance, CreateMaintenanceDto, UpdateMaintenanceDto> {

    public MirembajtjaRepository() throws SQLException {
        super("Maintenance");
    }

    @Override
    Maintenance fromResultSet(ResultSet rs) {
        try{
            return Maintenance.getInstance(rs);
        }catch (SQLException e){
            return null;
        }
    }

    // metoda create
    public Maintenance create(CreateMaintenanceDto Mirembajtjadto) {
        String query = "INSERT INTO MIREMBAJTJA (idVetura,pershkrimi,dataFillimit,dataMbarimit,kosto,statusi,idStafi) Values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, Mirembajtjadto.getIdCar());
            preparedStatement.setString(2, Mirembajtjadto.getDescription());
            preparedStatement.setDate(3, Mirembajtjadto.getDateStart());
            preparedStatement.setDate(4, Mirembajtjadto.getDateFinish());
            preparedStatement.setBigDecimal(5, Mirembajtjadto.getCost());
            preparedStatement.setObject(6, Mirembajtjadto.getStatus(), Types.OTHER);
            preparedStatement.setInt(7, Mirembajtjadto.getIdStaff());
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

    public Maintenance update(UpdateMaintenanceDto Mirembajtjadto) {
        StringBuilder query = new StringBuilder("UPDATE MIREMBAJTJA SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (Mirembajtjadto.getDescription() != null) {
            query.append("pershkrimi = ?, ");
            parametrat.add(Mirembajtjadto.getDescription());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getDateStart() != null) {
            query.append("dataFillimit = ?, ");
            parametrat.add(Mirembajtjadto.getDateStart());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getDateFininsh() != null) {
            query.append("dataMbarimit = ?, ");
            parametrat.add(Mirembajtjadto.getDateFininsh());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getCost() != null) {
            query.append("kosto = ?, ");
            parametrat.add(Mirembajtjadto.getCost());
            hasUpdate = true;
        }
        if (Mirembajtjadto.getStatus() != null) {
            query.append("statusi = CAST(? AS StatusMaintenanceEnum), ");
            parametrat.add(Mirembajtjadto.getStatus().name());
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
