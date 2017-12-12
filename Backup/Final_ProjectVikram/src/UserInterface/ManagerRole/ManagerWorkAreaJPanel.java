/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManagerRole;

import Business.Enterprise.DonationMgmtEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ResearchEnterprise;
import Business.Network.Network;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.ScientistWorkRequest;
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
        populatePredictionTable();
    }
    
    
    
    public void populatePredictionTable()
    {
        DefaultTableModel dtm = (DefaultTableModel) predictionTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest req : managementOrganization.getWorkQueue().getWorkRequestList())
        {
            ScientistWorkRequest swr = (ScientistWorkRequest) req;
            Object[] row = new Object[3];
            row[0] = swr;
            row[1] = swr.getStatus();
            row[2] = swr.getResearch().getEmergency();
            dtm.addRow(row);
        }
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
            
            if(request instanceof DonationWorkRequest)
            {
                DonationWorkRequest request2 = (DonationWorkRequest) request;
                
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request2.getDonation().getMoneyDonation() == 0 ? "---" : request2.getDonation().getMoneyDonation();
                row[2] = request2.getDonation().getFood_quantity() == 0 ? "---" : request2.getDonation().getFood_quantity();
                row[3] = request2.getDonation().getCloth_quantity() == 0 ? "---" : request2.getDonation().getCloth_quantity();
                row[4] = request2.getMessage();

                model.addRow(row);
            }
            
        }
        for(Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()){//WorkRequest request : organization.getWorkQueue().getWorkRequestList()
            if (en instanceof DonationMgmtEnterprise) {
                for(WorkRequest request : en.getWorkQueue().getWorkRequestList()){
                    if (request instanceof ScientistWorkRequest) {
                        if (((ScientistWorkRequest) request).getResearch().getEmergency().equals("Earthquake")) {
                            setSize(50,50);
                            setLocation(40,30);
                            //setDefaultCloseOperation(EXIT_ON_CLOSE);
                            //JPanel p = new JPanel();
                            //emergencyPanel.add(new JLabel(new ImageIcon("source.gif")));

    //                        imageIcon = new ImageIcon(fitimage(image, emergencyLabel.getWidth(), emergencyLabel.getHeight()));
    //                        emergencyLabel.setIcon(imageIcon);
                            ImageIcon ii = new ImageIcon("C:\\Users\\namra\\Desktop\\minions.jpg");
                            emergencyLabel.setIcon(ii);
                            emergencyLabel.show(true);
                        }
                        else if (((ScientistWorkRequest) request).getResearch().getEmergency().equals("Hurricane Emergency")){
                            ImageIcon ii = new ImageIcon("C:\\Users\\vikram\\Documents\\NetBeansProjects\\Final_Project\\Images\\hurricanegif.gif");
                            emergencyLabel.setIcon(ii);
                            emergencyLabel.show(true);
                        }
                        else if (((ScientistWorkRequest) request).getResearch().getEmergency().equals("Tsunami Emergency")) {
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
    
    
    private Image fitimage(BufferedImage image, int width, int height) 
    {
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
        emergencyLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        predictionTable = new javax.swing.JTable();

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

        emergencyLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\namra\\Desktop\\minions.jpg")); // NOI18N

        jLabel2.setText("Emergency Donation Summary");

        jLabel3.setText("Non Emergency Donation Summary");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor", "Money Amount", "Food Quantity", "Clothes Quantity", "Acknowledgement "
            }
        ));
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Food Quantity");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Clothes Quantity");
        }

        predictionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Status", "Emergency"
            }
        ));
        jScrollPane3.setViewportView(predictionTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sendAckBtn)
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(emergencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(183, 183, 183))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(93, 93, 93)))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(emergencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendAckBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JLabel emergencyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable predictionTable;
    private javax.swing.JButton sendAckBtn;
    // End of variables declaration//GEN-END:variables

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
