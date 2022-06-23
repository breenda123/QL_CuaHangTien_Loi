/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.BangCongDieuHanhBUS;
import BUS.BangCongBanHangBUS;
import BUS.BangCongKiemKhoBUS;
import BUS.BangCongAnNinhBUS;
import DAL.BangCongDieuHanhDAL;
import DAL.BangCongBanHangDAL;
import DAL.BangCongKiemKhoDAL;
import DAL.BangCongAnNinhDAL;
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
/**
 *
 * @author Ngoc
 */
public class frmQLBangCong extends javax.swing.JPanel {

    DateFormat dateFormat = new SimpleDateFormat("MM");
    DateFormat dateFormatY = new SimpleDateFormat("yyyy");

    Date dateDH = new Date();
    Date dateAN = new Date();
    Date dateBH = new Date();
    Date dateKK = new Date();
    Date dateTV = new Date();

    Calendar cal = Calendar.getInstance();
    DefaultTableModel modelDH;
    DefaultTableModel modelAN;
    DefaultTableModel modelBH;
    DefaultTableModel modelKK;
    DefaultTableModel modelTV;

    private Connection conn;
    /**
     * Creates new form frmQLBangCong
     */
    public frmQLBangCong() {
        initComponents();
        
        //getCBboxMaNVTV();
//        BangCongDieuHanhBUS.getCBboxMaNV(cbxMaNhanVienDH);
//        BangCongBanHangBUS.getCBboxMaNV(cbxMaNhanVienBH);
//        BangCongKiemKhoBUS.getCBboxMaNV(cbxMaNhanVienKK);
//        BangCongAnNinhBUS.getCBboxMaNV(cbxMaNhanVienAN);
        loadcbxMaNhanVien();
//        BangCongBanHangBUS.getCBboxMaBoPhan(cbxMaBoPhanBH);
//        BangCongDieuHanhBUS.getCBboxMaBoPhan(cbxMaBoPhanDH);
//        BangCongKiemKhoBUS.getCBboxMaBoPhan(cbxMaBoPhanKK);
//        BangCongAnNinhBUS.getCBboxMaBoPhan(cbxMaBoPhanAN);
////        getCBboxTenPhong();
//        getCBboxTenBoPhan();
        loadcbxMaBoPhan();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        modelDH = (DefaultTableModel) tblDH.getModel();
        modelBH = (DefaultTableModel) tblBH.getModel(); 
        //modelTV = (DefaultTableModel) tblTV.getModel();
        modelKK = (DefaultTableModel) tblKK.getModel();
        modelAN = (DefaultTableModel) tblAN.getModel();

        txtThangDH.setText(" " + dateFormat.format(dateDH));
        txtThangBH.setText(" " + dateFormat.format(dateBH));
        txtThangKK.setText(" " + dateFormat.format(dateKK));
        txtThangAN.setText(" " + dateFormat.format(dateAN));
        //txtThangTV.setText(" " + dateFormat.format(dateTV));

        txtNamDH.setText(" " + dateFormatY.format(dateDH));
        txtNamBH.setText(" " + dateFormatY.format(dateBH));
        txtNamKK.setText(" " + dateFormatY.format(dateKK));
        txtNamAN.setText(" " + dateFormatY.format(dateAN));
        //txtLuongNgay.setText(" " + dateFormatY.format(dateTV));

        //showTV();
        showDH();
        showBH();
        showKK();
        showAN();
    }
    public void loadcbxMaNhanVien(){
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaNV FROM dbo.TblTTNVCoBan";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                String manv = rs.getString("MANV");
                cbxMaNhanVienDH.addItem(manv);
                cbxMaNhanVienAN.addItem(manv);
                cbxMaNhanVienKK.addItem(manv);
                cbxMaNhanVienBH.addItem(manv);
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
    }
    public void loadcbxMaBoPhan(){
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaBoPhan FROM dbo.TblBoPhan";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                String mabp = rs.getString("MaBoPhan");
                cbxMaBoPhanDH.addItem(mabp);
                cbxMaBoPhanBH.addItem(mabp);
                cbxMaBoPhanKK.addItem(mabp);
                cbxMaBoPhanAN.addItem(mabp);
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
    }
    
    public void showDH() {
        ArrayList<BangCongDieuHanh> dh = BangCongDieuHanhDAL.dhList();
        DefaultTableModel model = (DefaultTableModel)tblDH.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<dh.size();i++) {
            row[0]=dh.get(i).getMaNhanVien();
            row[1]=dh.get(i).getLuongCoBan();
            row[2]=dh.get(i).getPhuCap();
            row[3]=dh.get(i).getPhuCapKhac();
            row[4]=dh.get(i).getThang();
            row[5]=dh.get(i).getNam();
            row[6]=dh.get(i).getSoNgayCong();
            row[7]=dh.get(i).getSoNgayNghi();
            row[8]=dh.get(i).getSoGioLam();
            row[9]=dh.get(i).getGhiChu();
            row[10]=dh.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }
    
    public void showBH() {
        ArrayList<BangCongBanHang> bh = BangCongBanHangDAL.bhList();
        DefaultTableModel model = (DefaultTableModel)tblBH.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<bh.size();i++) {
            row[0]=bh.get(i).getMaNhanVien();
            row[1]=bh.get(i).getLuongCoBan();
            row[2]=bh.get(i).getPhuCap();
            row[3]=bh.get(i).getPhuCapKhac();
            row[4]=bh.get(i).getThang();
            row[5]=bh.get(i).getNam();
            row[6]=bh.get(i).getSoNgayCong();
            row[7]=bh.get(i).getSoNgayNghi();
            row[8]=bh.get(i).getSoGioLam();
            row[9]=bh.get(i).getGhiChu();
            row[10]=bh.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }
    
    public void showKK() {
        ArrayList<BangCongKiemKho> kk = BangCongKiemKhoDAL.kkList();
        DefaultTableModel model = (DefaultTableModel)tblKK.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<kk.size();i++) {
            row[0]=kk.get(i).getMaNhanVien();
            row[1]=kk.get(i).getLuongCoBan();
            row[2]=kk.get(i).getPhuCap();
            row[3]=kk.get(i).getPhuCapKhac();
            row[4]=kk.get(i).getThang();
            row[5]=kk.get(i).getNam();
            row[6]=kk.get(i).getSoNgayCong();
            row[7]=kk.get(i).getSoNgayNghi();
            row[8]=kk.get(i).getSoGioLam();
            row[9]=kk.get(i).getGhiChu();
            row[10]=kk.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }
        
