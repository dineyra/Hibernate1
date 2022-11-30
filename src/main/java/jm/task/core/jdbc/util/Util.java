package jm.task.core.jdbc.util;


import jm.task.core.jdbc.MySQLConnector;

import java.sql.Connection;

public class Util {
    // реализуйте настройку соеденения с БД

    private static String url = "jdbc:mysql://127.0.0.1";
    private static String port = "3306";
    private static String user = "root";
    private static String dbName = "mydb";
    private static String password = "root";

    public static Connection getConnection() {
        try {
            MySQLConnector mySqlConnector = new MySQLConnector(url, port, dbName, user, password);
            return mySqlConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String args[]) {

        System.out.println(getConnection());
    }


}
