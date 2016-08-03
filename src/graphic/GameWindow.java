package graphic;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;

import logic.Fruta;
import logic.Game;
import logic.PlayerScore;
import logic.Splash;


/**
 * Janela de jogo
 * @author Joao Trindade & Paulo Marcos
 *
 */
public class GameWindow {
	/** Endereço ficheiro musica */
	public static final String LABANANA_WAV = "Musica/labanana.WAV";
	/** Estado do click do rato */
	static boolean mouseClick = false;
	/** Endereco imagem de fundo */
	public static String GameWall="Imagens/Wood.jpg";
	/** Cor de letra */
	public static Color FontColor = new Color(0,175,240);
	/** Frame principal do jogo */
	public static JFrame frame;
	/** Painel de jogo */
	public static GamePanel painel1;
	/** Painel de Menu */
	public static MenuPanel painelMenu;
	/** Painel de Highscores */
	public static HighscoresPanel painelHighscores;
	/** Painel de Howto */
	public static HowtoPanel painelHowto;
	/** Painel de defenições */
	public static SettingsPanel painelSettings;
	/** Estado de jogo: 0 - Não iniciado, 1 - A Jogar, 2-Paused, 3-GameOver, 4-exit  */
	public static int gameStatus;
	/** Fruta existente */
	public static ArrayList<Fruta>fruta = new ArrayList<Fruta>();
	/** Splash existentes */
	public static ArrayList<Splash>splash = new ArrayList<Splash>();
	/** Delay do timer movimento da fruta */
	private static int delay = 25;
	/**Delay timer de jogo */
	private static int delay_segundo = 1000;
	/** Timer movimento da fruta */ 
	private static Timer timerMovimento;
	/** Timer do tempo de jogo */
	private static Timer timerJogo;
	/** Segundos que faltam para o fim do jogo */
	public static int gameLenght = 60;
	/** Segundos que faltam para o fim do jogo */
	public static int secondsLeft = 60;
	/** Se a pontuacao ja foi guardada */
	public static boolean scoreIsSaved;
	/** ArrayList de Highscores */
	public static ArrayList<PlayerScore> highscores = new ArrayList<PlayerScore>();
	/** Nome do ficheiro onde guardar pontuaçoes */
	public static final String HIGHSCORES_FILENAME = "Files/highscores";
	/** Formato da data */
	public static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	/** Numero maximo de fruta por segundo */
	public static int maxThrowNumber = 1;
	/** Pontos no jogo */
	public static int cut_points = 0;
	/**Musica a ser reproduzida  */
	public static Clip playingMusic = null;
	/** Accao para desencadear movimento e atualizacao da fruta */
	static ActionListener action;
	/** Accao para controlar o tempo de jogo. Atualiza o relogio*/
	static ActionListener action2;
	/** Tipos de letra predefenidos */
	public static Font tipoLetra=null, tipoLetra2=null, tipoLetraHighscores=null; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					GameWindow window = new GameWindow();
					window.frame.setVisible(true);
					//System.out.println("Entrou MAIN");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
			action = new ActionListener()
	        {   
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	                if(secondsLeft == 0)
	                {
	                	timerMovimento.stop();
	                	timerJogo.stop();
	            		gameStatus = 3;
	            		if (!(scoreIsSaved))
	            		{
	            			scoreIsSaved = true;
	            			GetPlayerInfo sl = new GetPlayerInfo();
		    				sl.setVisible(true);
		    				sl.setLocationRelativeTo(null);
		    				
	            		}
	                	//System.out.println("Timer Acabou");
	                   // label.setText("The time is up!");
	                }
	                else
	                {
	                	//contador++;
	                	//System.out.println("Wait for " + contador + " sec");
	                	Game.actualizaFruta(fruta,splash);
	                	Game.limpaVector(fruta);
	                	painel1.repaint();
	                    //label.setText("Wait for " + contador + " sec");
	                }
	            }
	        };
	
	        
	        
	        
	        
	        action2 = new ActionListener()
	        {   
	            @Override
	            public void actionPerformed(ActionEvent event)
	            {
	            	
	            	
	            	if (secondsLeft == 0)
	            	{
	            		//timerJogo.stop();
	            		//gameStatus = 0;
	            	}
	            	else
	            	{
	            		secondsLeft--;
	            		if (secondsLeft == (gameLenght/2)) maxThrowNumber++;
	            		Game.adicionaFrutaAleatoria(fruta, maxThrowNumber);
	            		Game.actualizaFruta(fruta,splash);
	            		Game.limpaVector(fruta);
	            		painel1.repaint();
	            	}
	            }
	        };
	        
	        
	        timerMovimento = new Timer(delay, action);
	        timerMovimento.setInitialDelay(0);
	        //timerMovimento.start();
	        
	        timerJogo = new Timer(delay_segundo, action2);
	        timerJogo.setInitialDelay(0);
	        //timerJogo.start();
	        
	        
       
        while (gameStatus != 4)
        {
        	/*
        	if (gameStatus == 3)
        	{
        		SaveScore sl = new SaveScore();
    				sl.setVisible(true);
				sl.setLocationRelativeTo(null);
        	}*/
        	
        	if (gameStatus == 2)
        	{
        		painel1.setFocusable(false);
        		timerJogo.stop();
        		timerMovimento.stop();
        		
        	}
        	if(gameStatus == 1)
        	{
        		painelMenu.setVisible(false);
        		painelMenu.setFocusable(false);
        		painel1.setVisible(true);
        		painel1.setFocusable(true);
        		timerMovimento.start();
        		timerJogo.start();
        		
        	}
        }
        
	}
	

	/**
	 * Create the application.
	 */
	public GameWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		File ficheiroFonte = new File("Fonts/gameFont.ttf");
		try {
			tipoLetra = Font.createFont(Font.TRUETYPE_FONT, ficheiroFonte);
			tipoLetraHighscores = new Font("Tahoma", Font.PLAIN, 25);
			tipoLetra2 = tipoLetra.deriveFont(Font.ITALIC, 115);
			
			//System.out.println("Entrou tipo letra");
		} catch (FontFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		PlayerScore.loadScoreFile(HIGHSCORES_FILENAME, highscores);
		
		gameStatus = 0;
		//TODO: ATIVAR ESTA LINHA
		playingMusic = Game.start_music(LABANANA_WAV);
		
		//System.out.println("Entrou Initialize");
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		painel1 = new GamePanel();
		painel1.setBounds(0, 0, 1280, 768);
		painel1.setOpaque(false);
		
		
		painelMenu = new MenuPanel();
		painelMenu.setBounds(0, 0, 1280, 768);
		painelMenu.setOpaque(true);
		
		painelHighscores = new HighscoresPanel();
		painelHighscores.setBounds(0, 0, 1280, 768);
		painelHighscores.setOpaque(true);
		
		painelHowto = new HowtoPanel();
		painelHowto.setBounds(0, 0, 1280, 768);
		painelHowto.setOpaque(true);
		
		painelSettings = new SettingsPanel();
		painelSettings.setBounds(0, 0, 1280, 768);
		painelSettings.setOpaque(true);
		
		
		frame.getContentPane().add(painelMenu);
		frame.getContentPane().add(painel1);
		frame.getContentPane().add(painelHighscores);
		frame.getContentPane().add(painelHowto);
		frame.getContentPane().add(painelSettings);
		
		painelSettings.setVisible(false);
		painelHowto.setVisible(false);
		painelHowto.setFocusable(true);
		painelHighscores.setVisible(false);
		painelHighscores.setFocusable(true);
		painelMenu.setVisible(true);
		painelMenu.setFocusable(true);
		painel1.setVisible(false);

		
		//frame.pack();
	}
}
