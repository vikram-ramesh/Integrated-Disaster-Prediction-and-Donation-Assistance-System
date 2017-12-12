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
public class ScientistWorkRequest extends WorkRequest{
    private Research research;
    private String area;
        
    public ScientistWorkRequest(){
        research = new Research();
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
//    @Override
//    public String toString()
//    {
//        return area;
//    }

}
