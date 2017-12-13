/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import Business.Role.ScientistRole;
import java.util.ArrayList;

/**
 *
 * @author vikram
 */
public class ResearchEnterprise extends Enterprise{
    public ResearchEnterprise(String name) {
        super(name, EnterpriseType.Research);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        //added
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ScientistRole());
        return roles;
    }
}
