package database;

import java.sql.*;

public class DbManager {

    private static Connection dbConnection = null;
    private static final String dbName = "auteline";

    /**
     * This method starts embedded Derby engine and creates a connection. Consequent calls to this
     * function will not create new connection; instead the existing will be returned.
     *
     * @return a connection to the database; null if failed
     */
    public static Connection connect() {
        if (dbConnection != null) {
            return dbConnection;
        }
        try {
            // start Embedded Derby engine
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            // create a connection
            dbConnection = DriverManager.getConnection("jdbc:mysql://172.105.99.6:3306/" + dbName, "root", "rootpassword");


        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.exit(1);
        } finally {
            return dbConnection;
        }
    }

    /**
     * This method returns the connection we created earlier
     *
     * @return the stored database connection
     */
    public static Connection getConnection() {
        if (dbConnection == null) {
            // either return null or try connect again
            return null;
        }
        return dbConnection;
    }

    /**
     * This method close the connection. This should be called only when we know the connection is
     * no longed needed.
     */
    public static void close() {
        if (dbConnection != null) {
            try {
                dbConnection.close();
                dbConnection = null;
            } catch (SQLException ex) {
                // exception handle here
            }
        }
    }

}
