package com.zelenin.restaurant.repositories;

import com.zelenin.restaurant.beans.Dish;
import com.zelenin.restaurant.beans.Order;
import com.zelenin.restaurant.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*  private Integer id;
    private Integer createdById;
    private Date createdOn;
    private Integer ownerId;
    private Integer statusId;
    private Integer paymentTypeId;
    private String description;
    private boolean isPayed;*/

public class OrderRepo {

    public static void createOrder(Connection conn, UserAccount user, Order order) throws SQLException {
        String sql = "INSERT INTO order(created_by_id, created_on, status_id, is_payed) " +
                     "VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, user.getId());
        pstm.setDate(1, new java.sql.Date(System.currentTimeMillis()));
        pstm.setInt(1, 1);
        pstm.setBoolean(1, false);
        ResultSet rs = pstm.executeQuery();
    }

    //public static void confirmOrder(Connection conn, )

}
