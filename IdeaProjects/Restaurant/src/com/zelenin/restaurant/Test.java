package com.zelenin.restaurant;

import java.sql.Connection;
import com.zelenin.restaurant.beans.UserAccount;
import com.zelenin.restaurant.conn.ConnectionUtils;
import com.zelenin.restaurant.repositories.UserAccountRepo;

public class Test {
    public static void main(String[] args) throws Exception {
        Connection conn = null;

            conn = ConnectionUtils.getConnection();
            UserAccount user = UserAccountRepo.findUser(conn, "Petro", "best_pass");
            System.out.println(user);

            ConnectionUtils.closeQuietly(conn);

    }
}
