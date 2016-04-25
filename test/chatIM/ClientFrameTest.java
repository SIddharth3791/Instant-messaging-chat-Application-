/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatIM;



import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sid
 */
public class ClientFrameTest {
   
    @Test
    public void TestClient()
    {
        clientFrame CF = new clientFrame();
        assertTrue(true);
    }
    
    @Test
    public void TestMessaging()
    {
        String Msg = "Hello, How are you?";
        clientFrame CF = new clientFrame();
        CF.Messaging();
        assertTrue(true);
        
    }
    
    @Test
    public void TestConnection() throws IOException
    {
        int portAddress = 1111;
        clientFrame CF = new clientFrame();
        
    }
    
    
    public void TestUserAdd()
    {
        clientFrame CF = new clientFrame();
        CF.userAdd("Siddharth");
        assertTrue(true);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
