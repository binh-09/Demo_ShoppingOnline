/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class DBContext {

    protected Connection connection;

    public DBContext() {
        try {
//            String url = "jdbc:sqlserver://localhost:1433;databaseName=Northwind";
//            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=Northwind;";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Northwind;encrypt=true;trustServerCertificate=true;";

            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
//            if (connection != null) {
//                System.out.println("Kết nối thành công!");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Chi tiết lỗi: " + e.getMessage());
        }
    }
}
