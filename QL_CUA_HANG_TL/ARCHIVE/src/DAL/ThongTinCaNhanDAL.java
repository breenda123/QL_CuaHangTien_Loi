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
import DTO.ThongTinCaNhan;
import com.toedter.calendar.JDateChooser;
import static groovy.util.Eval.x;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author DangKhoa
 */
public class ThongTinCaNhanDAL {
    private static Connection conn;
    
    public static ArrayList<ThongTinCaNhan> ttList() {
        ArrayList<ThongTinCaNhan> ttList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCaNhan");
            ResultSet rs = ps.executeQuery();
            ThongTinCaNhan tt;
            while (rs.next()) {
                tt = new ThongTinCaNhan(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("GioiTinh"),
                    rs.getString("NgaySinh"),
                    rs.getString("NoiSinh"),
                    rs.getString("NguyenQuan"),
                    rs.getString("DCThuongtru"),
                    rs.getString("DCTamtru"),
                    rs.getString("SDT"),
                    rs.getString("DanToc"),
                    rs.getString("TonGiao"),
                    rs.getString("QuocTich"),
                    rs.getString("GhiChu")
                );
                ttList.add(tt);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return ttList;
    }
    
    public static void getCBbox(JComboBox maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV \n" +
"  FROM TblTTNVCoBan\n" +
"  WHERE MaNV IN ( SELECT MaNV \n" +
"					FROM TblTTNVCoBan\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblTTNVCaNhan\n" +
"					)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNV.addItem(rs.getString("MaNV"));
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, e, "Lỗi", 1);
        }
    }
    
    public static void getCBboxTb(JComboBox maNV) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV FROM TblTTNVCoBan ORDER BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNV.addItem(rs.getString("MaNV"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Them(String maNhanVien, String hoTen, String gioiTinh, String ngaySinh, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
             String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "INSERT INTO TblTTNVCaNhan (MaNV, HoTen, GioiTinh, NgaySinh, NoiSinh,  NguyenQuan, DCThuongtru, DCTamtru, "
            + "SDT, DanToc, TonGiao, QuocTich, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, hoTen);
            ps.setString(3, gioiTinh);
            ps.setString(4, ngaySinh);
            ps.setString(5, noiSinh);
            ps.setString(6, nguyenQuan);
            ps.setString(7, diaChiThuongTru);
            ps.setString(8, diaChiTamTru);
            ps.setString(9, soDienThoai);
            ps.setString(10, danToc);
            ps.setString(11, tonGiao);
            ps.setString(12, quocTich);
            ps.setString(13, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "DELETE FROM TblTTNVCaNhan WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String hoTen, String gioiTinh, String ngaySinh,String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
             String ghiChu, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "UPDATE TblTTNVCaNhan SET HoTen=?, GioiTinh=?, NgaySinh=?, NoiSinh=?, NguyenQuan=?, DCThuongtru=?, DCTamtru=?, "
            + "SDT=?, DanToc=?, TonGiao=?, QuocTich=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);                       
            ps.setString(1, hoTen);
            ps.setString(2, gioiTinh);
            ps.setString(3, ngaySinh);
            ps.setString(4, noiSinh);
            ps.setString(5, nguyenQuan);
            ps.setString(6, diaChiThuongTru);
            ps.setString(7, diaChiTamTru);
            ps.setString(8, soDienThoai);
            ps.setString(9, danToc);
            ps.setString(10, tonGiao);
            ps.setString(11, quocTich);
            ps.setString(12, ghiChu);
            ps.setString(13, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Lỗi", 2);
        }
    }

    
}
