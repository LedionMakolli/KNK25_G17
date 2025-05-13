package services;

import database.DBConnection;
import repository.ReservationsRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationService {
    private final ReservationsRepository repo;
    public ReservationService() throws SQLException {
        repo = new ReservationsRepository();
    }

    /** Mark old reservations as ENDED. Call this at startup or before searches. */
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
}
