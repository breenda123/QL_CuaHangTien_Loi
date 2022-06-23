/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.LuongDAL;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author DangKhoa
 */
public class LuongBUS {
    public static void getCBboxMaNV(JComboBox maNV) {
        LuongDAL.getCBboxMaNV(maNV);
    }
    
    public static void getCBboxMaNVTb(JComboBox maNV) {
        LuongDAL.getCBboxMaNVTb(maNV);
    }
    
    public static void Them(String maNhanVien, String maLuong, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBan, String luongCoBan_gio, String phuCapCV, String hinhThuc, String ngayNhap, String ghiChu) {
        LuongDAL.Them(maNhanVien, maLuong, hoTen, gioiTinh, chucVu, chucDanh, luongCoBan, luongCoBan_gio, phuCapCV, hinhThuc, ngayNhap, ghiChu);
    }
    
    public static void Xoa(String maLuong) {
        LuongDAL.Xoa(maLuong);
    }
    
    public static void Sua(String maNhanVien, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBan, String luongCoBan_gio, String phuCapCV, String hinhThuc, String ngayNhap, String ghiChu,  String maLuong) {
        LuongDAL.Sua(maNhanVien, hoTen, gioiTinh, chucVu, chucDanh, luongCoBan, luongCoBan_gio, phuCapCV, hinhThuc, ngayNhap, ghiChu, maLuong);
    }
    public static void Moi(JComboBox maNhanVien, JTextField maLuong, JTextField hoTen, JComboBox gioiTinh, JComboBox chucVu, JTextField chucDanh, JTextField luongCoBan, 
                JTextField luongCoBan_gio, JTextField PCCV, JComboBox hinhThuc, JDateChooser ngayNhap, JTextField ghiChu){
        LuongDAL.Moi(maNhanVien, maLuong, hoTen, gioiTinh, chucVu, chucDanh, luongCoBan, luongCoBan_gio, PCCV, hinhThuc, ngayNhap, ghiChu);
    }
}
