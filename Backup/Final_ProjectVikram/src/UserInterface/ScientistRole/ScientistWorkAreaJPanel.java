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
        
        btnHurricane.setToolTipText("Hurricane");
        btnEarthquake.setToolTipText("Earthquake");
        btnTsunami.setToolTipText("Tsunami");
        
//        
//        int []numArray = new int[]{11,22,05,01,55,120,65,125};
//        Arrays.sort(numArray);
//        double median;
//        if (numArray.length % 2 == 0)
//        median = ((double)numArray[numArray.length/2] + (double)numArray[numArray.length/2 - 1])/2;
//        else
//        median = (double) numArray[numArray.length/2];
//        System.out.println(median);
//        int r = poisson(median);
//        System.out.println(r);
//    }
//    
//    
//    
//     private static int poisson(double mean) 
//     {
//        int r = 0;
//        Random random = new Random();
//        double a = random.nextDouble();
//        double p = Math.exp(-mean);
//
//        while (a > p) 
//        {
//        r++;
//        a = a - p;
//        p = p * mean / r;
//    }
//        return r;

        prob();

    }
   
    public void prob()
    {
        double T;
        int N = 10;
        double P;
        
        
        String csvFile = "C:\\Users\\namra\\Desktop\\MSIS NU\\Sem 1\\AED\\FinalProject\\Prediction.csv";// name of your filw
        
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
            
            if(P >= 0.7)
            {
                System.out.println(entry.getKey());
                
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
        btnHurricane = new javax.swing.JButton();
        btnTsunami = new javax.swing.JButton();
        btnEarthquake = new javax.swing.JButton();

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

        btnHurricane.setIcon(new javax.swing.ImageIcon("C:\\Users\\namra\\Desktop\\MSIS NU\\Sem 1\\AED\\FinalProject\\tsunami.jpg")); // NOI18N
        btnHurricane.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHurricaneActionPerformed(evt);
            }
        });
        add(btnHurricane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 340, 140));

        btnTsunami.setIcon(new javax.swing.ImageIcon("C:\\Users\\namra\\Desktop\\MSIS NU\\Sem 1\\AED\\FinalProject\\hurricane.jpg")); // NOI18N
        btnTsunami.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTsunamiActionPerformed(evt);
            }
        });
        add(btnTsunami, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 130));

        btnEarthquake.setIcon(new javax.swing.ImageIcon("C:\\Users\\namra\\Desktop\\MSIS NU\\Sem 1\\AED\\FinalProject\\earthquake.jpg")); // NOI18N
        btnEarthquake.setRolloverEnabled(false);
        btnEarthquake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEarthquakeActionPerformed(evt);
            }
        });
        add(btnEarthquake, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 420, 120));
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
    
    private void btnHurricaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHurricaneActionPerformed
        // TODO add your handling code here:
        HurricanePredictionJPanel hurricanePredictionJPanel = new HurricanePredictionJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),account,enterprise,network);
        userProcessContainer.add("HurricanePredictionJPanel", hurricanePredictionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnHurricaneActionPerformed

    private void btnEarthquakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEarthquakeActionPerformed
        // TODO add your handling code here:
        EarthquakePredictionJPanel earthquakePredictionJPanel = new EarthquakePredictionJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),account,enterprise,network);
        userProcessContainer.add("EarthquakePredictionJPanel", earthquakePredictionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEarthquakeActionPerformed

    private void btnTsunamiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTsunamiActionPerformed
        // TODO add your handling code here:
        TsunamiPredictionJPanel tsunamiPredictionJPanel = new TsunamiPredictionJPanel(userProcessContainer, enterprise.getOrganizationDirectory(),account,enterprise,network);
        userProcessContainer.add("TsunamiPredictionJPanel", tsunamiPredictionJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnTsunamiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEarthquake;
    private javax.swing.JButton btnEmergency;
    private javax.swing.JButton btnHurricane;
    private javax.swing.JButton btnTsunami;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
