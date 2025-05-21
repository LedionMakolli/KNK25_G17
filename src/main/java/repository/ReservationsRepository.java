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

    @Override
    public Reservations fromResultSet(ResultSet rs) {
        try {
            return Reservations.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Reservations> getAll() {
        ArrayList<Reservations> list = new ArrayList<>();
        String sql = "SELECT * FROM reservationsview";
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(fromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Reservations getById(int id) {
        String sql = "SELECT * FROM reservationsview WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return fromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean existsOverlap(int idCar, Date start, Date end) {
        String query = """
                SELECT 1
                FROM reservations
                WHERE idcar = ?
                   AND reservationstatus = 'ACTIVE'
                   AND NOT (enddate < ? OR startdate > ?)
                LIMIT 1                
                """;
        try (PreparedStatement pstm = connection.prepareStatement(query)) {
            pstm.setInt(1, idCar);
            pstm.setDate(2, start);
            pstm.setDate(3, end);
            try (ResultSet rs = pstm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking overlap", e);
        }
    }

    public Reservations findOverlapReservation(int idCar, Date start, Date end) {
        String sql = """
                SELECT *
                  FROM reservations
                 WHERE idcar = ?
                   AND reservationstatus = 'ACTIVE'
                   AND NOT (enddate < ? OR startdate > ?)
                 LIMIT 1
                """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCar);
            ps.setDate(2, start);
            ps.setDate(3, end);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return fromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching overlapping reservation", e);
        }
        return null;
    }

//3. Metoda create

    public Reservations create(CreateReservationsDto reservationsDto) {
        String query = """
        INSERT INTO Reservations (idClient, idCar, startDate, endDate, reservationStatus,createdAt)
        VALUES (?,?,?,?,?,?) RETURNING *
""";

        try (PreparedStatement pstm = connection.prepareStatement(query)) {

            pstm.setInt(1, reservationsDto.getIdClient());
            pstm.setInt(2, reservationsDto.getIdCar());
            pstm.setDate(3, reservationsDto.getStartDate());
            pstm.setDate(4, reservationsDto.getEndDate());
            pstm.setObject(5, reservationsDto.getReservationStatus(), Types.OTHER);
            pstm.setDate(6, Date.valueOf(reservationsDto.getCurrentDate()));


            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create reservation: " + e.getMessage());
        }
        return null;
    }

    //4. Metoda update
    public Reservations update(UpdateReservationsDto reservationsDto) {
        StringBuilder query = new StringBuilder("UPDATE Reservations SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdates = false;

        if (reservationsDto.getIdCar() > 0) {
            query.append("idcar = ?, ");
            params.add(reservationsDto.getIdCar());
            hasUpdates = true;
        }

        if (reservationsDto.getStartDate() != null) {
            query.append("startdate = ?, ");
            params.add(reservationsDto.getStartDate());
            hasUpdates = true;
        }

        if (reservationsDto.getEndDate() != null) {
            query.append("enddate = ?, ");
            params.add(reservationsDto.getEndDate());
            hasUpdates = true;
        }

        if (reservationsDto.getReservationStatus() != null) {
            query.append("reservationstatus = ?, ");
            params.add(reservationsDto.getReservationStatus().name());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(reservationsDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append("WHERE id = ?");
        params.add(reservationsDto.getId());

        try (PreparedStatement pstm = connection.prepareStatement(query.toString())) {
            for (int i = 0; i < params.size(); i++) {
                Object param = params.get(i);
                pstm.setObject(i + 1, param);
            }
            pstm.executeUpdate();
            return getById(reservationsDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update reservation: " + e.getMessage(), e);
        }
    }

    public List<Reservations> getByClientId(int clientId) throws SQLException{
        List<Reservations> reservations = new ArrayList<>();
        String query = "SELECT * FROM ReservationsView WHERE idClient = ?";

        PreparedStatement ptsm = connection.prepareStatement(query);
        ptsm.setInt(1,clientId);
        ResultSet rs = ptsm.executeQuery();
        while (rs.next()){
            Reservations reservation = fromResultSet(rs);
            reservations.add(reservation);
        }
        return reservations;
    }
}











