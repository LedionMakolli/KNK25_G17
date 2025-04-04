package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import java.sql.*;
import java.util.ArrayList;

public class KlientetRepository extends BaseRepository<Klientet, CreateKlientetDto, UpdateKlientetDto> {

    public KlientetRepository() throws SQLException {
        super("klientet");
    }

    @Override
    public Klientet fromResultSet(ResultSet rs) {
        try {
            return Klientet.getInstance(rs);
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 3. Metoda Create
    public Klientet create(CreateKlientetDto klientetDto) {
        String query= """
                INSERT INTO KLIENTET (emri, mbiemri, nrpersonal, nrtelefoni) 
                values (?, ?, ?, ?)
                """;
        try {
            PreparedStatement pstm=this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, klientetDto.getEmri());
            pstm.setString(2, klientetDto.getMbiemri());
            pstm.setString(3, klientetDto.getNrPersonal());
            pstm.setString(4, klientetDto.getNrTelefoni());
            pstm.execute();
            ResultSet result=pstm.getGeneratedKeys();
            if(result.next()) {
                int id=result.getInt(1);
                return this.getById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Metoda 4. Update
    public Klientet update(UpdateKlientetDto klientetDto) {
        String query= """
                UPDATE KLIENTET
                SET nrtelefoni=?
                WHERE id=?
                """;
        try {
            PreparedStatement pstm=this.connection.prepareStatement(query);
            pstm.setString(1, klientetDto.getNrTelefoni());
            pstm.setInt(2, klientetDto.getId());
            pstm.executeUpdate();
            System.out.println("Perditesimi u krye me sukses!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getById(klientetDto.getId());
    }

    // Metoda 5. delete Klient
    public boolean delete(int id) {
        String query="DELETE FROM KLIENTET WHERE ID=?";

        try {
            PreparedStatement pstm=this.connection.prepareStatement(query);
            pstm.setInt(1, id);
            return pstm.executeUpdate()==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}