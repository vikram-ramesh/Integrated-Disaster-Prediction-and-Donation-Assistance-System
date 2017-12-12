/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Donation;

/**
 *
 * @author mansi
 */
public class Donation 
{
    private float food_quantity;
    private float cloth_quantity;
    private float moneyDonation;
    

   
    public float getFood_quantity() 
    {
        return food_quantity;
    }

    public void setFood_quantity(float food_quantity) {
        this.food_quantity = food_quantity;
    }

    public float getCloth_quantity() {
        return cloth_quantity;
    }

    public void setCloth_quantity(float cloth_quantity) {
        this.cloth_quantity = cloth_quantity;
    }

    public float getMoneyDonation() {
        return moneyDonation;
    }

    public void setMoneyDonation(float moneyDonation) {
        this.moneyDonation = moneyDonation;
    }
    
    
    
    
}
