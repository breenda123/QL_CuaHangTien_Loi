///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DAL;
//
//import DAL.QLNhanSuDAL;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Font;
//import java.awt.Toolkit;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import net.proteanit.sql.DbUtils;
//import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import DTO.QLNhanSu;
//import javax.swing.JRadioButton;
//import javax.swing.JTable;
//
///**
// *
// * @author DangKhoa
// */
//public class SearchDAL {
//    private Connection conn;
//    
//    public static void search(JTable table, JRadioButton radId, JRadioButton radName, JRadioButton radChucVu) {
//        try {
//            if (radId.isSelected()) {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//                PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCoBan WHERE MaNV=?");
//                ps.setString(1, search);
//                ResultSet rs = ps.executeQuery();
//                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//                ps.close();
//            } else if (radName.isSelected()) {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//                PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCoBan WHERE HoTen=?");
//                ps.setString(1, search);
//                ResultSet rs = ps.executeQuery();
//                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//                ps.close();
//            } else if (radCMND.isSelected()) {
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
//                PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCoBan WHERE ChucVu=?");
//                ps.setString(1, search);
//                ResultSet rs = ps.executeQuery();
//                jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//                ps.close();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
//}
