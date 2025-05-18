package repository;

import models.Clients;
import models.Staff;
import models.Dto.CreateStafDto;
import models.Dto.UpdateStafDto;
import services.PasswordHasher;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffRepository extends BaseRepository<Staff, CreateStafDto, UpdateStafDto> {

    public StaffRepository() throws SQLException {
        super("staff");
    }

    @Override
    public Staff fromResultSet(ResultSet rs) {
        try {
            return Staff.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metoda Create
    public Staff create(CreateStafDto stafiDto) {
        String query = """
                INSERT INTO STAFF (FIRSTNAME, LASTNAME, AGE, PERSONALNUMBER, EMAIL, USERNAME, PASSWORD, SALT, TELEPHONENUMBER, POSITION, EMPLOYMENTDATE, SALARY)
                VALUES (?,?,?,?,?,?,?,?,?,?,?,?);
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, stafiDto.getFirstName());
            pstm.setString(2, stafiDto.getLastName());
            pstm.setInt(3, stafiDto.getAge());
            pstm.setString(4, stafiDto.getPersonalNumber());
            pstm.setString(5, stafiDto.getEmail());
            pstm.setString(6, stafiDto.getUsername());
            pstm.setString(7, PasswordHasher.generateSaltedHash(stafiDto.getPassword(),stafiDto.getSalt()));
            pstm.setString(8,stafiDto.getSalt());
            pstm.setString(9, stafiDto.getTelephoneNumber());
            pstm.setObject(10, stafiDto.getPosition(), Types.OTHER);
            pstm.setDate(11, java.sql.Date.valueOf(stafiDto.getEmploymentDate()));
            pstm.setDouble(12, stafiDto.getSalary());
            pstm.execute();
            ResultSet result = pstm.getGeneratedKeys();
            if (result.next()) {
                int id = result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        // login metoda

        public Staff findByUsernameAndPassword(String username, String password) {
            String query = "SELECT * FROM STAFF WHERE USERNAME = ?";
            try {
                PreparedStatement ptsm = this.connection.prepareStatement(query);
                ptsm.setString(1, username);
                ResultSet rs = ptsm.executeQuery();

                if (rs.next()) {
                    String salt = rs.getString("SALT");
                    String storedHash = rs.getString("PASSWORD");

                    if (PasswordHasher.compareSaltedHash(password, salt, storedHash)) {
                        return fromResultSet(rs);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }



    public Staff update(UpdateStafDto stafiDto) {
        StringBuilder query = new StringBuilder("UPDATE STAFF SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (stafiDto.getAge() > 0) {
            query.append("AGE = ?, ");
            parametrat.add(stafiDto.getAge());
            hasUpdates = true;
        }
        if (stafiDto.getEmail() != null) {
            query.append("EMAIL = ?, ");
            parametrat.add(stafiDto.getEmail());
            hasUpdates = true;
        }
        if (stafiDto.getPassword() != null) {
            query.append("PASSWORD = ?, ");
            parametrat.add(stafiDto.getPassword());
            hasUpdates = true;
        }
        if (stafiDto.getTelephoneNumber() != null) {
            query.append("TELEPHONENUMBER = ?, ");
            parametrat.add(stafiDto.getTelephoneNumber());
            hasUpdates = true;
        }
        if (stafiDto.getPosition() != null) {
            query.append("POSITION = ?::staffpositionenum, "); // CAST HERE
            parametrat.add(stafiDto.getPosition().name()); // Use enum name
            hasUpdates = true;
        }
        if (stafiDto.getSalary() > 0) {
            query.append("SALARY = ?, ");
            parametrat.add(stafiDto.getSalary());
            hasUpdates = true;
        }
        if (stafiDto.getSalt() != null) {
            query.append("SALT = ?, ");
            parametrat.add(stafiDto.getSalt());
            hasUpdates = true;
        }

        if (!hasUpdates) {
            return getById(stafiDto.getId());
        }

        query.setLength(query.length() - 2);
        query.append(" WHERE ID = ?");
        parametrat.add(stafiDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                preparedStatement.setObject(i + 1, parametrat.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(stafiDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error during staff update!", e);
        }
    }

    // kontrollo username

    public boolean existsByUsername(String username) {
        try {
            String query = "SELECT COUNT(*) FROM STAFF WHERE USERNAME = ?";
            PreparedStatement pstm = connection.prepareStatement(query);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error during existsByUsername in staff!",e);
        }
        return false;
    }

}