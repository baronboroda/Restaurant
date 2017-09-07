package com.zelenin.restaurant.repositories;

import com.zelenin.restaurant.beans.Dish;
import com.zelenin.restaurant.beans.DishInOrder;
import com.zelenin.restaurant.beans.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishInOrderRepo {

    public static List<DishInOrder> getDishesFromOrder(Connection conn, Order order) throws SQLException {
        List<DishInOrder> result = new ArrayList<>();

        String sql = "SELECT dio.id, dio.dish_id, dio.order_id, dio.price, dio.quantity " +
                     "FROM dish_in_order AS dio " +
                     "WHERE dio.order_id = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, order.getId());
        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            DishInOrder dish = new DishInOrder();
            dish.setId(rs.getInt("id"));
            dish.setDishId(rs.getInt("dish_id"));
            dish.setOrderId(rs.getInt("order_id"));
            dish.setPrice(rs.getBigDecimal("price"));
            dish.setQuantity(rs.getFloat("quantity"));

            result.add(dish);
        }
        return result;
    }

    public static void addDishToOrder(Connection conn, Dish dish, Order order, Float quantity) throws SQLException {
        String sql = "INSERT INTO dish_in_order(dish_id, order_id, price, quantity)" +
                     "VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, dish.getId());
        pstm.setInt(1, order.getId());
        pstm.setBigDecimal(1, dish.getPrice());
        pstm.setFloat(1, quantity);
        ResultSet rs = pstm.executeQuery();
    }
}
