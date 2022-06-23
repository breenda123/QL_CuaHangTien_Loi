/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.QLNhanSuDAL;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author DangKhoa
 */
public class QLNhanSuBUS {
    public static void getCBboxBP(JComboBox bophan) {
        QLNhanSuDAL.getCBboxBP(bophan);
    }

    
    public static void Moi(JComboBox maBoPhan, JTextField maNhanVien, JTextField hoTen, JDateChooser ngaySinh, JComboBox gioiTinh, JTextField CMND, JDateChooser ngayCap, JTextField noiCap, JComboBox chucVu, 
            JTextField chucDanh, JTextField loaiHD, JDateChooser ngayKy, JDateChooser ngayHetHan, JTextField ghiChu) {
        QLNhanSuDAL.Moi(maBoPhan, maNhanVien, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu);
    }
    
    public static void Them(String maBoPhan, String maNhanVien, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu) {
        QLNhanSuDAL.Them(maBoPhan, maNhanVien, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu);
    }
    
    public static void Xoa(String maNhanVien) {
        QLNhanSuDAL.Xoa(maNhanVien);
    }
    
    public static void Sua(String maBoPhan, String maPhong, String hoTen, String ngaySinh, String gioiTinh, String CMND, String ngayCap, String noiCap, String chucVu, 
            String chucDanh, String loaiHD, String ngayKy, String ngayHetHan, String ghiChu, String maNhanVien) {
        QLNhanSuDAL.Sua(maBoPhan, hoTen, ngaySinh, gioiTinh, CMND, ngayCap, noiCap, chucVu, chucDanh, loaiHD, ngayKy, ngayHetHan, ghiChu, maNhanVien);
    }
}
