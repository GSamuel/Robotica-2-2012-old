import java.io.DataOutputStream;
import java.io.IOException;

import javax.bluetooth.RemoteDevice;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;


public class MainTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.out.println("Connecting");
		RemoteDevice btrd = Bluetooth.getKnownDevice("NXT2");
		if (btrd == null) 
		{
		  LCD.clear();
		  LCD.drawString("No such device", 0, 0);
		  Button.waitForAnyPress();
		  System.exit(1);
		}
		System.out.println("Connected...");

		BTConnection btc = Bluetooth.connect(btrd);
		System.out.println("Connecting");
		
		if (btc == null) 
		{
		  LCD.clear();
		  LCD.drawString("Connect fail", 0, 0);
		  Button.waitForAnyPress();
		  System.exit(1);
		}
		
		System.out.println("connected");
		
		DataOutputStream out = btc.openDataOutputStream();
		System.out.println("Writing...");
		out.write('n');
		out.write('0');
		out.write('0');
		out.write('b');
		out.flush();
		out.close();
		System.out.println("done...");
		btc.closeStream();
	}

}
