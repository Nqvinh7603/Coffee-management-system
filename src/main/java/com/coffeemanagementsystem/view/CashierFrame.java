package com.coffeemanagementsystem.view;

import java.awt.Color;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Quang Vinh B2110111
 */
public class CashierFrame extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    int ban = 0, loaiSP = 0, dongDangChon = -1;
    int banDaChon[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private String user, hoten;
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public CashierFrame(String user, String hoten) {
        this.user = user;
        this.hoten = hoten;
        initComponents();
        setLocationRelativeTo(null);
        initTableSP();
        initTableTTHD();
        btnXoa.setEnabled(false);
        txtDangChon.setEditable(false);
        txtChao.setText("" + hoten);
        clock();
        initToMau();
        initMauBan();
        toMau();
    }

    public CashierFrame() {
        initComponents();
        setLocationRelativeTo(null);
        initTableSP();
        initTableTTHD();
        btnXoa.setEnabled(false);
        txtDangChon.setEditable(false);
        clock();
        initMauBan();
        initToMau();
        toMau();
    }

    private void clock() {
        ClockThread clock = new ClockThread(lblClock);
        clock.start();
    }
    private DefaultTableModel tblModelSP;
    private DefaultTableModel tblModelTTHD, tblModelHD;

    private void initTableTTHD() {
        tblModelTTHD = new DefaultTableModel();
        tblModelTTHD.setColumnIdentifiers(new Object[]{"Tên sản phẩm", "Giá", "Đơn vị", "Số lượng"});
        tblTTHD.setModel(tblModelTTHD);
    }

    private void initTableHD() {
        tblModelHD = new DefaultTableModel();
        tblModelHD.setColumnIdentifiers(new Object[]{"Tên sản phẩm", "Giá", "Đơn vị", "Số lượng", "Tạm tính"});
        tblHoaDon.setModel(tblModelHD);
    }

    private void initTableSP() {
        tblModelSP = new DefaultTableModel();
        tblModelSP.setColumnIdentifiers(new Object[]{"Mã sản phẩm", "Tên sản phẩm", "Giá", "Đơn vị"});
        tblSP.setModel(tblModelSP);
    }

    private void renderToTableTTHD() {
        tblModelTTHD.setRowCount(0);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "select * from temporary";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) == ban) {
                    Object[] row = new Object[]{
                        rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getInt(7)
                    };
                    tblModelTTHD.addRow(row);
                }

            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblModelTTHD.fireTableDataChanged();
    }

    private void renderToTableSP(int loaiSP) {
        tblModelSP.setRowCount(0);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "select * from product";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(5) == loaiSP) {
                    Object[] row = new Object[]{
                        rs.getString(1), rs.getString(2), formatter.format(rs.getInt(3)),
                        rs.getString(4)
                    };
                    tblModelSP.addRow(row);
                }

            }

            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblModelSP.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dlgDMK = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        txtMatKhauMoi2 = new javax.swing.JPasswordField();
        txtMatKhauCu = new javax.swing.JPasswordField();
        txtMKC = new javax.swing.JLabel();
        txtMKM = new javax.swing.JLabel();
        txtMKM1 = new javax.swing.JLabel();
        dlgThanhToan = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblSoBan = new javax.swing.JLabel();
        lblNhanVienLap = new javax.swing.JLabel();
        lblThoiGianLap = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblSoHoaDon = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pnlChonBan = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtChao = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        changePassBtn = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTHD = new javax.swing.JTable();
        rdoNuoc = new javax.swing.JRadioButton();
        rdoAn = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDangChon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JSpinner();
        jSeparator2 = new javax.swing.JSeparator();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        lblBan = new javax.swing.JLabel();

        dlgDMK.setTitle("ĐỔI MẬT KHẨU");
        dlgDMK.setLocation(new java.awt.Point(400, 250));
        dlgDMK.setMinimumSize(new java.awt.Dimension(520, 300));
        dlgDMK.setModal(true);
        dlgDMK.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Mật khẩu cũ");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Mật khẩu mới");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Nhập lại mật khẩu mới");

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Xác nhận");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Thoát");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txtMKC.setForeground(new java.awt.Color(255, 0, 0));
        txtMKC.setText(" ");

        txtMKM.setForeground(new java.awt.Color(255, 0, 0));
        txtMKM.setText(" ");

        txtMKM1.setForeground(new java.awt.Color(255, 0, 0));
        txtMKM1.setText(" ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMKC)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMatKhauMoi)
                                .addComponent(txtMatKhauCu, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                            .addComponent(txtMKM1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMKM)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtMatKhauMoi2)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtMatKhauCu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(txtMKC)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMKM1)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMatKhauMoi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(txtMKM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dlgDMKLayout = new javax.swing.GroupLayout(dlgDMK.getContentPane());
        dlgDMK.getContentPane().setLayout(dlgDMKLayout);
        dlgDMKLayout.setHorizontalGroup(
            dlgDMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgDMKLayout.setVerticalGroup(
            dlgDMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dlgThanhToan.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dlgThanhToan.setLocation(new java.awt.Point(450, 90));
        dlgThanhToan.setMinimumSize(new java.awt.Dimension(570, 596));
        dlgThanhToan.setModal(true);
        dlgThanhToan.setResizable(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(561, 558));
        jPanel4.setMinimumSize(new java.awt.Dimension(561, 558));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Số bàn:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nhân viên lập:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Thời gian lập:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Chi tiết:");

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Giá", "donvitinh", "Số Lương", "Tạm tính"
            }
        ));
        jScrollPane3.setViewportView(tblHoaDon);

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Đồng ý");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("THÀNH TIỀN:");

        lblSoBan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoBan.setText("lblSoBan");

        lblNhanVienLap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNhanVienLap.setText("lblNhanVienLap");

        lblThoiGianLap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblThoiGianLap.setText("lblThoiGianLap");

        lblThanhTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblThanhTien.setText("lblThanhTien");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Số hóa đơn:");

        lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSoHoaDon.setText("lblSoHoaDon");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1)
                            .addComponent(lblThanhTien))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoHoaDon)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblThoiGianLap, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(lblNhanVienLap, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblSoHoaDon))
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblSoBan))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNhanVienLap))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lblThoiGianLap))
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblThanhTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout dlgThanhToanLayout = new javax.swing.GroupLayout(dlgThanhToan.getContentPane());
        dlgThanhToan.getContentPane().setLayout(dlgThanhToanLayout);
        dlgThanhToanLayout.setHorizontalGroup(
            dlgThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgThanhToanLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dlgThanhToanLayout.setVerticalGroup(
            dlgThanhToanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgThanhToanLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THU NGÂN");
        setResizable(false);

        pnlChonBan.setBackground(new java.awt.Color(153, 153, 153));
        pnlChonBan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn1.setBackground(new java.awt.Color(255, 102, 0));
        btn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn1.setForeground(new java.awt.Color(255, 255, 255));
        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn11.setBackground(new java.awt.Color(255, 102, 0));
        btn11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn11.setForeground(new java.awt.Color(255, 255, 255));
        btn11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn11.setText("11");
        btn11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 102, 0));
        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn2.setForeground(new java.awt.Color(255, 255, 255));
        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn12.setBackground(new java.awt.Color(255, 102, 0));
        btn12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn12.setForeground(new java.awt.Color(255, 255, 255));
        btn12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn12.setText("12");
        btn12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(255, 102, 0));
        btn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn3.setForeground(new java.awt.Color(255, 255, 255));
        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(255, 102, 0));
        btn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn4.setForeground(new java.awt.Color(255, 255, 255));
        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn13.setBackground(new java.awt.Color(255, 102, 0));
        btn13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn13.setForeground(new java.awt.Color(255, 255, 255));
        btn13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn13.setText("13");
        btn13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn13ActionPerformed(evt);
            }
        });

        btn14.setBackground(new java.awt.Color(255, 102, 0));
        btn14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn14.setForeground(new java.awt.Color(255, 255, 255));
        btn14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn14.setText("14");
        btn14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn14ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 102, 0));
        btn5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn5.setForeground(new java.awt.Color(255, 255, 255));
        btn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(255, 102, 0));
        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.setForeground(new java.awt.Color(255, 255, 255));
        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(255, 102, 0));
        btn7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn7.setForeground(new java.awt.Color(255, 255, 255));
        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(255, 102, 0));
        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn8.setForeground(new java.awt.Color(255, 255, 255));
        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn18.setBackground(new java.awt.Color(255, 102, 0));
        btn18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn18.setForeground(new java.awt.Color(255, 255, 255));
        btn18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn18.setText("18");
        btn18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn18ActionPerformed(evt);
            }
        });

        btn17.setBackground(new java.awt.Color(255, 102, 0));
        btn17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn17.setForeground(new java.awt.Color(255, 255, 255));
        btn17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn17.setText("17");
        btn17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn17ActionPerformed(evt);
            }
        });

        btn16.setBackground(new java.awt.Color(255, 102, 0));
        btn16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn16.setForeground(new java.awt.Color(255, 255, 255));
        btn16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn16.setText("16");
        btn16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn16ActionPerformed(evt);
            }
        });

        btn15.setBackground(new java.awt.Color(255, 102, 0));
        btn15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn15.setForeground(new java.awt.Color(255, 255, 255));
        btn15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn15.setText("15");
        btn15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn15ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(255, 102, 0));
        btn9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn9.setForeground(new java.awt.Color(255, 255, 255));
        btn9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn19.setBackground(new java.awt.Color(255, 102, 0));
        btn19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn19.setForeground(new java.awt.Color(255, 255, 255));
        btn19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn19.setText("19");
        btn19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn19ActionPerformed(evt);
            }
        });

        btn10.setBackground(new java.awt.Color(255, 102, 0));
        btn10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn10.setForeground(new java.awt.Color(255, 255, 255));
        btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn10.setText("10");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn20.setBackground(new java.awt.Color(255, 102, 0));
        btn20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn20.setForeground(new java.awt.Color(255, 255, 255));
        btn20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-100-Flat-Dinner.16.png"))); // NOI18N
        btn20.setText("20");
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChonBanLayout = new javax.swing.GroupLayout(pnlChonBan);
        pnlChonBan.setLayout(pnlChonBanLayout);
        pnlChonBanLayout.setHorizontalGroup(
            pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChonBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn16, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn12, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(btn17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn19, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btn4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn15, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                    .addComponent(btn10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlChonBanLayout.setVerticalGroup(
            pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChonBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChonBanLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlChonBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtChao.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtChao.setForeground(new java.awt.Color(153, 153, 153));

        jButton3.setBackground(new java.awt.Color(255, 204, 12));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Log out");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        changePassBtn.setBackground(new java.awt.Color(255, 204, 12));
        changePassBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        changePassBtn.setText("Change password");
        changePassBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        changePassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassBtnActionPerformed(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 0, 0));
        lblClock.setText("tg");
        lblClock.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtChao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePassBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));

        tblTTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTHDMouseClicked(evt);
            }
        });
        tblTTHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTTHDKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTHD);

        buttonGroup1.add(rdoNuoc);
        rdoNuoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoNuoc.setForeground(new java.awt.Color(255, 0, 0));
        rdoNuoc.setText("DRINK");
        rdoNuoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Graphicloads-Food-Drink-Drink-3.24.png"))); // NOI18N
        rdoNuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoNuocMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoAn);
        rdoAn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rdoAn.setForeground(new java.awt.Color(51, 0, 255));
        rdoAn.setText("FOOD");
        rdoAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Webalys-Kameleon.pics-Food-Dome.24.png"))); // NOI18N
        rdoAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoAnMouseClicked(evt);
            }
        });
        rdoAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAnActionPerformed(evt);
            }
        });

        tblSP.setForeground(new java.awt.Color(51, 0, 255));
        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product code", "Product name", "Unit", "Price"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        tblSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblSPKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tblSP);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CHOOSING:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TEMPORARY BILL");

        txtDangChon.setEditable(false);
        txtDangChon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDangChon.setForeground(new java.awt.Color(51, 51, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MENU");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("QUANTITY:");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSoLuong.setValue(1);

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Kyo-Tux-Aeon-Sign-Close.24.png"))); // NOI18N
        btnXoa.setText("Remove");
        btnXoa.setMaximumSize(new java.awt.Dimension(60, 35));
        btnXoa.setMinimumSize(new java.awt.Dimension(60, 35));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(255, 51, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Hopstarter-Button-Button-Add.24.png"))); // NOI18N
        btnThem.setText("Add");
        btnThem.setMaximumSize(new java.awt.Dimension(60, 35));
        btnThem.setMinimumSize(new java.awt.Dimension(60, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(51, 153, 255));
        btnThanhToan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/coffeemanagementsystem/images/Designbolts-Seo-Pay-Per-Click.24.png"))); // NOI18N
        btnThanhToan.setText("PAY");
        btnThanhToan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rdoAn)
                                .addGap(42, 42, 42)
                                .addComponent(rdoNuoc))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDangChon, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoAn)
                            .addComponent(rdoNuoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDangChon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(txtSoLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        lblBan.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBan.setForeground(new java.awt.Color(204, 102, 0));
        lblBan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblBan.setMaximumSize(new java.awt.Dimension(64, 35));
        lblBan.setMinimumSize(new java.awt.Dimension(64, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlChonBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlChonBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(lblBan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
        ban = 6;
        lblBan.setText("TABLE" + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        ban = 1;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn1ActionPerformed

    private void rdoNuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoNuocMouseClicked
        // TODO add your handling code here:
        loaiSP = 1;
        renderToTableSP(loaiSP);
    }//GEN-LAST:event_rdoNuocMouseClicked

    private void rdoAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoAnMouseClicked
        // TODO add your handling code here:
        loaiSP = 2;
        renderToTableSP(loaiSP);
    }//GEN-LAST:event_rdoAnMouseClicked

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        dongDangChon = tblSP.getSelectedRow();
        txtDangChon.setText(tblSP.getValueAt(dongDangChon, 0).toString());
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
    }//GEN-LAST:event_tblSPMouseClicked

    private void tblTTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTHDMouseClicked
        // TODO add your handling code here:
        int row = tblTTHD.getSelectedRow();
        String tensp = tblTTHD.getValueAt(row, 0).toString();
        int soluong = Integer.parseInt(tblTTHD.getValueAt(row, 3).toString());
        txtDangChon.setText(tensp);
        txtSoLuong.setValue(soluong);

        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
    }//GEN-LAST:event_tblTTHDMouseClicked
    private void initMauBan() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "select * from temporary";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                banDaChon[rs.getInt(1)] = 1;
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    private void toMauBan(int i) {
        switch (i) {
            case 1:
                btn1.setBackground(Color.cyan);
                break;
            case 2:
                btn2.setBackground(Color.cyan);
                break;
            case 3:
                btn3.setBackground(Color.cyan);
                break;
            case 4:
                btn4.setBackground(Color.cyan);
                break;
            case 5:
                btn5.setBackground(Color.cyan);
                break;
            case 6:
                btn6.setBackground(Color.cyan);
                break;
            case 7:
                btn7.setBackground(Color.cyan);
                break;
            case 8:
                btn8.setBackground(Color.cyan);
                break;
            case 9:
                btn9.setBackground(Color.cyan);
                break;
            case 10:
                btn10.setBackground(Color.cyan);
                break;
            case 11:
                btn11.setBackground(Color.cyan);
                break;
            case 12:
                btn12.setBackground(Color.cyan);
                break;
            case 13:
                btn13.setBackground(Color.cyan);
                break;
            case 14:
                btn14.setBackground(Color.cyan);
                break;
            case 15:
                btn15.setBackground(Color.cyan);
                break;
            case 16:
                btn16.setBackground(Color.cyan);
                break;
            case 17:
                btn17.setBackground(Color.cyan);
                break;
            case 18:
                btn18.setBackground(Color.cyan);
                break;
            case 19:
                btn19.setBackground(Color.cyan);
                break;
            case 20:
                btn20.setBackground(Color.cyan);
                break;

            default:
                break;
        }
    }

    private void toMau() {
        for (int i = 1; i <= 20; i++) {
            if (banDaChon[i] == 1) {
                toMauBan(i);
            }
        }
    }

    private void initToMau() {
        for (int i = 1; i <= 20; i++) {
            xoaMauBan(i);
        }
    }

    private void xoaMauBan(int i) {
        switch (i) {
            case 1:
                btn1.setBackground(Color.gray);
                break;
            case 2:
                btn2.setBackground(Color.gray);
                break;
            case 3:
                btn3.setBackground(Color.gray);
                break;
            case 4:
                btn4.setBackground(Color.gray);
                break;
            case 5:
                btn5.setBackground(Color.gray);
                break;
            case 6:
                btn6.setBackground(Color.gray);
                break;
            case 7:
                btn7.setBackground(Color.gray);
                break;
            case 8:
                btn8.setBackground(Color.gray);
                break;
            case 9:
                btn9.setBackground(Color.gray);
                break;
            case 10:
                btn10.setBackground(Color.gray);
                break;
            case 11:
                btn11.setBackground(Color.gray);
                break;
            case 12:
                btn12.setBackground(Color.gray);
                break;
            case 13:
                btn13.setBackground(Color.gray);
                break;
            case 14:
                btn14.setBackground(Color.gray);
                break;
            case 15:
                btn15.setBackground(Color.gray);
                break;
            case 16:
                btn16.setBackground(Color.gray);
                break;
            case 17:
                btn17.setBackground(Color.gray);
                break;
            case 18:
                btn18.setBackground(Color.gray);
                break;
            case 19:
                btn19.setBackground(Color.gray);
                break;
            case 20:
                btn20.setBackground(Color.gray);
                break;

            default:
                break;
        }
    }
    boolean daThemThanhCong = false;
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int soluong = Integer.parseInt(txtSoLuong.getValue().toString());
        String masp = txtDangChon.getText();
        if (ban < 1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        else if (masp.isEmpty())
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        else if (soluong < 1)
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        else {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String Url = "jdbc:mysql://localhost/coffee";
                String dbuser = "root";
                String pass = "Nqv@762003";
                Connection conn = DriverManager.getConnection(Url, dbuser, pass);
                String sql = "select * from product where idproduct=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, masp);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {

                    sql = "INSERT INTO temporary VALUES(?,?,?,?,?,?,?)";
                    st = conn.prepareStatement(sql);
                    st.setInt(1, ban);

                    st.setString(2, masp);
                    st.setString(3, rs.getString(2));
                    st.setInt(4, rs.getInt(3));
                    st.setString(5, rs.getString(4));
                    st.setInt(6, rs.getInt(5));
                    st.setInt(7, soluong);
                    int sodong = st.executeUpdate();
                    daThemThanhCong = true;
                    JOptionPane.showMessageDialog(this, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                txtDangChon.setText("");
                txtSoLuong.setValue(1);
                banDaChon[ban] = 1;
                toMauBan(ban);
                renderToTableTTHD();
                rs.close();
                st.close();
                conn.close();
                
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        ban = 2;
        lblBan.setText("Table : " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblTTHD.getSelectedRow();
        if (row >= 0) {
            String tensp = tblTTHD.getValueAt(row, 0).toString();
            int soluong = Integer.parseInt(tblTTHD.getValueAt(row, 3).toString());
            int giasp = Integer.parseInt(tblTTHD.getValueAt(row, 1).toString());
            String donvisp = tblTTHD.getValueAt(row, 2).toString();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String Url = "jdbc:mysql://localhost/coffee";
                String dbuser = "root";
                String pass = "Nqv@762003";
                Connection conn = DriverManager.getConnection(Url, dbuser, pass);
                String sql = "DELETE FROM temporary WHERE name=? AND quantity=? AND price=? AND unit=?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, tensp);
                st.setInt(3, giasp);
                st.setString(4, donvisp);
                st.setInt(2, soluong);

                int sodong = st.executeUpdate();
                if (sodong > 0) {
                    renderToTableTTHD();
                    txtDangChon.setText("");
                    txtSoLuong.setValue(1);
                    if (tblTTHD.getRowCount() == 0) {
                        banDaChon[ban] = 0;
                        xoaMauBan(ban);
                    }
                    JOptionPane.showMessageDialog(this, "Đã xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                st.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        ban = 3;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        ban = 7;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();        // TODO add your handling code here:
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        ban = 8;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        ban = 9;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
        ban = 10;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn10ActionPerformed

    private void btn11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ActionPerformed
        // TODO add your handling code here:
        ban = 11;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn11ActionPerformed

    private void btn12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ActionPerformed
        ban = 12;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn12ActionPerformed

    private void btn13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn13ActionPerformed
        // TODO add your handling code here:
        ban = 13;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn13ActionPerformed

    private void btn14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn14ActionPerformed
        ban = 14;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn14ActionPerformed

    private void btn15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn15ActionPerformed
        ban = 15;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn15ActionPerformed

    private void btn16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn16ActionPerformed
        ban = 16;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn16ActionPerformed

    private void btn17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn17ActionPerformed
        ban = 17;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn17ActionPerformed

    private void btn18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn18ActionPerformed
        ban = 18;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn18ActionPerformed

    private void btn19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn19ActionPerformed
        ban = 19;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn19ActionPerformed

    private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20ActionPerformed
        ban = 20;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();// TODO add your handling code here:
    }//GEN-LAST:event_btn20ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        ban = 4;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
        ban = 5;
        lblBan.setText("TABLE " + ban);
        renderToTableTTHD();
    }//GEN-LAST:event_btn5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int yes = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn Đăng xuất không?", "THÔNG BÁO", JOptionPane.YES_NO_OPTION);
        if (yes == 0) {
            this.dispose();
            LoginFrame dn = new LoginFrame();
            dn.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        String pw = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "select password from user WHERE account=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                pw = rs.getString(1);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!pw.equals(txtMatKhauCu.getText()))
            txtMKC.setText("SAI MẬT KHẨU!");
        else {
            txtMKC.setText(" ");
            if (txtMatKhauMoi.getText().trim().isEmpty()) {
                txtMKM1.setText("KHÔNG ĐƯỢC ĐỂ TRỐNG!");
            } else if (!txtMatKhauMoi.getText().equals(txtMatKhauMoi2.getText())) {
                txtMKM.setText("KHÔNG KHỚP!");
                txtMKM1.setText(" ");
            } else {

                txtMKM.setText(" ");
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    String Url = "jdbc:mysql://localhost/coffee";
                    String dbuser = "root";
                    String pass = "Nqv@762003";
                    Connection conn = DriverManager.getConnection(Url, dbuser, pass);
                    String sql = "UPDATE user SET password=? WHERE account=?";
                    PreparedStatement st = conn.prepareStatement(sql);
                    st.setString(1, txtMatKhauMoi.getText());
                    st.setString(2, user);
                    int dong = st.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thành công!");
                    txtMatKhauCu.setText("");
                    txtMatKhauMoi.setText("");
                    txtMatKhauMoi2.setText("");
                    txtMKM1.setText(" ");
                    dlgDMK.dispose();
                    st.close();
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dlgDMK.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void changePassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassBtnActionPerformed
        // TODO add your handling code here:
        ChangePasswordFrame changePasswordFrame = new ChangePasswordFrame(user);
        changePasswordFrame.setVisible(true);
//dlgDMK.setVisible(true);
//        dlgDMK.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_changePassBtnActionPerformed

    public String layNgay() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String s = date.toString().trim();

        String[] parts = s.split("-");
        String nam = parts[0];
        String thang = parts[1];
        String ngay = parts[2];
        return ngay + "-" + thang + "-" + nam;
    }

    private int sohd, tienan = 0, tiennuoc = 0;

    private void renderToTableThanhToan() {
        tblModelHD.setRowCount(0);
        tienan = 0;
        tiennuoc = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "select max(idreceipt) from receipt";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            rs = st.executeQuery();
            if (rs.next()) {
                sohd = rs.getInt(1) + 1;
            }

            sql = "select * from temporary where tablenumber=? ";
            st = conn.prepareStatement(sql);
            st.setInt(1, ban);
            rs = st.executeQuery();
            while (rs.next()) {
                if (rs.getInt(6) == 1) {
                    tiennuoc += rs.getInt(4) * rs.getInt(7);
                } else {
                    tienan += rs.getInt(4) * rs.getInt(7);
                }

                Object[] row = new Object[]{
                    rs.getString(3), formatter.format(rs.getInt(4)), rs.getString(5),
                    rs.getInt(7), formatter.format(rs.getInt(4) * rs.getInt(7)) + " VNĐ"
                };
                tblModelHD.addRow(row);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tblModelHD.fireTableDataChanged();
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if(daThemThanhCong){
        int soluong = Integer.parseInt(txtSoLuong.getValue().toString());

        String masp = txtDangChon.getText();
        if (ban < 1)
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        else if (tblTTHD.getRowCount() < 1)
            JOptionPane.showMessageDialog(this, "Chưa gọi món", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        else {
            initTableHD();
            renderToTableThanhToan();
            lblSoBan.setText(ban + "");
            lblSoHoaDon.setText(sohd + "");
            lblNhanVienLap.setText(hoten);
            lblThoiGianLap.setText(lblClock.getText().trim() + "  Ngày " + layNgay());
            lblThanhTien.setText(formatter.format((tienan + tiennuoc)) + " VNĐ");

            dlgThanhToan.setVisible(true);
            dlgThanhToan.setLocationRelativeTo(null);
        }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm trước khi thanh toán!", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblSPKeyReleased
        // TODO add your handling code here:
        dongDangChon = tblSP.getSelectedRow();
        txtDangChon.setText(tblSP.getValueAt(dongDangChon, 0).toString());
        btnXoa.setEnabled(false);
        btnThem.setEnabled(true);
    }//GEN-LAST:event_tblSPKeyReleased

    private void tblTTHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTTHDKeyReleased
        // TODO add your handling code here:
        int row = tblTTHD.getSelectedRow();
        String tensp = tblTTHD.getValueAt(row, 0).toString();
        int soluong = Integer.parseInt(tblTTHD.getValueAt(row, 3).toString());
        txtDangChon.setText(tensp);
        txtSoLuong.setValue(soluong);

        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
    }//GEN-LAST:event_tblTTHDKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dlgThanhToan.dispose();
        ThanhToan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rdoAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoAnActionPerformed
    //Đổ data vô Bảng HoaDon
    public String layNgayHD() {
//        long millis = System.currentTimeMillis();
//        java.sql.Date date = new java.sql.Date(millis);
//        String s = date.toString().trim();
//
//        String[] parts = s.split("-");
//        String nam = parts[0];
//        String thang = parts[1];
//        String ngay = parts[2];
//        return thang + "-" + ngay + "-" + nam;
            long millis = System.currentTimeMillis();
    java.sql.Timestamp timestamp = new java.sql.Timestamp(millis);
    
    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    try {
        // Format lại ngày tháng theo định dạng mới
        String formattedDateTime = outputFormat.format(timestamp);
        return formattedDateTime;
    } catch (Exception e) {
        e.printStackTrace();
        return ""; // Hoặc xử lý lỗi theo ý của bạn
    }

    }

    private void ThanhToan() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Url = "jdbc:mysql://localhost/coffee";
            String dbuser = "root";
            String pass = "Nqv@762003";
            Connection conn = DriverManager.getConnection(Url, dbuser, pass);
            String sql = "insert into receipt values(?,?,?,?,?)";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setInt(1, sohd);
            st.setString(2, hoten);
            st.setString(3, layNgayHD());
            st.setInt(4, tiennuoc);
            st.setInt(5, tienan);
            int soDong = st.executeUpdate();
            if (soDong > 0) {
                JOptionPane.showMessageDialog(this, "Đã thanh toán bàn số " + ban, "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
            }

            //Xóa Tạm tính hóa đơn
            sql = "delete from temporary where tablenumber = ?";
            banDaChon[ban] = 0;
            xoaMauBan(ban);
            st = conn.prepareStatement(sql);
            st.setInt(1, ban);
            soDong = st.executeUpdate();
            renderToTableTTHD();
            st.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi", "CẢNH BÁO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton changePassBtn;
    private javax.swing.JDialog dlgDMK;
    private javax.swing.JDialog dlgThanhToan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblNhanVienLap;
    private javax.swing.JLabel lblSoBan;
    private javax.swing.JLabel lblSoHoaDon;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblThoiGianLap;
    private javax.swing.JPanel pnlChonBan;
    private javax.swing.JRadioButton rdoAn;
    private javax.swing.JRadioButton rdoNuoc;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSP;
    private javax.swing.JTable tblTTHD;
    private javax.swing.JLabel txtChao;
    private javax.swing.JTextField txtDangChon;
    private javax.swing.JLabel txtMKC;
    private javax.swing.JLabel txtMKM;
    private javax.swing.JLabel txtMKM1;
    private javax.swing.JPasswordField txtMatKhauCu;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtMatKhauMoi2;
    private javax.swing.JSpinner txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
