/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DonorSelfRegistration;

import Business.EcoSystem;
import Business.Enterprise.DonationMgmtEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DonationOrganization;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.DonorRole;
import Business.Role.Role;
import javax.swing.JOptionPane;

/**
 *
 * @author namra
 */
public class DonorSelfRegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form donorSelfRegistrationJPanel
     */
    private EcoSystem system;
    public DonorSelfRegistrationJPanel(EcoSystem system) 
    {
        initComponents();
        this.system=system;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameTxtFld = new javax.swing.JTextField();
        userNameTxtFld = new javax.swing.JTextField();
        registerBtn = new javax.swing.JButton();
        passwordPasswordFld = new javax.swing.JPasswordField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Donor Registration");

        jLabel2.setText("Name : ");

        jLabel3.setText("UserName : ");

        jLabel4.setText("Password : ");

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(204, 204, 204)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userNameTxtFld)
                    .addComponent(nameTxtFld)
                    .addComponent(passwordPasswordFld, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(registerBtn)
                    .addComponent(jLabel1))
                .addGap(237, 237, 237))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordPasswordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addComponent(registerBtn)
                .addGap(131, 131, 131))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
       
        
    if(nameTxtFld.getText().equals(""))// || nameTxtFld.getText().matches("[1-0]+") )
    {
        JOptionPane.showMessageDialog(null, "Invalid entry in name Field");
        return;
    }
    
    if(userNameTxtFld.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null, "Invalid entry in UserName Field");
        return;
    }
    
    if(passwordPasswordFld.getText().equals(""))
    {
       JOptionPane.showMessageDialog(null, "Invalid entry in password Field");
        return; 
    }
        
        
    
        for (Network network : system.getNetworkList())
        {
            for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise instanceof DonationMgmtEnterprise)
                {
                    for(Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        if(organization instanceof DonationOrganization)
                        {
                            Person person = organization.getPersonDirectory().createEmployee(nameTxtFld.getText());
                            Role role = new DonorRole();
                            
                            if(organization.getUserAccountDirectory().checkIfUsernameIsUnique(userNameTxtFld.getText()) == false)
                            {
                                JOptionPane.showMessageDialog(null, "User name already exists. Try a different one.");
                                return;
                            }
                            
                            organization.getUserAccountDirectory().createUserAccount(userNameTxtFld.getText(), passwordPasswordFld.getText(), person, role);
                             
                        }
                    }
                }
                 
            }
        
        }
    
    
    

    }//GEN-LAST:event_registerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTxtFld;
    private javax.swing.JPasswordField passwordPasswordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField userNameTxtFld;
    // End of variables declaration//GEN-END:variables
}
