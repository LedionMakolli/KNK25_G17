package repository;

import models.Dto.*;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RezervimetRepository extends BaseRepository<Rezervimet, CreateRezervimetDto, UpdateRezervimetDto> {
    private Connection connection;

    public RezervimetRepository() throws SQLException {
        super("Rezervimet");
    }

    public Rezervimet fromResultSet(ResultSet rs) {
        try {
            return Rezervimet.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


//3. Metoda create

    public Rezervimet create(CreateRezervimetDto rezervimetDto) {
        String query = """
            
                INSERT INTO Rezervimet (idKlienti, idVetura, dataFillimit, dataMbarimit, statusiRezervimet)
            VALUES (?,?,?,
         ?,?)""";
    try{
        PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, rezervimetDto.getIdKlienti());
        pstm.setInt(2, rezervimetDto.getIdVetura());
        pstm.setDate(3, rezervimetDto.getDataFillimit());
        pstm.setDate(4, rezervimetDto.getDataMbarimit());
        pstm.setObject(5, rezervimetDto.getStatusiRezervimet(), Types.OTHER);
        pstm.execute();
                ResultSet rs = pstm.getGeneratedKeys();
        if(rs.next()){
            int id = rs.getInt(1);
        return this.getById(id);
        }
    }catch(SQLException e){
      e.printStackTrace();
    }
    return null;
 }
 //4. Metoda update
    public Rezervimet update(UpdateRezervimetDto rezervimetDto, String modeli_vetures) {
        StringBuilder query = new StringBuilder("UPDATE REZERVIMET SET");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates = false;


        if (rezervimetDto.getIdVetura() > 0) {
            query.append("idVetura=?, ");
            parametrat.add(rezervimetDto.getIdVetura());
            hasUpdates = true;
        }

        if (rezervimetDto.getDataFillimit() != null) {
            query.append("dataFillimit=?, ");
            parametrat.add(rezervimetDto.getDataFillimit());
            hasUpdates = true;
        }

        if (rezervimetDto.getDataMbarimit() != null) {
            query.append("dataMbarimit=?, ");
            parametrat.add(rezervimetDto.getDataMbarimit());
            hasUpdates = true;
        }

        if (rezervimetDto.getStatusiRezervimet() != null) {
            query.append("statusiRezervimet=?,");
            parametrat.add(rezervimetDto.getStatusiRezervimet());
            hasUpdates = true;

            try {
                PreparedStatement pstm = this.connection.prepareStatement(query.toString());
                for (int i = 0; i < parametrat.size(); i++) {
                    if (parametrat.get(i) instanceof String && i == parametrat.size() - 1) {
                        pstm.setObject(i + 1, parametrat.get(i));
                    } else {
                        pstm.setObject(i + 1, parametrat.get(i));
                    }
                }
                pstm.execute();
                return getById(rezervimetDto.getIdRezervimet());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        if (!hasUpdates) {
            return getById(rezervimetDto.getIdRezervimet());
        }
        query.setLength(query.length() - 2);
        query.append("WHERE idRezervimet=?");
        parametrat.add(rezervimetDto.getIdRezervimet());

        try {
            PreparedStatement pstm = connection.prepareStatement(query.toString());
            for (int i = 0; i < parametrat.size(); i++) {
                pstm.setObject(i + 1, parametrat.get(i));
            }
            pstm.executeUpdate();
            return getById(rezervimetDto.getIdRezervimet());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit", e);
        }

    }}










