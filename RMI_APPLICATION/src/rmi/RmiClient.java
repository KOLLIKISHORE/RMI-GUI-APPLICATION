package rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author kolli
 */
public class RmiClient extends javax.swing.JFrame {

 //  public static  InterfaceRMI Interface_Object =null;
   private InterfaceRMI Interface_Object;
   // Please provide the port number which was not assigned to other processes
   int port =5075;
   //**********Please enter the exact path to Path variable
    String path ="C:\\Users\\kolli\\Desktop\\Table2.in" ;
   // private Object Interface_Object;
    
    
    /**
     * Creates new form RMI
     */
    public RmiClient() {
        initComponents();
        addItemsComboBox();

    }

    public void addItemsComboBox() {
        // ArrayList can be used to load all the values from file to drop down button including duplicate values  
        //ArrayList<String> location_list = new ArrayList<String>();
        // ArrayList<String> artist_list = new ArrayList<String>();

        // HashMap is used to load the unique values to the drop down or combobox button
        HashSet<String> location_list = new HashSet<String>();
        HashSet<String> artist_list = new HashSet<String>();
        try {
          //  FileInputStream fstream = new FileInputStream("C:\\Users\\kolli\\Desktop\\Table2.in");
          FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String seperator = "<SEP>";
            String line = null;
            while ((line = br.readLine()) != null) {

                String[] str = line.split(seperator);
                String artist_name = str[2];
                String location = str[3];
                String songs = str[4];

                if (location.contains("<I>")) {
                    /*
                     String sep ="<I>";
                    String[] str2 = location.split(sep);
                    
                    location_list.add(str2[0]);
                    location_list.add(str2[1]);
                     */

                    String[] str2 = location.split("<I>");
                    for (String j : str2) {
                        location_list.add(j);
                    }

                } else {
                    location_list.add(location);
                }

                artist_list.add(artist_name);

            }
        } catch (IOException e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }

        String[] locationArray = location_list.toArray(new String[]{});
        String[] artistArray = artist_list.toArray(new String[]{});

        LOCATIONS_LIST_VIEW.setModel(new DefaultComboBoxModel(locationArray));
        ARTISTS_NAMES.setModel(new DefaultComboBoxModel(artistArray));
        //********************** SORTING OF LOCATIONS  and Artist Names **********************************************

        /*
        SortedComboBoxModel<String> model1;
        model1 = new SortedComboBoxModel<String>(locationArray);
        SortedComboBoxModel<String> model2;
        model2 = new SortedComboBoxModel<String>(artistArray);
        
        LOCATIONS_LIST_VIEW.setModel(model1);
        ARTISTS_NAMES.setModel(model2);
        
         */
        // *************************************************************************
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        LOCATIONS_LIST_VIEW = new javax.swing.JComboBox<>();
        ARTISTS_NAMES = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LOCATIONS_LIST_VIEW.setEditable(true);
        LOCATIONS_LIST_VIEW.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        LOCATIONS_LIST_VIEW.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        LOCATIONS_LIST_VIEW.setAutoscrolls(true);
        LOCATIONS_LIST_VIEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOCATIONS_LIST_VIEWActionPerformed(evt);
            }
        });

        ARTISTS_NAMES.setEditable(true);
        ARTISTS_NAMES.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        ARTISTS_NAMES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARTISTS_NAMESActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(0, 204, 255));
        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(204, 0, 204));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TOTAL LIST OF LOCATIONS", "TOTAL LIST OF ARTISTS", " " }));
        jComboBox1.setAutoscrolls(true);
        jComboBox1.setRequestFocusEnabled(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel2.setText("  LOCATIONS LIST VIEW");

        jLabel3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel3.setText("    ARTISTS LIST VIEW");

        jLabel4.setBackground(new java.awt.Color(0, 204, 51));
        jLabel4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel4.setText("AGGREGATION OPERATIONS");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel5.setText("LOCATIONWISE OPERATIONS");

        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIST OF ARTISTS FOR SPECIFIC LOCATION", "COUNT OF SONGS FOR SPECIFIC LOCATION" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel1.setText("SELECT LOCATION FROM BELOW LIST");

        jLabel7.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel7.setText("LIST OF ALL SONGS ASSOCIATED WITH ARTIST");

        jLabel8.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel8.setText("SELECT ARTIST FROM BELOW LIST");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel6.setText("NUMBER OF SONGS");

        jLabel9.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jLabel9.setText("LIST OF ARTISTS OF LOCATION");
        jLabel9.setToolTipText("");

        jButton4.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton4.setText("CLEAR OUTPUT");
        jButton4.setToolTipText("");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton5.setText("CLEAR OUTPUT");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton6.setText("CLEAR OUTPUT");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        jButton7.setText("CLEAR");
        jButton7.setToolTipText("");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(357, 357, 357)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(LOCATIONS_LIST_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(338, 338, 338)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(210, 210, 210)
                                                .addComponent(jLabel8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ARTISTS_NAMES, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(79, 79, 79))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jButton7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jButton1)
                        .addGap(522, 522, 522)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(223, 223, 223)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLabel4)))
                        .addGap(31, 31, 31)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ARTISTS_NAMES, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LOCATIONS_LIST_VIEW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jButton4))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(274, 274, 274))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5)
                                    .addComponent(jButton6))
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    private void LOCATIONS_LIST_VIEWActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
              
       
        
        
        

    }                                                   

    private void ARTISTS_NAMESActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        

        
    }                                          
   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
      
          Registry registry = null;
            try{
                registry = LocateRegistry.getRegistry(port);
                InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("HOW");
            
            
         
   // *************** songsOfRelevantArtist method calling*****************************
    	 if(ARTISTS_NAMES.getSelectedIndex() >= 0) {

             //String location_item = comboBox.getSelectedItem().toString();
             // String data = LOCATIONS_LIST_VIEW.getItemAt(LOCATIONS_LIST_VIEW.getSelectedIndex());
                
             String artist_name = (String) ARTISTS_NAMES.getSelectedItem();
             System.out.println("Artist name is"+artist_name);
 	     ArrayList<String> songs_list = null; 
           

              try {
                  
                          songs_list = Interface_Object.songsOfRelevantArtist(artist_name);
                          
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              }
             
              		for (String i:songs_list) 
 				{
 					jTextArea3.append(i+"\n"); 
 				}
          }  
         
   
        
            }catch(Exception e){
                 System.err.println("CLIENT IS THROWING EXCEPTION" + e.toString());
            e.printStackTrace();
            }
        
        
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
         Registry registry = null;
            try{
                registry = LocateRegistry.getRegistry(port);
                InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("HOW");
            
            
         
   // *************** totalLocationList  method calling*****************************
    	 if(jComboBox1.getSelectedIndex() == 0 ) {

             //String location_item = comboBox.getSelectedItem().toString();
             // String data = LOCATIONS_LIST_VIEW.getItemAt(LOCATIONS_LIST_VIEW.getSelectedIndex());
                
             String requirement = (String) jComboBox1.getSelectedItem();
             System.out.println("you selected the option"+requirement);
 	     ArrayList<String> location_list = null; 
            try {
                  
                          location_list = Interface_Object.totalLocationList();
                          
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              }
             
              		for (String i:location_list) 
 				{
 					jTextArea1.append(i+"\n"); 
 				}
          }  
         
         
        // *****************************calling the totalArtistCollection() method******************************
        
         	 if(jComboBox1.getSelectedIndex() == 1 ) {

             //String location_item = comboBox.getSelectedItem().toString();
             // String data = LOCATIONS_LIST_VIEW.getItemAt(LOCATIONS_LIST_VIEW.getSelectedIndex());
                
             String requirement = (String) jComboBox1.getSelectedItem();
             System.out.println("you selected the option"+requirement);
 	     ArrayList<String> artist_list = null; 
            try {
                  
                          artist_list = Interface_Object.totalArtistCollection();
                          
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              }
             
              		for (String i:artist_list) 
 				{
 					jTextArea1.append(i+"\n"); 
 				}
          }
         
         
         
         
       }catch(Exception e){
                 System.err.println("CLIENT IS THROWING EXCEPTION" + e.toString());
            e.printStackTrace();
            }
        
     
        
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        String location = (String) LOCATIONS_LIST_VIEW.getSelectedItem();
        System.out.println("Location is"+location);
         System.out.println(" combo boc index:"+jComboBox2.getSelectedIndex()+"and"+LOCATIONS_LIST_VIEW.getSelectedItem());
         
         
          Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(port);
                InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("HOW");
            
            
         
   // *************** artistsOfLocation method calling*****************************
    	 if(jComboBox2.getSelectedIndex() == 0 && LOCATIONS_LIST_VIEW.getSelectedIndex() >= 0) {

             //String location_item = comboBox.getSelectedItem().toString();
              String data= LOCATIONS_LIST_VIEW.getItemAt(LOCATIONS_LIST_VIEW.getSelectedIndex());
                
             //String location = (String) LOCATIONS_LIST_VIEW.getSelectedItem();
             System.out.println("Location is"+location);
 	   ArrayList<String> artistNames = null; 
           
           
 	   /*
 	  Registry registry = null;
      try {
          registry = LocateRegistry.getRegistry();
      } catch (RemoteException ex) {
          Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("Hello");
      } catch (RemoteException ex) {
          Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
      } catch (NotBoundException ex) {
          Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
      }  */
             
              try {
                  
                  artistNames = Interface_Object.artistsOfLocation(location);
              } catch (FileNotFoundException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              } catch (IOException ex) {
                  Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
              }
             
              		for (String i:artistNames) 
 				{
 					jTextArea2.append(i+"\n"); 
 				}
          }  
         
    	
        //****************************Numberofsongs of location*****************************
        
        if(jComboBox2.getSelectedIndex() == 1 && LOCATIONS_LIST_VIEW.getSelectedIndex() >= 0)
        {
            int songs = 0;  
            try {
                songs = Interface_Object.countOfSongs(location);
            } catch (IOException ex) {
                Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
				//jTextArea2.append(""+songs);
				//System.out.println("songs are: "+songs);
                                 String result=String.valueOf(songs); 
				jTextField1.setText(result);
        }
        
        
        
            } catch (NotBoundException ex) {
                Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) { 
           Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
       } 
          
        
        
        
        
        
        
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
       
    }                                           

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        jTextArea1.setText("");
        
    }                                        

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        jTextArea3.setText("");
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        jTextArea2.setText("");
        
    }                                        

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         jTextField1.setText("");
    }                                        
    
    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) throws RemoteException, NotBoundException {
      
   
                       System.out.println("THIS IS CILENT");
    
      
   try {
       
       //InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("rmi://localhost:1022/Hello");
       
      /* Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(5067);
            } catch (RemoteException ex) {
                Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                InterfaceRMI  Interface_Object =(InterfaceRMI) registry.lookup("HOW");
            } catch (RemoteException ex) {
                Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(RmiClient.class.getName()).log(Level.SEVERE, null, ex);
            } 
                
      */
       
       
     /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    RmiClient rmi = new RmiClient();
                    rmi.setVisible(true);
                    rmi.setTitle("RMI APPLICATION");
            
                }
            });
            
   } catch (Exception e1) {
            System.err.println("CLIENT IS THROWING EXCEPTION : " + e1.toString());
            e1.printStackTrace();
}

    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> ARTISTS_NAMES;
    private javax.swing.JComboBox<String> LOCATIONS_LIST_VIEW;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   


}
