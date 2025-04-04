package repository;

import database.DBConnection;
import models.*;
import models.Dto.*;
import models.enums.Karburanti;
import models.enums.StatusiVetura;
import java.sql.*;
import java.util.*;

public class VeturatRepository extends BaseRepository<Veturat, CreateVeturatDto, UpdateVeturatDto>{
    private Connection connection;

    public VeturatRepository() throws SQLException {
        super("veturat");
    }
    @Override
    Veturat fromResultSet(ResultSet rs) {
        try {
            return Veturat.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
//    // 1. metoda getAll
//    public ArrayList<Veturat> getAll() {
//        ArrayList<Veturat> veturat=new ArrayList<>();
//        String query="SELECT * FROM VETURAT";
//        try {
//            Statement statement=this.connection.createStatement();
//            ResultSet resultSet= statement.executeQuery(query);
//            while(resultSet.next()) {
//                veturat.add(Veturat.getInstance(resultSet));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return veturat;
//    }
//    // 2. metoda getById
//    public Veturat getById(int idVetura) {
//        String query="SELECT * FROM VETURAT WHERE idVetura=?";
//        try {
//            PreparedStatement preparedStatement=connection.prepareStatement(query);
//            preparedStatement.setInt(1, idVetura);
//            ResultSet resultSet=preparedStatement.executeQuery();
//            if(resultSet.next()) {
//                return Veturat.getInstance(resultSet);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    // 3. metoda create
    public Veturat create(CreateVeturatDto veturatDto) {
        String query= """
                INSERT INTO VETURAT (TARGAT, MODELI, NGJYRA, VITI_PRODHIMIT,
                KILOMETRAZHA, NUMRI_ULESEVE, KARBURANTI, CMIMI_DITOR, STATUSI)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, veturatDto.getTargat());
            preparedStatement.setString(2, veturatDto.getModeli());
            preparedStatement.setString(3, veturatDto.getNgjyra());
            preparedStatement.setInt(4, veturatDto.getVitiProdhimit());
            preparedStatement.setBigDecimal(5, veturatDto.getKilometrazha());
            preparedStatement.setInt(6, veturatDto.getNumriUleseve());
            preparedStatement.setObject(7, veturatDto.getKarburanti(), Types.OTHER);
            preparedStatement.setInt(8, veturatDto.getCmimiDitor());
            preparedStatement.setObject(9, veturatDto.getStatusi().name(), Types.OTHER);
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
    public Veturat update(UpdateVeturatDto VeturatDto) {
        StringBuilder query = new StringBuilder("UPDATE VETURAT SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates=false;

        if (VeturatDto.getNgjyra() != null) {
            query.append("ngjyra = ?, ");
            parametrat.add(VeturatDto.getNgjyra());
            hasUpdates=true;
        }
        if (VeturatDto.getKilometrazha() != null) {
            query.append("kilometrazha = ?, ");
            parametrat.add(VeturatDto.getKilometrazha());
            hasUpdates=true;
        }
        if (VeturatDto.getCmimiDitor() > 0) {
            query.append("cmimi_ditor = ?, ");
            parametrat.add(VeturatDto.getCmimiDitor());
            hasUpdates=true;
        }
        if (VeturatDto.getStatusi() != null) {
            query.append("statusi = ?, ");
            parametrat.add(VeturatDto.getStatusi());
            hasUpdates=true;
        }
        if (!hasUpdates) {
            return getById(VeturatDto.getIdVetura());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE ID_VETURA=?");
        parametrat.add(VeturatDto.getIdVetura());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                preparedStatement.setObject(i+1, parametrat.get(i));
            }
            preparedStatement.executeUpdate();
            return getById(VeturatDto.getIdVetura());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit!", e);
        }
    }
//    // 5. metoda delete
//    public boolean delete(int id_vetura) {
//        String query="DELETE FROM VETURAT WHERE id_vetura=?";
//        try {
//            PreparedStatement preparedStatement=connection.prepareStatement(query);
//            preparedStatement.setInt(1, id_vetura);
//            return preparedStatement.executeUpdate()==1;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    // 6. metoda filtro
    public ArrayList<Veturat> filter(String modeli, String ngjyra, int viti_prodhimit, int numri_uleseve,
                                     Karburanti karburanti, int cmimi_ditor, StatusiVetura statusi) {
        ArrayList<Veturat> veturat=new ArrayList<Veturat>();
        StringBuilder query=new StringBuilder("SELECT * FROM VETURAT WHERE 1=1");
        List<Object> parametrat=new ArrayList<>();

        if(modeli!=null) {
            query.append(" and modeli= ?");
            parametrat.add(modeli);
        }
        if(ngjyra!=null) {
            query.append(" and ngjyra= ?");
            parametrat.add(ngjyra);
        }
        if(viti_prodhimit>0) {
            query.append(" and viti_prodhimit=?");
            parametrat.add(viti_prodhimit);
        } else if(viti_prodhimit<0) {
            throw new IllegalArgumentException("Viti i prodhimit eshte jo valid");
        }
        if(numri_uleseve>0) {
            query.append(" and numri_uleseve=?");
            parametrat.add(numri_uleseve);
        } else if(numri_uleseve<0){
            throw new IllegalArgumentException("Numri i uleseve eshte jo valid");
        }
        if (karburanti != null) {
            query.append(" and karburanti::text = ?");
            parametrat.add(karburanti.name());
        }

        if(cmimi_ditor>0) {
            query.append(" and cmimi_ditor=?");
            parametrat.add(cmimi_ditor);
        } else if(cmimi_ditor<0) {
            throw new IllegalArgumentException("Cmimi ditor eshte jo valid");
        }
        if(statusi!=null) {
            query.append(" and statusi::text = ?");
            parametrat.add(statusi.name());
        }
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                preparedStatement.setObject(i+1, parametrat.get(i));
            }
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()) {
                veturat.add(Veturat.getInstance(resultSet));
            } else {
                System.out.println("Nuk u gjeten te dhenat ne baze te filtrimit tuaj.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veturat;
    }
}