    public void showAN() {
        ArrayList<BangCongAnNinh> an = BangCongAnNinhDAL.anList();
        DefaultTableModel model = (DefaultTableModel)tblAN.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<an.size();i++) {
            row[0]=an.get(i).getMaNhanVien();
            row[1]=an.get(i).getLuongCoBan();
            row[2]=an.get(i).getPhuCap();
            row[3]=an.get(i).getPhuCapKhac();
            row[4]=an.get(i).getThang();
            row[5]=an.get(i).getNam();
            row[6]=an.get(i).getSoNgayCong();
            row[7]=an.get(i).getSoNgayNghi();
            row[8]=an.get(i).getSoGioLam();
            row[9]=an.get(i).getGhiChu();
            row[10]=an.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnDieuHanh = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lblHeader2 = new javax.swing.JLabel();
        lblMaNhanVienDH = new javax.swing.JLabel();
        cbxMaNhanVienDH = new javax.swing.JComboBox<>();
        lblGhiChuDH = new javax.swing.JLabel();
        txtGhiChuDH = new javax.swing.JTextField();
        lblPhuCapDH = new javax.swing.JLabel();
        txtPhuCapDH = new javax.swing.JTextField();
        lblLuongCoBanDH = new javax.swing.JLabel();
        txtLuongCoBanDH = new javax.swing.JTextField();
        lblNamDH = new javax.swing.JLabel();
        txtNamDH = new javax.swing.JTextField();
        lblThangDH = new javax.swing.JLabel();
        txtThangDH = new javax.swing.JTextField();
        lblSoNgayCongDH = new javax.swing.JLabel();
        txtSoNgayCongDH = new javax.swing.JTextField();
        lblSoNgayLamThemDH = new javax.swing.JLabel();
        txtSoNgayLamThemDH = new javax.swing.JTextField();
        lblSoNgayNghiDH = new javax.swing.JLabel();
        txtSoNgayNghiDH = new javax.swing.JTextField();
        lblPhuCapKhacDH = new javax.swing.JLabel();
        txtPhuCapKhacDH = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        lblHeader6 = new javax.swing.JLabel();
        btnThemDH = new javax.swing.JButton();
        btnSuaDH = new javax.swing.JButton();
        btnXoaDH = new javax.swing.JButton();
        btnMoiDH = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDH = new javax.swing.JTable();
        lblMaBoPhanDH = new javax.swing.JLabel();
        cbxMaBoPhanDH = new javax.swing.JComboBox<>();
        pnAnNinh = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblHeader5 = new javax.swing.JLabel();
        lblMaNhanVienAN = new javax.swing.JLabel();
        cbxMaNhanVienAN = new javax.swing.JComboBox<>();
        lblGhiChuAN = new javax.swing.JLabel();
        txtGhiChuAN = new javax.swing.JTextField();
        lblNamAN = new javax.swing.JLabel();
        txtNamAN = new javax.swing.JTextField();
        lblThangAN = new javax.swing.JLabel();
        txtThangAN = new javax.swing.JTextField();
        lblSoNgayCongAN = new javax.swing.JLabel();
        txtSoNgayCongAN = new javax.swing.JTextField();
        lblSoNgayLamThemAN = new javax.swing.JLabel();
        txtSoNgayLamThemAN = new javax.swing.JTextField();
        lblSoNgayNghiAN = new javax.swing.JLabel();
        txtSoNgayNghiAN = new javax.swing.JTextField();
        lblPhuCapKhacAN = new javax.swing.JLabel();
        txtPhuCapKhacAN = new javax.swing.JTextField();
        lblLuongCoBanAN = new javax.swing.JLabel();
        txtLuongCoBanAN = new javax.swing.JTextField();
        txtPhuCapAN = new javax.swing.JTextField();
        lblPhuCapAN = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        lblHeader9 = new javax.swing.JLabel();
        btnThemAN = new javax.swing.JButton();
        btnSuaAN = new javax.swing.JButton();
        btnXoaAN = new javax.swing.JButton();
        btnMoiAN = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAN = new javax.swing.JTable();
        lblMaBoPhanAN = new javax.swing.JLabel();
        cbxMaBoPhanAN = new javax.swing.JComboBox<>();
        pnlKiemKho = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        lblHeader4 = new javax.swing.JLabel();
        lblMaNhanVienKK = new javax.swing.JLabel();
        cbxMaNhanVienKK = new javax.swing.JComboBox<>();
        lblGhiChuKK = new javax.swing.JLabel();
        txtGhiChuKK = new javax.swing.JTextField();
        lblNamKK = new javax.swing.JLabel();
        txtNamKK = new javax.swing.JTextField();
        lblThangKK = new javax.swing.JLabel();
        txtThangKK = new javax.swing.JTextField();
        lblSoNgayCongKK = new javax.swing.JLabel();
        txtSoNgayCongKK = new javax.swing.JTextField();
        lblSoNgayLamThemKK = new javax.swing.JLabel();
        txtSoNgayLamThemKK = new javax.swing.JTextField();
        lblSoNgayNghiKK = new javax.swing.JLabel();
        txtSoNgayNghiKK = new javax.swing.JTextField();
        lblPhuCapKhacKK = new javax.swing.JLabel();
        txtPhuCapKhacKK = new javax.swing.JTextField();
        lblLuongCoBanKK = new javax.swing.JLabel();
        txtLuongCoBanKK = new javax.swing.JTextField();
        txtPhuCapKK = new javax.swing.JTextField();
        lblPhuCapKK = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lblHeader8 = new javax.swing.JLabel();
        btnThemKK = new javax.swing.JButton();
        btnSuaKK = new javax.swing.JButton();
        btnXoaKK = new javax.swing.JButton();
        btnMoiKK = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKK = new javax.swing.JTable();
        lblMaBoPhanKK = new javax.swing.JLabel();
        cbxMaBoPhanKK = new javax.swing.JComboBox<>();
        pnBanHang = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lblHeader3 = new javax.swing.JLabel();
        lblMaNhanVienBH = new javax.swing.JLabel();
        cbxMaNhanVienBH = new javax.swing.JComboBox<>();
        lblGhiChuBH = new javax.swing.JLabel();
        txtGhiChuBH = new javax.swing.JTextField();
        lblNamBH = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JTextField();
        lblThangBH = new javax.swing.JLabel();
        txtThangBH = new javax.swing.JTextField();
        lblSoNgayCongBH = new javax.swing.JLabel();
        txtSoNgayCongBH = new javax.swing.JTextField();
        lblSoNgayLamThemBH = new javax.swing.JLabel();
        txtSoNgayLamThemBH = new javax.swing.JTextField();
        lblSoNgayNghiBH = new javax.swing.JLabel();
        txtSoNgayNghiBH = new javax.swing.JTextField();
        lblLuongCoBanBH = new javax.swing.JLabel();
        txtLuongCoBanBH = new javax.swing.JTextField();
        lblPhuCapBH = new javax.swing.JLabel();
        txtPhuCapBH = new javax.swing.JTextField();
        lblMaBoPhanBH = new javax.swing.JLabel();
        cbxMaBoPhanBH = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lblHeader7 = new javax.swing.JLabel();
        btnThemBH = new javax.swing.JButton();
        BH = new javax.swing.JButton();
        btnXoaBH = new javax.swing.JButton();
        btnMoiBH = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblBH = new javax.swing.JTable();
        lblPhuCapKhacBH = new javax.swing.JLabel();
        txtPhuCapKhacBH = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(107, 195, 196));

        jPanel4.setBackground(new java.awt.Color(107, 195, 196));

