/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.BangCongAnNinhDAL;
import DTO.BangCongAnNinh;
import javax.swing.JComboBox;

/**
 *
 * @author DangKhoa
 */
public class BangCongAnNinhBUS {
    public static void getCBboxMaNV(JComboBox maNhanVien) {
        BangCongAnNinhDAL.getCBboxMaNV(maNhanVien);
    }
    
    public static void getCBboxMaNVTb(JComboBox maNhanVien) {
        BangCongAnNinhDAL.getCBboxMaNVTb(maNhanVien);
    }
    
    public static void getCBboxMaBoPhan(JComboBox maBoPhan) {
        BangCongAnNinhDAL.getCBboxMaBoPhan(maBoPhan);
    }
    public static void Them(String maNhanVien, String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, 
            String soNgayNghi, String soGioLam, String ghiChu, String maBoPhan) {
        BangCongAnNinhDAL.Them(maNhanVien, luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maBoPhan);
    }
    
    public static void Xoa(String maNhanVien) {
        BangCongAnNinhDAL.Xoa(maNhanVien);
    }
    
    public static void Sua(String luongCoBan, String phuCap, String phuCapKhac, String thang, String nam, String soNgayCong, 
            String soNgayNghi, String soGioLam, String ghiChu, String maBoPhan, String maNhanVien) {
        BangCongAnNinhDAL.Sua(luongCoBan, phuCap, phuCapKhac, thang, nam, soNgayCong, soNgayNghi, soGioLam, ghiChu, maBoPhan, maNhanVien);
    }
}
