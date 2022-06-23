/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Ngoc
 */
public class Luong {
    private String maNhanVien, maLuong, hoTen, gioiTinh, chucVu, chucDanh, luongCoBan,
            luongCoBan_gio, phuCapCV, hinhThuc, ngayNhap, ghiChu;

    public Luong(String maNhanVien, String maLuong, String hoTen, String gioiTinh, String chucVu, String chucDanh, String luongCoBan, String luongCoBan_gio, String phuCapCV, String hinhThuc, String ngayNhap, String ghiChu) {
        this.maNhanVien = maNhanVien;
        this.maLuong = maLuong;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.chucDanh = chucDanh;
        this.luongCoBan = luongCoBan;
        this.luongCoBan_gio = luongCoBan_gio;
        this.phuCapCV = phuCapCV;
        this.hinhThuc = hinhThuc;
        this.ngayNhap = ngayNhap;
        this.ghiChu = ghiChu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    public String getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getLuongCoBan_gio() {
        return luongCoBan_gio;
    }

    public void setLuongCoBan_gio(String luongCoBan_gio) {
        this.luongCoBan_gio = luongCoBan_gio;
    }

    public String getPhuCapCV() {
        return phuCapCV;
    }

    public void setPhuCapCV(String phuCapCV) {
        this.phuCapCV = phuCapCV;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    } 
}
