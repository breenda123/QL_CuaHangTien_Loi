/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.BangCongDieuHanhDAL;
import DAL.BangCongBanHangDAL;
import DAL.BangCongKiemKhoDAL;
import DAL.BangCongAnNinhDAL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DTO.BangCongDieuHanh;
import DTO.BangCongBanHang;
import DTO.BangCongKiemKho;
import DTO.BangCongAnNinh;
import javax.swing.JTable;
/**
 *
 * @author Ngoc
 */
public class frmTraCuuLuong extends javax.swing.JPanel {

    DefaultTableModel modelDH;
    DefaultTableModel modelAN;
    DefaultTableModel modelBH;
    DefaultTableModel modelKK;
    //DefaultTableModel modelTV;

    private Connection conn;
    /**
     * Creates new form frmThongTinNhanVien
     */
    public frmTraCuuLuong() {
        initComponents();
        
        modelDH = (DefaultTableModel) tblDH.getModel();
        modelBH = (DefaultTableModel) tblBH.getModel();
        //modelTV = (DefaultTableModel) tblTV.getModel();
        modelKK = (DefaultTableModel) tblKK.getModel();
        modelAN = (DefaultTableModel) tblAN.getModel();
        
        //showTV();
        showDH();
        showBH();
        showKK();
        showAN();
    }

    public void showDH() {
        ArrayList<BangCongDieuHanh> dh = BangCongDieuHanhDAL.dhtcList();
        DefaultTableModel model = (DefaultTableModel)tblDH.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<dh.size();i++) {
            row[0]=dh.get(i).getMaNhanVien();
            row[1]=dh.get(i).getHoTen();
            row[2]=dh.get(i).getNgaySinh();
            row[3]=dh.get(i).getLuongCoBan();
            row[4]=dh.get(i).getPhuCap();
            row[5]=dh.get(i).getPhuCapKhac();
            row[6]=dh.get(i).getThang();
            row[7]=dh.get(i).getNam();
            row[8]=dh.get(i).getSoNgayCong();
            row[9]=dh.get(i).getSoNgayNghi();
            row[10]=dh.get(i).getSoGioLam();
            row[11]=dh.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }
    
    public void showBH() {
        ArrayList<BangCongBanHang> bh = BangCongBanHangDAL.bhtcList();
        DefaultTableModel model = (DefaultTableModel)tblBH.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<bh.size();i++) {
            row[0]=bh.get(i).getMaNhanVien();
            row[1]=bh.get(i).getHoTen();
            row[2]=bh.get(i).getNgaySinh();
            row[3]=bh.get(i).getLuongCoBan();
            row[4]=bh.get(i).getPhuCap();
            row[5]=bh.get(i).getPhuCapKhac();
            row[6]=bh.get(i).getThang();
            row[7]=bh.get(i).getNam();
            row[8]=bh.get(i).getSoNgayCong();
            row[9]=bh.get(i).getSoNgayNghi();
            row[10]=bh.get(i).getSoGioLam();
            row[11]=bh.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }
    
