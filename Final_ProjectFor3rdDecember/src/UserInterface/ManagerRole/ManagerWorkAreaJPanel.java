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
import Business.Organization.DonationOrganization;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.TimerTesting;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.ScientistWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.OptimizedDistribution.OptimizedDistributionJPanel;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Timer timer;

    public ManagerWorkAreaJPanel(JPanel UserProcessContainer, Enterprise enterprise, UserAccount useraccount, Organization organization,Network network ) 
    {
        initComponents();
        this.UserProcessContainer = UserProcessContainer;
        //this.request = request;
        this.useraccount = useraccount;
        this.network = network;
        this.managementOrganization = (ManagmentOrganization) organization;
        this.enterprise=enterprise;
        emergencyLabel.show(false);

        populateTable();
        populatePredictionTable();
        
        //this.timer = new Timer();
        
        
        
        timerMethod(5);
        //timer.schedule(new TimerTesting.RemindTask(), seconds*1000);
        
        System.out.println("Task Scheduled");
        
    }
    
    
     class RemindTask extends TimerTask
    {

        @Override
        public void run() 
        {
            System.out.println("Time is up !");
            timer.cancel();
            
            if(predictionTable.getRowCount() == 0)
            {
                return;
            }
            else
            {
                DefaultTableModel model = (DefaultTableModel) predictionTable.getModel();
       
                for(int row = 0; row<predictionTable.getRowCount(); row++)
                {
                    
                    for(int column = 2 ; column<predictionTable.getColumnCount();column++)
                    {

                        WorkRequest selected = (WorkRequest) model.getValueAt(row, column);

                        System.out.println("ScientistWorkRequest at 2 column -->" + selected);
                        
                        if(selected.getStatus().equals("Emergency"))
                        {
                            DonationWorkRequest donationWorkRequest = new DonationWorkRequest();
                            System.out.println("inside if");
                            
                            for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList())
                            {
                                if(o instanceof DonationOrganization)
                                {
                                    o.getWorkQueue().getWorkRequestList().add(selected);
                                    
                                    System.out.println("sent the request to donation organization");
                                }
                            }
                            
                            
                            
                        }
                        selected.setStatus("Alerted");
                    }
                }
            }
            
        }
        
    }
    
    public void timerMethod(int seconds)
    {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }
    
    
    public void populatePredictionTable()
    {
        DefaultTableModel dtm = (DefaultTableModel) predictionTable.getModel();
        dtm.setRowCount(0);
        
        
        
        for(WorkRequest req : managementOrganization.getWorkQueue().getWorkRequestList())
        {
            
            if(req instanceof ScientistWorkRequest)
            {
                ScientistWorkRequest swr = (ScientistWorkRequest) req;
                Object[] row = new Object[3];
                row[0] = swr.getArea();
                row[2] = swr;
                row[1] = swr.getResearch().getEmergency();
                dtm.addRow(row);
            }
            
            
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
        nonEmergencyJTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        predictionTable = new javax.swing.JTable();
        ManageResourcesBtn = new javax.swing.JButton();

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

        jLabel2.setText("Non Emergency Donation Summary");

        jLabel3.setText("Emergency Donation Summary");

        nonEmergencyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor", "Money Amount", "Food Quantity", "Clothes Quantity", "Acknowledgement "
            }
        ));
        jScrollPane2.setViewportView(nonEmergencyJTable);
        if (nonEmergencyJTable.getColumnModel().getColumnCount() > 0) {
            nonEmergencyJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        predictionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Event", "Satus"
            }
        ));
        jScrollPane3.setViewportView(predictionTable);

        ManageResourcesBtn.setText("Manage Distribution");
        ManageResourcesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManageResourcesBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(emergencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ManageResourcesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendAckBtn))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(emergencyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendAckBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(ManageResourcesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
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

    private void ManageResourcesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManageResourcesBtnActionPerformed

        try {
            OptimizedDistributionJPanel optimizedDistributionJPanel = new OptimizedDistributionJPanel(UserProcessContainer,
                enterprise, useraccount, managementOrganization);
            UserProcessContainer.add("OptimizedDistributionJPanel", optimizedDistributionJPanel);
            CardLayout layout = (CardLayout) UserProcessContainer.getLayout();
            layout.next(UserProcessContainer);
        } catch (Exception ex) {
            
            System.out.println("Unable to go to manage distribution");
            Logger.getLogger(ManagerWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ManageResourcesBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManageResourcesBtn;
    private javax.swing.JLabel emergencyLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable;
    private javax.swing.JTable nonEmergencyJTable;
    private javax.swing.JTable predictionTable;
    private javax.swing.JButton sendAckBtn;
    // End of variables declaration//GEN-END:variables

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