        pnDieuHanh.setBackground(new java.awt.Color(254, 255, 250));
        pnDieuHanh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel10.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader2.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader2.setText("Thông tin về điều hành");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader2)
                .addContainerGap(758, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienDH.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienDH.setText("Mã nhân viên");

        cbxMaNhanVienDH.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienDH.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuDH.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuDH.setText("Ghi chú");

        txtGhiChuDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuDH.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuDH.setEnabled(false);
        txtGhiChuDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuDH.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuDHActionPerformed(evt);
            }
        });

        lblPhuCapDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapDH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapDH.setText("Phụ cấp*");

        txtPhuCapDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapDH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapDH.setEnabled(false);
        txtPhuCapDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapDHKeyPressed(evt);
            }
        });

        lblLuongCoBanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanDH.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanDH.setText("Lương cơ bản*");

        txtLuongCoBanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanDH.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanDH.setEnabled(false);
        txtLuongCoBanDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanDHKeyPressed(evt);
            }
        });

        lblNamDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamDH.setForeground(new java.awt.Color(3, 100, 117));
        lblNamDH.setText("Năm*");

        txtNamDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNamDH.setForeground(new java.awt.Color(3, 100, 117));
        txtNamDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtNamDH.setEnabled(false);
        txtNamDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtNamDH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangDH.setForeground(new java.awt.Color(3, 100, 117));
        lblThangDH.setText("Tháng*");

        txtThangDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangDH.setForeground(new java.awt.Color(3, 100, 117));
        txtThangDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangDH.setEnabled(false);
        txtThangDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangDH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongDH.setText("Số ngày công*");

        txtSoNgayCongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongDH.setText("30");
        txtSoNgayCongDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongDH.setEnabled(false);
        txtSoNgayCongDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongDHKeyPressed(evt);
            }
        });

        lblSoNgayLamThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemDH.setText("Số giờ làm thêm*");

        txtSoNgayLamThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemDH.setEnabled(false);
        txtSoNgayLamThemDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemDHKeyPressed(evt);
            }
        });

        lblSoNgayNghiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiDH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiDH.setText("Số ngày nghỉ*");

        txtSoNgayNghiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiDH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiDH.setEnabled(false);
        txtSoNgayNghiDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiDHKeyPressed(evt);
            }
        });

        lblPhuCapKhacDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacDH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacDH.setText("Phụ cấp khác*");

        txtPhuCapKhacDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacDH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacDH.setEnabled(false);
        txtPhuCapKhacDH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacDH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacDHKeyPressed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel13.setBackground(new java.awt.Color(254, 255, 250));
        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel14.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader6.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader6.setText("Chức năng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader6)
                .addContainerGap(821, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader6, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemDH.setBackground(new java.awt.Color(3, 100, 117));
        btnThemDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemDH.setForeground(new java.awt.Color(107, 195, 196));
        btnThemDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemDH.setText("Thêm");
        btnThemDH.setBorder(null);
        btnThemDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemDH.setEnabled(false);
        btnThemDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDHActionPerformed(evt);
            }
        });

        btnSuaDH.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaDH.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaDH.setText("Sửa");
        btnSuaDH.setBorder(null);
        btnSuaDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaDH.setEnabled(false);
        btnSuaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDHActionPerformed(evt);
            }
        });

        btnXoaDH.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaDH.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaDH.setText("Xoá");
        btnXoaDH.setBorder(null);
        btnXoaDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaDH.setEnabled(false);
        btnXoaDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDHActionPerformed(evt);
            }
        });

        btnMoiDH.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiDH.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiDH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiDH.setText("Mới");
        btnMoiDH.setBorder(null);
        btnMoiDH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiDHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblDH.setBackground(new java.awt.Color(254, 255, 250));
        tblDH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblDH.setForeground(new java.awt.Color(3, 100, 117));
        tblDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDH.setGridColor(new java.awt.Color(3, 100, 117));
        tblDH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDH);

        lblMaBoPhanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBoPhanDH.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBoPhanDH.setText("Mã bộ phận");

        cbxMaBoPhanDH.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaBoPhanDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaBoPhanDH.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaBoPhanDH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        javax.swing.GroupLayout pnDieuHanhLayout = new javax.swing.GroupLayout(pnDieuHanh);
        pnDieuHanh.setLayout(pnDieuHanhLayout);
        pnDieuHanhLayout.setHorizontalGroup(
            pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDieuHanhLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnDieuHanhLayout.createSequentialGroup()
                        .addComponent(lblLuongCoBanDH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLuongCoBanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addComponent(lblMaNhanVienDH)
                        .addGap(32, 32, 32)
                        .addComponent(cbxMaNhanVienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPhuCapDH)
                            .addComponent(lblMaBoPhanDH))
                        .addGap(42, 42, 42)
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaBoPhanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuCapDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGhiChuDH)
                    .addComponent(lblPhuCapKhacDH)
                    .addComponent(lblNamDH)
                    .addComponent(lblThangDH))
                .addGap(18, 18, 18)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuCapKhacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnDieuHanhLayout.createSequentialGroup()
                                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemDH)
                                    .addComponent(lblSoNgayCongDH))
                                .addGap(18, 18, 18)
                                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnDieuHanhLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiDH)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtGhiChuDH, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnDieuHanhLayout.setVerticalGroup(
            pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDieuHanhLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThangDH)
                            .addComponent(txtSoNgayLamThemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayLamThemDH))
                        .addGap(18, 18, 18)
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamDH)
                            .addComponent(txtSoNgayCongDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayCongDH)
                            .addComponent(txtLuongCoBanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLuongCoBanDH)))
                    .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienDH)))
                .addGap(18, 18, 18)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhuCapDH)
                        .addComponent(txtPhuCapDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhuCapKhacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKhacDH)
                        .addComponent(lblSoNgayNghiDH))
                    .addComponent(txtSoNgayNghiDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGhiChuDH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGhiChuDH))
                    .addComponent(lblMaBoPhanDH)
                    .addComponent(cbxMaBoPhanDH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(" Điều hành", pnDieuHanh);

        pnAnNinh.setBackground(new java.awt.Color(254, 255, 250));
        pnAnNinh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel12.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader5.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader5.setText("Thông tin an ninh");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader5, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienAN.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienAN.setText("Mã nhân viên");

        cbxMaNhanVienAN.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienAN.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuAN.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuAN.setText("Ghi chú");

        txtGhiChuAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuAN.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuAN.setEnabled(false);
        txtGhiChuAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuAN.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuANActionPerformed(evt);
            }
        });

        lblNamAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamAN.setForeground(new java.awt.Color(3, 100, 117));
        lblNamAN.setText("Năm*");

        txtNamAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNamAN.setForeground(new java.awt.Color(3, 100, 117));
        txtNamAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtNamAN.setEnabled(false);
        txtNamAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtNamAN.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangAN.setForeground(new java.awt.Color(3, 100, 117));
        lblThangAN.setText("Tháng*");

        txtThangAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangAN.setForeground(new java.awt.Color(3, 100, 117));
        txtThangAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangAN.setEnabled(false);
        txtThangAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangAN.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongAN.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongAN.setText("Số ngày công*");

        txtSoNgayCongAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongAN.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongAN.setText("30");
        txtSoNgayCongAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongAN.setEnabled(false);
        txtSoNgayCongAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongANKeyPressed(evt);
            }
        });

        lblSoNgayLamThemAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemAN.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemAN.setText("Số giờ làm thêm*");

        txtSoNgayLamThemAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemAN.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemAN.setEnabled(false);
        txtSoNgayLamThemAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemANKeyPressed(evt);
            }
        });

        lblSoNgayNghiAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiAN.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiAN.setText("Số ngày nghỉ*");

        txtSoNgayNghiAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiAN.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiAN.setEnabled(false);
        txtSoNgayNghiAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiANKeyPressed(evt);
            }
        });

        lblPhuCapKhacAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacAN.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacAN.setText("Phụ cấp khác*");

        txtPhuCapKhacAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacAN.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacAN.setEnabled(false);
        txtPhuCapKhacAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacANKeyPressed(evt);
            }
        });

        lblLuongCoBanAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanAN.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanAN.setText("Lương cơ bản*");

        txtLuongCoBanAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanAN.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanAN.setEnabled(false);
        txtLuongCoBanAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanANKeyPressed(evt);
            }
        });

        txtPhuCapAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapAN.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapAN.setEnabled(false);
        txtPhuCapAN.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapAN.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapANKeyPressed(evt);
            }
        });

        lblPhuCapAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapAN.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapAN.setText("Phụ cấp*");

        jPanel19.setBackground(new java.awt.Color(254, 255, 250));
        jPanel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel20.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader9.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader9.setText("Chức năng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader9, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemAN.setBackground(new java.awt.Color(3, 100, 117));
        btnThemAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemAN.setForeground(new java.awt.Color(107, 195, 196));
        btnThemAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemAN.setText("Thêm");
        btnThemAN.setBorder(null);
        btnThemAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemAN.setEnabled(false);
        btnThemAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemANActionPerformed(evt);
            }
        });

        btnSuaAN.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaAN.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaAN.setText("Sửa");
        btnSuaAN.setBorder(null);
        btnSuaAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaAN.setEnabled(false);
        btnSuaAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaANActionPerformed(evt);
            }
        });

        btnXoaAN.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaAN.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaAN.setText("Xoá");
        btnXoaAN.setBorder(null);
        btnXoaAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaAN.setEnabled(false);
        btnXoaAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaANActionPerformed(evt);
            }
        });

        btnMoiAN.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiAN.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiAN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiAN.setText("Mới");
        btnMoiAN.setBorder(null);
        btnMoiAN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiANActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiAN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemAN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaAN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaAN, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemAN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaAN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaAN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiAN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator5.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblAN.setBackground(new java.awt.Color(254, 255, 250));
        tblAN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblAN.setForeground(new java.awt.Color(3, 100, 117));
        tblAN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAN.setGridColor(new java.awt.Color(3, 100, 117));
        tblAN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblANMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblAN);

        lblMaBoPhanAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBoPhanAN.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBoPhanAN.setText("Mã bộ phận");

        cbxMaBoPhanAN.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaBoPhanAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaBoPhanAN.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaBoPhanAN.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        javax.swing.GroupLayout pnAnNinhLayout = new javax.swing.GroupLayout(pnAnNinh);
        pnAnNinh.setLayout(pnAnNinhLayout);
        pnAnNinhLayout.setHorizontalGroup(
            pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator5)
            .addGroup(pnAnNinhLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLuongCoBanAN)
                            .addComponent(lblPhuCapAN)
                            .addComponent(lblMaNhanVienAN))
                        .addGap(18, 18, 18)
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxMaNhanVienAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhuCapAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongCoBanAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addComponent(lblMaBoPhanAN)
                        .addGap(42, 42, 42)
                        .addComponent(cbxMaBoPhanAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                                .addComponent(lblThangAN)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                                .addComponent(lblNamAN)
                                .addGap(79, 79, 79)
                                .addComponent(txtNamAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                                .addComponent(lblPhuCapKhacAN)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapKhacAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnAnNinhLayout.createSequentialGroup()
                                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemAN)
                                    .addComponent(lblSoNgayCongAN))
                                .addGap(18, 18, 18)
                                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongAN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnAnNinhLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiAN)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiAN, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addComponent(lblGhiChuAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGhiChuAN, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnAnNinhLayout.setVerticalGroup(
            pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThangAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoNgayLamThemAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayLamThemAN))
                        .addGap(18, 18, 18)
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoNgayCongAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoNgayCongAN)
                            .addComponent(txtLuongCoBanAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLuongCoBanAN)
                            .addComponent(lblNamAN))
                        .addGap(18, 18, 18)
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoNgayNghiAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPhuCapKhacAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhuCapKhacAN)
                                .addComponent(lblSoNgayNghiAN)
                                .addComponent(txtPhuCapAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPhuCapAN))))
                    .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienAN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienAN)
                        .addComponent(lblThangAN)))
                .addGap(18, 18, 18)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaBoPhanAN)
                    .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGhiChuAN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGhiChuAN)
                        .addComponent(cbxMaBoPhanAN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("An ninh", pnAnNinh);

        pnlKiemKho.setBackground(new java.awt.Color(254, 255, 250));
        pnlKiemKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel11.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader4.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader4.setText("Thông tin kiểm kho");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienKK.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienKK.setText("Mã nhân viên");

        cbxMaNhanVienKK.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienKK.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuKK.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuKK.setText("Ghi chú");

        txtGhiChuKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuKK.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuKK.setEnabled(false);
        txtGhiChuKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuKK.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuKKActionPerformed(evt);
            }
        });

        lblNamKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamKK.setForeground(new java.awt.Color(3, 100, 117));
        lblNamKK.setText("Năm*");

        txtNamKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNamKK.setForeground(new java.awt.Color(3, 100, 117));
        txtNamKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtNamKK.setEnabled(false);
        txtNamKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtNamKK.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangKK.setForeground(new java.awt.Color(3, 100, 117));
        lblThangKK.setText("Tháng*");

        txtThangKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangKK.setForeground(new java.awt.Color(3, 100, 117));
        txtThangKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangKK.setEnabled(false);
        txtThangKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangKK.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongKK.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongKK.setText("Số ngày công*");

        txtSoNgayCongKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongKK.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongKK.setText("30");
        txtSoNgayCongKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongKK.setEnabled(false);
        txtSoNgayCongKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongKKKeyPressed(evt);
            }
        });

        lblSoNgayLamThemKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemKK.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemKK.setText("Số giờ làm thêm*");

        txtSoNgayLamThemKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemKK.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemKK.setEnabled(false);
        txtSoNgayLamThemKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemKKKeyPressed(evt);
            }
        });

        lblSoNgayNghiKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiKK.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiKK.setText("Số ngày nghỉ*");

        txtSoNgayNghiKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiKK.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiKK.setEnabled(false);
        txtSoNgayNghiKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiKKKeyPressed(evt);
            }
        });

        lblPhuCapKhacKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacKK.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacKK.setText("Phụ cấp khác*");

        txtPhuCapKhacKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacKK.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacKK.setEnabled(false);
        txtPhuCapKhacKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacKKKeyPressed(evt);
            }
        });

        lblLuongCoBanKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanKK.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanKK.setText("Lương cơ bản*");

        txtLuongCoBanKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanKK.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanKK.setEnabled(false);
        txtLuongCoBanKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanKKKeyPressed(evt);
            }
        });

        txtPhuCapKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKK.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKK.setEnabled(false);
        txtPhuCapKK.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKK.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKKKeyPressed(evt);
            }
        });

        lblPhuCapKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKK.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKK.setText("Phụ cấp*");

        jPanel17.setBackground(new java.awt.Color(254, 255, 250));
        jPanel17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));
        jPanel17.setEnabled(false);

        jPanel18.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader8.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader8.setText("Chức năng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader8, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemKK.setBackground(new java.awt.Color(3, 100, 117));
        btnThemKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemKK.setForeground(new java.awt.Color(107, 195, 196));
        btnThemKK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemKK.setText("Thêm");
        btnThemKK.setBorder(null);
        btnThemKK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemKK.setEnabled(false);
        btnThemKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKKActionPerformed(evt);
            }
        });

        btnSuaKK.setBackground(new java.awt.Color(3, 100, 117));
        btnSuaKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSuaKK.setForeground(new java.awt.Color(107, 195, 196));
        btnSuaKK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        btnSuaKK.setText("Sửa");
        btnSuaKK.setBorder(null);
        btnSuaKK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuaKK.setEnabled(false);
        btnSuaKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKKActionPerformed(evt);
            }
        });

        btnXoaKK.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaKK.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaKK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaKK.setText("Xoá");
        btnXoaKK.setBorder(null);
        btnXoaKK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaKK.setEnabled(false);
        btnXoaKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKKActionPerformed(evt);
            }
        });

        btnMoiKK.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiKK.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiKK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiKK.setText("Mới");
        btnMoiKK.setBorder(null);
        btnMoiKK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiKK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiKKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiKK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemKK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnSuaKK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaKK, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemKK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaKK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaKK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiKK, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator4.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblKK.setBackground(new java.awt.Color(254, 255, 250));
        tblKK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblKK.setForeground(new java.awt.Color(3, 100, 117));
        tblKK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số ngày làm thêm", "Ghi chú", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKK.setGridColor(new java.awt.Color(3, 100, 117));
        tblKK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKKMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblKK);

        lblMaBoPhanKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBoPhanKK.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBoPhanKK.setText("Mã bộ phận");

        cbxMaBoPhanKK.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaBoPhanKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaBoPhanKK.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaBoPhanKK.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        javax.swing.GroupLayout pnlKiemKhoLayout = new javax.swing.GroupLayout(pnlKiemKho);
        pnlKiemKho.setLayout(pnlKiemKhoLayout);
        pnlKiemKhoLayout.setHorizontalGroup(
            pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbxMaNhanVienKK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPhuCapKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                            .addComponent(lblLuongCoBanKK)
                            .addGap(18, 18, 18)
                            .addComponent(txtLuongCoBanKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblPhuCapKK)
                        .addComponent(lblMaNhanVienKK))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createSequentialGroup()
                        .addComponent(lblMaBoPhanKK)
                        .addGap(42, 42, 42)
                        .addComponent(cbxMaBoPhanKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                        .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createSequentialGroup()
                                .addComponent(lblThangKK)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createSequentialGroup()
                                .addComponent(lblNamKK)
                                .addGap(79, 79, 79)
                                .addComponent(txtNamKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createSequentialGroup()
                                .addComponent(lblPhuCapKhacKK)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapKhacKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemKK)
                                    .addComponent(lblSoNgayCongKK))
                                .addGap(18, 18, 18)
                                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemKK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongKK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiKK)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiKK, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlKiemKhoLayout.createSequentialGroup()
                        .addComponent(lblGhiChuKK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGhiChuKK, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        pnlKiemKhoLayout.setVerticalGroup(
            pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtThangKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSoNgayLamThemKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayLamThemKK))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblThangKK)
                        .addComponent(lblMaNhanVienKK)))
                .addGap(18, 18, 18)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoNgayCongKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSoNgayCongKK)
                    .addComponent(txtLuongCoBanKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLuongCoBanKK)
                    .addComponent(lblNamKK))
                .addGap(18, 18, 18)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgayNghiKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhuCapKhacKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKhacKK)
                        .addComponent(lblSoNgayNghiKK)
                        .addComponent(txtPhuCapKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKK)))
                .addGap(18, 18, 18)
                .addGroup(pnlKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGhiChuKK, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGhiChuKK)
                    .addComponent(lblMaBoPhanKK)
                    .addComponent(cbxMaBoPhanKK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kiểm kho", pnlKiemKho);

        pnBanHang.setBackground(new java.awt.Color(254, 255, 250));
        pnBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jPanel9.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader3.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader3.setText("Thông tin về bán hàng");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(lblHeader3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader3, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        lblMaNhanVienBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaNhanVienBH.setForeground(new java.awt.Color(3, 100, 117));
        lblMaNhanVienBH.setText("Mã nhân viên");

        cbxMaNhanVienBH.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaNhanVienBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaNhanVienBH.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaNhanVienBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        lblGhiChuBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblGhiChuBH.setForeground(new java.awt.Color(3, 100, 117));
        lblGhiChuBH.setText("Ghi chú");

        txtGhiChuBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtGhiChuBH.setForeground(new java.awt.Color(3, 100, 117));
        txtGhiChuBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtGhiChuBH.setEnabled(false);
        txtGhiChuBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtGhiChuBH.setPreferredSize(new java.awt.Dimension(3, 26));
        txtGhiChuBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhiChuBHActionPerformed(evt);
            }
        });

        lblNamBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblNamBH.setForeground(new java.awt.Color(3, 100, 117));
        lblNamBH.setText("Năm*");

        txtNamBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtNamBH.setForeground(new java.awt.Color(3, 100, 117));
        txtNamBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtNamBH.setEnabled(false);
        txtNamBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtNamBH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblThangBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblThangBH.setForeground(new java.awt.Color(3, 100, 117));
        lblThangBH.setText("Tháng*");

        txtThangBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtThangBH.setForeground(new java.awt.Color(3, 100, 117));
        txtThangBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtThangBH.setEnabled(false);
        txtThangBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtThangBH.setPreferredSize(new java.awt.Dimension(36, 28));

        lblSoNgayCongBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayCongBH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayCongBH.setText("Số ngày công*");

        txtSoNgayCongBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayCongBH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayCongBH.setText("30");
        txtSoNgayCongBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayCongBH.setEnabled(false);
        txtSoNgayCongBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayCongBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayCongBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayCongBHKeyPressed(evt);
            }
        });

        lblSoNgayLamThemBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayLamThemBH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayLamThemBH.setText("Số giờ làm thêm*");

        txtSoNgayLamThemBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayLamThemBH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayLamThemBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayLamThemBH.setEnabled(false);
        txtSoNgayLamThemBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayLamThemBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayLamThemBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayLamThemBHKeyPressed(evt);
            }
        });

        lblSoNgayNghiBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblSoNgayNghiBH.setForeground(new java.awt.Color(3, 100, 117));
        lblSoNgayNghiBH.setText("Số ngày nghỉ*");

        txtSoNgayNghiBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtSoNgayNghiBH.setForeground(new java.awt.Color(3, 100, 117));
        txtSoNgayNghiBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtSoNgayNghiBH.setEnabled(false);
        txtSoNgayNghiBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtSoNgayNghiBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtSoNgayNghiBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoNgayNghiBHKeyPressed(evt);
            }
        });

        lblLuongCoBanBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblLuongCoBanBH.setForeground(new java.awt.Color(3, 100, 117));
        lblLuongCoBanBH.setText("Lương cơ bản*");

        txtLuongCoBanBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtLuongCoBanBH.setForeground(new java.awt.Color(3, 100, 117));
        txtLuongCoBanBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtLuongCoBanBH.setEnabled(false);
        txtLuongCoBanBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtLuongCoBanBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtLuongCoBanBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCoBanBHKeyPressed(evt);
            }
        });

        lblPhuCapBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapBH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapBH.setText("Phụ cấp *");

        txtPhuCapBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapBH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapBH.setEnabled(false);
        txtPhuCapBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapBHKeyPressed(evt);
            }
        });

        lblMaBoPhanBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMaBoPhanBH.setForeground(new java.awt.Color(3, 100, 117));
        lblMaBoPhanBH.setText("Mã Bộ Phận");

        cbxMaBoPhanBH.setBackground(new java.awt.Color(107, 195, 196));
        cbxMaBoPhanBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbxMaBoPhanBH.setForeground(new java.awt.Color(3, 100, 117));
        cbxMaBoPhanBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        jPanel15.setBackground(new java.awt.Color(254, 255, 250));
        jPanel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(107, 195, 196)));

        jPanel16.setBackground(new java.awt.Color(3, 100, 117));

        lblHeader7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblHeader7.setForeground(new java.awt.Color(254, 255, 250));
        lblHeader7.setText("Chức năng");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(lblHeader7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader7, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btnThemBH.setBackground(new java.awt.Color(3, 100, 117));
        btnThemBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnThemBH.setForeground(new java.awt.Color(107, 195, 196));
        btnThemBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnThemBH.setText("Thêm");
        btnThemBH.setBorder(null);
        btnThemBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemBH.setEnabled(false);
        btnThemBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBHActionPerformed(evt);
            }
        });

        BH.setBackground(new java.awt.Color(3, 100, 117));
        BH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        BH.setForeground(new java.awt.Color(107, 195, 196));
        BH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/edit.png"))); // NOI18N
        BH.setText("Sửa");
        BH.setBorder(null);
        BH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BH.setEnabled(false);
        BH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHActionPerformed(evt);
            }
        });

        btnXoaBH.setBackground(new java.awt.Color(3, 100, 117));
        btnXoaBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnXoaBH.setForeground(new java.awt.Color(107, 195, 196));
        btnXoaBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/remove-user.png"))); // NOI18N
        btnXoaBH.setText("Xoá");
        btnXoaBH.setBorder(null);
        btnXoaBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaBH.setEnabled(false);
        btnXoaBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBHActionPerformed(evt);
            }
        });

        btnMoiBH.setBackground(new java.awt.Color(3, 100, 117));
        btnMoiBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnMoiBH.setForeground(new java.awt.Color(107, 195, 196));
        btnMoiBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/add-group.png"))); // NOI18N
        btnMoiBH.setText("Mới");
        btnMoiBH.setBorder(null);
        btnMoiBH.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiBHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMoiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnThemBH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btnXoaBH, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemBH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaBH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator3.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblBH.setBackground(new java.awt.Color(254, 255, 250));
        tblBH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblBH.setForeground(new java.awt.Color(3, 100, 117));
        tblBH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Ghi chú", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBH.setGridColor(new java.awt.Color(3, 100, 117));
        tblBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBHMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblBH);

        lblPhuCapKhacBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblPhuCapKhacBH.setForeground(new java.awt.Color(3, 100, 117));
        lblPhuCapKhacBH.setText("Phụ cấp khác*");

        txtPhuCapKhacBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtPhuCapKhacBH.setForeground(new java.awt.Color(3, 100, 117));
        txtPhuCapKhacBH.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));
        txtPhuCapKhacBH.setEnabled(false);
        txtPhuCapKhacBH.setMinimumSize(new java.awt.Dimension(3, 26));
        txtPhuCapKhacBH.setPreferredSize(new java.awt.Dimension(36, 28));
        txtPhuCapKhacBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapKhacBHKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
        pnBanHang.setLayout(pnBanHangLayout);
        pnBanHangLayout.setHorizontalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLuongCoBanBH)
                            .addComponent(lblMaBoPhanBH)
                            .addComponent(lblMaNhanVienBH))
                        .addGap(18, 18, 18)
                        .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxMaBoPhanBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaNhanVienBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLuongCoBanBH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addComponent(lblPhuCapKhacBH, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPhuCapKhacBH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addComponent(lblGhiChuBH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGhiChuBH, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnBanHangLayout.createSequentialGroup()
                                .addComponent(lblThangBH)
                                .addGap(66, 66, 66)
                                .addComponent(txtThangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addComponent(lblNamBH)
                                .addGap(79, 79, 79)
                                .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addComponent(lblPhuCapBH, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPhuCapBH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSoNgayLamThemBH)
                                    .addComponent(lblSoNgayCongBH))
                                .addGap(18, 18, 18)
                                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoNgayLamThemBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNgayCongBH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addComponent(lblSoNgayNghiBH)
                                .addGap(40, 40, 40)
                                .addComponent(txtSoNgayNghiBH, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBanHangLayout.setVerticalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBanHangLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoNgayLamThemBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayLamThemBH))
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaNhanVienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaNhanVienBH)
                        .addComponent(lblThangBH)
                        .addComponent(txtThangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoNgayCongBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSoNgayCongBH))
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMaBoPhanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaBoPhanBH)
                        .addComponent(lblNamBH)))
                .addGap(18, 18, 18)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoNgayNghiBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSoNgayNghiBH)
                        .addComponent(txtPhuCapBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapBH)
                        .addComponent(txtLuongCoBanBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLuongCoBanBH)))
                .addGap(18, 18, 18)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPhuCapKhacBH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPhuCapKhacBH))
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGhiChuBH, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGhiChuBH)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bán hàng", pnBanHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtGhiChuBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuBHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuBHActionPerformed

    private void txtSoNgayCongBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongBHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayCongBH.setEditable(false);
        else txtSoNgayCongBH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayCongBHKeyPressed

    private void txtSoNgayLamThemBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemBHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayLamThemBH.setEditable(false);
        else txtSoNgayLamThemBH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayLamThemBHKeyPressed

    private void txtSoNgayNghiBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiBHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayNghiBH.setEditable(false);
        else txtSoNgayNghiBH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayNghiBHKeyPressed

    private void txtLuongCoBanBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanBHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtLuongCoBanBH.setEditable(false);
        else txtLuongCoBanBH.setEditable(true);
    }//GEN-LAST:event_txtLuongCoBanBHKeyPressed

    private void txtPhuCapBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapBHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapBH.setEditable(false);
        else txtPhuCapBH.setEditable(true);
    }//GEN-LAST:event_txtPhuCapBHKeyPressed

    private void btnThemBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBHActionPerformed
        // TODO add your handling code here:
        BangCongBanHangBUS.Them(cbxMaNhanVienBH.getSelectedItem().toString(), txtLuongCoBanBH.getText(), txtPhuCapBH.getText(), 
                txtPhuCapKhacBH.getText(), txtThangBH.getText(), txtNamBH.getText(),txtSoNgayCongBH.getText(), 
                txtSoNgayNghiBH.getText(), txtSoNgayLamThemBH.getText(), txtGhiChuBH.getText(), cbxMaBoPhanBH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        showBH();
    }//GEN-LAST:event_btnThemBHActionPerformed

    private void BHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHActionPerformed
        // TODO add your handling code here:
        BangCongBanHangBUS.Sua(txtLuongCoBanBH.getText(), txtPhuCapBH.getText(), txtPhuCapBH.getText(), txtThangBH.getText(), 
                txtNamBH.getText(),txtSoNgayCongBH.getText(), txtSoNgayNghiBH.getText(), txtSoNgayLamThemBH.getText(), 
                txtGhiChuBH.getText(), cbxMaBoPhanBH.getSelectedItem().toString(), cbxMaNhanVienBH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        showBH();
    }//GEN-LAST:event_BHActionPerformed

    private void btnXoaBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBHActionPerformed
        // TODO add your handling code here:
        BangCongBanHangBUS.Xoa(cbxMaNhanVienBH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblBH.getModel();
        model.setRowCount(0);
        showBH();
    }//GEN-LAST:event_btnXoaBHActionPerformed

    private void btnMoiBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiBHActionPerformed
        // TODO add your handling code here:
