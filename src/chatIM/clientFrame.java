package chatIM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clientFrame extends javax.swing.JFrame {

    String username;
    ArrayList<String> clients = new ArrayList(); // Marks:- Holds all online Clients.
    int port ;
    Boolean ConnectionDone = false; //Marks:- boolean to specify if client is connected 
    
    Socket socket; //Marks :- Socket to send Message to server through serverSocket
    BufferedReader BUFFR; //Marks:- 
    PrintWriter Pwriter;
    
    public clientFrame() {
        initComponents();
    }

     public void Messaging() 
    {
    /**
     * need to start a new thread calling sendingMessag method
     * @result Thread will start communications. 
     */
         Thread IncomingReader = new Thread(new SendingMessage());
         IncomingReader.start();
    }
    public void userAdd(String data) 
    {
       /**
        * data as a string which needs to be stored
        * @result all the data is stored under client arraylist 
        */
         clients.add(data);
    }
    
     public void writeUsers() 
    {
         String[] List = new String[(clients.size())];
         clients.toArray(List);
         
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ChatArea = new javax.swing.JTextArea();
        TextArea = new javax.swing.JTextField();
        SendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        HostnameTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PortnumberTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UsernameTxt = new javax.swing.JTextField();
        ConnectButton = new javax.swing.JButton();
        disconnectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ChatArea.setColumns(20);
        ChatArea.setRows(5);
        jScrollPane1.setViewportView(ChatArea);

        SendButton.setText("Send");
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Host Name");

        jLabel2.setText("Port Number ");

        jLabel3.setText("User name");

        ConnectButton.setText("Connect ");
        ConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConnectButtonActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HostnameTxt)
                    .addComponent(PortnumberTxt)
                    .addComponent(UsernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(disconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(HostnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(PortnumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ConnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SendButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        
     /**
      * TextArea will be empty and text type in TextArea Text box
      * @param TextArea will attach with username and divider for server to figure out the client name and message
      * @result another client Chat window will get the send text message along with sender username
      */   
        String nothing = "";
        if ((TextArea.getText()).equals(nothing)) {
            TextArea.setText("");
            TextArea.requestFocus();
        } else {
            try {
               Pwriter.println(username + "@" + TextArea.getText() + "@" + "Chat");
               Pwriter.flush(); // flushes the buffer
            } catch (Exception ex) {
                ChatArea.append("Message was not sent. \n");
            }
            TextArea.setText("");
            TextArea.requestFocus();
        }

       TextArea.setText("");
            TextArea.requestFocus();
        
        
    }//GEN-LAST:event_SendButtonActionPerformed

    private void ConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConnectButtonActionPerformed
      
        /**
         * Get port number and host address
         * @param pass it through the socket to start connect with server.
         * @param Address will be local host by default
         * @result Print writer will send it to server side and server window will get client connected notification 
         */
         if (ConnectionDone == false) 
        {
            username = UsernameTxt.getText();
            UsernameTxt.setEditable(false);

            try 
            {
                int portno =Integer.parseInt(PortnumberTxt.getText());
                final String address = HostnameTxt.getText();
                socket = new Socket(address, portno);
                InputStreamReader streamreader = new InputStreamReader(socket.getInputStream()); //marks:- gets Message typed by clients
                BUFFR = new BufferedReader(streamreader);
                Pwriter = new PrintWriter(socket.getOutputStream()); //Marks:- sends message to output stream over server 
                Pwriter.println(username + "@has connected.@Connect");//Marks:- show who is connedted, "@" is a divider, thrid connect tells what to do with the data. 
                Pwriter.flush(); // Marks:- flushes buffer.
                ConnectionDone = true; //marks:- checks if client is connected or not.
            } 
            catch (Exception ex) 
            {
                ChatArea.append("Cannot Connect! Try Again. \n");
                UsernameTxt.setEditable(true);
            }
            
            Messaging();
            
        } else if (ConnectionDone == true) 
        {
            ChatArea.append("You are already connected. \n");
        }
        
        
        
    }//GEN-LAST:event_ConnectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        /**
         * Socket is open to continue connection with another client
         * @para socket can close input stream and output stream.
         * @result socket.close will end the connection.
         */
        
        try {
            socket.close(); //MArks:- Disconnect the user
            ChatArea.append("You are disconnected \n");
            
            
        } catch (IOException ex) {
            Logger.getLogger(clientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionDone = false;
        

        
        
        
        
    }//GEN-LAST:event_disconnectButtonActionPerformed

   
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ChatArea;
    private javax.swing.JButton ConnectButton;
    private javax.swing.JTextField HostnameTxt;
    private javax.swing.JTextField PortnumberTxt;
    private javax.swing.JButton SendButton;
    private javax.swing.JTextField TextArea;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

 

public class SendingMessage implements Runnable
{
/**
 * Sending message will have to store divider, notifier, username and Actual message in string Array.
 * @para String Array data[] will have divider "@" to split Stream
 * @result Chat Area of the client will have username + Message from sender client
 */
        @Override
        public void run() {
            String[] data;
            String stream;
            try 
            {
                while ((stream = BUFFR.readLine()) != null) //marks:- check if new data is coming from the server
                {
                     data = stream.split("@");

                     if (data[2].equals("Chat")) //mark:- if data[2] which is last data on the array is chat
                     {
                        ChatArea.append(data[0] + ": " + data[1] + "\n"); // marks:- data[0] is the username of the person, data[1] is the message.
                        ChatArea.setCaretPosition(ChatArea.getDocument().getLength());
                     } 
                     else if (data[2].equals("Connect"))//mark:- if data[2] which is last data on the array is connect 
                     {
                        ChatArea.removeAll();
                        userAdd(data[0]);
                     } 
                     
                }
           }catch(Exception ex) { }
        }
        }
    
}

