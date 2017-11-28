/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ScientistRole;

import Business.Enterprise.DonationMgmtEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ResearchEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EmergencyWorkRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vikram
 */
public class EarthquakePredictionJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EarthquakePredictionJPanel
     */

    JPanel userProcessContainer;
    OrganizationDirectory organizationDirectory;
    UserAccount account;
    Enterprise enterprise;
    Network network;
    
    EarthquakePredictionJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, UserAccount account, Enterprise enterprise,Network network) {
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

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(51, 255, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hurricane Prediction");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 960, 40));

        btnPredict.setText("Predict");
        btnPredict.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPredictActionPerformed(evt);
            }
        });
        add(btnPredict, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 170, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPredictActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPredictActionPerformed
        // TODO add your handling code here:
        
        EmergencyWorkRequest request = new EmergencyWorkRequest();
        
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
                    request.getResearch().setEmergency("Earthquake Emergency");
                    //request.setStatus("Earthquake Emergency");
                    ent.getWorkQueue().getWorkRequestList().add(request);
    }//GEN-LAST:event_btnPredictActionPerformed
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPredict;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
