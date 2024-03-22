/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TASK_05;

import com.sun.jdi.connect.spi.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sn96g
 */
public class db {
    public static Connection myconn(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//load jdbc driver
            
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/students", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("e");
            return null;
        }
        
        return conn;
    }
    
}
