package graphic;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collections;
 
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import logic.PlayerScore;
/**
 * Painel de Menu Inicial
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class MenuPanel extends JPanel implements MouseListener,MouseMotionListener {
	public static boolean pressedStatus[] = {false,false,false,false,false};
	

	public MenuPanel() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
		setBackground(Color.green);
	}
	
	
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(new ImageIcon("Imagens/menu1.png").getImage(), 0,0,null);
		g.drawImage(new ImageIcon("Imagens/banana-news.gif").getImage(), 75,194,null);
		g.drawImage(new ImageIcon("Imagens/Option2.jpg").getImage(), 565,194,null);
		if (pressedStatus[0] == true) g.drawImage(new ImageIcon("Imagens/ZenOver.png").getImage(), 394,194,null);
		if (pressedStatus[1] == true) g.drawImage(new ImageIcon("Imagens/HighscoresOver.png").getImage(), 884,194,null);
		if (pressedStatus[2] == true) g.drawImage(new ImageIcon("Imagens/SettingsOver.png").getImage(), 1042,194,null);
		if (pressedStatus[3] == true) g.drawImage(new ImageIcon("Imagens/HowtoOver.png").getImage(), 884,345,null);
		if (pressedStatus[4] == true) g.drawImage(new ImageIcon("Imagens/LogoutOver.png").getImage(), 1042,345,null);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("X: " + arg0.getX() + " Y:" +  arg0.getY() );
		
		if (e.getX() > 394 && e.getX() < 547 && e.getY()>195 && e.getY() < 340 )
		{
			System.out.println("START");
			GameWindow.fruta.clear();
			GameWindow.cut_points = 0;
			GameWindow.secondsLeft = GameWindow.gameLenght;
			GameWindow.gameStatus = 1;
			GameWindow.scoreIsSaved = false;
			
		}
		if (e.getX() > 884 && e.getX() < 1037 && e.getY()>195 && e.getY() < 340 )
		{
			System.out.println("HIGHSCORES");
			Collections.sort(GameWindow.highscores);
			
			
			this.setVisible(false);
			this.setFocusable(false);
			GameWindow.painelHighscores.setVisible(true);
			GameWindow.painelHighscores.repaint();
			GameWindow.painelHighscores.setFocusable(true);
			
		}
		if (e.getX() > 1042 && e.getX() < 1195 && e.getY()>195 && e.getY() < 340 )
		{
			System.out.println("SETTINGS");
			this.setVisible(false);
			this.setFocusable(false);
			GameWindow.painelSettings.setVisible(true);
			GameWindow.painelSettings.repaint();
			GameWindow.painelSettings.setFocusable(true);
		}
		if (e.getX() > 884 && e.getX() < 1037 && e.getY()>346 && e.getY() < 491 )
		{
			System.out.println("HOW TO");
			this.setVisible(false);
			this.setFocusable(false);
			GameWindow.painelHowto.setVisible(true);
			GameWindow.painelHowto.repaint();
			GameWindow.painelHowto.setFocusable(true);
		}
		if (e.getX() > 1042 && e.getX() < 1195 && e.getY()>346 && e.getY() < 491 )
		{
			System.out.println("LOG OUT");
			PlayerScore.saveScoreFile(GameWindow.HIGHSCORES_FILENAME,GameWindow.highscores);
			GameWindow.gameStatus = 4;
			GameWindow.frame.dispose();
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.repaint();
		for(int i= 0; i < pressedStatus.length; i++)
		{
			pressedStatus[i] = false;
		}
		
		if (e.getX() > 394 && e.getX() < 547 && e.getY()>195 && e.getY() < 340 ) pressedStatus[0] = true;
		if (e.getX() > 884 && e.getX() < 1037 && e.getY()>195 && e.getY() < 340 )pressedStatus[1] = true;
		if (e.getX() > 1042 && e.getX() < 1195 && e.getY()>195 && e.getY() < 340 ) pressedStatus[2] = true;
		if (e.getX() > 884 && e.getX() < 1037 && e.getY()>346 && e.getY() < 491 ) pressedStatus[3] = true;
		if (e.getX() > 1042 && e.getX() < 1195 && e.getY()>346 && e.getY() < 491 ) pressedStatus[4] = true;
		
	}


}
