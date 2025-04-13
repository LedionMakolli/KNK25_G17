package repository;

import models.Dto.*;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationsRepository extends BaseRepository<Reservations, CreateReservationsDto, UpdateReservationsDto> {
    public ReservationsRepository() throws SQLException {
        super("reservations");
    }

    public Reservations fromResultSet(ResultSet rs) {
        try {
            return Reservations.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


//3. Metoda create

    public Reservations create(CreateReservationsDto reservationsDto) {
        String query = """
            
                INSERT INTO Rezervimet (idClient, idCar, startDate, endDate, reservationStatus)
            VALUES (?,?,?,?,?)""";
    try{
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, reservationsDto.getIdClient());
        pstm.setInt(2, reservationsDto.getIdCar());
        pstm.setDate(3, reservationsDto.getStartDate());
        pstm.setDate(4, reservationsDto.getEndDate());
        pstm.setObject(5, reservationsDto.getReservationStatus(), Types.OTHER);
        pstm.execute();
        ResultSet rs = pstm.getGeneratedKeys();
        if(rs.next()){
            int id = rs.getInt(1);
        return this.getById(id);
        }
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
 }
 //4. Metoda update
    public Reservations update(UpdateReservationsDto reservationsDto) {
        StringBuilder query = new StringBuilder("UPDATE Reservations SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (reservationsDto.getIdCar() > 0) {
            query.append("idVetura = ?, ");
            parametrat.add(reservationsDto.getIdCar());
            hasUpdates = true;
        }

        if (reservationsDto.getStartDate() != null) {
            query.append("dataFillimit = ?, ");
            parametrat.add(reservationsDto.getStartDate());
            hasUpdates = true;
        }

        if (reservationsDto.getEndDate() != null) {
            query.append("dataMbarimit = ?, ");
            parametrat.add(reservationsDto.getEndDate());
            hasUpdates = true;
        }

        if (reservationsDto.getReservationStatus() != null) {
            query.append("statusiRezervimet = CAST(? AS StatusiRezervimetEnum), ");
            parametrat.add(reservationsDto.getReservationStatus().name());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(reservationsDto.getId());
        }
        query.setLength(query.length() - 2);
        query.append("WHERE id = ?");
        parametrat.add(reservationsDto.getId());

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
            return getById(reservationsDto.getId());
        } catch (SQLException e) {
         e.printStackTrace();
        }
return null;
    } }










