

import lejos.nxt.Button;

public class StopProgram extends Thread
{
	public void run(){
		Button.waitForAnyPress();
		System.exit(0);
	}
}
