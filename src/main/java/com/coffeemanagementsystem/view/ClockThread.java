package com.mycompany.quanlycuahang;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author tuhuu
 */
public class ClockThread extends Thread{
    private JLabel lbl;

    public ClockThread(JLabel lbl) {
        this.lbl = lbl;
    }
    
    public void run(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        while(true){
            Date now = new Date();
            String st = sdf.format(now);
            lbl.setText("     "+st);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                
            }
        }
        
        
    }
}
