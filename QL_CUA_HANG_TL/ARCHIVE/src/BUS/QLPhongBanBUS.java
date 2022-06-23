/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.QLPhongBanDAL;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author DangKhoa
 */
public class QLPhongBanBUS {
    public static void getCBbox(JComboBox bophan) {
        QLPhongBanDAL.getCBbox(bophan);
    }
    
    public static void Moi(JComboBox maBoPhan, JTextField maPhong, JTextField tenPhong, JDateChooser ngayThanhLap, JTextField ghiChu) {
        QLPhongBanDAL.Moi(maBoPhan, maPhong, tenPhong, ngayThanhLap, ghiChu);
    }
    
    public static void Them(String maBoPhan, String maPhong, String tenPhong, String ngayThanhLap, String ghiChu) {
        QLPhongBanDAL.Them(maBoPhan, maPhong, tenPhong, ngayThanhLap, ghiChu);
    }
    
    public static void Xoa(String maPhong) {
        QLPhongBanDAL.Xoa(maPhong);
    }
    
    public static void Sua(String maBoPhan, String tenPhong, String ngayThanhLap, String ghiChu, String maPhong) {
        QLPhongBanDAL.Sua(maBoPhan, tenPhong, ngayThanhLap, ghiChu, maPhong);
    }
}
