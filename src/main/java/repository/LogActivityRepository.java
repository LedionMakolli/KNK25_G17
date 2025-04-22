//package repository;
//
//import models.Dto.CreateLogActivityDto;
//
//import models.Dto.UpdateLogActivityDto;
//
//import models.LogActivity;
//
//import java.sql.*;
//
//public class LogActivityRepository extends BaseRepository<LogActivity, CreateLogActivityDto, UpdateLogActivityDto> {
//    public LogActivityRepository() throws SQLException{
//        super ("logactivity");
//    }
//
//    @Override
//    public LogActivity fromResultSet(ResultSet rs){
//        try{
//            return LogActivity.getInstance(rs);
//        }catch (SQLException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // metoda create
//
//    public LogActivity create(CreateLogActivityDto LogActivityDto){
//        String query = "INSERT INTO LogActivity (idUser,action,ipAddress, date) VALUES (?, ?, ?, ?)";
//
//        try{
//            PreparedStatement pstm = this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
//            pstm.setInt(1,LogActivityDto.getIdUser());
//            pstm.setObject(2,LogActivityDto.getAction(), Types.OTHER);
////            pstm.setString(3,LogActivityDto.getIpAddress());
//            pstm.setTimestamp(4, java.sql.Timestamp.valueOf(LogActivityDto.getDate()));
//            pstm.execute();
//            ResultSet resultSet = pstm.getGeneratedKeys();
//            if (resultSet.next()){
//                int id = resultSet.getInt(1);
//                return this.getById(id);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // metoda update
//
//
//
////        public LogActivity update(UpdateLogActivityDto LogActivityDto) {
////            StringBuilder query = new StringBuilder("UPDATE LOGACTIVITY SET ");
////            boolean hasUpdate = false;
////
////            if (LogActivityDto.getIdUser() != null) {
////                query.append("idUser = ?, ");
////                hasUpdate = true;
////            }
////            if (LogActivityDto.getAction() != null) {
////                query.append("action = ?, ");
////                hasUpdate = true;
////            }
////            if (LogActivityDto.getDate() != null) {
////                query.append("date = ?, ");
////                hasUpdate = true;
////            }
////            if (LogActivityDto.getIpAddress() != null) {
////                query.append("ipAddress = ?, ");
////                hasUpdate = true;
////            }
////
////            if (!hasUpdate) {
////                return getById(LogActivityDto.getId());
////            }
////
////
////            query.setLength(query.length() - 2);
////            query.append(" WHERE id = ?");
////
////            try {
////                PreparedStatement pstmt = this.connection.prepareStatement(query.toString());
////                int index = 1;
////
////                if (LogActivityDto.getIdUser() != null) {
////                    pstmt.setInt(index++, LogActivityDto.getIdUser());
////                }
////                if (LogActivityDto.getAction() != null) {
////                    pstmt.setString(index++, LogActivityDto.getAction().name());
////                }
////                if (LogActivityDto.getDate() != null) {
////                    pstmt.setTimestamp(index++, Timestamp.valueOf(LogActivityDto.getDate()));
////                }
////                if (LogActivityDto.getIpAddress() != null) {
////                    pstmt.setString(index++, LogActivityDto.getIpAddress());
////                }
////
////                pstmt.setInt(index, LogActivityDto.getId());
////                pstmt.executeUpdate();
////                return getById(LogActivityDto.getId());
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////            return null;
////        }
//
//
//}
