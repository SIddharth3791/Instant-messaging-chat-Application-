package chatIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerFrame extends javax.swing.JFrame {
  
ArrayList<String> Clientusers; //Marks:- Holds Clients how get connected
ArrayList clientOutputStreams;// sets messaging from client in array and sends over.

    public ServerFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ServerScreen = new javax.swing.JTextArea();
        ConnectButton = new javax.swing.JButton();
        DisconnectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PortnumberTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ServerScreen.setColumns(20);
        ServerScreen.setRows(5);
        jScrollPane1.setViewportView(ServerScreen);

        ConnectButton.setText("Connect ");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        DisconnectButton.setText("Disconnect");
        DisconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisconnectButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Port Number");

        PortnumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PortnumberTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(PortnumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DisconnectButton)
                            .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(ConnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DisconnectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(PortnumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Marks:- Connection Button will start server
    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed
        final int portnumber = Integer.parseInt(PortnumberTxt.getText());
        Thread Starter = new Thread(new Starting());
        Starter.start();
        ServerScreen.setText("Server started...\n");
        ServerScreen.append("your new port number is: " +portnumber+"\n");
        
    }//GEN-LAST:event_ConnectButtonActionPerformed
//marks:- Disconnet button will stop Server for 2 seconds and empty the portnumber Text
    private void DisconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisconnectButtonActionPerformed
    try {
        Thread.sleep(2000); // server will take 2 second hold to stop server.
        String Empty = "";  
        PortnumberTxt.setEditable(true);
        
    } catch (InterruptedException ex) {
        Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
    } 
    ServerScreen.setText("Server Stopped......\n");
    }//GEN-LAST:event_DisconnectButtonActionPerformed

    private void PortnumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PortnumberTxtActionPerformed
        
    }//GEN-LAST:event_PortnumberTxtActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConnectButton;
    private javax.swing.JButton DisconnectButton;
    private javax.swing.JTextField PortnumberTxt;
    private javax.swing.JTextArea ServerScreen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  
    
    public class Clients implements Runnable{

       BufferedReader BuffR;
       Socket socket;
       PrintWriter PrintW;
     /**
      * this method is for the thread which is started
      * @result Particular thread will be allocated to clients 
      */
    public Clients(Socket sock, PrintWriter clientWrite)
    {
     
      PrintW = clientWrite;
        
        try {
             socket = sock;
            InputStreamReader Input = new InputStreamReader(socket.getInputStream());
            BuffR = new BufferedReader(Input);
            
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
       
       /**
     * Read the Text using BuffR and divide the Text using divider "@".
     * @param string Array data will have name of client and the message store which will be divided using divider 
     * @result once the data[] is figuered out it will call sendmessage method.
     */
    @Override
    public void run() {   
   
         String text;
        String[] data;
        
        try {
            while((text = BuffR.readLine()) != null)
            {
                
               data = text.split("@"); // @ is a divider.
               
               
               if (data[2].equals("Connect"))
               {
                  
                  sendMessage((data[0] + "@" + data[1] + "@" + "Chat"));
               
               }else if(data[2].equals("Chat"))
               {
                   sendMessage(text);
               }
               else
               {
                   ServerScreen.append("not Connected");
               }
            }
        } catch (IOException ex) {
            Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
    /**
     *  Text from client side
     * @param text from client and get iterated
     * @Resulteffects:- Message from Clients store in array and printed
    */
    public void sendMessage(String text)
    
    {
        Iterator getMessage = clientOutputStreams.iterator();
        
        while(getMessage.hasNext())
        {
            try{
                PrintWriter Pwriter = (PrintWriter) getMessage.next();
                Pwriter.println(text);
                Pwriter.flush();
            }catch (Exception ex)
            {
                System.out.println("error in sending message");
            }
        }
    }
    

 public class Starting implements Runnable{
/**
         * Require: enter portnumber and loalhost to connect with other client. 
         * @param client is store in Clientusers, ClientOutSreams stores message to send.
         * @result both the clients will get notification about the connection
        */
        @Override
        public void run() {
        
            clientOutputStreams = new ArrayList();
            Clientusers = new ArrayList();

            try {
                final int portnumber = Integer.parseInt(PortnumberTxt.getText());// get portnumber to authenticate,  
                ServerSocket SSR =  new ServerSocket(portnumber);
               // ServerScreen.append("your new port number is: " +portnumber+"\n");
                while(true)
                {
                    Socket sock = SSR.accept(); // this command accepts socket.
                    PrintWriter Pwrite = new PrintWriter(sock.getOutputStream()); 
                    clientOutputStreams.add(Pwrite);
                    Thread listen = new Thread(new Clients(sock, Pwrite));
                    listen.start();
                    ServerScreen.append("Got connection  "+"\n");
                }
            } catch (IOException ex) {
                System.out.println("Wrong connections");
                
            }
        }
    
}
         
  
}