//        cbxMaNhanVienBH.removeAllItems();
//        BangCongBanHangBUS.getCBboxMaNV(cbxMaNhanVienBH);
        
        txtLuongCoBanBH.setEnabled(true);
        txtPhuCapBH.setEnabled(true);
        txtPhuCapKhacBH.setEnabled(true);
        txtThangBH.setEnabled(true);
        txtNamBH.setEnabled(true);
        txtSoNgayCongBH.setEnabled(true);
        txtSoNgayNghiBH.setEnabled(true);
        txtSoNgayLamThemBH.setEnabled(true);
        txtGhiChuBH.setEnabled(true);
        //cbxMaBoPhanBH.setEnabled(true);
        btnThemBH.setEnabled(true);
        btnXoaBH.setEnabled(false);
        BH.setEnabled(false);
        
        //cbxMaNhanVienBH.setSelectedIndex(0);
        txtLuongCoBanBH.setText("");
        txtPhuCapBH.setText("");
        txtPhuCapKhacBH.setText("");
        txtThangBH.setText(dateFormat.format(dateBH));
        txtNamBH.setText(dateFormatY.format(dateBH));
        txtSoNgayCongBH.setText("30");
        txtSoNgayNghiBH.setText("");
        txtSoNgayLamThemBH.setText("");
        txtGhiChuBH.setText("");
        //cbxMaBoPhanBH.setSelectedIndex(0);
        String maNV = cbxMaNhanVienBH.getSelectedItem().toString();
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaBoPhan FROM dbo.TblTTNKKoBan WHERE MaNV='"+maNV+"'";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                String mabp = rs.getString("MaBoPhan");             
                cbxMaBoPhanBH.setSelectedItem(mabp);           
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
    }//GEN-LAST:event_btnMoiBHActionPerformed

    private void tblBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBHMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienBH.removeAllItems();
        BangCongBanHangBUS.getCBboxMaNVTb(cbxMaNhanVienBH);
        
        txtLuongCoBanBH.setEnabled(true);
        txtPhuCapBH.setEnabled(true);
        txtPhuCapKhacBH.setEnabled(true);
        txtThangBH.setEnabled(true);
        txtNamBH.setEnabled(true);
        txtSoNgayCongBH.setEnabled(true);
        txtSoNgayNghiBH.setEnabled(true);
        txtSoNgayLamThemBH.setEnabled(true);
        txtGhiChuBH.setEnabled(true);
        //cbxMaBoPhanBH.setEnabled(true);
        btnThemBH.setEnabled(true);
        btnXoaBH.setEnabled(true);
        BH.setEnabled(true);
        
        int i = tblBH.getSelectedRow();
        cbxMaNhanVienBH.setSelectedItem(modelBH.getValueAt(i, 0).toString());
        txtLuongCoBanBH.setText(modelBH.getValueAt(i, 1).toString());
        txtPhuCapBH.setText(modelBH.getValueAt(i, 2).toString());
        txtPhuCapKhacBH.setText(modelBH.getValueAt(i, 3).toString() );
        txtThangBH.setText(modelBH.getValueAt(i, 4).toString());
        txtNamBH.setText(modelBH.getValueAt(i, 5).toString());
        txtSoNgayCongBH.setText(modelBH.getValueAt(i, 6).toString());
        txtSoNgayNghiBH.setText(modelBH.getValueAt(i, 7).toString());
        txtSoNgayLamThemBH.setText(modelBH.getValueAt(i, 8).toString());
        txtGhiChuBH.setText(modelBH.getValueAt(i, 9).toString());
        cbxMaBoPhanBH.setSelectedItem(modelBH.getValueAt(i, 10).toString());
    }//GEN-LAST:event_tblBHMouseClicked

    private void txtGhiChuDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuDHActionPerformed

    private void txtPhuCapDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapDH.setEditable(false);
        else txtPhuCapDH.setEditable(true);
    }//GEN-LAST:event_txtPhuCapDHKeyPressed

    private void txtLuongCoBanDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtLuongCoBanDH.setEditable(false);
        else txtLuongCoBanDH.setEditable(true);
    }//GEN-LAST:event_txtLuongCoBanDHKeyPressed

    private void txtSoNgayCongDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayCongDH.setEditable(false);
        else txtSoNgayCongDH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayCongDHKeyPressed

    private void txtSoNgayLamThemDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayLamThemDH.setEditable(false);
        else txtSoNgayLamThemDH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayLamThemDHKeyPressed

    private void txtSoNgayNghiDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayNghiDH.setEditable(false);
        else txtSoNgayNghiDH.setEditable(true);
    }//GEN-LAST:event_txtSoNgayNghiDHKeyPressed

    private void txtPhuCapKhacDHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacDHKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapKhacDH.setEditable(false);
        else txtPhuCapKhacDH.setEditable(true);
    }//GEN-LAST:event_txtPhuCapKhacDHKeyPressed

    private void btnThemDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDHActionPerformed
        // TODO add your handling code here:
        BangCongDieuHanhBUS.Them(cbxMaNhanVienDH.getSelectedItem().toString(), txtLuongCoBanDH.getText(), txtPhuCapDH.getText(), 
                txtPhuCapKhacDH.getText(), txtThangDH.getText(), txtNamDH.getText(), txtSoNgayCongDH.getText(), txtSoNgayNghiDH.getText(), 
                txtSoNgayLamThemDH.getText(), txtGhiChuDH.getText(), cbxMaBoPhanDH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnThemDHActionPerformed

    private void btnSuaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDHActionPerformed
        // TODO add your handling code here:
        BangCongDieuHanhBUS.Sua(txtLuongCoBanDH.getText(), txtPhuCapDH.getText(), txtPhuCapKhacDH.getText(), txtThangDH.getText(),
                txtNamDH.getText(), txtSoNgayCongDH.getText(), txtSoNgayNghiDH.getText(), txtSoNgayLamThemDH.getText(), 
                txtGhiChuDH.getText(), cbxMaBoPhanDH.getSelectedItem().toString(), cbxMaNhanVienDH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnSuaDHActionPerformed

    private void btnXoaDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDHActionPerformed
        // TODO add your handling code here:
        BangCongDieuHanhBUS.Xoa(cbxMaNhanVienDH.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblDH.getModel();
        model.setRowCount(0);
        showDH();
    }//GEN-LAST:event_btnXoaDHActionPerformed

    private void btnMoiDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiDHActionPerformed
        // TODO add your handling code here:
//        cbxMaNhanVienDH.removeAllItems();
//        BangCongDieuHanhBUS.getCBboxMaNV(cbxMaNhanVienDH);
        
        txtLuongCoBanDH.setEnabled(true);
        txtPhuCapDH.setEnabled(true);
        txtPhuCapKhacDH.setEnabled(true);
        txtThangDH.setEnabled(true);
        txtNamDH.setEnabled(true);
        txtSoNgayCongDH.setEnabled(true);
        txtSoNgayNghiDH.setEnabled(true);
        txtSoNgayLamThemDH.setEnabled(true);
        txtGhiChuDH.setEnabled(true);
        btnThemDH.setEnabled(true);
        btnXoaDH.setEnabled(false);
        btnSuaDH.setEnabled(false);
        
        //cbxMaNhanVienDH.setSelectedIndex(0);
        txtLuongCoBanDH.setText("");
        txtPhuCapDH.setText("");
        txtPhuCapKhacDH.setText("");
        txtThangDH.setText(dateFormat.format(dateDH));
        txtNamDH.setText(dateFormatY.format(dateDH));
        txtSoNgayCongDH.setText("30");
        txtSoNgayNghiDH.setText("");
        txtSoNgayLamThemDH.setText("");
        txtGhiChuDH.setText("");
//        cbxMaBoPhanDH.setSelectedIndex(0);
        String maNV = cbxMaNhanVienDH.getSelectedItem().toString();
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaBoPhan FROM dbo.TblTTNVCoBan WHERE MaNV='"+maNV+"'";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                String mabp = rs.getString("MaBoPhan");             
                cbxMaBoPhanDH.setSelectedItem(mabp);           
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
    }//GEN-LAST:event_btnMoiDHActionPerformed

    private void tblDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDHMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienDH.removeAllItems();
        BangCongDieuHanhBUS.getCBboxMaNVTb(cbxMaNhanVienDH);
        
        txtLuongCoBanDH.setEnabled(true);
        txtPhuCapDH.setEnabled(true);
        txtPhuCapKhacDH.setEnabled(true);
        txtThangDH.setEnabled(true);
        txtNamDH.setEnabled(true);
        txtSoNgayCongDH.setEnabled(true);
        txtSoNgayNghiDH.setEnabled(true);
        txtSoNgayLamThemDH.setEnabled(true);
        txtGhiChuDH.setEnabled(true);
        btnThemDH.setEnabled(true);
        btnXoaDH.setEnabled(true);
        btnSuaDH.setEnabled(true);
        
        int i = tblDH.getSelectedRow();
        cbxMaNhanVienDH.setSelectedItem(modelDH.getValueAt(i, 0).toString());
        txtLuongCoBanDH.setText(modelDH.getValueAt(i, 1).toString());
        txtPhuCapDH.setText(modelDH.getValueAt(i, 2).toString());
        txtPhuCapKhacDH.setText(modelDH.getValueAt(i, 3).toString());
        txtThangDH.setText(modelDH.getValueAt(i, 4).toString());
        txtNamDH.setText(modelDH.getValueAt(i, 5).toString());
        txtSoNgayCongDH.setText(modelDH.getValueAt(i, 6).toString());
        txtSoNgayNghiDH.setText(modelDH.getValueAt(i, 7).toString());
        txtSoNgayLamThemDH.setText(modelDH.getValueAt(i, 8).toString());
        txtGhiChuDH.setText(modelDH.getValueAt(i, 9).toString());
        cbxMaBoPhanDH.setSelectedItem(modelDH.getValueAt(i, 10).toString());
    }//GEN-LAST:event_tblDHMouseClicked

    private void txtGhiChuANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuANActionPerformed

    private void txtSoNgayCongANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayCongAN.setEditable(false);
        else txtSoNgayCongAN.setEditable(true);
    }//GEN-LAST:event_txtSoNgayCongANKeyPressed

    private void txtSoNgayLamThemANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayLamThemAN.setEditable(false);
        else txtSoNgayLamThemAN.setEditable(true);
    }//GEN-LAST:event_txtSoNgayLamThemANKeyPressed

    private void txtSoNgayNghiANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayNghiAN.setEditable(false);
        else txtSoNgayNghiAN.setEditable(true);
    }//GEN-LAST:event_txtSoNgayNghiANKeyPressed

    private void txtPhuCapKhacANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapKhacAN.setEditable(false);
        else txtPhuCapKhacAN.setEditable(true);
    }//GEN-LAST:event_txtPhuCapKhacANKeyPressed

    private void txtLuongCoBanANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtLuongCoBanAN.setEditable(false);
        else txtLuongCoBanAN.setEditable(true);
    }//GEN-LAST:event_txtLuongCoBanANKeyPressed

    private void txtPhuCapANKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapANKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapAN.setEditable(false);
        else txtPhuCapAN.setEditable(true);
    }//GEN-LAST:event_txtPhuCapANKeyPressed

    private void btnThemANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemANActionPerformed
        // TODO add your handling code here:
        BangCongAnNinhBUS.Them(cbxMaNhanVienAN.getSelectedItem().toString(), txtLuongCoBanAN.getText(), txtPhuCapAN.getText(), txtPhuCapKhacAN.getText(), txtThangAN.getText(),
                txtNamAN.getText(), txtSoNgayCongAN.getText(), txtSoNgayNghiAN.getText(), txtSoNgayLamThemAN.getText(), 
                txtGhiChuAN.getText(), cbxMaBoPhanAN.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblAN.getModel();
        model.setRowCount(0);
        showAN();
    }//GEN-LAST:event_btnThemANActionPerformed

    private void btnSuaANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaANActionPerformed
        // TODO add your handling code here:
        BangCongAnNinhBUS.Sua(txtLuongCoBanAN.getText(), txtPhuCapAN.getText(), txtPhuCapKhacAN.getText(), txtThangAN.getText(),
                txtNamAN.getText(), txtSoNgayCongAN.getText(), txtSoNgayNghiAN.getText(), txtSoNgayLamThemAN.getText(), 
                txtGhiChuAN.getText(), cbxMaBoPhanAN.getSelectedItem().toString(), cbxMaNhanVienAN.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblAN.getModel();
        model.setRowCount(0);
            showAN();
    }//GEN-LAST:event_btnSuaANActionPerformed

    private void btnXoaANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaANActionPerformed
        // TODO add your handling code here:
        BangCongAnNinhBUS.Xoa(cbxMaNhanVienAN.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblAN.getModel();
        model.setRowCount(0);
        showAN();
    }//GEN-LAST:event_btnXoaANActionPerformed

    private void btnMoiANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiANActionPerformed
        // TODO add your handling code here:
