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
    public Clients getByUsername(String username) {
        String query = "SELECT * FROM CLIENTS WHERE USERNAME = ?";
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query);
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // login metoda
    public Clients findByUsernameAndPassword(String username,String password){
        String query = "SELECT * FROM CLIENTS WHERE USERNAME = ? and PASSWORD = ?";
        return findByCredentials(query,username,password,this::fromResultSet);
    }


    public Clients create(CreateClientDto clientDto) {
        String query = """
        INSERT INTO CLIENTS (FIRSTNAME, LASTNAME, AGE, PERSONALNUMBER, EMAIL, USERNAME, PASSWORD, TELEPHONENUMBER)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;
        try {
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, clientDto.getFirstName());
            pstm.setString(2, clientDto.getLastName());
            pstm.setInt(3, clientDto.getAge());
            pstm.setString(4, clientDto.getPersonalNumber());
            pstm.setString(5, clientDto.getEmail());
            pstm.setString(6, clientDto.getUsername());
            pstm.setString(7, clientDto.getPassword());
            pstm.setString(8, clientDto.getTelephoneNumber());

            pstm.execute();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
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

        if (klientetDto.getAge() > 0) {
            query.append("AGE = ?, ");
            parametrat.add(klientetDto.getAge());
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
        if (klientetDto.getTelephoneNumber() != null) {
            query.append("TELEPHONENUMBER = ?, ");
            parametrat.add(klientetDto.getTelephoneNumber());
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
