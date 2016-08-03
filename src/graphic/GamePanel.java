package graphic;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Painel de jogo
 * @author Joao Trindade & Paulo Marcos
 *
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	public static ArrayList<Point> pontos = new ArrayList<Point>();
	public static int X_Cord = -1;
	public static int Y_Cord = -1;
	public static int X_Cord_last = -1;
	public static int Y_Cord_last = -1;
	public static boolean released=false;
	
	
	public GamePanel() {
		super();
		//setForeground(new ImageIcon("wallpaper1.png").getImage());
		
		
		MyListener myListener1 = new MyListener();
		addMouseListener(myListener1);
		addMouseMotionListener(myListener1);
		
		//addMouseMotionListener(this);
	}
	

	
	public void paintComponent(Graphics g)
	{
		
		
		//DESENHAR BG
		g.setFont(GameWindow.tipoLetra2);
		g.drawImage(new ImageIcon(GameWindow.GameWall).getImage(), 0,0,null);
		//g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
		
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(GameWindow.secondsLeft), 1085, 100);
		g.drawString(Integer.toString(GameWindow.cut_points), 0, 100);
		
		for(int j = 0; j < GameWindow.splash.size(); j++)
		{
			if (GameWindow.splash.get(j).getTicks() > 0)
			{	
				g.drawImage(new ImageIcon(GameWindow.splash.get(j).getImagem()).getImage(), ((int)GameWindow.splash.get(j).getX()), (int)GameWindow.splash.get(j).getY(), null);
				GameWindow.splash.get(j).setTicks(GameWindow.splash.get(j).getTicks() - 1);
			}
			else
			{
				GameWindow.splash.remove(j);
				j--;
			}
			
		}
		
		
		//DESENHAR A FRUTA
		//System.out.println("Entrou paint. Size Fruta = " + GameWindow.fruta.size() );
		//GameWindow.fruta.size()
		for(int i = 0; i < GameWindow.fruta.size(); i++)
		{
			if (GameWindow.fruta.get(i).isCutted() == false)
			{
				g.drawImage(new ImageIcon(GameWindow.fruta.get(i).getImagem()).getImage(), ((int)GameWindow.fruta.get(i).getX()), (int)GameWindow.fruta.get(i).getY(), null);
			}
		}
		
		if(released == true)
		{
			//System.out.println("Entrou RELEASE");
			pontos.clear();
			this.setOpaque(false); 
			super.paintComponent(g); 
		}
		else
		{ 
			
			this.setOpaque(true);
			
			g.setColor(new Color(220,220,220));
			((Graphics2D) g).setStroke(new BasicStroke(5));
			
			for(int i = 0 ; i < pontos.size()-2; i++)
			{
				g.drawLine(pontos.get(i).x, pontos.get(i).y, pontos.get(i+1).x, pontos.get(i+1).y);
			}
		}
		
		
		
	}
}