//        cbxMaNhanVienAN.removeAllItems();
//        BangCongAnNinhBUS.getCBboxMaNV(cbxMaNhanVienAN);
        
        txtLuongCoBanAN.setEnabled(true);
        txtPhuCapAN.setEnabled(true);
        txtPhuCapKhacAN.setEnabled(true);
        txtThangAN.setEnabled(true);
        txtNamAN.setEnabled(true);
        txtSoNgayCongAN.setEnabled(true);
        txtSoNgayNghiAN.setEnabled(true);
        txtSoNgayLamThemAN.setEnabled(true);
        txtGhiChuAN.setEnabled(true);
        btnThemAN.setEnabled(true);
        btnXoaAN.setEnabled(false);
        btnSuaAN.setEnabled(false);
        
        //cbxMaNhanVienAN.setSelectedIndex(0);
        txtLuongCoBanAN.setText("");
        txtPhuCapAN.setText("");
        txtPhuCapKhacAN.setText("");
        txtThangAN.setText(dateFormat.format(dateAN));
        txtNamAN.setText(dateFormatY.format(dateAN));
        txtSoNgayCongAN.setText("30");
        txtSoNgayNghiAN.setText("");
        txtSoNgayLamThemAN.setText("");
        txtGhiChuAN.setText("");
        //cbxMaBoPhanAN.setSelectedIndex(0);
        String maNV = cbxMaNhanVienAN.getSelectedItem().toString();
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaBoPhan FROM dbo.TblTTNVCoBan WHERE MaNV='"+maNV+"'";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                String mabp = rs.getString("MaBoPhan");             
                cbxMaBoPhanAN.setSelectedItem(mabp);           
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
    }//GEN-LAST:event_btnMoiANActionPerformed

    private void tblANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblANMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienAN.removeAllItems();
        BangCongAnNinhBUS.getCBboxMaNVTb(cbxMaNhanVienAN);
        
        txtLuongCoBanAN.setEnabled(true);
        txtPhuCapAN.setEnabled(true);
        txtPhuCapKhacAN.setEnabled(true);
        txtThangAN.setEnabled(true);
        txtNamAN.setEnabled(true);
        txtSoNgayCongAN.setEnabled(true);
        txtSoNgayNghiAN.setEnabled(true);
        txtSoNgayLamThemAN.setEnabled(true);
        txtGhiChuAN.setEnabled(true);
        btnThemAN.setEnabled(true);
        btnXoaAN.setEnabled(true);
        btnSuaAN.setEnabled(true);
        
        int i = tblAN.getSelectedRow();
        cbxMaNhanVienAN.setSelectedItem(modelAN.getValueAt(i, 0).toString());
        txtLuongCoBanAN.setText(modelAN.getValueAt(i, 1).toString());
        txtPhuCapAN.setText(modelAN.getValueAt(i, 2).toString());
        txtPhuCapKhacAN.setText(modelAN.getValueAt(i, 3).toString());
        txtThangAN.setText(modelAN.getValueAt(i, 4).toString());
        txtNamAN.setText(modelAN.getValueAt(i, 5).toString());
        txtSoNgayCongAN.setText(modelAN.getValueAt(i, 6).toString());
        txtSoNgayNghiAN.setText(modelAN.getValueAt(i, 7).toString());
        txtSoNgayLamThemAN.setText(modelAN.getValueAt(i, 8).toString());
        txtGhiChuAN.setText(modelAN.getValueAt(i, 9).toString());
        cbxMaBoPhanAN.setSelectedItem(modelAN.getValueAt(i, 10).toString());
    }//GEN-LAST:event_tblANMouseClicked

    private void txtGhiChuKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhiChuKKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhiChuKKActionPerformed

    private void txtSoNgayCongKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayCongKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayCongKK.setEditable(false);
        else txtSoNgayCongKK.setEditable(true);
    }//GEN-LAST:event_txtSoNgayCongKKKeyPressed

    private void txtSoNgayLamThemKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayLamThemKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayLamThemKK.setEditable(false);
        else txtSoNgayLamThemKK.setEditable(true);
    }//GEN-LAST:event_txtSoNgayLamThemKKKeyPressed

    private void txtSoNgayNghiKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoNgayNghiKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtSoNgayNghiKK.setEditable(false);
        else txtSoNgayNghiKK.setEditable(true);
    }//GEN-LAST:event_txtSoNgayNghiKKKeyPressed

    private void txtPhuCapKhacKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapKhacKK.setEditable(false);
        else txtPhuCapKhacKK.setEditable(true);
    }//GEN-LAST:event_txtPhuCapKhacKKKeyPressed

    private void txtLuongCoBanKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCoBanKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtLuongCoBanKK.setEditable(false);
        else txtLuongCoBanKK.setEditable(true);
    }//GEN-LAST:event_txtLuongCoBanKKKeyPressed

    private void txtPhuCapKKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKKKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapKK.setEditable(false);
        else txtPhuCapKK.setEditable(true);
    }//GEN-LAST:event_txtPhuCapKKKeyPressed

    private void btnThemKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKKActionPerformed
        // TODO add your handling code here:
        BangCongKiemKhoBUS.Them(cbxMaNhanVienKK.getSelectedItem().toString(), txtLuongCoBanKK.getText(), txtPhuCapKK.getText(), txtPhuCapKhacKK.getText(), txtThangKK.getText(),
                txtNamKK.getText(), txtSoNgayCongKK.getText(), txtSoNgayNghiKK.getText(), txtSoNgayLamThemKK.getText(), 
                txtGhiChuKK.getText(),cbxMaBoPhanKK.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblKK.getModel();
        model.setRowCount(0);
        showKK();
    }//GEN-LAST:event_btnThemKKActionPerformed

    private void btnSuaKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKKActionPerformed
        // TODO add your handling code here:
        BangCongKiemKhoBUS.Them(txtLuongCoBanKK.getText(), txtPhuCapKK.getText(), txtPhuCapKhacKK.getText(), txtThangKK.getText(),
                txtNamKK.getText(), txtSoNgayCongKK.getText(), txtSoNgayNghiKK.getText(), txtSoNgayLamThemKK.getText(), 
                txtGhiChuKK.getText(), cbxMaBoPhanKK.getSelectedItem().toString(), cbxMaNhanVienKK.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblKK.getModel();
        model.setRowCount(0);
        showKK();
    }//GEN-LAST:event_btnSuaKKActionPerformed

    private void btnXoaKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKKActionPerformed
        // TODO add your handling code here:
        BangCongKiemKhoBUS.Xoa(cbxMaNhanVienKK.getSelectedItem().toString());
        DefaultTableModel model = (DefaultTableModel) tblKK.getModel();
        model.setRowCount(0);
        showKK();
    }//GEN-LAST:event_btnXoaKKActionPerformed

    private void btnMoiKKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiKKActionPerformed
        // TODO add your handling code here:
