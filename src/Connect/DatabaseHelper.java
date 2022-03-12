/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Admin
 */
public class DatabaseHelper {
    public static Connection openConnection() throws Exception{
       
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=ThongTinSinhVien";
        String username = "sa";
        String password = "abc123";
        Connection conn ;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(connectionUrl,username,password);
        System.out.println(conn.getCatalog());
        return conn;
       
    }
    public static void main(String[] args) throws Exception {
        openConnection();
    }
}
