package kz.aitu.Universityms.databasecon;

import java.sql.*;

public class dbuni {

    public static String getUniversityByRating(Integer searchRating) {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM univer WHERE rating = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, searchRating);
            rs = stmt.executeQuery();
            while (rs.next()) {
                result.append("University Name: ").append(rs.getString("name")).append("\n")
                        .append("Location: ").append(rs.getString("location")).append("\n")
                        .append("Rating: ").append(rs.getInt("rating")).append("\n")
                        .append("-------------------------\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(rs, stmt, con); }

        return result.length() > 0 ? result.toString() : "No universities found with rating: " + searchRating;
    }

    public static void addUni(String universityName, String location, Integer rating) {
        String sql = "INSERT INTO univer (name, location, rating) VALUES (?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, universityName);
            stmt.setString(2, location);
            stmt.setInt(3, rating);
            stmt.executeUpdate();
            System.out.println("University added: " + universityName);
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }

    public static void updateUniRating(String uniName, Integer newRat) {
        String sql = "UPDATE univer SET rating = ? WHERE name = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, newRat);
            stmt.setString(2, uniName);
            if (stmt.executeUpdate() > 0) System.out.println("Rating for " + uniName + " updated.");
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }

    public static void dropUni(String universityName) {
        String sql = "DELETE FROM univer WHERE name = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, universityName);
            if (stmt.executeUpdate() > 0) System.out.println("University " + universityName + " deleted.");
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }

    public static String getUniversityInfo() {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM univer";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = dbcon.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result.append("University Name: ").append(rs.getString("name")).append("\n")
                        .append("Location: ").append(rs.getString("location")).append("\n")
                        .append("Rating: ").append(rs.getInt("rating")).append("\n")
                        .append("-------------------------\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(rs, stmt, con); }
        return result.toString();
    }
}