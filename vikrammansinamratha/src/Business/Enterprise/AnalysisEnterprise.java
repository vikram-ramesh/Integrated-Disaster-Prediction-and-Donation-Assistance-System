/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Role.AdminRole;
import Business.Role.AnalystRole;
import Business.Role.Role;

import java.util.ArrayList;

/**
 *
 * @author vikram
 */
public class AnalysisEnterprise extends Enterprise{
        public AnalysisEnterprise(String name) {
        super(name, EnterpriseType.Analytics);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        //added
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
}
