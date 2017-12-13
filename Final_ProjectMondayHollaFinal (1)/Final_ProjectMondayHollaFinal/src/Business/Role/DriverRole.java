/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DonationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class DriverRole extends Role{
    
private static int counter;
private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
private int driverId;
private boolean assigned =false;

    public boolean isAssigned() {
        return assigned;
    }

    @Override
    public String toString() {
        return "DriverRole" ;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
public DriverRole(){
    counter++;
    driverId = counter;
}

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
      //  return new DriverWorkAreaJPanel(userProcessContainer, account, (DonationOrganization)organization, enterprise);
        return null;
    }
    
    
}
