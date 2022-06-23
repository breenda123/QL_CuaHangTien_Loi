/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.ThongTinCaNhanDAL;
import javax.swing.JComboBox;

/**
 *
 * @author DangKhoa
 */
public class ThongTinCaNhanBUS {
    public static void getCBbox(JComboBox maNV) {
        ThongTinCaNhanDAL.getCBbox(maNV);
    }
    
    public static void getCBboxTb(JComboBox maNV) {
        ThongTinCaNhanDAL.getCBboxTb(maNV);
    }
    
    public static void Them( String maNhanVien, String hoTen, String gioiTinh, String ngaySinh, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
             String ghiChu) {
        ThongTinCaNhanDAL.Them(maNhanVien, hoTen, gioiTinh, ngaySinh, noiSinh, nguyenQuan, diaChiThuongTru, diaChiTamTru, soDienThoai, danToc, tonGiao, quocTich, ghiChu);
    }
    
    public static void Xoa(String maNhanVien) {
        ThongTinCaNhanDAL.Xoa(maNhanVien);
    }
    
    public static void Sua(String hoTen, String gioiTinh, String ngaySinh, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, 
          String ghiChu, String maNhanVien) {
        ThongTinCaNhanDAL.Sua(hoTen, gioiTinh, ngaySinh, noiSinh, nguyenQuan, diaChiThuongTru, diaChiTamTru, soDienThoai, danToc, tonGiao, quocTich, ghiChu, maNhanVien);
    }


}
