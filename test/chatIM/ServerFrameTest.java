/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatIM;

import java.io.IOException;
import java.net.Socket;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sid
 */
public class ServerFrameTest {
    @Test
    public void TestConnection()
    {
        ServerFrame SF = new ServerFrame();
        assertTrue(true);
       
    }
    
    public void TestDisconnection() throws InterruptedException
    {
        ServerFrame SF = new ServerFrame();
        Thread.sleep(5000);
        assertTrue(true);
    }
}
