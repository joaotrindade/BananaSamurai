package graphic;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * Painel de HowTo
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class HowtoPanel extends JPanel implements MouseListener {

	public HowtoPanel() {
		super();
		addMouseListener(this);
		
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("Imagens/howto_bg.png").getImage(), 0,0,null);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 1185 && e.getX() < 1245 && e.getY()>31 && e.getY() < 91 )
		{
			System.out.println("GO BACK");
			this.setVisible(false);
			this.setFocusable(false);
			GameWindow.painelMenu.setVisible(true);
			GameWindow.painelMenu.setFocusable(true);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
