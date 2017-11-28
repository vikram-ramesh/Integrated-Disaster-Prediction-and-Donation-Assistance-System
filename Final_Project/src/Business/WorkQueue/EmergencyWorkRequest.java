/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;


import Business.Research.Research;

/**
 *
 * @author vikram
 */
public class EmergencyWorkRequest extends WorkRequest{
    private Research research;
        
    public EmergencyWorkRequest(){
        research = new Research();
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

}
