package repository;

import models.Dto.UpdateClientDto;
import models.Clients;
import models.Dto.CreateClientDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository extends BaseRepository<Clients, CreateClientDto, UpdateClientDto> {

    public ClientRepository() throws SQLException {
        super("clients");
    }

    @Override
    public Clients fromResultSet(ResultSet rs) {
        try {
            return Clients.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Clients create(CreateClientDto klientetDto) {
        String query = """
                INSERT INTO KLIENTET (FIRSTNAME, LASTNAME, AGE, PERSONALNUMBER, EMAIL, USERNAME, PASSWORD, TELEPHONENUMBER)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, klientetDto.getFirstName());
            pstm.setString(2, klientetDto.getLastName());
            pstm.setInt(3, klientetDto.getAge());
            pstm.setString(5, klientetDto.getPersonalNumber());
            pstm.setString(5, klientetDto.getEmail());
            pstm.setString(6, klientetDto.getUsername());
            pstm.setString(7, klientetDto.getPassword());
            pstm.setString(8, klientetDto.getTelephoneNumber());
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

    public Clients update(UpdateClientDto klientetDto) {
        StringBuilder query = new StringBuilder("UPDATE CLIENTS SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;

        if (klientetDto.getTelephoneNumber() != null) {
            query.append("TELEPHONENUMBER = ?, ");
            parametrat.add(klientetDto.getTelephoneNumber());
            hasUpdates = true;
        }
        if (klientetDto.getEmail() != null) {
            query.append("EMAIL = ?, ");
            parametrat.add(klientetDto.getEmail());
            hasUpdates = true;
        }
        if (klientetDto.getPassword() != null) {
            query.append("PASSWORD = ?, ");
            parametrat.add(klientetDto.getPassword());
            hasUpdates = true;
        }
        if (!hasUpdates) {
            return getById(klientetDto.getId());
        }
        query.setLength(query.length() - 2);
        query.append(" WHERE ID = ?");
        parametrat.add(klientetDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                preparedStatement.setObject(i + 1, parametrat.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(klientetDto.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error during client update!", e);
        }
    }

}
