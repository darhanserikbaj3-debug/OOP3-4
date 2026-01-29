package kz.aitu.Universityms.databasecon;

import java.sql.*;

public class dbcon {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "darkhanserikbay";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void closeResources(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    System.err.println("Error closing resource: " + e.getMessage());
                }
            }
        }
    }
}