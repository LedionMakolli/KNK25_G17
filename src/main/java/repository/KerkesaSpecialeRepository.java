package repository;

import models.Dto.CreateKerkesatSpecialeDto;
import models.Dto.CreatePenalizimetDto;
import models.Dto.UpdateKerkesatSpecialeDto;
import models.KerkesaSpeciale;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KerkesaSpecialeRepository extends BaseRepository<KerkesaSpeciale, CreateKerkesatSpecialeDto, UpdateKerkesatSpecialeDto> {
    public KerkesaSpecialeRepository() throws SQLException{
        super("kerkesaspeciale");
    }
    @Override
    public KerkesaSpeciale fromResultSet(ResultSet rs){
        try{
            return KerkesaSpeciale.getInstance(rs);
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public KerkesaSpeciale create(CreateKerkesatSpecialeDto kerkesatSpecialeDto){
        String query= """
                INSERT INTO KERKESASPECIALE (idRezervimet, kerkese, plotesuar) VALUES (?,?,?)""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, kerkesatSpecialeDto.getIdRezervimet());
            preparedStatement.setString(2, kerkesatSpecialeDto.getKerkese());
            preparedStatement.setBoolean(3, kerkesatSpecialeDto.isPlotesuar());
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                return this.getById(id);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } return null;

    }
    
}
