package com.zelenin.restaurant;

import java.sql.Connection;
import com.mysql.jdbc.MySQLConnection;
import com.zelenin.restaurant.beans.UserAccount;
import com.zelenin.restaurant.conn.MySQLConnUtils;
import com.zelenin.restaurant.utils.DBUtils;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            UserAccount user = DBUtils.findUser(conn, "Свирид", "best_pass");
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close Statement and Connection
            if (conn != null) {
                conn.close();
            }
        }
    }
}
