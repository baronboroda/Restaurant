package com.zelenin.restaurant;

import java.sql.Connection;
import java.util.Collection;

import com.zelenin.restaurant.beans.Dish;
import com.zelenin.restaurant.beans.UserAccount;
import com.zelenin.restaurant.conn.ConnectionUtils;
import com.zelenin.restaurant.repositories.DishRepo;
import com.zelenin.restaurant.repositories.OrderRepo;
import com.zelenin.restaurant.repositories.UserAccountRepo;

import static com.zelenin.restaurant.repositories.DishRepo.getMenu;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = null;

        conn = ConnectionUtils.getConnection();
        UserAccount user = UserAccountRepo.findUser(conn, "Petro", "best_pass");
        System.out.println("Hello, " + user);
        Collection<Dish> menu = DishRepo.getMenu(conn);
        System.out.println("Menu");
        System.out.println("---------------------------");
        for(Dish d : menu) {
            System.out.println(d);
        }
        ConnectionUtils.closeQuietly(conn);

        OrderRepo.createOrder(conn, user);

    }
}
