/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.CaLamControl;
import Controller.ChamCongControl;
import Controller.NhanVienControl;
import Model.CaLam;
import Model.ChamCong;
import Model.NhanVien;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.awt.image.ImageObserver.ERROR;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import tableModel.ChamCongModel;
import tableModel.NhanVienModel;

/**
 *
 * @author nhanh
 */
public class ChamCongJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CaLamJPanel
     */
    
    CaLamControl caLamControl;
    NhanVienControl nhanVienControl;
    ChamCongControl chamCongControl;
    
    List<CaLam> listCaLam;
    List<NhanVien> listNhanVien;
    List<ChamCong> listChamCong;
    String dateTime = null;
    String dateTime2 = null;
    public ChamCongJPanel() {
        initComponents();
        initData();
        handle();
    }
    
    public void initData() {
        txtNhanVien.setEditable(false);
        caLamControl = new CaLamControl();
        nhanVienControl = new NhanVienControl();
        chamCongControl = new ChamCongControl();
        listCaLam = caLamControl.GetList();
        listNhanVien = nhanVienControl.GetList();
        listChamCong = chamCongControl.GetList();
        cbxCaLam.removeAllItems();
        for (CaLam caLam : listCaLam) {
            cbxCaLam.addItem(caLam.getTenCa());
        }
        
        for(CaLam cl: listCaLam) {
            if (cbxCaLam.getSelectedItem().toString().equalsIgnoreCase(cl.getTenCa())){
                txtTimeInput.setText(String.valueOf(cl.getThoiGianVao()));
                txtTimeOutput.setText(String.valueOf(cl.getThoiGianRa()));
            }
        }
        TableModel modelNhanVien = new NhanVienModel(listNhanVien);
        tableNhanVien.setModel(modelNhanVien);
        
        TableModel modelChamCong = new ChamCongModel(listChamCong);
        tableChamCong.setModel(modelChamCong);
    }
    
    public void handle() {
        
        // Insert
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        btnChamCong.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtMaCong.getText().isEmpty()) {
                    dateTime = (String) formatter.format(ngayDangKy.getDate());
                    dateTime2 = (String) formatter.format(ngayLam.getDate());
                    Boolean exists = false;
                    for (ChamCong chamCong : listChamCong) {
                        if(chamCong.getMaCong().equalsIgnoreCase(txtMaCong.getText().trim()))
                            exists = true;
                    }
                    if (exists) {
                        JOptionPane.showMessageDialog(null, "Mã công đã tồn tại!");
                    } 
                    else {
                        int r = tableNhanVien.getSelectedRow();
                        String maNV = null;
                        String maCa = null;
                        for (CaLam cl: listCaLam) {
                            if (cl.getTenCa().equalsIgnoreCase(cbxCaLam.getSelectedItem().toString()))
                                maCa = cl.getMaCa();
                        }
                        if (r != -1) {
                            maNV = tableNhanVien.getValueAt(r, 0).toString();
                        }
                        ChamCong chamCong = new ChamCong(txtMaCong.getText(), Date.valueOf(dateTime), Date.valueOf(dateTime2),Float.parseFloat(txtLuongCa.getText().trim()),
                                                         maNV, maCa, txtGhiChu.getText());
                        if (chamCongControl.addChamCong(chamCong)){
                            listChamCong = chamCongControl.GetList();
                            TableModel modelChamCong = new ChamCongModel(listChamCong);
                            tableChamCong.setModel(modelChamCong);
                            JOptionPane.showMessageDialog(null, "Đã thêm chấm công !");
                            Clear();
                        }
                    }
                         
                }
            }
        
        });
        
        cbxCaLam.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               for(CaLam cl: listCaLam) {
                   if (cbxCaLam.getSelectedItem().toString().equalsIgnoreCase(cl.getTenCa())){
                       txtTimeInput.setText(String.valueOf(cl.getThoiGianVao()));
                       txtTimeOutput.setText(String.valueOf(cl.getThoiGianRa()));
                   }
               }
            }
        });
        
        btnXoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = tableChamCong.getSelectedRow();
                if (r != -1) {
                    if (chamCongControl.deleteChamCong(tableChamCong.getValueAt(r, 0).toString())) {
                        JOptionPane.showMessageDialog(null, "Xóa thành công!");
                        listChamCong = chamCongControl.GetList();
                        TableModel modelChamCong = new ChamCongModel(listChamCong);
                        tableChamCong.setModel(modelChamCong);
                        Clear();
                    }else 
                        JOptionPane.showMessageDialog(null, "Chưa chọn dòng xóa!");

                }
            }
        });
        
        btnCapNhat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = tableChamCong.getSelectedRow();
                    dateTime = (String) formatter.format(ngayDangKy.getDate());
                    dateTime2 = (String) formatter.format(ngayLam.getDate());
                if (r != -1) {
                    int r1 = tableNhanVien.getSelectedRow();
                        String maNV = null;
                        String maCa = null;
                        for (CaLam cl: listCaLam) {
                            if (cl.getTenCa().equalsIgnoreCase(cbxCaLam.getSelectedItem().toString()))
                                maCa = cl.getMaCa();
                        }
                        if (r1 != -1) {
                            maNV = tableNhanVien.getValueAt(r1, 0).toString();
                        }else {
                            for(NhanVien nv: listNhanVien){
                                String name = nv.getHoNV() + " " +nv.getTenNV();
                                if (name.equalsIgnoreCase(txtNhanVien.getText().trim())){
                                    maNV = nv.getMaNV();
                                }
                            }
                        }
                        if (maNV.equalsIgnoreCase("")){
                            JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên!");
                        } else {
                            ChamCong chamCong = new ChamCong(txtMaCong.getText(), Date.valueOf(dateTime), Date.valueOf(dateTime2),Float.parseFloat(txtLuongCa.getText().trim()),
                                                         maNV, maCa, txtGhiChu.getText());
                            if (chamCongControl.updateChamCong(chamCong)) {
                                JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
                                listChamCong = chamCongControl.GetList();
                                TableModel modelChamCong = new ChamCongModel(listChamCong);
                                tableChamCong.setModel(modelChamCong);
                                Clear();
                            }else 
                                JOptionPane.showMessageDialog(null, "Chưa chọn dòng cần cập nhật!");
                        }
                        
                }
            }
        });
        
        tableNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = tableNhanVien.getSelectedRow();
                if (r != -1) {
                    txtNhanVien.setText(tableNhanVien.getValueAt(r, 1).toString());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        
        tableChamCong.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = tableChamCong.getSelectedRow();
                if (r != -1) {
                    try {
                        ChamCong chamC = null;
                            for(ChamCong chamCong: listChamCong) {
                                if (chamCong.getMaCong().equalsIgnoreCase(tableChamCong.getValueAt(r, 0).toString())){
                                    chamC = chamCong;
                                }
                            }
                        if (Date.valueOf(LocalDate.now()).compareTo(chamC.getNgayLam()) < 0) {
                        
                            txtMaCong.setText(tableChamCong.getValueAt(r, 0).toString());
                            txtNhanVien.setText(tableChamCong.getValueAt(r, 1).toString().trim());
                            cbxCaLam.setSelectedItem(tableChamCong.getValueAt(r, 2).toString().trim());
                            txtLuongCa.setText(tableChamCong.getValueAt(r, 5).toString());
                            txtGhiChu.setText(tableChamCong.getValueAt(r, 6).toString());
                            for(CaLam cl: listCaLam) {
                                if (cbxCaLam.getSelectedItem().toString().equalsIgnoreCase(cl.getTenCa())){
                                    txtTimeInput.setText(String.valueOf(cl.getThoiGianVao()));
                                    txtTimeOutput.setText(String.valueOf(cl.getThoiGianRa()));
                                }
                            }
                        }else {
                            Clear();
                            tableChamCong.clearSelection();
                        }
                            
                    }catch(Exception ex) {
                        ex.getStackTrace();
                    }
                    
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        
        });
    }
    
    public void Clear() {
        txtMaCong.setText("");
        txtNhanVien.setText("");
        tableNhanVien.clearSelection();
        txtGhiChu.setText("");
        txtLuongCa.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaCong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        cbxCaLam = new javax.swing.JComboBox<>();
        txtLuongCa = new javax.swing.JTextField();
        ngayLam = new com.toedter.calendar.JDateChooser();
        ngayDangKy = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTimeInput = new javax.swing.JTextField();
        txtTimeOutput = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnChamCong = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableChamCong = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ CHẤM CÔNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(373, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Chấm Công"));

        jLabel2.setText("Mã Công:");

        txtMaCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCongActionPerformed(evt);
            }
        });

        jLabel3.setText("Nhân Viên: ");

        txtNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhanVienActionPerformed(evt);
            }
        });

        jLabel4.setText("Lương Ca:");

        jLabel5.setText("Ca Làm:");

        jLabel6.setText("Ngày Đăng Ký");

        jLabel7.setText("Ngày Làm:");

        jLabel8.setText("Ghi Chú:");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane3.setViewportView(txtGhiChu);

        cbxCaLam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Thời Gian Vào:");

        jLabel10.setText("Thời Gian Ra:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimeInput)
                            .addComponent(txtMaCong)
                            .addComponent(cbxCaLam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngayLam, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                            .addComponent(ngayDangKy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNhanVien)
                            .addComponent(txtLuongCa)
                            .addComponent(txtTimeOutput))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtLuongCa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtTimeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimeOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ngayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(ngayLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Nhân Viên"));

        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableNhanVien);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức Năng"));

        btnChamCong.setBackground(new java.awt.Color(51, 255, 51));
        btnChamCong.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnChamCong.setText("Chấm Công");
        btnChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(255, 255, 0));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCapNhat.setText("Cập Nhật");

        btnXoa.setBackground(new java.awt.Color(255, 51, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnChamCong)
                .addGap(54, 54, 54)
                .addComponent(btnCapNhat)
                .addGap(46, 46, 46)
                .addComponent(btnXoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChamCong)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Chấm Công"));

        tableChamCong.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableChamCong);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChamCongActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMaCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCongActionPerformed

    private void txtNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnChamCong;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxCaLam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser ngayDangKy;
    private com.toedter.calendar.JDateChooser ngayLam;
    private javax.swing.JTable tableChamCong;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtLuongCa;
    private javax.swing.JTextField txtMaCong;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtTimeInput;
    private javax.swing.JTextField txtTimeOutput;
    // End of variables declaration//GEN-END:variables
}
