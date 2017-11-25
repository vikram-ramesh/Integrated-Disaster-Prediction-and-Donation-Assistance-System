/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DonationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DonorRole.DonorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author mansi
 */
public class DonorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
       return new DonorWorkAreaJPanel(userProcessContainer, account, (DonationOrganization)organization, enterprise);
    }
    
}
