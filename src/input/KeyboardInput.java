package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Panel;

public class KeyboardInput implements KeyListener {

	private Panel panel;
	
	public KeyboardInput(Panel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			panel.increaseWidth(-1);
			break;
		case  KeyEvent.VK_RIGHT:
			panel.increaseWidth(1);
			break;
		case KeyEvent.VK_UP:
			panel.increaseHeight(-1);
			break;
		case  KeyEvent.VK_DOWN:
			panel.increaseHeight(1);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
