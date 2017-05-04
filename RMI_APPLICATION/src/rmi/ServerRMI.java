package rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.*;
import java.io.*;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import javax.sound.midi.SysexMessage;
import javax.swing.JFrame;
import javax.swing.JLabel;
        
public class ServerRMI extends UnicastRemoteObject implements InterfaceRMI {
//**********Please enter the exact path to Path variable
    String Path ="C:\\Users\\kolli\\Desktop\\Table2.in";
    String Line;
    String delimiter = "<SEP>";
    
    
   public ServerRMI() throws RemoteException{
		
	super();
	
    }

    
   // @Override
   public  ArrayList<String> artistsOfLocation (String loc)throws RemoteException, FileNotFoundException,IOException
    {
       // System.out.println("In artist method");
        ArrayList<String> artistcollection = new ArrayList<String>();		
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
        System.out.println(Path);
                
		while ((Line = br.readLine()) != null)   {
			
			String[] words =Line.split(delimiter); 
                         String location = words[3];
                         String artist_list = words[2];
			 if( location.contains(loc) )
		        artistcollection.add(artist_list);
                          
                         }
		
	   return artistcollection;	
           
        
    }
       
  public int countOfSongs(String loc) throws IOException, RemoteException {
      System.out.println("In songs method");
   BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
       int cnt =0;
       while ((Line = br.readLine()) != null)   {
           
           String[] words =Line.split(delimiter); 
           String location = words[3];
           String  songs = words[4];
	   if(location.contains(loc))	
               { 
                   if(songs.contains("<I>"))
                   {
                    String[] str2 = songs.split("<I>");
                     for (String j : str2) 
                        cnt=cnt+1;
                   
                   }
                   else
                       cnt=cnt+1;
                   
               }
           
           
       }
       
       return cnt;
       
  }
           
  public  ArrayList<String> songsOfRelevantArtist(String Artist) throws IOException, RemoteException{
  
  
      ArrayList<String> songsOfArtist_list = new ArrayList<String>();		
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
                
		while ((Line = br.readLine()) != null)   {
			
			String[] words =Line.split(delimiter); 
                         String artist_name = words[2];
                         String songs = words[4];
                         
			 if( artist_name.contains(Artist) )
                         {  
                               if(songs.contains("<I>"))
                                  {
                                    String[] str2 = songs.split("<I>");
                                     for (String j : str2)
                                      songsOfArtist_list.add(j);
                                  }  
                               
                               else
                                   songsOfArtist_list.add(songs);
                         }
                              
                             
		
                }
	   return songsOfArtist_list;	
  
  
}           
               
 public ArrayList<String> totalArtistCollection()throws IOException, RemoteException{
    
    
    ArrayList<String> artist_collection_list = new ArrayList<String>();		
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
    
    while ((Line = br.readLine()) != null)   {
			
            String[] words =Line.split(delimiter); 
            String artist = words[2];
            if(artist.contains("<I>"))
            {
                
            String[] str2 = artist.split("<I>");
            for (String j : str2)
             artist_collection_list.add(j);
              }  
                               
             else
             artist_collection_list.add(artist);
            
    }
            
    return artist_collection_list;
}
    
    
 public ArrayList<String> totalLocationList() throws IOException, RemoteException{
     
     ArrayList<String> location_collection_list = new ArrayList<String>();		
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path)));
     
    while ((Line = br.readLine()) != null) {

                String[] str = Line.split(delimiter);
                String location = str[3];
                if (location.contains("<I>"))
                {
                   String[] str2 = location.split("<I>");
                    for (String j : str2) {
                        location_collection_list.add(j);
                    }

                } else {
                    location_collection_list.add(location);
                }
    }
    
    return location_collection_list;
    
 }
     
     
   /*  
public static void main(String[] args) {
        
        try {
			
            ServerRMI rmi = new ServerRMI();
           Registry registry = LocateRegistry.createRegistry(1051); 
            registry.rebind("Hello",rmi);
              
          // Naming.rebind("Hello",rmix
           
           
            System.out.println("SERVER IS STARTED TO ACCEPT THE REQUESTS FROM CLIENT");
            
             JFrame f = new JFrame();
             f.setVisible(true);
             f.setSize(300, 300);
             f.setTitle("SERVER");
            JLabel lb = new JLabel("SERVER IS STARTED");
             lb.setBounds(600,150, 100,30);
             f.add(lb);
             
            
            
             
        } catch (Exception e) {
           System.err.println("SERVER IS THROWING EXCEPTION" + e.toString());
            e.printStackTrace();
        }
*/
    }

   
    
    
    
    
    
    
    
