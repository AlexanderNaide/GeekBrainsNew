package ru.gb.TestClasses;

import java.sql.*;

public class Test1 {

    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/geodata");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

//        try {
//            statement.execute("CREATE TABLE IF NOT EXISTS Chat_Client_BD (" +
//                    "nick STRING PRIMARY KEY NOT NULL UNIQUE," +
//                    "log STRING NOT NULL UNIQUE," +
//                    "pas STRING NOT NULL)");

//            connection.setAutoCommit(false);
//            for (int i = 1; i < 6; i++) {
//                String nick = String.format("nick%d", i);
//                String log = String.format("log%d", i);
//                String pas = String.format("pass%d", i);
//                ResultSet resultSet = statement.executeQuery(String.format("SELECT EXISTS(SELECT * FROM Chat_Client_BD where nick = '%s')", nick));
//                if (resultSet.getInt(1) == 0) {
//                    statement.execute(String.format("INSERT INTO Chat_Client_BD (nick, log, pas) VALUES ('%s', '%s', '%s')", nick, log, pas));
//                }
//            }
//            connection.setAutoCommit(true);

//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void authenticate(String login, String password) {
        try {
            ResultSet resultSet = statement.executeQuery(String.format("SELECT nick FROM Chat_Client_BD WHERE log = '%s' and pas = '%s'", login, password));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String changeNick(String login, String newNick) {
        try {
            ResultSet resultNick = statement.executeQuery(String.format("SELECT EXISTS(SELECT * FROM Chat_Client_BD where nick = '%s')", newNick));
            if (resultNick.getInt(1) != 0) {
            }
            statement.execute(String.format("UPDATE Chat_Client_BD SET nick = '%s' WHERE log = '%s'", newNick, login));
            return newNick;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String createUser(String login, String password, String newNick) {
        try {
            ResultSet resultNick = statement.executeQuery(String.format("SELECT EXISTS(SELECT * FROM Chat_Client_BD where nick = '%s')", newNick));

            ResultSet resultLog = statement.executeQuery(String.format("SELECT EXISTS(SELECT * FROM Chat_Client_BD where log = '%s')", login));

            statement.execute(String.format("INSERT INTO Chat_Client_BD (nick, log, pas) VALUES ('%s', '%s', '%s')", newNick, login, password));
            return newNick;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteUser(String login, String password) {
        try {
            ResultSet resultSet = statement.executeQuery(String.format("SELECT nick FROM Chat_Client_BD WHERE log = '%s' and pas = '%s'", login, password));
            if (!resultSet.isClosed()) {
                statement.execute(String.format("DELETE FROM Chat_Client_BD WHERE log = '%s'", login));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changePassword(String login, String password, String newPassword) {
        try {
            ResultSet resultSet = statement.executeQuery(String.format("SELECT nick FROM Chat_Client_BD WHERE log = '%s' and pas = '%s'", login, password));
            if (!resultSet.isClosed()) {
                statement.execute(String.format("UPDATE Chat_Client_BD SET pas = '%s' WHERE log = '%s'", newPassword, login));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

