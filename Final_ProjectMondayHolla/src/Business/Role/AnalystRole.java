/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AnalyticsOrganization;
import Business.Organization.Organization;
import Business.Organization.ResearchOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.AnalystRole.AnalystWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author vikram
 */
public class AnalystRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
       return new AnalystWorkAreaJPanel(userProcessContainer, account, (AnalyticsOrganization)organization, enterprise,business,network);
    }
}
