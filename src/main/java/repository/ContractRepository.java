package repository;

import models.Dto.*;
import models.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository extends BaseRepository<Contract, CreateContractDto, UpdateContractDto> {

    public ContractRepository() throws SQLException{
        super("contract");
    }

    @Override
    public Contract fromResultSet(ResultSet rs){
        try{
            return Contract.getInstance(rs);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // metoda create

    public Contract create(CreateContractDto ContractDto){
        String query = "INSERT INTO Contract (idReservation,sum, payment, date) VALUES (?, ?, ?,?)";

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, ContractDto.getIdReservation());
            pstm.setDouble(2, ContractDto.getSum());
            pstm.setObject(3, ContractDto.getPayment(), Types.OTHER);
            pstm.setDate(4, ContractDto.getDate());
            pstm.execute();
            ResultSet resultSet = pstm.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                return this.getById(id);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    // metoda update

    public Contract update(UpdateContractDto KontrataDto){
        StringBuilder query = new StringBuilder("UPDATE CONTRACT SET ");
        List<Object> parametrat = new ArrayList<>();
        boolean hasUpdate = false;

        if (KontrataDto.getSum() > 0){
            query.append("sum = ?, ");
            parametrat.add(KontrataDto.getSum());
            hasUpdate = true;
        }
        if (KontrataDto.getPayment() != null){
            query.append("payment = CAST(? AS PaymentEnum), ");
            parametrat.add(KontrataDto.getPayment().name());
            hasUpdate = true;
        }
        if (KontrataDto.getDate() != null){
            query.append("date = ?, ");
            parametrat.add(KontrataDto.getDate());
            hasUpdate = true;
        }

        if (!hasUpdate){
            return getById(KontrataDto.getId());
        }
        query.setLength(query.length()-2);
        query.append(" WHERE id = ?");
        parametrat.add(KontrataDto.getId());

        try{
            PreparedStatement pstm = this.connection.prepareStatement(query.toString());
            for (int i = 0; i<parametrat.size(); i++){
                if (parametrat.get(i) instanceof String && i == parametrat.size()-1){
                    pstm.setObject(i+1,parametrat.get(i), Types.OTHER);
                }else {
                    pstm.setObject(i + 1, parametrat.get(i));
                }
            }
            pstm.execute();
            return getById(KontrataDto.getId());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
