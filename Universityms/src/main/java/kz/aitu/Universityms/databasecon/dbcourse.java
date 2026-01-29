package kz.aitu.Universityms.databasecon;

import java.sql.*;

public class dbcourse {

    public static String getCourseByCredits(Integer searchCredits) {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM course WHERE credits = ?";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, searchCredits);
            rs = stmt.executeQuery();
            while (rs.next()) {
                result.append("Course Name: ").append(rs.getString("course_name")).append("\n")
                        .append("Course Code: ").append(rs.getString("course_code")).append("\n")
                        .append("Credits: ").append(rs.getInt("credits")).append("\n")
                        .append("-------------------------\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(rs, stmt, con); }

        return result.length() > 0 ? result.toString() : "No courses found with " + searchCredits + " credits.";
    }

    public static void addCourse(String courseName, String courseCode, Integer credits) {
        String sql = "INSERT INTO course (course_name, course_code, credits) VALUES (?, ?, ?)";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, courseName);
            stmt.setString(2, courseCode);
            stmt.setInt(3, credits);
            stmt.executeUpdate();
            System.out.println("Course added: " + courseName);
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }

    public static String getCourseInfo() {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM course";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            con = dbcon.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                result.append("Course name: ").append(rs.getString("course_name")).append("\n")
                        .append("Course code: ").append(rs.getString("course_code")).append("\n")
                        .append("Credits: ").append(rs.getInt("credits")).append("\n")
                        .append("-------------------------\n");
            }
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(rs, stmt, con); }
        return result.toString();
    }

    public static void updateCourseCredits(String courseName, Integer newCredit) {
        String sql = "UPDATE course SET credits = ? WHERE course_name = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, newCredit);
            stmt.setString(2, courseName);
            if (stmt.executeUpdate() > 0) System.out.println("Credits for " + courseName + " updated.");
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }

    public static void dropCourse(String courseName) {
        String sql = "DELETE FROM course WHERE course_name = ?";
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = dbcon.getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, courseName);
            if (stmt.executeUpdate() > 0) System.out.println("Course " + courseName + " deleted.");
        } catch (SQLException e) { e.printStackTrace(); }
        finally { dbcon.closeResources(stmt, con); }
    }
}