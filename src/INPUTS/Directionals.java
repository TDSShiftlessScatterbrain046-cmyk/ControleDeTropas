package INPUTS;

import java.awt.event.*;

public class Directionals implements KeyListener{

	public int[] sides = {0,0};
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code== KeyEvent.VK_W) {
			sides[1] -= 1;
		}
		else if (code== KeyEvent.VK_S) {
			sides[1] += 1;
		}
		else if (code== KeyEvent.VK_A) {
			sides[0] -= 1;
		}
		else if (code== KeyEvent.VK_D) {
			sides[0] += 1;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code== KeyEvent.VK_W) {
			sides[1] += 1;
		}
		else if (code== KeyEvent.VK_S) {
			sides[1] -= 1;
		}
		else if (code== KeyEvent.VK_A) {
			sides[0] += 1;
		}
		else if (code== KeyEvent.VK_D) {
			sides[0] -= 1;
		}
	}

}
