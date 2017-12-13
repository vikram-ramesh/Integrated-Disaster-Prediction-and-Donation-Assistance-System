/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DonorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import UserInterface.MainJFrame;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vikram
 */
public class ConfirmDonationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConfirmDonationJPanel
     */
    int k;
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount account;
    private Enterprise enterprise;

    ConfirmDonationJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, UserAccount account, Enterprise enterprise, int k) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.organizationDirectory=organizationDirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.k = k;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOtp = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(txtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        if (Integer.parseInt(txtOtp.getText()) == k) {
        String from = "aedprojectmail@gmail.com";
        String pass = "securepayment";
        String add = "ramesh.vik@husky.neu.edu";
        String[] to = {add};
        String host = "smtp.gmail.com"; 
        
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.user",from);
        prop.put("mail.smtp.password",pass);
        prop.put("mail.smtp.port","587");
        prop.put("mail.smtp.auth","true");
        
        //Session session = Session.getDefaultInstance(prop);
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, pass);
            }
        });
        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }
            for (int i = 0; i < toAddress.length; i++) {
                msg.setRecipient(Message.RecipientType.TO, toAddress[i]);
            }
            
            msg.setSubject("test");
            //double k1 = Math.random()*100000;//Integer.toString(k)
            //k = (int) k1;
            //System.out.println(k);
            msg.setContent("Thank you for your donation","text/html;charset=\"ISO-8859-1\"");
            Transport transport = session.getTransport("smtp");
            transport.connect(host,from,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
                   
        } catch (MessagingException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            JOptionPane.showMessageDialog(null, "Thank you for the confirmation");
        }
        else{
            JOptionPane.showMessageDialog(null, "Sorry invalid code");
            return;
        }
    }//GEN-LAST:event_btnConfirmActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JTextField txtOtp;
    // End of variables declaration//GEN-END:variables
}