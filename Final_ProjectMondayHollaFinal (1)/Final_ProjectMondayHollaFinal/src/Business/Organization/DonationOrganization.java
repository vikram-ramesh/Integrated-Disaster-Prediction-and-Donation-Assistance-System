/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DonorRole;
import Business.Role.DriverRole;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class DonationOrganization extends Organization{

    public DonationOrganization() {
        super(Organization.Type.Donation.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonorRole());
       
        return roles;
    }
     
}