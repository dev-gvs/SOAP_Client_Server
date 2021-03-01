package gui;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import soap.IServer;
import soap.Result;

public class Main extends javax.swing.JFrame {

    String serverAddress = "";
    IServer soapServer;

    public Main() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelY = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldX = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldA = new javax.swing.JTextField();
        jButtonSolve = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldServerAddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GVS03_SOAP_Client_Server");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/example.png"))); // NOI18N
        jLabel1.setAlignmentY(0.0F);
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabelY.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelY.setText("Y =");
        getContentPane().add(jLabelY, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 220, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("X =");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 30, -1));

        jTextFieldX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldX, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("A =");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 30, -1));

        jTextFieldA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 90, -1));

        jButtonSolve.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonSolve.setText("Решить");
        jButtonSolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSolve, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 220, 30));

        jButtonClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonClear.setText("Очистить");
        jButtonClear.setMaximumSize(new java.awt.Dimension(87, 25));
        jButtonClear.setMinimumSize(new java.awt.Dimension(87, 25));
        jButtonClear.setPreferredSize(new java.awt.Dimension(87, 25));
        jButtonClear.setRequestFocusEnabled(false);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 220, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("B =");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 30, -1));

        jTextFieldB.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jTextFieldB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Адрес сервера:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, 20));

        jTextFieldServerAddress.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldServerAddress.setText("http://localhost:1099/soap");
        getContentPane().add(jTextFieldServerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 450, -1));

        setSize(new java.awt.Dimension(622, 410));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        jTextFieldX.setText("");
        jTextFieldA.setText("");
        jTextFieldB.setText("");
        jLabelY.setText("Y =");
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonSolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolveActionPerformed
        try {
            String newServerAddress = jTextFieldServerAddress.getText();

            if (!serverAddress.equals(newServerAddress)) {
                serverAddress = newServerAddress;
                JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
                factoryBean.setServiceClass(IServer.class);
                factoryBean.setAddress(serverAddress);
                soapServer = (IServer) factoryBean.create();
            }

            double x = Double.parseDouble(jTextFieldX.getText());
            double secondArg;
            if (x <= 4) {
                secondArg = Double.parseDouble(jTextFieldA.getText());
            } else {
                secondArg = Double.parseDouble(jTextFieldB.getText());
            }

            // Вызов удаленного метода на сервере через web-технологию SOAP
            Result result = soapServer.solve(x, secondArg);

            if (result != null) {
                jLabelY.setText("Y = " + result.getY());
            } else {
                jLabelY.setText("ОШИБКА");
            }
        } catch (Exception e) {
            e.printStackTrace();
            jLabelY.setText("ОШИБКА");
        }
    }//GEN-LAST:event_jButtonSolveActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonSolve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelY;
    private javax.swing.JTextField jTextFieldA;
    private javax.swing.JTextField jTextFieldB;
    private javax.swing.JTextField jTextFieldServerAddress;
    private javax.swing.JTextField jTextFieldX;
    // End of variables declaration//GEN-END:variables
}
