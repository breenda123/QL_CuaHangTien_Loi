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
import DTO.QLPhongBan;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author DangKhoa
 */
public class QLPhongBanDAL {
    private static Connection conn;
    
    public static ArrayList<QLPhongBan> pbList() {
        ArrayList<QLPhongBan> pbList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblPhongBan");
            ResultSet rs = ps.executeQuery();
            QLPhongBan pb;
            while (rs.next()) {
                pb = new QLPhongBan(
                    rs.getString("MaBoPhan"),
                    rs.getString("MaPhong"),
                    rs.getString("TenPhong"),
                    rs.getString("NgayTLap"),
                    rs.getString("GhiChu")
                );
                pbList.add(pb);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return pbList;
    }
    
    public static void getCBbox(JComboBox bophan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT MaBophan FROM TblBoPhan ORDER BY MaBophan");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bophan.addItem(rs.getString("MaBophan"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Moi(JComboBox maBoPhan, JTextField maPhong, JTextField tenPhong, JDateChooser ngayThanhLap, JTextField ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*)+1 AS SL FROM TblPhongBan");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("SL");
                maBoPhan.setSelectedIndex(0);
                maPhong.setText("mp0" + rnno);
                tenPhong.setText("");
                ngayThanhLap.setDateFormatString("yyyy-MM-dd");
                ghiChu.setText("");
            } else {
                maPhong.setText("mp001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Them(String maBoPhan, String maPhong, String tenPhong, String ngayThanhLap, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "INSERT INTO TblPhongBan(MaBoPhan, MaPhong, TenPhong, NgayTLap, GhiChu) "
            + "values(?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, maPhong);
            ps.setString(3, tenPhong);
            ps.setString(4, ngayThanhLap);
            ps.setString(5, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "DELETE FROM TblPhongBan WHERE MaPhong=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPhong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maBoPhan, String tenPhong, String ngayThanhLap, String ghiChu, String maPhong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLNS;" + "username=sa;password=123456");
            String sql = "UPDATE TblPhongBan SET MaBoPhan=?, TenPhong=?, NgayTLap=?, GhiChu=? WHERE MaPhong=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, maBoPhan);
            ps.setString(2, tenPhong);         
            ps.setString(3, ngayThanhLap);
            ps.setString(4, ghiChu);
            ps.setString(5, maPhong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
