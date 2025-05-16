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

    public Payments create(CreatePaymentsDto paymentsDto) {
        String query = "INSERT INTO PAYMENTS (IDRESERVATION, TYPE, PROMOCODEID, TOTALNODISCOUNT, TOTALFINAL, DATE) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, paymentsDto.getIdReservation());
            preparedStatement.setString(2, paymentsDto.getType().toString());
            if(paymentsDto.getPromoCodeId() != null){
                preparedStatement.setInt(3, paymentsDto.getPromoCodeId());
            }else{
                preparedStatement.setNull(3, Types.INTEGER);
            }
            preparedStatement.setBigDecimal(4, paymentsDto.getTotalNoDiscount());
            preparedStatement.setBigDecimal(5, paymentsDto.getTotalFinal());
            preparedStatement.setTimestamp(6, Timestamp.valueOf(paymentsDto.getDate()));

            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                return this.getById(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Payments update(UpdatePaymentsDto paymentsDto) {
        StringBuilder query = new StringBuilder("UPDATE PAYMENTS SET ");
        List<Object> parameters = new ArrayList<>();

        if (paymentsDto.getType() != null) {
            query.append("type = ?, ");
            parameters.add(paymentsDto.getType().toString());
        }
        if (paymentsDto.getPromoCodeId() > 0) {
            query.append("promocodeid = ?, ");
            parameters.add(paymentsDto.getPromoCodeId());
        }
        if (paymentsDto.getTotalNoDiscount() != null) {
            query.append("totalnodiscount = ?, ");
            parameters.add(paymentsDto.getTotalNoDiscount());
        }
        if (paymentsDto.getTotalFinal() != null) {
            query.append("totalfinal = ?, ");
            parameters.add(paymentsDto.getTotalFinal());
        }
        if (paymentsDto.getDate() != null) {
            query.append("date = ?, ");
            parameters.add(Timestamp.valueOf(paymentsDto.getDate()));
        }

        if (parameters.isEmpty()) {
            return getById(paymentsDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE id = ?");
        parameters.add(paymentsDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parameters.size(); i++) {
                preparedStatement.setObject(i + 1, parameters.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(paymentsDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Error updating payment", e);
        }
    }

    public List<Payments> getByClientId(int clientId) throws SQLException{
       List <Payments> payments = new ArrayList<>();
       String query = "SELECT p.* FROM Payments p " +
               "JOIN Reservations r ON p.idReservation = r.id " +
               "WHERE r.idClient = ?";

       PreparedStatement ptsm = this.connection.prepareStatement(query);
       ptsm.setInt(1,clientId);
       ResultSet rs = ptsm.executeQuery();

       while (rs.next()){
           Payments payment = fromResultSet(rs);
           payments.add(payment);
       }
       return payments;
    }
}