package repository;

import models.Dto.CreateMaintenanceDto;
import models.Dto.UpdateMaintenanceDto;
import models.Maintenance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRepository extends BaseRepository<Maintenance, CreateMaintenanceDto, UpdateMaintenanceDto> {

    public MaintenanceRepository() throws SQLException {
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
    public Maintenance create(CreateMaintenanceDto MaintenanceDto) {
        String query = "INSERT INTO Maintenance (idCar,description,dateStart,dateFinish,cost,status,idStaff) Values (?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, MaintenanceDto.getIdCar());
            preparedStatement.setString(2, MaintenanceDto.getDescription());
            preparedStatement.setDate(3, MaintenanceDto.getDateStart());
            preparedStatement.setDate(4, MaintenanceDto.getDateFinish());
            preparedStatement.setBigDecimal(5, MaintenanceDto.getCost());
            preparedStatement.setObject(6, MaintenanceDto.getStatus(), Types.OTHER);
            preparedStatement.setInt(7, MaintenanceDto.getIdStaff());
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

    public Maintenance update(UpdateMaintenanceDto MaintenanceDto) {
        StringBuilder query = new StringBuilder("UPDATE MAINTENANCE SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (MaintenanceDto.getDescription() != null) {
            query.append("description = ?, ");
            parametrat.add(MaintenanceDto.getDescription());
            hasUpdate = true;
        }
        if (MaintenanceDto.getDateStart() != null) {
            query.append("dateStart = ?, ");
            parametrat.add(MaintenanceDto.getDateStart());
            hasUpdate = true;
        }
        if (MaintenanceDto.getDateFininsh() != null) {
            query.append("dateFinish = ?, ");
            parametrat.add(MaintenanceDto.getDateFininsh());
            hasUpdate = true;
        }
        if (MaintenanceDto.getCost() != null) {
            query.append("cost = ?, ");
            parametrat.add(MaintenanceDto.getCost());
            hasUpdate = true;
        }
        if (MaintenanceDto.getStatus() != null) {
            query.append("status = CAST(? AS StatusMaintenanceEnum), ");
            parametrat.add(MaintenanceDto.getStatus().name());
            hasUpdate = true;
        }

        if (hasUpdate) {
            query.setLength(query.length() - 2);
        } else {
            return getById(MaintenanceDto.getId());
        }

        query.append(" WHERE id = ?");
        parametrat.add(MaintenanceDto.getId());

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

            return getById(MaintenanceDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
