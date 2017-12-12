/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author namra
 */
import java.util.Timer;
import java.util.TimerTask;

public class TimerTesting 
{
    Timer timer;
    
    public TimerTesting(int seconds) 
    {
        
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
        
    }
    
    class RemindTask extends TimerTask
    {

        @Override
        public void run() 
        {
            System.out.println("Time is up !");
            timer.cancel();
        }
        
    }
    
    
}
