package graphic;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import logic.Game;



/**
 * Listener de movimentos do rato
 * @author Joao Trindade & Paulo Marcos
 *
 */
public class MyListener extends MouseInputAdapter {
	/** Estado do rato. Se esta premido ou não */
	private boolean releaseStatus = true;

	/** Movimento de drag do rato */
	public void mouseDragged(MouseEvent e)
	{
		if (GameWindow.gameStatus != 2)
		{
			
		
			if(releaseStatus == true)
			{
				GamePanel.X_Cord_last = e.getX();
				GamePanel.Y_Cord_last = e.getY();
				GamePanel.X_Cord = e.getX();
				GamePanel.Y_Cord = e.getY();
				
	
				GamePanel.pontos.add(e.getPoint());
			
				releaseStatus = false;
				GamePanel.released = false;
			}
			else
			{
				GamePanel.X_Cord_last = GamePanel.X_Cord;
				GamePanel.Y_Cord_last = GamePanel.Y_Cord;
				GamePanel.X_Cord = e.getX();
				GamePanel.Y_Cord = e.getY();
				
				if(GamePanel.pontos.size()<10)
				{
					GamePanel.pontos.add(e.getPoint());
				}
				else
				{
					GamePanel.pontos.remove(0);
					//System.out.println(GamePanel.pontos.get(0).x + " " + GamePanel.pontos.get(0).y);
					GamePanel.pontos.add(e.getPoint());
					
					//System.out.println("NPontos : " + GamePanel.pontos.size());
				}
			}
			//System.out.println("Entrou drag");
			//System.out.println("X: "+ GamePanel.X_Cord + " Y: "+ GamePanel.Y_Cord );
			//System.out.println("XL: "+ GamePanel.X_Cord_last + " YL: "+ GamePanel.Y_Cord_last);
			Game.checkColisao(GameWindow.fruta, GamePanel.pontos);
			//GameWindow.painel1.repaint();
		}
		
	}
	
	/** Detetar quando o rato já nao esta premido */
	public void mouseReleased(MouseEvent e)
	{
		//System.out.println("Entrou release");
		releaseStatus = true;
		GamePanel.released = true;
		GameWindow.painel1.setOpaque(false);
		
		//GameWindow.painel1.repaint();
	}
	
	/** Detetar click do botao direito do rato para pausar o jogo */
	public void mouseClicked(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			System.out.println("Game Paused/Continued");
			if (GameWindow.gameStatus == 1) GameWindow.gameStatus = 2;
			else if (GameWindow.gameStatus == 2) GameWindow.gameStatus = 1;
		}
	}
	

}
