package com.zelenin.restaurant.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.zelenin.restaurant.beans.*;

public class DBUtils {

    public static UserAccount findUser(Connection conn, String userName, String password) throws SQLException {

        String sql = "SELECT au.id, au.name, au.password, ut.name AS user_type_name " +
                     "FROM account_user AS au " +
                     "LEFT OUTER JOIN user_type AS ut ON ut.id = au.user_type_id " +
                     "WHERE au.name = ? AND au.password= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setId(rs.getInt("id"));
            user.setName(userName);
            user.setPassword(password);
            user.setUserTypeName(rs.getString("user_type_name"));
            return user;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String userName) throws SQLException {

        String sql = "SELECT au.id, au.name, au.password, ut.name AS user_type_name " +
                     "FROM account_user AS au " +
                     "LEFT OUTER JOIN user_type AS ut ON ut.id = au.user_type_id " +
                     "WHERE au.name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            UserAccount user = new UserAccount();
            user.setId(rs.getInt("id"));
            user.setName(userName);
            user.setUserTypeName(rs.getString("user_type_name"));
            return user;
        }
        return null;
    }

    public static List<Dish> getAllDishes(Connection conn) throws SQLException {

        List<Dish> result = new ArrayList<>();

        String sql = "SELECT d.id, d.name, u.name as unit_name, d.quantity, c.name as category_name, d.price " +
                     "FROM dish AS d " +
                     "LEFT OUTER JOIN unit AS u ON ut.id = d.unit_id " +
                     "LEFT OUTER JOIN category AS c ON c.id = d.category_id ";

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setUnitName(rs.getString("unit_name"));
            dish.setQuantity(rs.getFloat("quantity"));
            dish.setCategoryName(rs.getString("category_name"));
            dish.setPrice(rs.getBigDecimal("price"));

            result.add(dish);
        }
        return result;
    }


}
