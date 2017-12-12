/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ScientistRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.ResearchEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ScientistWorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vikram
 */
public class HurricanePredictionJPanel extends javax.swing.JPanel {

    /**
     * Creates new form HurricanePredictionJPanel
     */
    JPanel userProcessContainer;
    OrganizationDirectory organizationDirectory;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    
    HurricanePredictionJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, UserAccount account, Enterprise enterprise,Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organizationDirectory = organizationDirectory;
        this.account = account;
        this.enterprise = enterprise;
        this.network = network;
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
        btnPredict = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hurricane Prediction");

        btnPredict.setText("Predict");
        btnPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredictActionPerformed(evt);
            }
        });

        backBtn.setText("<<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(560, 560, 560)
                                .addComponent(btnPredict, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(backBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(btnPredict, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(96, 96, 96))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredictActionPerformed
        // TODO add your handling code here:
                
        ScientistWorkRequest request = new ScientistWorkRequest();
        
//        request.setSender(userAccount);
//        request.setStatus("Donated");
        //request.getResearch().setEmergency("Earthquake Emergency");
        //request.setMessage(message);
        Organization org = null;
        Enterprise ent = null;
            for (Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()) {
                      if (en instanceof ResearchEnterprise){
                    ent = en;
                    break;
                }  
                    }
                if (ent!=null){
                    JOptionPane.showMessageDialog(null, "Request Sent");
                    request.setSender(account);
                    request.getResearch().setEmergency("Hurricane Emergency");
                    //request.setStatus("Earthquake Emergency");
                    ent.getWorkQueue().getWorkRequestList().add(request);
    } 
    }//GEN-LAST:event_btnPredictActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnPredict;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
