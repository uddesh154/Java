import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseApplet extends JApplet implements MouseListener,MouseMotionListener{
	private String msg="";

	public void init(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	public void paint(Graphics g){
		super.paint(g);
		FontMetrics fm = g.getFontMetrics();
		int w = fm.stringWidth(msg);
		int h = fm.getHeight();
		int x = (getWidth()-w)/2;
		int y = (getHeight()-h)/2;
		g.drawString(msg,x, y);
	}

	public void mouseEntered(MouseEvent me){
		msg = "Mouse Entered";
		repaint();
	}

	public void mouseExited(MouseEvent me){
		msg = "Mouse Exited";
		repaint();
	}

	public void mousePressed(MouseEvent me){
		msg = "Mouse Pressed";
		repaint();
	}

	public void mouseReleased(MouseEvent me){
		msg = "Mouse Released";
		repaint();
	}

	public void mouseClicked(MouseEvent me){
		msg = "Mouse Clicked";
		repaint();
	}

	public void mouseDragged(MouseEvent me){
		msg = "Mouse Dragged";
		repaint();
	}

	public void mouseMoved(MouseEvent me){
		msg = "Mouse Moved";
		repaint();
	}
}

/*
<applet code=MouseApplet width=400 height=400></applet>
*/


