package INPUTS;

import java.awt.event.*;

public class Directionals implements KeyListener{

	public boolean W,A,S,D;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) 		{W = true;}
		else if (code== KeyEvent.VK_S) 	{A = true;}
		else if (code== KeyEvent.VK_A) 	{S = true;}
		else if (code== KeyEvent.VK_D) 	{D = true;}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) 		{W = false;}
		else if (code== KeyEvent.VK_S) 	{A = false;}
		else if (code== KeyEvent.VK_A) 	{S = false;}
		else if (code== KeyEvent.VK_D) 	{D = false;}
	}

}
