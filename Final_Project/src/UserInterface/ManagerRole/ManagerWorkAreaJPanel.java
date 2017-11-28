/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManagerRole;

import Business.Enterprise.Enterprise;
import Business.Enterprise.ResearchEnterprise;
import Business.Network.Network;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.EmergencyWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author namra
 */
public class ManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private JPanel UserProcessContainer;
    private Enterprise enterprise;
    //private DonationWorkRequest request;
    private UserAccount useraccount;
    private ManagmentOrganization managementOrganization;
    private Network network;

    public ManagerWorkAreaJPanel(JPanel UserProcessContainer, Enterprise enterprise, UserAccount useraccount, Organization organization,Network network ) {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        //this.request = request;
        this.useraccount = useraccount;
        this.network = network;
        this.managementOrganization = (ManagmentOrganization) organization;
        emergencyLabel.show(false);

        populateTable();
    }

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        ImageIcon imageIcon;
        model.setRowCount(0);
//        BufferedImage image = null;
//        try 
//        {
//            image = ImageIO.read(new File("source.gif"));
//        }
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//        }
        //DonationWorkRequest request2 = (DonationWorkRequest) request;
        for (WorkRequest request : managementOrganization.getWorkQueue().getWorkRequestList()) 
        {
            DonationWorkRequest request2 = (DonationWorkRequest) request;
            Object[] row = new Object[5];
            row[0] = request;
            row[1] = request2.getDonation().getMoneyDonation() == 0 ? "---" : request2.getDonation().getMoneyDonation();
            row[2] = request2.getDonation().getFood_quantity() == 0 ? "---" : request2.getDonation().getFood_quantity();
            row[3] = request2.getDonation().getCloth_quantity() == 0 ? "---" : request2.getDonation().getCloth_quantity();
            row[4] = request.getMessage();

            model.addRow(row);
        }
        for(Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()){//WorkRequest request : organization.getWorkQueue().getWorkRequestList()
            if (en instanceof ResearchEnterprise) {
                for(WorkRequest request : en.getWorkQueue().getWorkRequestList()){
                    if (request instanceof EmergencyWorkRequest) {
                        if (((EmergencyWorkRequest) request).getResearch().getEmergency().equals("Earthquake Emergency")) {
                            setSize(50,50);
                            setLocation(40,30);
                            //setDefaultCloseOperation(EXIT_ON_CLOSE);
                            //JPanel p = new JPanel();
                            //emergencyPanel.add(new JLabel(new ImageIcon("source.gif")));

    //                        imageIcon = new ImageIcon(fitimage(image, emergencyLabel.getWidth(), emergencyLabel.getHeight()));
    //                        emergencyLabel.setIcon(imageIcon);
                            ImageIcon ii = new ImageIcon("C:\\Users\\vikram\\Documents\\NetBeansProjects\\Final_Project\\Images\\Earthquake2.gif");
                            emergencyLabel.setIcon(ii);
                            emergencyLabel.show(true);
                        }
                        else if (((EmergencyWorkRequest) request).getResearch().getEmergency().equals("Hurricane Emergency")){
                            ImageIcon ii = new ImageIcon("C:\\Users\\vikram\\Documents\\NetBeansProjects\\Final_Project\\Images\\hurricanegif.gif");
                            emergencyLabel.setIcon(ii);
                            emergencyLabel.show(true);
                        }
                        else if (((EmergencyWorkRequest) request).getResearch().getEmergency().equals("Tsunami Emergency")) {
                            ImageIcon ii = new ImageIcon("C:\\Users\\vikram\\Documents\\NetBeansProjects\\Final_Project\\Images\\Tsunamigif.gif");
                            emergencyLabel.setIcon(ii);
                            emergencyLabel.show(true);
                        }
//                        emergencyLabel.add(new JLabel(new ImageIcon("source.gif")));
                        //getContentPane().add(emergencyPanel);
                    }
                }
                    break; 
            }
        }
    }
    
    
    private Image fitimage(BufferedImage image, int width, int height) {
    BufferedImage resizedimage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = resizedimage.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(image, 0, 0,width,height,null);
    g2.dispose();
    return resizedimage;    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sendAckBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        emergencyLabel = new javax.swing.JLabel();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor", "Money Amount", "Food Quantity", "Clothes Quantity", "Acknowledgement "
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Manager Work Area");

        sendAckBtn.setText("Send Acknowledgement >>");
        sendAckBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendAckBtnActionPerformed(evt);
            }
        });

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(183, 183, 183))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(emergencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sendAckBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendAckBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emergencyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                .addGap(101, 101, 101))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        UserProcessContainer.remove(this);
        CardLayout layout = (CardLayout) UserProcessContainer.getLayout();
        layout.previous(UserProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void sendAckBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendAckBtnActionPerformed
       
        int selectedRow = jTable.getSelectedRow();
        
        if(selectedRow <0){
            JOptionPane.showMessageDialog(null, "PLease select a row");
            return;
        }
        WorkRequest request = (WorkRequest) jTable.getValueAt(selectedRow, 0);
        AcknowledgementJPanel acknowledgementJPanel = new AcknowledgementJPanel(UserProcessContainer, request);
        UserProcessContainer.add("acknowledgementJPanel", acknowledgementJPanel);
        CardLayout layout = (CardLayout) UserProcessContainer.getLayout();
        layout.next(UserProcessContainer);
    }//GEN-LAST:event_sendAckBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel emergencyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton sendAckBtn;
    // End of variables declaration//GEN-END:variables

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