    public void showKK() {
        ArrayList<BangCongKiemKho> kk = BangCongKiemKhoDAL.kktcList();
        DefaultTableModel model = (DefaultTableModel)tblKK.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<kk.size();i++) {
            row[0]=kk.get(i).getMaNhanVien();
            row[1]=kk.get(i).getHoTen();
            row[2]=kk.get(i).getNgaySinh();
            row[3]=kk.get(i).getLuongCoBan();
            row[4]=kk.get(i).getPhuCap();
            row[5]=kk.get(i).getPhuCapKhac();
            row[6]=kk.get(i).getThang();
            row[7]=kk.get(i).getNam();
            row[8]=kk.get(i).getSoNgayCong();
            row[9]=kk.get(i).getSoNgayNghi();
            row[10]=kk.get(i).getSoGioLam();
            row[11]=kk.get(i).getMaBoPhan();
            model.addRow(row);
        };
    }

    public void showAN() {
        ArrayList<BangCongAnNinh> an = BangCongAnNinhDAL.antcList();
        DefaultTableModel model = (DefaultTableModel)tblAN.getModel();
        Object[] row = new Object[17];
        for (int i=0;i<an.size();i++) {
            row[0]=an.get(i).getMaNhanVien();
            row[1]=an.get(i).getHoTen();
            row[2]=an.get(i).getNgaySinh();
            row[3]=an.get(i).getLuongCoBan();
            row[4]=an.get(i).getPhuCap();
            row[5]=an.get(i).getPhuCapKhac();
            row[6]=an.get(i).getThang();
            row[7]=an.get(i).getNam();
            row[8]=an.get(i).getSoNgayCong();
            row[9]=an.get(i).getSoNgayNghi();
            row[10]=an.get(i).getSoGioLam();
            row[11]=an.get(i).getMaBoPhan();
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
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDH = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        txtSearchDH = new javax.swing.JTextField();
        lblSearch2 = new javax.swing.JLabel();
        lblTienDH = new javax.swing.JLabel();
        lblTienLuongDH = new javax.swing.JLabel();
        lblVNDDH = new javax.swing.JLabel();
        txtThongbaoDH = new javax.swing.JLabel();
        lblThangDH = new javax.swing.JLabel();
        txtThangDH = new javax.swing.JLabel();
        lblNamDH = new javax.swing.JLabel();
        txtNamDH = new javax.swing.JLabel();
        pnAnNinh = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblAN = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        txtSearchAN = new javax.swing.JTextField();
        lblSearch3 = new javax.swing.JLabel();
        lblTienLuongAN = new javax.swing.JLabel();
        lblTienAN = new javax.swing.JLabel();
        lblVNDAN = new javax.swing.JLabel();
        txtThongbaoAN = new javax.swing.JLabel();
        lblThangAN = new javax.swing.JLabel();
        txtThangAN = new javax.swing.JLabel();
        lblNamAN = new javax.swing.JLabel();
        txtNamAN = new javax.swing.JLabel();
        pnKiemKho = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblKK = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        txtSearchKK = new javax.swing.JTextField();
        lblSearch4 = new javax.swing.JLabel();
        lblTienLuongKK = new javax.swing.JLabel();
        lblTienKK = new javax.swing.JLabel();
        lblVNDKK = new javax.swing.JLabel();
        txtThongbaoKK = new javax.swing.JLabel();
        lblThangKK = new javax.swing.JLabel();
        txtThangKK = new javax.swing.JLabel();
        lblNamKK = new javax.swing.JLabel();
        txtNamKK = new javax.swing.JLabel();
        pnBanHang = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblBH = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        txtSearchBH = new javax.swing.JTextField();
        lblSearch1 = new javax.swing.JLabel();
        lblTienLuongBH = new javax.swing.JLabel();
        lblTienBH = new javax.swing.JLabel();
        lblVNDBH = new javax.swing.JLabel();
        txtThongbaoBH = new javax.swing.JLabel();
        lblThangBH = new javax.swing.JLabel();
        txtThangBH = new javax.swing.JLabel();
        lblNamBH = new javax.swing.JLabel();
        txtNamBH = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(107, 195, 196));

        jPanel4.setBackground(new java.awt.Color(107, 195, 196));

        pnDieuHanh.setBackground(new java.awt.Color(254, 255, 250));
        pnDieuHanh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

        jSeparator2.setBackground(new java.awt.Color(3, 100, 117));
        jSeparator2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(3, 100, 117)));

        tblDH.setBackground(new java.awt.Color(254, 255, 250));
        tblDH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tblDH.setForeground(new java.awt.Color(3, 100, 117));
        tblDH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        jButton3.setBackground(new java.awt.Color(254, 255, 250));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/magnifier.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearchDH.setBackground(new java.awt.Color(254, 255, 250));
        txtSearchDH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearchDH.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchDH.setText("word...");
        txtSearchDH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(107, 195, 196)));
        txtSearchDH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchDHFocusGained(evt);
            }
        });
        txtSearchDH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchDHKeyReleased(evt);
            }
        });

        lblSearch2.setBackground(new java.awt.Color(3, 100, 117));
        lblSearch2.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblSearch2.setForeground(new java.awt.Color(3, 100, 117));
        lblSearch2.setText("Tìm kiếm");

        lblTienDH.setBackground(new java.awt.Color(3, 100, 117));
        lblTienDH.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTienDH.setForeground(new java.awt.Color(3, 100, 117));
        lblTienDH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienDH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblTienLuongDH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTienLuongDH.setText("Tiền lương:");

        lblVNDDH.setBackground(new java.awt.Color(3, 100, 117));
        lblVNDDH.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblVNDDH.setForeground(new java.awt.Color(3, 100, 117));
        lblVNDDH.setText("VND");

        txtThongbaoDH.setForeground(new java.awt.Color(255, 51, 51));

        lblThangDH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblThangDH.setText("Tháng:");

        txtThangDH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtThangDH.setForeground(new java.awt.Color(51, 102, 255));

        lblNamDH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNamDH.setText("Năm: ");

        txtNamDH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtNamDH.setForeground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout pnDieuHanhLayout = new javax.swing.GroupLayout(pnDieuHanh);
        pnDieuHanh.setLayout(pnDieuHanhLayout);
        pnDieuHanhLayout.setHorizontalGroup(
            pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addGroup(pnDieuHanhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addComponent(lblThangDH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNamDH)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamDH, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTienLuongDH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTienDH, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVNDDH)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnDieuHanhLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSearch2)
                        .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDieuHanhLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSearchDH, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(pnDieuHanhLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(txtThongbaoDH, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnDieuHanhLayout.setVerticalGroup(
            pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDieuHanhLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearchDH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSearch2))
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThongbaoDH, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTienLuongDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThangDH)
                        .addComponent(txtThangDH, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNamDH)
                        .addComponent(txtNamDH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblTienDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVNDDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Điều hành", pnDieuHanh);

        pnAnNinh.setBackground(new java.awt.Color(254, 255, 250));
        pnAnNinh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

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
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        jButton4.setBackground(new java.awt.Color(254, 255, 250));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/magnifier.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearchAN.setBackground(new java.awt.Color(254, 255, 250));
        txtSearchAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearchAN.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchAN.setText("word...");
        txtSearchAN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(107, 195, 196)));
        txtSearchAN.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchANFocusGained(evt);
            }
        });
        txtSearchAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchANKeyReleased(evt);
            }
        });

        lblSearch3.setBackground(new java.awt.Color(3, 100, 117));
        lblSearch3.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblSearch3.setForeground(new java.awt.Color(3, 100, 117));
        lblSearch3.setText("Tìm kiếm");

        lblTienLuongAN.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTienLuongAN.setText("Tiền lương:");

        lblTienAN.setBackground(new java.awt.Color(3, 100, 117));
        lblTienAN.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTienAN.setForeground(new java.awt.Color(3, 100, 117));
        lblTienAN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienAN.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblVNDAN.setBackground(new java.awt.Color(3, 100, 117));
        lblVNDAN.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblVNDAN.setForeground(new java.awt.Color(3, 100, 117));
        lblVNDAN.setText("VND");

        txtThongbaoAN.setForeground(new java.awt.Color(255, 0, 0));

        lblThangAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblThangAN.setText("Tháng:");

        txtThangAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lblNamAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNamAN.setText("Năm: ");

        txtNamAN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnAnNinhLayout = new javax.swing.GroupLayout(pnAnNinh);
        pnAnNinh.setLayout(pnAnNinhLayout);
        pnAnNinhLayout.setHorizontalGroup(
            pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnAnNinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addComponent(lblThangAN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThangAN, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNamAN)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamAN, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSearch3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addComponent(txtSearchAN, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnAnNinhLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                                .addComponent(lblTienLuongAN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTienAN, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblVNDAN))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                                .addComponent(txtThongbaoAN, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnAnNinhLayout.setVerticalGroup(
            pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAnNinhLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(txtSearchAN, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch3))
                .addGap(9, 9, 9)
                .addComponent(txtThongbaoAN, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTienLuongAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVNDAN, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(pnAnNinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThangAN)
                        .addComponent(txtThangAN, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNamAN)
                        .addComponent(txtNamAN, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("An ninh", pnAnNinh);

        pnKiemKho.setBackground(new java.awt.Color(254, 255, 250));
        pnKiemKho.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

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
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Lương cơ bản", "Phụ cấp", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, true
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

        jButton5.setBackground(new java.awt.Color(254, 255, 250));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/magnifier.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearchKK.setBackground(new java.awt.Color(254, 255, 250));
        txtSearchKK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearchKK.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchKK.setText("word...");
        txtSearchKK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(107, 195, 196)));
        txtSearchKK.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchKKFocusGained(evt);
            }
        });
        txtSearchKK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKKKeyReleased(evt);
            }
        });

        lblSearch4.setBackground(new java.awt.Color(3, 100, 117));
        lblSearch4.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblSearch4.setForeground(new java.awt.Color(3, 100, 117));
        lblSearch4.setText("Tìm kiếm");

        lblTienLuongKK.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTienLuongKK.setText("Tiền lương:");

        lblTienKK.setBackground(new java.awt.Color(3, 100, 117));
        lblTienKK.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTienKK.setForeground(new java.awt.Color(3, 100, 117));
        lblTienKK.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienKK.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lblVNDKK.setBackground(new java.awt.Color(3, 100, 117));
        lblVNDKK.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblVNDKK.setForeground(new java.awt.Color(3, 100, 117));
        lblVNDKK.setText("VND");

        txtThongbaoKK.setForeground(new java.awt.Color(255, 51, 51));

        lblThangKK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblThangKK.setText("Tháng:");

        txtThangKK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lblNamKK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNamKK.setText("Năm: ");

        txtNamKK.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnKiemKhoLayout = new javax.swing.GroupLayout(pnKiemKho);
        pnKiemKho.setLayout(pnKiemKhoLayout);
        pnKiemKhoLayout.setHorizontalGroup(
            pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKiemKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblThangKK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThangKK, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(lblNamKK)
                .addGap(18, 18, 18)
                .addComponent(txtNamKK, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTienLuongKK)
                .addGap(18, 18, 18)
                .addComponent(lblTienKK, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVNDKK)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKiemKhoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSearch4)
                .addGroup(pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnKiemKhoLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(txtThongbaoKK, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnKiemKhoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchKK, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnKiemKhoLayout.setVerticalGroup(
            pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnKiemKhoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSearch4)
                    .addComponent(txtSearchKK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtThongbaoKK, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTienLuongKK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienKK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVNDKK, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(pnKiemKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThangKK)
                        .addComponent(txtThangKK, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNamKK)
                        .addComponent(txtNamKK, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kiểm kho", pnKiemKho);

        pnBanHang.setBackground(new java.awt.Color(254, 255, 250));
        pnBanHang.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(107, 195, 196)));

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
                "Mã nhân viên", "Họ tên", "Ngày sinh", "Lương cơ bản", "Phụ cấp chức vụ ", "Phụ cấp khác", "Tháng", "Năm", "Số ngày công", "Số ngày nghỉ", "Số giờ làm thêm", "Mã bộ phận"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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

        jButton2.setBackground(new java.awt.Color(254, 255, 250));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 0, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlnstl/src/magnifier.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSearchBH.setBackground(new java.awt.Color(254, 255, 250));
        txtSearchBH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSearchBH.setForeground(new java.awt.Color(204, 204, 204));
        txtSearchBH.setText("word...");
        txtSearchBH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(107, 195, 196)));
        txtSearchBH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchBHFocusGained(evt);
            }
        });
        txtSearchBH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchBHKeyReleased(evt);
            }
        });

        lblSearch1.setBackground(new java.awt.Color(3, 100, 117));
        lblSearch1.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblSearch1.setForeground(new java.awt.Color(3, 100, 117));
        lblSearch1.setText("Tìm kiếm");

        lblTienLuongBH.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblTienLuongBH.setText("Tiền lương:");

        lblTienBH.setBackground(new java.awt.Color(3, 100, 117));
        lblTienBH.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblTienBH.setForeground(new java.awt.Color(3, 100, 117));
        lblTienBH.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienBH.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblVNDBH.setBackground(new java.awt.Color(3, 100, 117));
        lblVNDBH.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        lblVNDBH.setForeground(new java.awt.Color(3, 100, 117));
        lblVNDBH.setText("VND");

        txtThongbaoBH.setForeground(new java.awt.Color(255, 0, 0));

        lblThangBH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblThangBH.setText("Tháng:");

        txtThangBH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        lblNamBH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblNamBH.setText("Năm: ");

        txtNamBH.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnBanHangLayout = new javax.swing.GroupLayout(pnBanHang);
        pnBanHang.setLayout(pnBanHangLayout);
        pnBanHangLayout.setHorizontalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addGroup(pnBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addComponent(lblThangBH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNamBH)
                        .addGap(18, 18, 18)
                        .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTienLuongBH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTienBH, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblVNDBH)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSearch1)
                        .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSearchBH, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(pnBanHangLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(txtThongbaoBH, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnBanHangLayout.setVerticalGroup(
            pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBanHangLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSearch1)
                        .addComponent(jButton2))
                    .addGroup(pnBanHangLayout.createSequentialGroup()
                        .addComponent(txtSearchBH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(9, 9, 9)
                .addComponent(txtThongbaoBH, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblTienLuongBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTienBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVNDBH, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(pnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThangBH)
                        .addComponent(txtThangBH, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNamBH)
                        .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
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

    private void tblDHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDHMouseClicked
        int i = tblDH.getSelectedRow();
        String luongDH = modelDH.getValueAt(i, 3).toString();
        String phuCapDH = modelDH.getValueAt(i, 4).toString();
        String phuCapKhacDH = modelDH.getValueAt(i, 5).toString();
        String soNgayCongDH = modelDH.getValueAt(i, 8).toString();
        String soGioLamThemDH = modelDH.getValueAt(i, 10).toString();
        String soNgayNghiDH = modelDH.getValueAt(i, 9).toString();
        double tienDH =0;
        if (Double.valueOf(soNgayCongDH)>0){
             tienDH = Double.valueOf(luongDH) + Double.valueOf(phuCapDH) + Double.valueOf(phuCapKhacDH) + 
                    (((Double.valueOf(soGioLamThemDH) / 8) - (Double.valueOf(soNgayNghiDH)))  * (Double.valueOf(luongDH) / Double.valueOf(soNgayCongDH)));
            
        }
        else if (Double.valueOf(soNgayCongDH)==0){
            tienDH = Double.valueOf(luongDH)*Double.valueOf(soGioLamThemDH);
            
        }
        int sum = (int)tienDH;
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum);
        
        lblTienDH.setText("" + format);
        txtNamDH.setText(modelDH.getValueAt(i, 7).toString());
        txtThangDH.setText(modelDH.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tblDHMouseClicked
    
    private void tblANMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblANMouseClicked
        int i = tblAN.getSelectedRow();
        String luongAN = modelAN.getValueAt(i, 3).toString();
        String phuCapAN = modelAN.getValueAt(i, 4).toString();
        String phuCapKhacAN = modelAN.getValueAt(i, 5).toString();
        String soNgayCongAN = modelAN.getValueAt(i, 8).toString();
        String soGioLamThemAN = modelAN.getValueAt(i, 10).toString();
        String soNgayNghiAN = modelAN.getValueAt(i, 9).toString();
                double tienAN =0;
        if (Double.valueOf(soNgayCongAN)>0){
             tienAN = Double.valueOf(luongAN) + Double.valueOf(phuCapAN) + Double.valueOf(phuCapKhacAN) + 
                    (((Double.valueOf(soGioLamThemAN) / 8) - (Double.valueOf(soNgayNghiAN)))  * (Double.valueOf(luongAN) / Double.valueOf(soNgayCongAN)));
            
        }
        else if(Double.valueOf(soNgayCongAN)==0){
            tienAN = Double.valueOf(luongAN)*Double.valueOf(soGioLamThemAN);
        }
        
        int sum = (int)tienAN;
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum);
        
        lblTienAN.setText("" + format);
        txtNamAN.setText(modelAN.getValueAt(i, 7).toString());
        txtThangAN.setText(modelAN.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tblANMouseClicked

    private void tblKKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKKMouseClicked
        int i = tblKK.getSelectedRow();
        String luongKK = modelKK.getValueAt(i, 3).toString();
        String phuCapKK = modelKK.getValueAt(i, 4).toString();
        String phuCapKhacKK = modelKK.getValueAt(i, 5).toString();
        String soNgayCongKK = modelKK.getValueAt(i, 8).toString();
        String soGioLamThemKK = modelKK.getValueAt(i, 10).toString();
        String soNgayNghiKK = modelKK.getValueAt(i, 9).toString();
        double tienKK =0;
        if (Double.valueOf(soNgayCongKK)>0){
             tienKK = Double.valueOf(luongKK) + Double.valueOf(phuCapKK) + Double.valueOf(phuCapKhacKK) + 
                    (((Double.valueOf(soGioLamThemKK) / 8) - (Double.valueOf(soNgayNghiKK)))  * (Double.valueOf(luongKK) / Double.valueOf(soNgayCongKK)));
            
        }
        else if(Double.valueOf(soNgayCongKK)==0){
            tienKK = Double.valueOf(luongKK)*Double.valueOf(soGioLamThemKK);
        }
        int sum = (int)tienKK;
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum);
        
        lblTienKK.setText("" + format);
        txtNamKK.setText(modelKK.getValueAt(i, 7).toString());
        txtThangKK.setText(modelKK.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tblKKMouseClicked

    private void txtSearchBHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchBHFocusGained
        // TODO add your handling code here:
        lblTienBH.setText("");
        if(txtSearchBH.getText().trim().toLowerCase().equals("word...")) {
            txtSearchBH.setText("");
            txtSearchBH.setForeground(new Color(3, 100, 117));
            txtSearchBH.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        }
    }//GEN-LAST:event_txtSearchBHFocusGained

    private void txtSearchBHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBHKeyReleased
        // TODO add your handling code here:
        lblTienBH.setText("");
        String search = txtSearchBH.getText().toLowerCase();
        if(search.equals("")) showBH();
        else{
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
                PreparedStatement ps = conn.prepareStatement("SELECT TblTTNVCoBan.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem "
                        + "FROM TblCongBanHang, TblTTNVCoBan "
                        + "WHERE TblCongBanHang.MaNV=TblTTNVCoBan.MaNV AND TblTTNVCoBan.MaNV LIKE ?");
                ps.setString(1, "%" + search + "%");
                ResultSet rs = ps.executeQuery();
                tblBH.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                if (tblBH.getRowCount() == 0) txtThongbaoBH.setText("Không có kết quả cần tra cứu");
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txtSearchBHKeyReleased

    private void txtSearchDHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchDHFocusGained
        // TODO add your handling code here:
        lblTienDH.setText("");
        if(txtSearchDH.getText().trim().toLowerCase().equals("word...")) {
            txtSearchDH.setText("");
            txtSearchDH.setForeground(new Color(3, 100, 117));
            txtSearchDH.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        }
    }//GEN-LAST:event_txtSearchDHFocusGained

    private void txtSearchDHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDHKeyReleased
        // TODO add your handling code here:
        String search = txtSearchDH.getText().toLowerCase();
        lblTienDH.setText("");
        if(search.equals("")) showDH();
        else{
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
                PreparedStatement ps = conn.prepareStatement("SELECT TblTTNVCoBan.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, "
                        + "PhuCapKhac, Thang, Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem "
                        + "FROM TblCongDieuHanh, TblTTNVCoBan "
                        + "WHERE TblCongDieuHanh.MaNV=TblTTNVCoBan.MaNV AND TblTTNVCoBan.MaNV=?");
                ps.setString(1, search);
                ResultSet rs = ps.executeQuery();
                tblDH.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                if (tblDH.getRowCount() == 0) txtThongbaoDH.setText("Không có kết quả cần tra cứu");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtSearchDHKeyReleased

    private void txtSearchANFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchANFocusGained
        // TODO add your handling code here:
        lblTienAN.setText("");
        if(txtSearchAN.getText().trim().toLowerCase().equals("word...")) {
            txtSearchAN.setText("");
            txtSearchAN.setForeground(new Color(3, 100, 117));
            txtSearchAN.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        }
    }//GEN-LAST:event_txtSearchANFocusGained

    private void txtSearchANKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchANKeyReleased
        // TODO add your handling code here:
        lblTienAN.setText("");
        String search = txtSearchAN.getText().toLowerCase();
        if(search.equals("")) showAN();
        else{
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
                PreparedStatement ps = conn.prepareStatement("SELECT TblTTNVCoBan.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem "
                        + "FROM TblCongAnNinh, TblTTNVCoBan "
                        + "WHERE TblCongAnNinh.MaNV=TblTTNVCoBan.MaNV AND TblTTNVCoBan.MaNV=?");
                ps.setString(1, search);
                ResultSet rs = ps.executeQuery();
                tblAN.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                if (tblAN.getRowCount() == 0) txtThongbaoAN.setText("Không có kết quả cần tra cứu");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txtSearchANKeyReleased

    private void txtSearchKKFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchKKFocusGained
        // TODO add your handling code here:
        lblTienKK.setText("");
        if(txtSearchKK.getText().trim().toLowerCase().equals("word...")) {
            txtSearchKK.setText("");
            txtSearchKK.setForeground(new Color(3, 100, 117));
            txtSearchKK.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
        }
    }//GEN-LAST:event_txtSearchKKFocusGained

    private void txtSearchKKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKKKeyReleased
        // TODO add your handling code here:
        lblTienKK.setText("");
        String search = txtSearchKK.getText().toLowerCase();
        if(search.equals("")) showAN();
        else{
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLNS;" + "username=sa;password=lenhha12345::");
                PreparedStatement ps = conn.prepareStatement("SELECT TblTTNVCoBan.MaNV, HoTen, NgaySinh, LCB, PhuCapCVu, PhuCapKhac, Thang, Nam, SoNgayCongThang, SoNgayNghi, SoGioLamThem "
                        + "FROM TblCongKiemKho, TblTTNVCoBan "
                        + "WHERE TblCongKiemKho.MaNV=TblTTNVCoBan.MaNV AND TblTTNVCoBan.MaNV=?");
                ps.setString(1, search);
                ResultSet rs = ps.executeQuery();
                tblKK.setModel(DbUtils.resultSetToTableModel(rs));
                ps.close();
                if (tblKK.getRowCount() == 0) txtThongbaoKK.setText("Không có kết quả cần tra cứu");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txtSearchKKKeyReleased

    private void tblBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBHMouseClicked
        int i = tblBH.getSelectedRow();
        String luongBH = modelBH.getValueAt(i, 3).toString();
        String phuCapBH = modelBH.getValueAt(i, 4).toString();
        String phuCapKhacBH = modelBH.getValueAt(i, 5).toString();
        String soNgayCongBH = modelBH.getValueAt(i, 8).toString();
        String soGioLamThemBH = modelBH.getValueAt(i, 10).toString();
        String soNgayNghiBH = modelBH.getValueAt(i, 9).toString();
        
        double tienBH =0;
        if (Double.valueOf(soNgayCongBH)>0){
             tienBH = Double.valueOf(luongBH) + Double.valueOf(phuCapBH) + Double.valueOf(phuCapKhacBH) + 
                    (((Double.valueOf(soGioLamThemBH) / 8) - (Double.valueOf(soNgayNghiBH)))  * (Double.valueOf(luongBH) / Double.valueOf(soNgayCongBH)));
            
        }
        else if(Double.valueOf(soNgayCongBH)==0){
            tienBH = Double.valueOf(luongBH)*Double.valueOf(soGioLamThemBH);
        }
        int sum = (int)tienBH;
        
        String pattern = "###,###.###";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(sum);
        
        lblTienBH.setText("" + format);
        txtNamBH.setText(modelBH.getValueAt(i, 7).toString());
        txtThangBH.setText(modelBH.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tblBHMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblNamAN;
    private javax.swing.JLabel lblNamBH;
    private javax.swing.JLabel lblNamDH;
    private javax.swing.JLabel lblNamKK;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JLabel lblSearch2;
    private javax.swing.JLabel lblSearch3;
    private javax.swing.JLabel lblSearch4;
    private javax.swing.JLabel lblThangAN;
    private javax.swing.JLabel lblThangBH;
    private javax.swing.JLabel lblThangDH;
    private javax.swing.JLabel lblThangKK;
    private javax.swing.JLabel lblTienAN;
    private javax.swing.JLabel lblTienBH;
    private javax.swing.JLabel lblTienDH;
    private javax.swing.JLabel lblTienKK;
    private javax.swing.JLabel lblTienLuongAN;
    private javax.swing.JLabel lblTienLuongBH;
    private javax.swing.JLabel lblTienLuongDH;
    private javax.swing.JLabel lblTienLuongKK;
    private javax.swing.JLabel lblVNDAN;
    private javax.swing.JLabel lblVNDBH;
    private javax.swing.JLabel lblVNDDH;
    private javax.swing.JLabel lblVNDKK;
    private javax.swing.JPanel pnAnNinh;
    private javax.swing.JPanel pnBanHang;
    private javax.swing.JPanel pnDieuHanh;
    private javax.swing.JPanel pnKiemKho;
    private javax.swing.JTable tblAN;
    private javax.swing.JTable tblBH;
    private javax.swing.JTable tblDH;
    private javax.swing.JTable tblKK;
    private javax.swing.JLabel txtNamAN;
    private javax.swing.JLabel txtNamBH;
    private javax.swing.JLabel txtNamDH;
    private javax.swing.JLabel txtNamKK;
    private javax.swing.JTextField txtSearchAN;
    private javax.swing.JTextField txtSearchBH;
    private javax.swing.JTextField txtSearchDH;
    private javax.swing.JTextField txtSearchKK;
    private javax.swing.JLabel txtThangAN;
    private javax.swing.JLabel txtThangBH;
    private javax.swing.JLabel txtThangDH;
    private javax.swing.JLabel txtThangKK;
    private javax.swing.JLabel txtThongbaoAN;
    private javax.swing.JLabel txtThongbaoBH;
    private javax.swing.JLabel txtThongbaoDH;
    private javax.swing.JLabel txtThongbaoKK;
    // End of variables declaration//GEN-END:variables
}
