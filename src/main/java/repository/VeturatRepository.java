package repository;

import models.*;
import models.Dto.*;
import models.enums.KarburantiEnum;
import models.enums.StatusiVeturaEnum;
import java.sql.*;
import java.util.*;

public class VeturatRepository extends BaseRepository<Veturat, CreateVeturatDto, UpdateVeturatDto> {

    public VeturatRepository() throws SQLException {
        super("veturat");
    }
    @Override
    public Veturat fromResultSet(ResultSet rs) {
        try {
            return Veturat.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 3. metoda create
    public Veturat create(CreateVeturatDto veturatDto) {
        String query= """
                INSERT INTO VETURAT (TARGAT, MODELI, NGJYRA, VITIPRODHIMIT,
                KILOMETRAZHA, NUMRIULESEVE, KARBURANTI, CMIMIDITOR, STATUSI)
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
            query.append("cmimiditor = ?, ");
            parametrat.add(VeturatDto.getCmimiDitor());
            hasUpdates=true;
        }
        if (VeturatDto.getStatusi() != null) {
            query.append("statusi = ?, ");
            parametrat.add(VeturatDto.getStatusi().name());
            hasUpdates=true;
        }
        if (!hasUpdates) {
            return getById(VeturatDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id=?");
        parametrat.add(VeturatDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                preparedStatement.setObject(i+1, parametrat.get(i), Types.OTHER);
            }
            preparedStatement.executeUpdate();
            return getById(VeturatDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit!", e);
        }
    }
    // 6. metoda filtro
    public ArrayList<Veturat> filter(String modeli, String ngjyra, int vitiProdhimit, int numriUleseve,
                                     KarburantiEnum karburanti, int cmimiDitor, StatusiVeturaEnum statusi) {
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
        if(vitiProdhimit>0) {
            query.append(" and vitiprodhimit=?");
            parametrat.add(vitiProdhimit);
        } else if(vitiProdhimit<0) {
            throw new IllegalArgumentException("Viti i prodhimit eshte jo valid");
        }
        if(numriUleseve>0) {
            query.append(" and numriuleseve=?");
            parametrat.add(numriUleseve);
        } else if(numriUleseve<0){
            throw new IllegalArgumentException("Numri i uleseve eshte jo valid");
        }
        if (karburanti != null) {
            query.append(" and karburanti::text = ?");
            parametrat.add(karburanti.name());
        }

        if(cmimiDitor>0) {
            query.append(" and cmimiditor=?");
            parametrat.add(cmimiDitor);
        } else if(cmimiDitor<0) {
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
