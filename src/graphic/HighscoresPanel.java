package graphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Classe de tratamento dos highscores 
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class HighscoresPanel extends JPanel implements MouseListener {
	
	public HighscoresPanel() {
		super();
		addMouseListener(this);
		setBackground(Color.green);
		System.out.println("Entrei construtor");
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("Imagens/highscores_bg.png").getImage(), 0,0,null);
		g.setColor(GameWindow.FontColor);
		g.setFont(GameWindow.tipoLetraHighscores);
		for(int i = 0; i< 10; i++)
		{
			g.drawString(GameWindow.highscores.get(i).toString(), 440, 200+i*50) ;
		}
		
		
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
