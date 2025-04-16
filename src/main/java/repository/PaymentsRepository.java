package repository;

import models.Dto.CreatePaymentsDto;
import models.Dto.UpdatePaymentsDto;
import models.Payments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentsRepository extends BaseRepository<Payments, CreatePaymentsDto, UpdatePaymentsDto> {
    public PaymentsRepository() throws SQLException {
        super("payments");
    }

    @Override
    public Payments fromResultSet(ResultSet rs) {
        try {
            return Payments.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Create method
    public Payments create(CreatePaymentsDto paymentsDto) {
        String query = """
                INSERT INTO PAYMENTS (ID, IDRESERVATION, TYPE, PROMOCODEID,
                TOTALNODISCOUNT, TOTALFINAL, DATE)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, paymentsDto.getId());
            preparedStatement.setInt(2, paymentsDto.getIdReservation());
            preparedStatement.setString(3, paymentsDto.getType().toString());
            preparedStatement.setInt(4, paymentsDto.getPromoCodeId());  // Changed from getPromoCode()
            preparedStatement.setBigDecimal(5, paymentsDto.getTotalNoDiscount());
            preparedStatement.setBigDecimal(6, paymentsDto.getTotalFinal());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(paymentsDto.getDate()));

            preparedStatement.execute();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update method
    public Payments update(UpdatePaymentsDto paymentsDto) {
        StringBuilder query = new StringBuilder("UPDATE PAYMENTS SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (paymentsDto.getType() != null) {
            query.append("type = ?, ");
            parameters.add(paymentsDto.getType().toString());
            hasUpdates = true;
        }
        if (paymentsDto.getPromoCodeId() != 0) {  // Changed to check for 0 instead of null
            query.append("promocodeid = ?, ");
            parameters.add(paymentsDto.getPromoCodeId());  // Using promoCodeId directly
            hasUpdates = true;
        }
        if (paymentsDto.getTotalNoDiscount() != null) {
            query.append("totalnodiscount = ?, ");
            parameters.add(paymentsDto.getTotalNoDiscount());
            hasUpdates = true;
        }
        if (paymentsDto.getTotalFinal() != null) {
            query.append("totalfinal = ?, ");
            parameters.add(paymentsDto.getTotalFinal());
            hasUpdates = true;
        }
        if (paymentsDto.getDate() != null) {
            query.append("date = ?, ");
            parameters.add(Timestamp.valueOf(paymentsDto.getDate()));
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(paymentsDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE id=?");
        parameters.add(paymentsDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                Object param = parameters.get(i);
                if (param instanceof Timestamp) {
                    preparedStatement.setTimestamp(i + 1, (Timestamp) param);
                } else {
                    preparedStatement.setObject(i + 1, param);
                }
            }
            preparedStatement.executeUpdate();
            return getById(paymentsDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Error during update!", e);
        }
    }
}