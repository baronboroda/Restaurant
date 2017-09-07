package com.zelenin.restaurant.repositories;

import com.zelenin.restaurant.beans.UserAccount;

import java.sql.*;

public class UserAccountRepo {

    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

        String sql = "SELECT au.id, au.name, au.password, au.user_type_id " +
                     "FROM account_user AS au " +
                     "WHERE au.name = ? AND au.password = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setId(rs.getInt("id"));
            user.setName(userName);
            user.setPassword(password);
            user.setUserTypeId(rs.getInt("user_type_id"));
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {

        String sql = "SELECT au.id, au.name, au.password, au.user_type_id " +
                     "FROM account_user AS au " +
                     "WHERE au.name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setId(rs.getInt("id"));
            user.setName(userName);
            user.setUserTypeId(rs.getInt("user_type_id"));
            return user;
        }
        return null;
    }
}