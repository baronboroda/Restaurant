package com.zelenin.restaurant.conn;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MySQLConnUtils {

    public static Connection getMySQLConnection()
            throws ClassNotFoundException, SQLException{

        String hostName = "localhost";
        String dbName = "restaurant";
        String userName = "root";
        String password = "root";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException{

        // Creates a BasicDataSource
        BasicDataSource ds = new BasicDataSource();

        // Define Driver Class
        ds.setDriverClassName("com.mysql.jdbc.Driver");

        // Define Server URL
        ds.setUrl("jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false");

        // Define Username
        ds.setUsername(userName);

        // Define Your Password
        ds.setPassword(password);

        // onnection (session) with a specific database. SQL statements are
        // executed and results are returned within the context of a connection.
        return ds.getConnection();
    }

}
