package repository;

import database.DBConnection;
import models.Dto.UpdateUserDto;
import models.User;
import models.Dto.CreateUserDto;

import java.sql.*;

public class UserRepository extends BaseRepository<User, CreateUserDto, UpdateUserDto> {
//    public UserRepository() {
//        super("users");
//    }

//    public User fromResultSet(ResultSet rs) throws SQLException {
//        return User.getInstance(rs);
//    }

    public User fromResultSet(ResultSet rs) {
        try {
            return User.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Connection connection;

    public UserRepository() {
        super("users");
        this.connection = DBConnection.getConnection();
    }

    // metoda create
    public User create(CreateUserDto userDto) {
        String query = """
                INSERT INTO USERS (EMRI, MBIEMRI, EMAIL, PASSWORD, ROLI)
                VALUES (?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, userDto.getEmri());
            pstm.setString(2, userDto.getMbiemri());
            pstm.setString(3, userDto.getEmail());
            pstm.setString(4, userDto.getPassword());
            pstm.setString(5, userDto.getRoli());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            if(rs.next()){
                int id = rs.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // metoda update
    public User update(UpdateUserDto userDto) {
        String query = """
                UPDATE USERS
                SET EMAIL = ?
                SET PASSWORD = ?
                SET ROLI = ?
                WHERE ID = ?
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setString(1, userDto.getEmail());
            pstm.setString(2, userDto.getPassword());
            pstm.setString(3, userDto.getRoli());
            pstm.setInt(4, userDto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getById(userDto.getId());
    }
}
