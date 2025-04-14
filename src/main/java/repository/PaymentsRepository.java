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
    public PaymentsRepository fromResultSet(ResultSet rs) {
        try {
            return Payments.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 3. metoda create
    public Payments create(CreatePaymentsDto paymentsDto) {
        String query= """
                INSERT INTO PAGESAT (ID, IDRESERVATION, TYPE, PROMOCODEID,
                TOTALNODISCOUNT, TOTALFINAL, DATE)
                VALUES (?, ?, ?, ?, ?, ?, ?,)
                """;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, paymentsDto.getId());
            preparedStatement.setInt(2, paymentsDto.getIdReservation());
            preparedStatement.setObject(3, paymentsDto.getType(),Types.OTHER);
            preparedStatement.setInt(4, paymentsDto.getPromoCodeId());
            preparedStatement.setBigDecimal(5, paymentsDto.getTotalNoDiscount());
            preparedStatement.setBigDecimal(6, paymentsDto.getTotalFinal());
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(paymentsDto.getDate()));

            preparedStatement.execute();
            ResultSet result=preparedStatement.getGeneratedKeys();
            if(result.next()) {
                int id=result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 4. metoda update
    public Payments update(UpdatePaymentsDto PaymentsDto) {
        StringBuilder query = new StringBuilder("UPDATE PAYMENTS SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates=false;

        if (PaymentsDto.getType() != null) {
            query.append("type = ?, ");
            parametrat.add(PaymentsDto.getType());
            hasUpdates=true;
        }
        if (PaymentsDto.getPromoCodeId() != null) {
            query.append("promocodeid = ?, ");
            parametrat.add(PaymentsDto.getPromoCodeId());
            hasUpdates=true;
        }
        if (PaymentsDto.getTotalNoDiscount() !=null) {
            query.append("totalnodiscount = ?, ");
            parametrat.add(PaymentsDto.getTotalNoDiscount());
            hasUpdates=true;
        }
        if (PaymentsDto.getTotalFinal() != null) {
            query.append("totalfinal = ?, ");
            parametrat.add(PaymentsDto.getTotalFinal());
            hasUpdates=true;
        }
        if (PaymentsDto.getDate() != null) {
            query.append("date = ?, ");
            parametrat.add(PaymentsDto.getDate());
            hasUpdates=true;
        }
        if (!hasUpdates) {
            return getById(PaymentsDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id=?");
        parametrat.add(PaymentsDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                preparedStatement.setObject(i+1, parametrat.get(i), Types.OTHER);
            }
            preparedStatement.executeUpdate();
            return getById(PaymentsDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Error during update!", e);
        }
    }

}
