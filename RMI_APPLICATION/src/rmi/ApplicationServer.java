package rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.HeadlessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author kolli
 */
public class ApplicationServer  {
  
    
    public static void main(String[] args) {
        
        try {
            // ***********************// Please provide the port number which was not assigned to other processes************************
             int port =5075;
            ServerRMI rmi = new ServerRMI();
            Registry registry = LocateRegistry.createRegistry(port); 
            registry.rebind("HOW",rmi);
             // registry.rebind("HelloWorld", obj);
         
           
           
            System.out.println("SERVER IS STARTED TO ACCEPT THE REQUESTS FROM CLIENT");
            
             JFrame f = new JFrame();
             f.setVisible(true);
             f.setSize(300, 300);
             f.setTitle("SERVER");
            JLabel lb = new JLabel("SERVER IS STARTED");
             lb.setBounds(600,150, 100,30);
             f.add(lb);
             
            
            
             
        } catch (HeadlessException | RemoteException e) {
           System.err.println("SERVER IS THROWING EXCEPTION" + e.toString());
        }
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    


