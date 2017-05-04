package rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface InterfaceRMI extends Remote {
    
    
    
       public ArrayList<String> artistsOfLocation(String location)throws RemoteException, FileNotFoundException, IOException; 
       public   int countOfSongs(String location) throws IOException, RemoteException;
       public   ArrayList<String> songsOfRelevantArtist(String Artist) throws IOException, RemoteException;
       public    ArrayList<String> totalArtistCollection()throws IOException, RemoteException;
       public  ArrayList<String> totalLocationList() throws IOException, RemoteException;
	 
}
    