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

        String sql = "SELECT au.id, au.name, au.password, au.user_type_id" +
                     "FROM account_user AS au " +
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

    public static List<Dish> getAllDishes(Connection conn) throws SQLException {

        List<Dish> result = new ArrayList<>();

        String sql = "SELECT d.id, d.name, d.unit_id, d.quantity, d.category_id, d.price " +
                     "FROM dish AS d";

        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setUnitId(rs.getInt("unit_id"));
            dish.setQuantity(rs.getFloat("quantity"));
            dish.setCategoryId(rs.getInt("category_id"));
            dish.setPrice(rs.getBigDecimal("price"));

            result.add(dish);
        }
        return result;
    }

    public static List<Dish> getDishesByCategory(Connection conn, Category category) throws SQLException {

        List<Dish> result = new ArrayList<>();

        String sql = "SELECT d.id, d.name, d.unit_id, d.quantity, d.category_id, d.price " +
                     "FROM dish AS d" +
                     "WHERE d.category_id = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, category.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            Dish dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setUnitId(rs.getInt("unit_id"));
            dish.setQuantity(rs.getFloat("quantity"));
            dish.setCategoryId(rs.getInt("category_id"));
            dish.setPrice(rs.getBigDecimal("price"));

            result.add(dish);
        }
        return result;
    }


}
