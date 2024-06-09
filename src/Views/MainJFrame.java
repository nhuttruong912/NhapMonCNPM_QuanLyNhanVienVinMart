package Views;

import Bean.DanhMucBean;
import Controller.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nhanh
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() {
        initComponents();     
        setTitle("NHÓM 24: Quản lý nhân viên làm việc ở cửa hàng VinMart Lê Văn Việt");
        setLocationRelativeTo(null);
        ChuyenManHinhController controller= new ChuyenManHinhController(jpnView);
        controller.setView(jpnNhanVien, jlbNhanVien);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        //listItem.add(new DanhMucBean("TrangChu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucBean("ChamCong", jpnChamCong, jlbChamCong));
        listItem.add(new DanhMucBean("PhieuLuong", jpnPhieuLuong, jlbPhieuLuong));
        listItem.add(new DanhMucBean("DoiMatKhau", jpnDoiMatKhau, jlbDoiMatKhau));
        
        controller.setEvent(listItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnChamCong = new javax.swing.JPanel();
        jlbChamCong = new javax.swing.JLabel();
        jpnPhieuLuong = new javax.swing.JPanel();
        jlbPhieuLuong = new javax.swing.JLabel();
        jpnDoiMatKhau = new javax.swing.JPanel();
        jlbDoiMatKhau = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        jpnRoot.setPreferredSize(new java.awt.Dimension(1200, 650));

        jpnMenu.setBackground(new java.awt.Color(82, 81, 82));

        jpnNhanVien.setBackground(new java.awt.Color(0, 153, 51));

        jlbNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Infor.png"))); // NOI18N
        jlbNhanVien.setText("THÔNG TIN NHÂN VIÊN");

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNhanVienLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jpnChamCong.setBackground(new java.awt.Color(0, 153, 51));

        jlbChamCong.setBackground(new java.awt.Color(255, 255, 255));
        jlbChamCong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbChamCong.setForeground(new java.awt.Color(255, 255, 255));
        jlbChamCong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbChamCong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CHAM_CONG.png"))); // NOI18N
        jlbChamCong.setText("CHẤM CÔNG");

        javax.swing.GroupLayout jpnChamCongLayout = new javax.swing.GroupLayout(jpnChamCong);
        jpnChamCong.setLayout(jpnChamCongLayout);
        jpnChamCongLayout.setHorizontalGroup(
            jpnChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChamCongLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnChamCongLayout.setVerticalGroup(
            jpnChamCongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChamCongLayout.createSequentialGroup()
                .addComponent(jlbChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnPhieuLuong.setBackground(new java.awt.Color(0, 153, 51));

        jlbPhieuLuong.setBackground(new java.awt.Color(255, 255, 255));
        jlbPhieuLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbPhieuLuong.setForeground(new java.awt.Color(255, 255, 255));
        jlbPhieuLuong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbPhieuLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/PHIEU_LUONG.png"))); // NOI18N
        jlbPhieuLuong.setText("PHIẾU LƯƠNG");

        javax.swing.GroupLayout jpnPhieuLuongLayout = new javax.swing.GroupLayout(jpnPhieuLuong);
        jpnPhieuLuong.setLayout(jpnPhieuLuongLayout);
        jpnPhieuLuongLayout.setHorizontalGroup(
            jpnPhieuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuLuongLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbPhieuLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnPhieuLuongLayout.setVerticalGroup(
            jpnPhieuLuongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnPhieuLuongLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbPhieuLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jpnDoiMatKhau.setBackground(new java.awt.Color(0, 153, 51));

        jlbDoiMatKhau.setBackground(new java.awt.Color(255, 255, 255));
        jlbDoiMatKhau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbDoiMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        jlbDoiMatKhau.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/DOI_MK.png"))); // NOI18N
        jlbDoiMatKhau.setText("ĐỔI MẬT KHẨU");

        javax.swing.GroupLayout jpnDoiMatKhauLayout = new javax.swing.GroupLayout(jpnDoiMatKhau);
        jpnDoiMatKhau.setLayout(jpnDoiMatKhauLayout);
        jpnDoiMatKhauLayout.setHorizontalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoiMatKhauLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jpnDoiMatKhauLayout.setVerticalGroup(
            jpnDoiMatKhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDoiMatKhauLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jlbDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpnMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnPhieuLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpnChamCong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnChamCong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnPhieuLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1016, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnRoot, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            //@Override
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbChamCong;
    private javax.swing.JLabel jlbDoiMatKhau;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbPhieuLuong;
    private javax.swing.JPanel jpnChamCong;
    private javax.swing.JPanel jpnDoiMatKhau;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnPhieuLuong;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
