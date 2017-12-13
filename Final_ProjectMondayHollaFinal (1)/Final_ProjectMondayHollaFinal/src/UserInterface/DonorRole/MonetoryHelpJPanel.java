/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DonorRole;

import Business.Enterprise.Enterprise;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import UserInterface.MainJFrame;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author namra
 */
public class MonetoryHelpJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MonetoryHelpJPanel
     */
   
    private JPanel userProcessContainer;
    private OrganizationDirectory organizationDirectory;
    private UserAccount account;
    private Enterprise enterprise;
    int k;
    public MonetoryHelpJPanel(JPanel userProcessContainer, OrganizationDirectory organizationDirectory, UserAccount account, Enterprise enterprise) 
    {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.organizationDirectory=organizationDirectory;
        this.account=account;
        this.enterprise=enterprise;
        
        firstNameTxtFld.setEnabled(false);
        cardNumberTxtFld.setEnabled(false);
        enterAmountTxtFld.setEnabled(false);
        donationNameTxtFld.setEnabled(false);
        
        foodWeightTxtFld.setEnabled(false);
        clothesWeightTxtFld1.setEnabled(false);
        
        comboboxPopulate();
        comboboxYear();
        
    }
    
    private boolean nullCheck(JTextField toCheck) 
    {
       if (!(toCheck.getText().equals(""))) 
       {
           return true;
       }
       return false;
    }
    
    private int validateInput(JTextField toCheck) 
    {
       int checked = 0;
       try 
       {
           String s = toCheck.getText();
           checked = Integer.parseInt(s);
       } 
       catch (NumberFormatException ne) 
       {
           JOptionPane.showMessageDialog(null, "Please enter the integer number instead of the " + toCheck.getText());
           checked = Integer.parseInt(toCheck.getText());
       }
       return checked;
   }
    
    
    private float validateInputFloat(JTextField toCheck) 
    {
       float checked = 0;
       try 
       {
           String s = toCheck.getText();
           checked = Float.parseFloat(s);
       } 
       catch (NumberFormatException ne) 
       {
           JOptionPane.showMessageDialog(null, "Please enter the integer number instead of the " + toCheck.getText());
           checked = Integer.parseInt(toCheck.getText());
       }
       return checked;
   }

    public void comboboxPopulate()
    {
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) monthComboBox.getModel();
        dcbm.setSelectedItem(0);
        
        Object row1 = new Object();
        row1 = "Jan"; 
        dcbm.addElement(row1);
        
        Object row2 = new Object();
        row2 = "Feb"; 
        dcbm.addElement(row2);
        
        Object row3 = new Object();
        row3 = "Mar"; 
        dcbm.addElement(row3);
        
        Object row4 = new Object();
        row4 = "Apr"; 
        dcbm.addElement(row4);
        
        Object row5 = new Object();
        row5 = "May"; 
        dcbm.addElement(row5);
        
        Object row6 = new Object();
        row6 = "Jun"; 
        dcbm.addElement(row6);
        
        Object row7 = new Object();
        row7 = "Jul"; 
        dcbm.addElement(row7);
        
        Object row8 = new Object();
        row8 = "Aug"; 
        dcbm.addElement(row8);
        
        Object row9 = new Object();
        row9 = "Sep"; 
        dcbm.addElement(row9);
        
        Object row10 = new Object();
        row10 = "Oct"; 
        dcbm.addElement(row10);
        
        Object row11 = new Object();
        row11 = "Nov"; 
        dcbm.addElement(row11);
        
        Object row12 = new Object();
        row12 = "Dec"; 
        dcbm.addElement(row12);
        
    }
    
    public void comboboxYear()
    {
        DefaultComboBoxModel dcbm = (DefaultComboBoxModel) yearComboBox.getModel();
        dcbm.setSelectedItem(0);
        
        for(int i=2018; i<2025; i++)
        {
            Object row = new Object();
            row = i; 
            dcbm.addElement(row);
        }
        
    }
            
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        firstNameTxtFld = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cardNumberTxtFld = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        monthComboBox = new javax.swing.JComboBox<>();
        yearComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        enterAmountTxtFld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        donationNameTxtFld = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        makeDonationBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        foodChkBox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        moneyChkBox = new javax.swing.JCheckBox();
        clothingChkBox = new javax.swing.JCheckBox();
        foodWeightTxtFld = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        clothesWeightTxtFld1 = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtOtp = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Name (as on the card)");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 105, 192, 25));
        add(firstNameTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 138, 281, 31));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Card Number");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 169, 99, 29));

        cardNumberTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTxtFldActionPerformed(evt);
            }
        });
        add(cardNumberTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 204, 281, 29));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Expiration Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 242, 119, 28));

        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });
        add(monthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 282, 41, 29));

        add(yearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 282, 40, 29));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Enter amount to donate");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 170, -1, 27));
        add(enterAmountTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 203, 168, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Donation in the name of : ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, 33));
        add(donationNameTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 168, 33));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Captureback.PNG"))); // NOI18N
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 65, 44));

        makeDonationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/Donate here.PNG"))); // NOI18N
        makeDonationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeDonationBtnActionPerformed(evt);
            }
        });
        add(makeDonationBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, 178, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Approx clothes weight (pounds) :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, 29));

        foodChkBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        foodChkBox.setText("Food");
        foodChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodChkBoxActionPerformed(evt);
            }
        });
        add(foodChkBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 66, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Donation Type");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 62, 135, 33));

        moneyChkBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        moneyChkBox.setText("Funds");
        moneyChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyChkBoxActionPerformed(evt);
            }
        });
        add(moneyChkBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 66, -1, -1));

        clothingChkBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clothingChkBox.setText("Clothing");
        clothingChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clothingChkBoxActionPerformed(evt);
            }
        });
        add(clothingChkBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 66, -1, -1));
        add(foodWeightTxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, 168, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Approx food weight (pounds) :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 221, 27));
        add(clothesWeightTxtFld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 168, 29));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 138, 288, 31));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("EMail");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 103, 130, 29));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Monetary Help");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 450, 50));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("$");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 20, 30));

        txtOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtpActionPerformed(evt);
            }
        });
        add(txtOtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 170, 30));

        btnConfirm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConfirm.setText("Confirm");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void makeDonationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeDonationBtnActionPerformed
        // TODO add your handling code here:

    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    DonationWorkRequest request = new DonationWorkRequest();

    Map<String, Object> validateMap = new HashMap<>();
            
     
        
        if (nullCheck(enterAmountTxtFld)) 
        {
            Float amountfunds = validateInputFloat(enterAmountTxtFld);
        }
        
        if (nullCheck(foodWeightTxtFld)) 
        {
            float foodWeightAmount = validateInputFloat(foodWeightTxtFld);
        }
        
        if (nullCheck(clothesWeightTxtFld1)) 
        {
            float clothesWeightAmount = validateInputFloat(clothesWeightTxtFld1);
        }
        

    populateMap("firstNameTxtFld", firstNameTxtFld.getText(), validateMap);
    //populateMap("lastNameTxtFld", lastNameTxtFld.getText(), validateMap);

    populateMap("cardNumberTxtFld", cardNumberTxtFld.getText(), validateMap);
    
    populateMap("enterAmountTxtFld", enterAmountTxtFld.getText(), validateMap);
    populateMap("foodWeightTxtFld", foodWeightTxtFld.getText(), validateMap);
    populateMap("clothesWeightTxtFld1", clothesWeightTxtFld1.getText(), validateMap);
    
    for (Map.Entry<String, Object> entry : validateMap.entrySet()) 
    {
        if(entry.getKey().equals("enterAmountTxtFld"))
        {
            request.getDonation().setMoneyDonation(Float.parseFloat(enterAmountTxtFld.getText()));
        }
        
        if(entry.getKey().equals("foodWeightTxtFld"))
        {
            request.getDonation().setFood_quantity(Float.parseFloat(foodWeightTxtFld.getText()));
        }
        
        if(entry.getKey().equals("clothesWeightTxtFld1"))
        {
            request.getDonation().setCloth_quantity(Float.parseFloat(clothesWeightTxtFld1.getText()));
        }
    }
        
        
        request.setDonationType(DonationWorkRequest.DonationType.NonEmergency);
        request.setSender(account);
        request.setStatus("Donated");

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof ManagmentOrganization) {
                org = organization;
                break;
            }
        }
        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(request);
            account.getWorkQueue().getWorkRequestList().add(request);
        }
        JOptionPane.showMessageDialog(null, "Thank you for your donation");
 //******************************************************************************
 
        String from = "aedprojectmail@gmail.com";
        String pass = "securepayment";
        String add = txtEmail.getText();
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
            double k1 = Math.random()*100000;//Integer.toString(k)
            k = (int) k1;
            //System.out.println(k);
            msg.setContent(Integer.toString(k),"text/html;charset=\"ISO-8859-1\"");
            Transport transport = session.getTransport("smtp");
            transport.connect(host,from,pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (MessagingException ex) {
            Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfirmDonationJPanel nonMonetoryDonationJPanel = new ConfirmDonationJPanel(userProcessContainer, organizationDirectory, account, enterprise,k);
        userProcessContainer.add("confirmDonationJPanel", nonMonetoryDonationJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_makeDonationBtnActionPerformed


private void populateMap(String key, Object value, Map<String, Object> mapref) 
{

    if (!(value.equals(""))) 
    {
        mapref.put(key, value);
    }
}


    private void cardNumberTxtFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTxtFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberTxtFldActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void moneyChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyChkBoxActionPerformed
        // TODO add your handling code here:
        if(moneyChkBox.isSelected()== true)
        {
            firstNameTxtFld.setEnabled(true);
            //lastNameTxtFld.setEnabled(true);
            cardNumberTxtFld.setEnabled(true);
            enterAmountTxtFld.setEnabled(true);
            donationNameTxtFld.setEnabled(true);
        }
        else if(moneyChkBox.isSelected()== false)
        {
            firstNameTxtFld.setEnabled(false);
            //lastNameTxtFld.setEnabled(false);
            cardNumberTxtFld.setEnabled(false);
            enterAmountTxtFld.setEnabled(false);
            donationNameTxtFld.setEnabled(false);
        }
       
    }//GEN-LAST:event_moneyChkBoxActionPerformed

    private void foodChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foodChkBoxActionPerformed
        // TODO add your handling code here:
        if(foodChkBox.isSelected()==true)
        {
            foodWeightTxtFld.setEnabled(true);
        }
        else if(foodChkBox.isSelected()==false)
        {
           foodWeightTxtFld.setEnabled(false); 
        }
    }//GEN-LAST:event_foodChkBoxActionPerformed

    private void clothingChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clothingChkBoxActionPerformed
        // TODO add your handling code here:
        if(clothingChkBox.isSelected()==true)
        {
            clothesWeightTxtFld1.setEnabled(true);
        }
        else if(clothingChkBox.isSelected()==false)
        {
           clothesWeightTxtFld1.setEnabled(false); 
        }


    }//GEN-LAST:event_clothingChkBoxActionPerformed

    private void monthComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthComboBoxActionPerformed

    private void txtOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtpActionPerformed

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
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JTextField cardNumberTxtFld;
    private javax.swing.JTextField clothesWeightTxtFld1;
    private javax.swing.JCheckBox clothingChkBox;
    private javax.swing.JTextField donationNameTxtFld;
    private javax.swing.JTextField enterAmountTxtFld;
    private javax.swing.JTextField firstNameTxtFld;
    private javax.swing.JCheckBox foodChkBox;
    private javax.swing.JTextField foodWeightTxtFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton makeDonationBtn;
    private javax.swing.JCheckBox moneyChkBox;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtOtp;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
