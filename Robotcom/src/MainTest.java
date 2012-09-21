import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;


public class MainTest implements MouseMotionListener, MouseListener
{
	static InputStream in;
	static OutputStream out;
	static boolean stop = false;
	static NXTComm con;
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws NXTCommException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException, NXTCommException {
		System.out.println("Connecting...");
		con = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
		System.out.println("Connected...");
		NXTInfo info = con.search(null)[0];
		con.open(info);		
		in = con.getInputStream();
		out = con.getOutputStream();
		System.out.println("Stream made: ");
		JFrame frame = new JFrame("TEST");
		frame.addMouseMotionListener(new MainTest());
		frame.addMouseListener(new MainTest());
		frame.setSize(100*10, 64*10);
		frame.setVisible(true);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		stop = true;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) 
	{
		System.out.println(arg0);
		try 
		{
			out.write(arg0.getX()/10);
			out.write(arg0.getY()/10);
			out.flush();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		try 
		{
			System.out.println("WRITE STOP");
			out.write(255);
			out.write(255);
			con.close();
			System.exit(0);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
			
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
