package repository;

import models.Dto.CreatePaymentsDto;
import models.Dto.UpdatePaymentsDto;
import models.Payments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentsRepository extends BaseRepository<Payments, CreatePaymentsDto, UpdatePaymentsDto> {
    public PaymentsRepository() throws SQLException {
        super("pagesat");
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

    // 3. metoda create
    public Payments create(CreatePaymentsDto paymentsDto) {
        String query = """
                INSERT INTO PAGESAT (ID, IDRESERVATION, TYPE, PROMOCODEID,
                TOTALNODISCOUNT, TOTALFINAL, DATE)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, paymentsDto.getId());
            preparedStatement.setInt(2, paymentsDto.getIdReservation());
            preparedStatement.setObject(3, paymentsDto.getType(), Types.OTHER);
            preparedStatement.setObject(4, paymentsDto.getPromoCode());
            preparedStatement.setBigDecimal(5, paymentsDto.getTotalNoDiscount());
            preparedStatement.setBigDecimal(6, paymentsDto.getTotalFinal());
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(paymentsDto.getDate()));

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

    // 4. metoda update
    public Payments update(UpdatePaymentsDto paymentsDto) {
        StringBuilder query = new StringBuilder("UPDATE PAYMENTS SET ");
        List<Object> parameters = new ArrayList<>();
        boolean hasUpdates = false;

        if (paymentsDto.getType() != null) {
            query.append("type = ?, ");
            parameters.add(paymentsDto.getType());
            hasUpdates = true;
        }
        if (paymentsDto.getPromoCode() != null) {  // Now checking for PromoCode object
            query.append("promocodeid = ?, ");
            parameters.add(paymentsDto.getPromoCode().getId());  // Adding promoCode's ID
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
            parameters.add(paymentsDto.getDate());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(paymentsDto.getId());
        }

        query.setLength(query.length() - 2); // Remove last comma
        query.append(" WHERE id=?");
        parameters.add(paymentsDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i), Types.OTHER);
            }
            preparedStatement.executeUpdate();
            return getById(paymentsDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Error during update!", e);
        }
    }
}
