/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author M4800
 */

public class KetNoiSQL {
    public static Connection layKetnoi(){
        Connection ketNoi = null;
        String url = "jdbc:sqlserver://;databaseName=QLNS";
        String username ="sa";
        String password ="lenhha12345::";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            ketNoi = DriverManager.getConnection(url,username,password);
            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ket noi that bai");
        } 
        return ketNoi;
    }
}
