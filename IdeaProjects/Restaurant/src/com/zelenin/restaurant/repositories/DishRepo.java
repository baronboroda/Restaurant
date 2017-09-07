package com.zelenin.restaurant.repositories;

import com.zelenin.restaurant.beans.Category;
import com.zelenin.restaurant.beans.Dish;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishRepo {

    public static List<Dish> getMenu(Connection conn) throws SQLException {

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
                    "FROM dish AS d " +
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
