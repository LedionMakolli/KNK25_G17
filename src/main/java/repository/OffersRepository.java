package repository;

import models.Dto.CreateOffersDto;
import models.Dto.UpdateOffersDto;
import models.Offers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OffersRepository extends BaseRepository<Offers, CreateOffersDto, UpdateOffersDto> {
    public OffersRepository() throws SQLException {
        super("offers");
    }

    @Override
    public Offers fromResultSet(ResultSet rs) {
        try {
            return Offers.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Offers create(CreateOffersDto offersDto) {
        String query = """
                INSERT INTO offers (idCar, discount, startDate, endDate)
                VALUES (?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, offersDto.getCarId());
            pstm.setDouble(2, offersDto.getDiscount());
            pstm.setDate(3, offersDto.getStartDate());
            pstm.setDate(4, offersDto.getEndDate());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Offers update(UpdateOffersDto offersDto) {
        StringBuilder query = new StringBuilder("UPDATE offers SET ");
        List<Object> params = new ArrayList<>();

        if (offersDto.getCarId() != null) {
            query.append("idCar = ?, ");
            params.add(offersDto.getCarId());
        }
        if (offersDto.getDiscount() != null) {
            query.append("discount = ?, ");
            params.add(offersDto.getDiscount());
        }
        if (offersDto.getStartDate() != null) {
            query.append("startDate = ?, ");
            params.add(offersDto.getStartDate());
        }
        if (offersDto.getEndDate() != null) {
            query.append("endDate = ?, ");
            params.add(offersDto.getEndDate());
        }


        if (params.isEmpty()) {
            return getById(offersDto.getId());
        }


        query.setLength(query.length() - 2);

        query.append(" WHERE id = ?");
        params.add(offersDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }
            pstm.executeUpdate();
            return getById(offersDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
