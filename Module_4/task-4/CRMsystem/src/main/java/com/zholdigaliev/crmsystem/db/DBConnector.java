package com.zholdigaliev.crmsystem.db;

import com.zholdigaliev.crmsystem.entity.ApplicationRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
