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
import DTO.QLNhanSu;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class QLNhanSuDAL {
    private static Connection conn;
    
    public static ArrayList<QLNhanSu> nsList() {
        ArrayList<QLNhanSu> nsList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblTTNVCoBan");
            ResultSet rs = ps.executeQuery();
            QLNhanSu ns;
            while (rs.next()) {
                ns = new QLNhanSu(
                    rs.getString("MaBoPhan"),
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("GioiTinh"),
                    rs.getString("CMTND"),
                    rs.getString("NgayCap"),
                    rs.getString("NoiCap"),
                    rs.getString("ChucVu"),
                    rs.getString("ChucDanh"),
                    rs.getString("LoaiHD"),
                    rs.getString("NgayKy"),
                    rs.getString("NgayHetHan"),
                    rs.getString("GhiChu")
                );
                nsList.add(ns);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return nsList;
    }
    
    public static void getCBboxBP(JComboBox bophan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
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
       
    public static void Moi(JComboBox maBoPhan, JTextField maNhanVien, JTextField hoTen, JDateChooser ngaySinh, JComboBox gioiTinh, JTextField CMND, JDateChooser ngayCap, JTextField noiCap, JComboBox chucVu, 
            JTextField chucDanh, JTextField loaiHD, JDateChooser ngayKy, JDateChooser ngayHetHan, JTextField ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ns = conn.prepareStatement("DECLARE @Total INT;\n" +
                "SET @Total = (SELECT COUNT(*)+1 AS SL FROM TblTTNVCoBan);\n" +
                "WHILE(SELECT 1 FROM dbo.TblTTNVCoban WHERE @Total = MaNV) = 1\n" +
                "BEGIN\n" +
                " SET @Total = @Total +1;\n" +
                "END\n" +
                "SELECT @Total AS SL;");
            ResultSet rs = ns.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("SL");
                maBoPhan.setSelectedIndex(0);
                maNhanVien.setText(rnno);
                hoTen.setText("");
                ngaySinh.setDateFormatString("yyyy-MM-dd");
                gioiTinh.setSelectedIndex(0);
                CMND.setText("");
                ngayCap.setDateFormatString("yyyy-MM-dd");
                noiCap.setText("");
                chucVu.setSelectedIndex(0);
                chucDanh.setText("");
                loaiHD.setText("");
                ngayKy.setDateFormatString("yyyy-MM-dd");
                ngayHetHan.setDateFormatString("yyyy-MM-dd");
                ghiChu.setText("");
            }
            else {
                maBoPhan.setSelectedIndex(0);
                maNhanVien.setText("1");
                hoTen.setText("");
                ngaySinh.setDateFormatString("yyyy-MM-dd");
                gioiTinh.setSelectedIndex(0);
                CMND.setText("");
                ngayCap.setDateFormatString("yyyy-MM-dd");
                noiCap.setText("");
                chucVu.setSelectedIndex(0);
                chucDanh.setText("");
                loaiHD.setText("");
                ngayKy.setDateFormatString("yyyy-MM-dd");
                ngayHetHan.setDateFormatString("yyyy-MM-dd");
                ghiChu.setText("");
                
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static void Them(String maBoPhan, String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "INSERT INTO TblTTNVCoBan(MaBoPhan, MaNV, HoTen, NgaySinh, "
            + "GioiTinh, CMTND, NgayCap, NoiCap, ChucVu, ChucDanh, LoaiHD, NgayKy, NgayHetHan, GhiChu) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhan);
            ps.setString(2, maNhanVien);
            ps.setString(3, hoTen);
            ps.setString(4, ngaySinh);
            ps.setString(5, gioiTinh);
            ps.setString(6, CMND);
            ps.setString(7, ngayCap);
            ps.setString(8, noiCap);
            ps.setString(9, chucVu);
            ps.setString(10, chucDanh);
            ps.setString(11, loaiHD);
            ps.setString(12, ngayKy);
            ps.setString(13, ngayHetHan);
            ps.setString(14, ghiChu);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Trùng thông tin!");
            JOptionPane.showMessageDialog(null, "Trùng mã nhân viên !!! "  , "Error", 2);
            e.printStackTrace();
        }
    }
    
    public static void Xoa(String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "DELETE FROM TblTTNVCoBan WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoá thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thông tin còn tồn tại ở chức năng khác!", "Lỗi", 2);
            //e.printStackTrace();
        }
    }
    
    public static void Sua(String maBoPhan, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "UPDATE TblTTNVCoBan SET MaBoPhan=?, HoTen=?, NgaySinh=?, "
            + "GioiTinh=?, CMTND=?, NgayCap=?, NoiCap=?, ChucVu=?, ChucDanh=?, "
            + "LoaiHD=?, NgayKy=?, NgayHetHan=?, GhiChu=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);           
            ps.setString(1, maBoPhan);      
            ps.setString(2, hoTen);
            ps.setString(3, ngaySinh);
            ps.setString(4, gioiTinh);
            ps.setString(5, CMND);
            ps.setString(6, ngayCap);
            ps.setString(7, noiCap);
            ps.setString(8, chucVu);
            ps.setString(9, chucDanh);
            ps.setString(10, loaiHD);
            ps.setString(11, ngayKy);
            ps.setString(12, ngayHetHan);
            ps.setString(13, ghiChu);
            ps.setString(14, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Chỉnh sửa thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Lỗi", 2);
            e.printStackTrace();
        }
    }
}
