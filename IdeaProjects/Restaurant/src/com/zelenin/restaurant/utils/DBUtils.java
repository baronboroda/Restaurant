package com.zelenin.restaurant.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zelenin.restaurant.beans.*;

public class DBUtils {

    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

        String sql = "SELECT au.name, au.password, ut.name AS user_type_name " +
                     "FROM account_user AS au " +
                     "LEFT OUTER JOIN user_type AS ut ON ut.id = au.user_type_id " +
                     "WHERE au.name = ? AND au.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            String userTypeName = rs.getString("user_type_name");
            UserAccount user = new UserAccount();
            user.setName(userName);
            user.setPassword(password);
            user.setUserTypeName(userTypeName);
            return user;
        }
        return null;
    }


}