//        cbxMaNhanVienKK.removeAllItems();
//        BangCongKiemKhoBUS.getCBboxMaNV(cbxMaNhanVienKK);
        
        txtLuongCoBanKK.setEnabled(true);
        txtPhuCapKK.setEnabled(true);
        txtPhuCapKhacKK.setEnabled(true);
        txtThangKK.setEnabled(true);
        txtNamKK.setEnabled(true);
        txtSoNgayCongKK.setEnabled(true);
        txtSoNgayNghiKK.setEnabled(true);
        txtSoNgayLamThemKK.setEnabled(true);
        txtGhiChuKK.setEnabled(true);
        btnThemKK.setEnabled(true);
        btnXoaKK.setEnabled(false);
        btnSuaKK.setEnabled(false);
        
        //cbxMaNhanVienKK.setSelectedIndex(0);
        txtLuongCoBanKK.setText("");
        txtPhuCapKK.setText("");
        txtPhuCapKhacKK.setText("");
        txtThangKK.setText(dateFormat.format(dateKK));
        txtNamKK.setText(dateFormatY.format(dateKK));
        txtSoNgayCongKK.setText("30");
        txtSoNgayNghiKK.setText("");
        txtSoNgayLamThemKK.setText("");
        txtGhiChuKK.setText("");
        
        String maNV = cbxMaNhanVienKK.getSelectedItem().toString();
        Connection ketNoi = KetNoiSQL.layKetnoi();
        String sql = "SELECT MaBoPhan FROM dbo.TblTTNKKoBan WHERE MaNV='"+maNV+"'";
        try{
            Statement state = ketNoi.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                String mabp = rs.getString("MaBoPhan");             
                cbxMaBoPhanKK.setSelectedItem(mabp);           
            }
        }
        catch(Exception e){
            System.out.println("Khong load duoc comboBox");
        }
        //cbxMaBoPhanKK.setSelectedIndex(0);
    }//GEN-LAST:event_btnMoiKKActionPerformed

    private void tblKKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKKMouseClicked
        // TODO add your handling code here:
        cbxMaNhanVienKK.removeAllItems();
        BangCongKiemKhoBUS.getCBboxMaNVTb(cbxMaNhanVienKK);
        
        txtLuongCoBanKK.setEnabled(true);
        txtPhuCapKK.setEnabled(true);
        txtPhuCapKhacKK.setEnabled(true);
        txtThangKK.setEnabled(true);
        txtNamKK.setEnabled(true);
        txtSoNgayCongKK.setEnabled(true);
        txtSoNgayNghiKK.setEnabled(true);
        txtSoNgayLamThemKK.setEnabled(true);
        txtGhiChuKK.setEnabled(true);
        btnThemKK.setEnabled(true);
        btnXoaKK.setEnabled(true);
        btnSuaKK.setEnabled(true);
        
        int i = tblKK.getSelectedRow();
        cbxMaNhanVienKK.setSelectedItem(modelKK.getValueAt(i, 0).toString());
        txtLuongCoBanKK.setText(modelKK.getValueAt(i, 1).toString());
        txtPhuCapKK.setText(modelKK.getValueAt(i, 2).toString());
        txtPhuCapKhacKK.setText(modelKK.getValueAt(i, 3).toString());
        txtThangKK.setText(modelKK.getValueAt(i, 4).toString());
        txtNamKK.setText(modelKK.getValueAt(i, 5).toString());
        txtSoNgayCongKK.setText(modelKK.getValueAt(i, 6).toString());
        txtSoNgayNghiKK.setText(modelKK.getValueAt(i, 7).toString());
        txtSoNgayLamThemKK.setText(modelKK.getValueAt(i, 8).toString());
        txtGhiChuKK.setText(modelKK.getValueAt(i, 9).toString());
        cbxMaBoPhanKK.setSelectedItem(modelKK.getValueAt(i, 10).toString());
    }//GEN-LAST:event_tblKKMouseClicked

    private void txtPhuCapKhacBHKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapKhacBHKeyPressed
        // TODO add your handling code here:
                char c = evt.getKeyChar();
        if (Character.isLetter(c)) txtPhuCapKhacBH.setEditable(false);
        else txtPhuCapKhacBH.setEditable(true);
    }//GEN-LAST:event_txtPhuCapKhacBHKeyPressed

    private void cbxMaNhanVienDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMaNhanVienDHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMaNhanVienDHActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BH;
    private javax.swing.JButton btnMoiAN;
    private javax.swing.JButton btnMoiBH;
    private javax.swing.JButton btnMoiDH;
    private javax.swing.JButton btnMoiKK;
    private javax.swing.JButton btnSuaAN;
    private javax.swing.JButton btnSuaDH;
    private javax.swing.JButton btnSuaKK;
    private javax.swing.JButton btnThemAN;
    private javax.swing.JButton btnThemBH;
    private javax.swing.JButton btnThemDH;
    private javax.swing.JButton btnThemKK;
    private javax.swing.JButton btnXoaAN;
    private javax.swing.JButton btnXoaBH;
    private javax.swing.JButton btnXoaDH;
    private javax.swing.JButton btnXoaKK;
    private javax.swing.JComboBox<String> cbxMaBoPhanAN;
    private javax.swing.JComboBox<String> cbxMaBoPhanBH;
    private javax.swing.JComboBox<String> cbxMaBoPhanDH;
    private javax.swing.JComboBox<String> cbxMaBoPhanKK;
    private javax.swing.JComboBox<String> cbxMaNhanVienAN;
    private javax.swing.JComboBox<String> cbxMaNhanVienBH;
    private javax.swing.JComboBox<String> cbxMaNhanVienDH;
    private javax.swing.JComboBox<String> cbxMaNhanVienKK;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblGhiChuAN;
    private javax.swing.JLabel lblGhiChuBH;
    private javax.swing.JLabel lblGhiChuDH;
    private javax.swing.JLabel lblGhiChuKK;
    private javax.swing.JLabel lblHeader2;
    private javax.swing.JLabel lblHeader3;
    private javax.swing.JLabel lblHeader4;
    private javax.swing.JLabel lblHeader5;
    private javax.swing.JLabel lblHeader6;
    private javax.swing.JLabel lblHeader7;
    private javax.swing.JLabel lblHeader8;
    private javax.swing.JLabel lblHeader9;
    private javax.swing.JLabel lblLuongCoBanAN;
    private javax.swing.JLabel lblLuongCoBanBH;
    private javax.swing.JLabel lblLuongCoBanDH;
    private javax.swing.JLabel lblLuongCoBanKK;
    private javax.swing.JLabel lblMaBoPhanAN;
    private javax.swing.JLabel lblMaBoPhanBH;
    private javax.swing.JLabel lblMaBoPhanDH;
    private javax.swing.JLabel lblMaBoPhanKK;
    private javax.swing.JLabel lblMaNhanVienAN;
    private javax.swing.JLabel lblMaNhanVienBH;
    private javax.swing.JLabel lblMaNhanVienDH;
    private javax.swing.JLabel lblMaNhanVienKK;
    private javax.swing.JLabel lblNamAN;
    private javax.swing.JLabel lblNamBH;
    private javax.swing.JLabel lblNamDH;
    private javax.swing.JLabel lblNamKK;
    private javax.swing.JLabel lblPhuCapAN;
    private javax.swing.JLabel lblPhuCapBH;
    private javax.swing.JLabel lblPhuCapDH;
    private javax.swing.JLabel lblPhuCapKK;
    private javax.swing.JLabel lblPhuCapKhacAN;
    private javax.swing.JLabel lblPhuCapKhacBH;
    private javax.swing.JLabel lblPhuCapKhacDH;
    private javax.swing.JLabel lblPhuCapKhacKK;
    private javax.swing.JLabel lblSoNgayCongAN;
    private javax.swing.JLabel lblSoNgayCongBH;
    private javax.swing.JLabel lblSoNgayCongDH;
    private javax.swing.JLabel lblSoNgayCongKK;
    private javax.swing.JLabel lblSoNgayLamThemAN;
    private javax.swing.JLabel lblSoNgayLamThemBH;
    private javax.swing.JLabel lblSoNgayLamThemDH;
    private javax.swing.JLabel lblSoNgayLamThemKK;
    private javax.swing.JLabel lblSoNgayNghiAN;
    private javax.swing.JLabel lblSoNgayNghiBH;
    private javax.swing.JLabel lblSoNgayNghiDH;
    private javax.swing.JLabel lblSoNgayNghiKK;
    private javax.swing.JLabel lblThangAN;
    private javax.swing.JLabel lblThangBH;
    private javax.swing.JLabel lblThangDH;
    private javax.swing.JLabel lblThangKK;
    private javax.swing.JPanel pnAnNinh;
    private javax.swing.JPanel pnBanHang;
    private javax.swing.JPanel pnDieuHanh;
    private javax.swing.JPanel pnlKiemKho;
    private javax.swing.JTable tblAN;
    private javax.swing.JTable tblBH;
    private javax.swing.JTable tblDH;
    private javax.swing.JTable tblKK;
    private javax.swing.JTextField txtGhiChuAN;
    private javax.swing.JTextField txtGhiChuBH;
    private javax.swing.JTextField txtGhiChuDH;
    private javax.swing.JTextField txtGhiChuKK;
    private javax.swing.JTextField txtLuongCoBanAN;
    private javax.swing.JTextField txtLuongCoBanBH;
    private javax.swing.JTextField txtLuongCoBanDH;
    private javax.swing.JTextField txtLuongCoBanKK;
    private javax.swing.JTextField txtNamAN;
    private javax.swing.JTextField txtNamBH;
    private javax.swing.JTextField txtNamDH;
    private javax.swing.JTextField txtNamKK;
    private javax.swing.JTextField txtPhuCapAN;
    private javax.swing.JTextField txtPhuCapBH;
    private javax.swing.JTextField txtPhuCapDH;
    private javax.swing.JTextField txtPhuCapKK;
    private javax.swing.JTextField txtPhuCapKhacAN;
    private javax.swing.JTextField txtPhuCapKhacBH;
    private javax.swing.JTextField txtPhuCapKhacDH;
    private javax.swing.JTextField txtPhuCapKhacKK;
    private javax.swing.JTextField txtSoNgayCongAN;
    private javax.swing.JTextField txtSoNgayCongBH;
    private javax.swing.JTextField txtSoNgayCongDH;
    private javax.swing.JTextField txtSoNgayCongKK;
    private javax.swing.JTextField txtSoNgayLamThemAN;
    private javax.swing.JTextField txtSoNgayLamThemBH;
    private javax.swing.JTextField txtSoNgayLamThemDH;
    private javax.swing.JTextField txtSoNgayLamThemKK;
    private javax.swing.JTextField txtSoNgayNghiAN;
    private javax.swing.JTextField txtSoNgayNghiBH;
    private javax.swing.JTextField txtSoNgayNghiDH;
    private javax.swing.JTextField txtSoNgayNghiKK;
    private javax.swing.JTextField txtThangAN;
    private javax.swing.JTextField txtThangBH;
    private javax.swing.JTextField txtThangDH;
    private javax.swing.JTextField txtThangKK;
    // End of variables declaration//GEN-END:variables
}
