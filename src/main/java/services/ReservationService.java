package services;

import database.DBConnection;
import models.Reservations;
import repository.ReservationsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public class ReservationService {
    private final ReservationsRepository repo;
    public ReservationService() throws SQLException {
        repo = new ReservationsRepository();
    }

    public void expireOldReservations() {
        String query = """
      UPDATE reservations
         SET reservationstatus = 'ENDED'
       WHERE reservationstatus = 'ACTIVE'
         AND enddate < CURRENT_DATE
    """;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to expire reservations", e);
        }
    }

    public List<Reservations> getRole() throws SQLException {
        List<Reservations> reservations ;
        String role = SessionManager.getInstance().getCurrentRole();
        if ("client".equals(role)){
            int clientId = SessionManager.getInstance().getCurrentClient().getId();
            reservations = repo.getByClientId(clientId);
        }else{
            reservations = repo.getAll();
        }
        return reservations;
    }
}
