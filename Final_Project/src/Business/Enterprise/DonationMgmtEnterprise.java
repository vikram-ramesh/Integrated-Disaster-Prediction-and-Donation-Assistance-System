/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.AdminRole;
import Business.Role.ManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class DonationMgmtEnterprise extends Enterprise{

    public DonationMgmtEnterprise(String name) {
        super(name, EnterpriseType.Donation);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        //added
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
    
    
    
}
