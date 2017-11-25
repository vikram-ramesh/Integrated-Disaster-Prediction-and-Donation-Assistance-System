/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Donation.Donation;





/**
 *
 * @author raunak
 */
public class DonationWorkRequest extends WorkRequest{
    
    private Donation donation;
    
    public DonationWorkRequest(){
        donation = new Donation();
    }

    public Donation getDonation() {
        return donation;
    }

    public void setDonation(Donation donation) {
        this.donation = donation;
    }
   
    
    
}
