/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Ngoc
 */
public class ThongTinCaNhan implements Serializable{
    private String maNhanVien, hoTen, gioiTinh, ngaySinh, noiSinh, nguyenQuan, diaChiThuongTru, diaChiTamTru, soDienThoai, danToc,quocTich,tonGiao,
                     ghiChu;

    public ThongTinCaNhan(String maNhanVien, String hoTen, String gioiTinh, String ngaySinh, String noiSinh, String nguyenQuan, String diaChiThuongTru, String diaChiTamTru, String soDienThoai, String danToc, String tonGiao, String quocTich, String ghiChu) {
        this.maNhanVien = maNhanVien;
        this.quocTich = quocTich;
        this.hoTen = hoTen;
        this.ngaySinh= ngaySinh;
        this.noiSinh = noiSinh;
        this.nguyenQuan = nguyenQuan;
        this.diaChiThuongTru = diaChiThuongTru;
        this.diaChiTamTru = diaChiTamTru;
        this.soDienThoai = soDienThoai;
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.gioiTinh= gioiTinh;
        this.ghiChu = ghiChu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
        public String gethoTen() {
        return hoTen;
    }

    public void sethoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getgioiTinh() {
        return gioiTinh;
    }

    public void setgioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getngaySinh(){
        return ngaySinh;
    }
    
    public void setngaySinh(String ngaySinh){
        this.ngaySinh = ngaySinh;
    }
    public String getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(String noiSinh) {
        this.noiSinh = noiSinh;
    }

    public String getNguyenQuan() {
        return nguyenQuan;
    }

    public void setNguyenQuan(String nguyenQuan) {
        this.nguyenQuan = nguyenQuan;
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public String getDiaChiTamTru() {
        return diaChiTamTru;
    }

    public void setDiaChiTamTru(String diaChiTamTru) {
        this.diaChiTamTru = diaChiTamTru;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
