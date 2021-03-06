/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Donation.getValue())){
            organization = new DonationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Management.getValue())){
            organization = new ManagmentOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Research.getValue())){
            organization = new ResearchOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Analytics.getValue())){
            organization = new AnalyticsOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}