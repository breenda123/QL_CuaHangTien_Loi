/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.BangLuongCongTy;
import DTO.Luong;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author DangKhoa
 */
public class LuongDAL {
    private static Connection conn;
    
    public static ArrayList<Luong> tlList() {
        ArrayList<Luong> tlList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblLuong");
            ResultSet rs = ps.executeQuery();
            Luong l;
            while (rs.next()) {
                l = new Luong(
                    rs.getString("MaNV"),
                    rs.getString("MaLuong"),
                    rs.getString("HoTen"),
                    rs.getString("GioiTinh"),
                    rs.getString("ChucVu"),
                    rs.getString("ChucDanh"),
                    rs.getString("LCB"),
                    rs.getString("LCB_gio"),
                    rs.getString("PCap"),
                    rs.getString("HinhThuc"),
                    rs.getString("NgayNhap"),
                    rs.getString("GhiChu")
                );
                tlList.add(l);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return tlList;
    }
    
    public static void getCBboxMaNV(JComboBox maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV \n" +
"  FROM TblTTNVCoBan\n" +
"  WHERE MaNV IN ( SELECT MaNV \n" +
"					FROM TblTTNVCoBan\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblLuong\n" +
"					)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNV.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getCBboxMaNVTb(JComboBox maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV FROM TblTTNVCoBan GROUP BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNV.addItem(rs.getString("MaNV"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Them(String maNhanVien, String maLuong, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBan, String luongCoBan_gio, String phuCapCV, String hinhThuc, String ngayNhap, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "INSERT INTO TblLuong(MaNV, MaLuong, HoTen, GioiTinh, ChucVu, "
            + "ChucDanh, LCB, LCB_gio, PCap, HinhThuc, NgayNhap, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, maLuong);
            ps.setString(3, hoTen);
            ps.setString(4, gioiTinh);
            ps.setString(5, chucVu);
            ps.setString(6, chucDanh);
            ps.setString(7, luongCoBan);
            ps.setString(8, luongCoBan_gio);
            ps.setString(9, phuCapCV);
            ps.setString(10, hinhThuc);
            ps.setString(11, ngayNhap);
            ps.setString(12, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maLuong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "DELETE FROM TblLuong WHERE MaLuong=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maLuong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String maNhanVien, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBan, 
            String luongCoBan_gio, String phuCapCV, String hinhThuc, String ngayNhap, String ghiChu, String maLuong) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "UPDATE TblLuong SET MaNV=?, HoTen=?, GioiTinh=?, ChucVu=?, "
            + " ChucDanh=?, LCB=?, LCB_gio=?, PCap=?, HinhThuc=?, NgayNhap=?, GhiChu=? WHERE MaLuong=? ";
            PreparedStatement ps = conn.prepareStatement(sql);    
            ps.setString(12, maLuong);
            ps.setString(2, hoTen);
            ps.setString(3, gioiTinh);
            ps.setString(4, chucVu);
            ps.setString(5, chucDanh);
            ps.setString(6, luongCoBan);
            ps.setString(7, luongCoBan_gio);
            ps.setString(8, phuCapCV);
            ps.setString(9, hinhThuc);
            ps.setString(10, ngayNhap);
            ps.setString(11, ghiChu);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Moi(JComboBox maNhanVien, JTextField maLuong, JTextField hoTen, JComboBox gioiTinh, JComboBox chucVu, JTextField chucDanh, JTextField luongCoBan, 
                JTextField luongCoBan_gio, JTextField phuCapCV, JComboBox hinhThuc, JDateChooser ngayNhap, JTextField ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("DECLARE @Total INT;\n" +
                "SET @Total = (SELECT COUNT(*)+1 AS SL FROM TblLuong);\n" +
                "WHILE(SELECT 1 FROM dbo.TblLuong WHERE @Total = MaNV) = 1\n" +
                "BEGIN\n" +
                " SET @Total = @Total +1;\n" +
                "END\n" +
                "SELECT @Total AS SL;");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("SL");
                
                //maNhanVien.setSelectedIndex(0);
                maLuong.setText("L" + rnno);
                hoTen.setText("");
                gioiTinh.setSelectedIndex(0);
                chucVu.setSelectedIndex(0);
                chucDanh.setText("");
                luongCoBan.setText("");
                luongCoBan_gio.setText("");
                phuCapCV.setText("");
                hinhThuc.setSelectedIndex(0);
                ngayNhap.setDateFormatString("yyyy-MM-dd");
                ghiChu.setText("");
            }
            else {
                //maNhanVien.setSelectedIndex(0);
                maLuong.setText("L");                
                hoTen.setText("");
                gioiTinh.setSelectedIndex(0);
                chucVu.setSelectedIndex(0);
                chucDanh.setText("");
                luongCoBan.setText("");
                luongCoBan_gio.setText("");
                phuCapCV.setText("");
                hinhThuc.setSelectedIndex(0);
                ngayNhap.setDateFormatString("yyyy-MM-dd");
                ghiChu.setText("");
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
