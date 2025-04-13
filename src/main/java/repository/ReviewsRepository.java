package repository;

import models.Dto.CreateReviewsDto;
import models.Dto.UpdateReviewsDto;
import models.Reviews;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewsRepository extends BaseRepository<Reviews, CreateReviewsDto, UpdateReviewsDto> {
    public ReviewsRepository() throws SQLException {
        super("reviews");
    }

    @Override
    public Reviews fromResultSet(ResultSet rs) {
        try {
            return Reviews.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Reviews create(CreateReviewsDto reviewDto) {
        String query = """
                INSERT INTO reviews (clientid, carid, rating, text, date)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, reviewDto.getClientId());
            pstm.setInt(2, reviewDto.getCarId());
            pstm.setInt(3, reviewDto.getRating());
            pstm.setString(4, reviewDto.getText());
            pstm.setTimestamp(5, reviewDto.getDate());
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

    public Reviews update(UpdateReviewsDto reviewDto) {
        StringBuilder query = new StringBuilder("UPDATE reviews SET ");
        List<Object> params = new ArrayList<>();
        boolean hasUpdates = false;

        if (reviewDto.getClientId() != null) {
            query.append("clientid = ?, ");
            params.add(reviewDto.getClientId());
            hasUpdates = true;
        }
        if (reviewDto.getCarId() != null) {
            query.append("carid = ?, ");
            params.add(reviewDto.getCarId());
            hasUpdates = true;
        }
        if (reviewDto.getRating() != null) {
            query.append("rating = ?, ");
            params.add(reviewDto.getRating());
            hasUpdates = true;
        }
        if (reviewDto.getText() != null) {
            query.append("text = ?, ");
            params.add(reviewDto.getText());
            hasUpdates = true;
        }
        if (reviewDto.getDate() != null) {
            query.append("date = ?, ");
            params.add(reviewDto.getDate());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(reviewDto.getId());
        }


        if (query.toString().endsWith(", ")) {
            query.setLength(query.length() - 2);
        }

        query.append(" WHERE id = ?");
        params.add(reviewDto.getId());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }
            pstm.executeUpdate();
            return getById(reviewDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
