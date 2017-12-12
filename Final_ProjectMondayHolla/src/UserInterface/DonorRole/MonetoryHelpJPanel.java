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
        lastNameTxtFld.setEnabled(false);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        firstNameTxtFld = new javax.swing.JTextField();
        lastNameTxtFld = new javax.swing.JTextField();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Monetory Help");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Name (as on the card)");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Card Number");

        cardNumberTxtFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTxtFldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Expiration Date");

        monthComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Enter amount to donate");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Donation in the name of : ");

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        makeDonationBtn.setText("Make Donation");
        makeDonationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeDonationBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Approx clothes weight in pounds :");

        foodChkBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        foodChkBox.setText("Food");
        foodChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foodChkBoxActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Donation Type");

        moneyChkBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        moneyChkBox.setText("Funds");
        moneyChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyChkBoxActionPerformed(evt);
            }
        });

        clothingChkBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        clothingChkBox.setText("Clothing");
        clothingChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clothingChkBoxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Approx food weight in pounds :");

        jLabel10.setText("EMail");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(makeDonationBtn)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(moneyChkBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(foodChkBox)
                                        .addGap(18, 18, 18)
                                        .addComponent(clothingChkBox))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(enterAmountTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cardNumberTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(donationNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(foodWeightTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(150, 150, 150)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clothesWeightTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(moneyChkBox)
                            .addComponent(foodChkBox)
                            .addComponent(clothingChkBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cardNumberTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(enterAmountTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(donationNameTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(foodWeightTxtFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(clothesWeightTxtFld1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeDonationBtn)
                    .addComponent(backBtn))
                .addGap(18, 18, 18))
        );
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
    populateMap("lastNameTxtFld", lastNameTxtFld.getText(), validateMap);

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
            lastNameTxtFld.setEnabled(true);
            cardNumberTxtFld.setEnabled(true);
            enterAmountTxtFld.setEnabled(true);
            donationNameTxtFld.setEnabled(true);
        }
        else if(moneyChkBox.isSelected()== false)
        {
            firstNameTxtFld.setEnabled(false);
            lastNameTxtFld.setEnabled(false);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastNameTxtFld;
    private javax.swing.JButton makeDonationBtn;
    private javax.swing.JCheckBox moneyChkBox;
    private javax.swing.JComboBox<String> monthComboBox;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox<String> yearComboBox;
    // End of variables declaration//GEN-END:variables
}
