/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;
import DAL.QLBoPhanDAL;
import DTO.QLPhongBan;
import java.util.ArrayList;
import javax.swing.JTextField;
/**
 *
 * @author DangKhoa
 */
public class QLBoPhanBUS { 
    public static void Moi(JTextField maBoPhan, JTextField tenBoPhan, JTextField ghiChu) {
        QLBoPhanDAL.Moi(maBoPhan, tenBoPhan, ghiChu);
    }
    
    public static void Them(String maBoPhan, String tenBoPhan, String ghiChu) {
        QLBoPhanDAL.Them(maBoPhan, tenBoPhan, ghiChu);
    }
    
    public static void Xoa(String maBoPhan) {
        QLBoPhanDAL.Xoa(maBoPhan);
    }
    
    public static void Sua(String tenBoPhan, String ghiChu, String maBoPhan) {
        QLBoPhanDAL.Sua(tenBoPhan, ghiChu, maBoPhan);
    }
}
