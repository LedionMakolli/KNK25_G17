package services;

import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class TransactionService {
    private final DBConnection databaseConnection;

    public TransactionService(DBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }


    public void execute(Consumer<Connection> transaction) throws SQLException {
        Connection connection = null;
        try {
            connection = databaseConnection.getConnection();
            connection.setAutoCommit(false);

            transaction.accept(connection);

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true); // Reset autocommit
                connection.close();
            }
        }
    }


    public <T> T executeWithResult(Function<Connection, T> transaction) throws SQLException {
        Connection connection = null;
        try {
            connection = databaseConnection.getConnection();
            connection.setAutoCommit(false);

            T result = transaction.apply(connection);

            connection.commit();
            return result;
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            throw e;
        } finally {
            if (connection != null) {
                connection.setAutoCommit(true); // Reset autocommit
                connection.close();
            }
        }
    }
}