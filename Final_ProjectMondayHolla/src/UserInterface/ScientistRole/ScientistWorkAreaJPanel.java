/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ScientistRole;

import Business.EcoSystem;
import Business.Enterprise.DonationMgmtEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.Organization.ResearchOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ScientistWorkRequest;
import UserInterface.DonorRole.MonetoryDonationJPanel;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vikram
 */
public class ScientistWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ScientistWorkAreaJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    ResearchOrganization researchOrganization;
    Enterprise enterprise;
    EcoSystem business;
    Network network;
    
    public ScientistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, ResearchOrganization researchOrganization, Enterprise enterprise,EcoSystem business,Network network) 
    {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.researchOrganization = researchOrganization;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        
        //btnHurricane.setToolTipText("Hurricane");
        btnEarthquake.setToolTipText("Earthquake");
        //btnTsunami.setToolTipText("Tsunami");
        
        //probabilityJLabell.setText();


        prob();

    }
   
    public void prob()
    {
        double T;
        double N = 10;
        double P;
        
        
        String csvFile = "C:\\Users\\vikram\\GIT\\AED\\AED Final Project\\Final_ProjectFor3rdDecember\\Prediction.csv";// name of your filw
        
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        HashMap <String,Integer> predictionMap = new HashMap<>();
        //key = city, value = frequency
        try
        {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null)
            {
                String[] array = line.split(cvsSplitBy);
                System.out.println("City  -->" + array[0] + "Area  -->" + array[1]);
                
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
               // dtm.setRowCount(0);
                
              
                Object[] row = new Object[2];
                 row[0] = array[0];
                 row[1] = array[1];
                 
                 dtm.addRow(row);
                
                 
                
                int counter = 1;
                if(predictionMap.containsKey(array[0]))
                {
                    counter =   predictionMap.get(array[0]);
                    counter ++;
                    predictionMap.put(array[0], counter);
                }
                else
                {
                   predictionMap.put(array[0], counter); 
                }
             
            }
            
            
                
        }
        
        
        catch(Exception e)
        {
              System.out.println("Bad Read");      
        }
        
        for(Map.Entry<String,Integer> entry : predictionMap.entrySet())
        {
            System.out.println("City -->"  + entry.getKey() +"Frequency-->" + entry.getValue()  );
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            T = N/entry.getValue();
            P = 1/T;
            
            //probabilityJLabell.setText(entry.getKey().toString() +" " +" Probability " +P);
            cityName1.setText(entry.getKey());
            p1TxtFld.setText(String.valueOf(P));
            
            
            
            if(P >= 0.7)
            {
                System.out.println(entry.getKey());
                cityName2.setText(entry.getKey());
                p2TxtFld.setText(String.valueOf(P));
                
                //send a workrequest to the manager about the quake in this place
                
                ScientistWorkRequest request = new ScientistWorkRequest();
                request.getResearch().setEmergency("Earthquake");
        //request.setMessage(message);
            JOptionPane.showMessageDialog(null, "Request Sent");
            request.setSender(account);
            Organization org = null;
            Enterprise ent = null;
            for (Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()) 
            {
                    if (en instanceof DonationMgmtEnterprise)
                    {
                        for(Organization organization : en.getOrganizationDirectory().getOrganizationList())
                        {
                            if(organization instanceof ManagmentOrganization)
                            {
                                org = organization;
                                ent = en;
                                break;
                            }
                        }
                        
                    }  
            }
                
            if (ent!=null)
            {
                request.setStatus("Emergency");
                request.setArea(entry.getKey());
                org.getWorkQueue().getWorkRequestList().add(request);
                account.getWorkQueue().getWorkRequestList().add(request);
            }
                
            }
            
            
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
        btnEmergency = new javax.swing.JButton();
        btnEarthquake = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        p1TxtFld = new javax.swing.JTextField();
        p2TxtFld = new javax.swing.JTextField();
        cityName1 = new javax.swing.JLabel();
        cityName2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Research ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 23, 940, 30));

        btnEmergency.setText("Emergency");
        btnEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyActionPerformed(evt);
            }
        });
        add(btnEmergency, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 232, 41));

        btnEarthquake.setRolloverEnabled(false);
        btnEarthquake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthquakeActionPerformed(evt);
            }
        });
        add(btnEarthquake, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 420, 160));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Year"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, 160));
        add(p1TxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 80, -1));
        add(p2TxtFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 80, -1));
        add(cityName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 60, 20));
        add(cityName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 60, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyActionPerformed
        // TODO add your handling code here:
        ScientistWorkRequest request = new ScientistWorkRequest();
        request.getResearch().setEmergency("");
        //request.setMessage(message);
        JOptionPane.showMessageDialog(null, "Request Sent");
        request.setSender(account);
        Organization org = null;
        Enterprise ent = null;
            for (Enterprise en: network.getEnterpriseDirectory().getEnterpriseList()) 
            {
                    if (en instanceof DonationMgmtEnterprise)
                    {
                        ent = en;
                        break;
                    }  
            }
                
            if (ent!=null)
            {
                request.setStatus("Emergency");
                ent.getWorkQueue().getWorkRequestList().add(request);               
            }
        
//        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
//            if (organization instanceof ManagmentOrganization){
//                org = organization;
//                break;
//            }
//        }
//        if (org!=null){
//            org.getWorkQueue().getWorkRequestList().add(request);
//            account.getWorkQueue().getWorkRequestList().add(request);
//        }
    }//GEN-LAST:event_btnEmergencyActionPerformed
    
    private void btnEarthquakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthquakeActionPerformed
        // TODO add your handling code here:
        EarthquakePredictionJPanel earthquakePredictionJPanel = new EarthquakePredictionJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),account,enterprise,network);
        userProcessContainer.add("EarthquakePredictionJPanel", earthquakePredictionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEarthquakeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEarthquake;
    private javax.swing.JButton btnEmergency;
    private javax.swing.JLabel cityName1;
    private javax.swing.JLabel cityName2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField p1TxtFld;
    private javax.swing.JTextField p2TxtFld;
    // End of variables declaration//GEN-END:variables
}
