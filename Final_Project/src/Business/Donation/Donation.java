/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donation;

import Business.UserAccount.UserAccount;

/**
 *
 * @author mansi
 */
public class Donation {
    private int food_quantity;
    private int cloth_quantity;
    private int moneyDonation;
    

   
    public int getFood_quantity() {
        return food_quantity;
    }

    public void setFood_quantity(int food_quantity) {
        this.food_quantity = food_quantity;
    }

    public int getCloth_quantity() {
        return cloth_quantity;
    }

    public void setCloth_quantity(int cloth_quantity) {
        this.cloth_quantity = cloth_quantity;
    }

    public int getMoneyDonation() {
        return moneyDonation;
    }

    public void setMoneyDonation(int moneyDonation) {
        this.moneyDonation = moneyDonation;
    }
    
    
    
    
}
