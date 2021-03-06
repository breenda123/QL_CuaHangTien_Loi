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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.BangCongDieuHanh;
import DTO.BangCongBanHang;
import DTO.BangCongKiemKho;
import DTO.BangCongAnNinh;
import javax.swing.JComboBox;

/**
 *
 * @author DangKhoa
 */
public class BangCongKiemKhoDAL {
    private static Connection conn;
    
    public static ArrayList<BangCongKiemKho> kkList() {
        ArrayList<BangCongKiemKho> kkList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM TblCongKiemKho");
            ResultSet rs = ps.executeQuery();
            BangCongKiemKho kk;
            while (rs.next()) {
                kk = new BangCongKiemKho(
                    rs.getString("MaNV"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("GhiChu"),
                    rs.getString("MaBoPhan")
                );
                kkList.add(kk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return kkList;
    }
    
    public static void getCBboxMaNV(JComboBox maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV \n" +
"  FROM TblTTNVCoBan\n" +
"  WHERE MaNV IN ( SELECT MaNV \n" +
"					FROM TblTTNVCoBan\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongDieuHanh\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongBanHang\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongKiemKho\n" +
"					EXCEPT\n" +
"					SELECT MaNV\n" +
"					FROM TblCongAnNinh\n" +
"					)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNhanVien.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("  SELECT MaNV FROM TblTTNVCoBan GROUP BY MaNV");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maNhanVien.addItem(rs.getString("MaNV"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void getCBboxMaBoPhan(JComboBox maBoPhan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT MaBoPhan FROM TblBoPhan ORDER BY MaBoPhan");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                maBoPhan.addItem(rs.getString("MaBoPhan"));
            }
            //cbxID.setModel(modelCombo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static ArrayList<BangCongKiemKho> kktcList() {
        ArrayList<BangCongKiemKho> kkList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            PreparedStatement ps = conn.prepareStatement("SELECT TblCongKiemKho.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, TblCongKiemKho.MaBoPhan FROM TblCongKiemKho, TblTTNVCoBan WHERE TblCongKiemKho.MaNV = TblTTNVCoBan.MaNV ");
            ResultSet rs = ps.executeQuery();
            BangCongKiemKho kk;
            while (rs.next()) {
                kk = new BangCongKiemKho(
                    rs.getString("MaNV"),
                    rs.getString("HoTen"),
                    rs.getString("NgaySinh"),
                    rs.getString("LCB"),
                    rs.getString("PhuCapCVu"),
                    rs.getString("PhuCapKhac"),
                    rs.getString("Thang"),
                    rs.getString("Nam"),
                    rs.getString("SoNgayCongThang"),
                    rs.getString("SoNgayNghi"),
                    rs.getString("SoGioLamThem"),
                    rs.getString("MaBoPhan")
                );
                kkList.add(kk);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return kkList;
    }
    
    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, 
            String soNgayCong, String soNgayNghi, String soGioLam, String ghiChu, String maBoPhan) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "INSERT INTO TblCongKiemKho(MaNV, LCB, PhuCapCVu, PhuCapKhac, Thang, "
            + "Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem, GhiChu, MaBoPhan) "
            + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.setString(2, luongCoBan);
            ps.setString(3, phuCap);
            ps.setString(4, phuCapKhac);
            ps.setString(5, thang);
            ps.setString(6, nam);
            ps.setString(7, soNgayCong);
            ps.setString(8, soNgayNghi);
            ps.setString(9, soGioLam);
            ps.setString(10, ghiChu);
            ps.setString(11, maBoPhan);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Th??m th??nh c??ng!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void Xoa(String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "DELETE FROM TblCongKiemKho WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xo?? th??nh c??ng!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, 
            String soNgayNghi, String soGioLam, String ghiChu, String maBoPhan, String maNhanVien) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
            String sql = "UPDATE TblCongKiemKho SET LCB=?, PhuCapCVu=?, PhuCapKhac=?, Thang=?, "
            + "Nam=?, SoNgayCongThang=?, SoNgayNghi=?, SoGioLamThem=?, GhiChu=?, MaBoPhan=? WHERE MaNV=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, luongCoBan);
            ps.setString(2, phuCap);
            ps.setString(3, phuCapKhac);
            ps.setString(4, thang);
            ps.setString(5, nam);
            ps.setString(6, soNgayCong);
            ps.setString(7, soNgayNghi);
            ps.setString(8, soGioLam);
            ps.setString(9, ghiChu);
            ps.setString(10, maBoPhan);
            ps.setString(11, maNhanVien);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ch???nh s???a th??nh c??ng!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
