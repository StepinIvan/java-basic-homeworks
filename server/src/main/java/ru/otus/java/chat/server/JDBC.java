package ru.otus.java.chat.server;
import java.sql.*;
public class JDBC {
    private static Connection connection;
    private static Statement statement;
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:Users.db");
        statement = connection.createStatement();
    }
}
