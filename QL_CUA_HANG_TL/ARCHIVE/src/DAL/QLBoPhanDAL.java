/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.TableUI;
import javax.swing.table.DefaultTableModel;
import DTO.QLBoPhan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

/**
 *
 * @author DangKhoa
 */
public class QLBoPhanDAL {
    
    private static Connection conn;
    
    public static ArrayList<QLBoPhan> bpList() {
        ArrayList<QLBoPhan> bpList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblBoPhan");
            ResultSet rs = ps.executeQuery();
            QLBoPhan bp;
            while (rs.next()) {
                bp = new QLBoPhan(
                    rs.getString("MaBoPhan"),
                    rs.getString("TenBoPhan"),
                    rs.getString("GhiChu")
                );
                bpList.add(bp);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return bpList;
    }
    
    public static void Moi(JTextField maBoPhan, JTextField tenBoPhan, JTextField ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*)+1 AS SL FROM TblBoPhan");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("SL");
                maBoPhan.setText("B"+ rnno);
                tenBoPhan.setText("");
                ghiChu.setText("");   
            }
            else {
                maBoPhan.setText("B1");
                tenBoPhan.setText("");
                ghiChu.setText("");     
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Them(String maBoPhan, String tenBoPhan, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "INSERT INTO TblBoPhan(MaBoPhan, TenBoPhan, GhiChu) "
                    + "values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, tenBoPhan);
            ps.setString(3, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MESSAGE: " + e , "Lỗi", 2);
        }
    }
    
    public static void Xoa(String maBoPhan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "DELETE FROM TblBoPhan WHERE MaBoPhan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MESSAGE: " + e , "Lỗi", 2);
        }
    }
    
    public static void Sua(String tenBoPhan, String ghiChu, String maBoPhan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "UPDATE TblBoPhan SET TenBoPhan=?, GhiChu=? WHERE MaBoPhan=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenBoPhan);
            ps.setString(2, ghiChu);
            ps.setString(3, maBoPhan);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "MESSAGE: " + e , "Lỗi", 2);
        }
    }
}

