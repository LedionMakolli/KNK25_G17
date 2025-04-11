package repository;

import models.Dto.CreatePagesatDto;
import models.Dto.CreateVeturatDto;
import models.Dto.UpdatePagesatDto;
import models.Dto.UpdateVeturatDto;
import models.Pagesat;
import models.Veturat;
import models.enums.KarburantiEnum;
import models.enums.StatusiVeturaEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagesatRepository extends BaseRepository<Pagesat, CreatePagesatDto, UpdatePagesatDto> {
    public PagesatRepository() throws SQLException {
        super("pagesat");
    }
    @Override
    public Pagesat fromResultSet(ResultSet rs) {
        try {
            return Pagesat.getInstance(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // 3. metoda create
    public Pagesat create(CreatePagesatDto pagesatDto) {
        String query= """
                INSERT INTO PAGESAT (ID, IDREZERVIMI, LLOJI,PROMOCODEID,
                TOTALIPAZBRITJE, TOTALIFINAL, DATA)
                VALUES (?, ?, ?, ?, ?, ?, ?,)
                """;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, pagesatDto.getId());
            preparedStatement.setInt(2, pagesatDto.getIdRezervimi());
            preparedStatement.setObject(3, pagesatDto.getLloji(),Types.OTHER);
            preparedStatement.setInt(4, pagesatDto.getPromoCodeId());
            preparedStatement.setBigDecimal(5, pagesatDto.getTotaliPaZbritje());
            preparedStatement.setBigDecimal(6, pagesatDto.getTotaliFinal());
            preparedStatement.setTimestamp(7, java.sql.Timestamp.valueOf(pagesatDto.getData()));

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
    public Pagesat update(UpdatePagesatDto PagesatDto) {
        StringBuilder query = new StringBuilder("UPDATE PAGESAT SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdates=false;

        if (PagesatDto.getLloji() != null) {
            query.append("lloji = ?, ");
            parametrat.add(PagesatDto.getLloji());
            hasUpdates=true;
        }
        if (PagesatDto.getPromoCodeId() != null) {
            query.append("promocodeid = ?, ");
            parametrat.add(PagesatDto.getPromoCodeId());
            hasUpdates=true;
        }
        if (PagesatDto.getTotaliPaZbritje() !=null) {
            query.append("totalipazbritje = ?, ");
            parametrat.add(PagesatDto.getTotaliPaZbritje());
            hasUpdates=true;
        }
        if (PagesatDto.getTotaliFinal() != null) {
            query.append("totalifinal = ?, ");
            parametrat.add(PagesatDto.getTotaliFinal());
            hasUpdates=true;
        }
        if (PagesatDto.getData() != null) {
            query.append("data = ?, ");
            parametrat.add(PagesatDto.getData());
            hasUpdates=true;
        }
        if (!hasUpdates) {
            return getById(PagesatDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id=?");
        parametrat.add(PagesatDto.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            for(int i=0; i<parametrat.size(); i++) {
                preparedStatement.setObject(i+1, parametrat.get(i), Types.OTHER);
            }
            preparedStatement.executeUpdate();
            return getById(PagesatDto.getId());
        } catch (SQLException e) {
            throw new RuntimeException("Gabim gjate perditesimit!", e);
        }
    }

}
