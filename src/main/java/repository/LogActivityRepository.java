package repository;

import models.Dto.CreateKontrataDto;
import models.Dto.CreateLogActivityDto;

import models.Dto.UpdateLogActivityDto;

import models.LogActivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogActivityRepository extends BaseRepository<LogActivity, CreateLogActivityDto, UpdateLogActivityDto> {
    public LogActivityRepository() throws SQLException{
        super ("logactivity");
    }

    @Override
    public LogActivity fromResultSet(ResultSet rs){
        try{
            return LogActivity.getInstance(rs);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // metoda create

    public LogActivity create(CreateLogActivityDto LogActivityDto){
        String query = "INSERT INTO LogActivity (id,idUser,veprimi,ipAddress, data) VALUES (?, ?,?, ?,?)";

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1,LogActivityDto.getId());
            pstm.setInt(2,LogActivityDto.getIdUser());
            pstm.setObject(3,LogActivityDto.getVeprimi(), Types.OTHER);
            pstm.setString(4,LogActivityDto.getIpAddress());
            pstm.setTimestamp(5, java.sql.Timestamp.valueOf(LogActivityDto.getData()));
            pstm.execute();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda update

    /*public LogActivity update(UpdateLogActivityDto LogActivityDto){
        StringBuilder query = new StringBuilder("UPDATE LOGACTIVITY SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (LogActivityDto.getShuma() > 0){
            query.append("shuma = ?, ");
            parametrat.add(LogActivityDto.getShuma());
            hasUpdate = true;
        }
        if (LogActivityDto.getPagesa() != null){
            query.append("pagesa = CAST(? AS Pagesa), ");
            parametrat.add(LogActivity.getPagesa().name());
            hasUpdate = true;
        }
        if (LogActivityDto.getData() != null){
            query.append("data = ?, ");
            parametrat.add(LogActivityDto.getData());
            hasUpdate = true;
        }

        if (!hasUpdate){
            return getById(LogActivityDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id = ?");
        parametrat.add(LogActivity.getId());

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i<parametrat.size(); i++){
                if (parametrat.get(i) instanceof String && i == parametrat.size()-1){
                    pstm.setObject(i+1,parametrat.get(i), Types.OTHER);
                }else {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
            }
            pstm.execute();
            return getById(LogActivityDto.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }*/
}
