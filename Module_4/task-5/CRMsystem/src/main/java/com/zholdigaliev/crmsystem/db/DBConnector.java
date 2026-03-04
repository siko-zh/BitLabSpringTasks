package com.zholdigaliev.crmsystem.db;

import com.zholdigaliev.crmsystem.entity.ApplicationRequest;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;
    private static String login = "postgres";
    private static String password = "6977";
    private static String url = "jdbc:postgresql://localhost:5433/CRMsystem?currentSchema=CRM";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ApplicationRequest> getAllRequests() {
        ArrayList<ApplicationRequest> requests = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM requests.applicationrequest");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                ApplicationRequest request = new ApplicationRequest();
                request.setId(resultSet.getLong("id"));
                request.setUserName(resultSet.getString("username"));
                request.setCourseName(resultSet.getString("coursename"));
                request.setCommentary(resultSet.getString("commentary"));
                request.setPhone(resultSet.getString("phone"));
                request.setHandled(resultSet.getBoolean("handled"));

                requests.add(request);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static void addRequest(ApplicationRequest request) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO requests.applicationrequest " +
                    "(username, coursename, commentary, phone, handled) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, request.getUserName());
            statement.setString(2, request.getCourseName());
            statement.setString(3, request.getCommentary());
            statement.setString(4, request.getPhone());
            statement.setBoolean(5, request.getHandled());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ApplicationRequest getRequestById(int id) {
        ApplicationRequest applicationRequest = new ApplicationRequest();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM requests.applicationrequest WHERE id = ?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                applicationRequest.setId(resultSet.getLong("id"));
                applicationRequest.setUserName(resultSet.getString("username"));
                applicationRequest.setCourseName(resultSet.getString("coursename"));
                applicationRequest.setCommentary(resultSet.getString("commentary"));
                applicationRequest.setPhone(resultSet.getString("phone"));
                applicationRequest.setHandled(resultSet.getBoolean("handled"));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return applicationRequest;
    }

    public static void updateRequest(int id, Boolean handled) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE requests.applicationrequest SET handled = ? WHERE id = ?");
            statement.setBoolean(1, handled);
            statement.setInt(2, id);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteRequest(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM requests.applicationrequest WHERE id = ?");
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<ApplicationRequest> getNewRequests() {
        ArrayList<ApplicationRequest> requests = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM requests.applicationrequest WHERE handled = false");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                ApplicationRequest request = new ApplicationRequest();
                request.setId(resultSet.getLong("id"));
                request.setUserName(resultSet.getString("username"));
                request.setCourseName(resultSet.getString("coursename"));
                request.setCommentary(resultSet.getString("commentary"));
                request.setPhone(resultSet.getString("phone"));
                request.setHandled(resultSet.getBoolean("handled"));

                requests.add(request);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static ArrayList<ApplicationRequest> getProcessedRequests() {
        ArrayList<ApplicationRequest> requests = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM requests.applicationrequest WHERE handled = true");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                ApplicationRequest request = new ApplicationRequest();
                request.setId(resultSet.getLong("id"));
                request.setUserName(resultSet.getString("username"));
                request.setCourseName(resultSet.getString("coursename"));
                request.setCommentary(resultSet.getString("commentary"));
                request.setPhone(resultSet.getString("phone"));
                request.setHandled(resultSet.getBoolean("handled"));

                requests.add(request);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requests;
    }
}
