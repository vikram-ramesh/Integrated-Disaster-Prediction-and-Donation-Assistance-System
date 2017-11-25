/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ManagmentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonationWorkRequest;
import UserInterface.ManagerRole.ManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author mansi
 */
public class ManagerRole  extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
               return new ManagerWorkAreaJPanel(userProcessContainer, enterprise, account, organization);
               //JPanel UserProcessContainer, DonationWorkRequest request, UserAccount useraccount, ManagmentOrganization managementOrganization
    }
    
}
