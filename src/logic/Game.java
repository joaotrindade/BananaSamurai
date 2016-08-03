package logic;

import graphic.GameWindow;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Point;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
/**
 * Classe do motor de jogo. Funcoes de movimento. Colisoes. etc.
 * @author Joao Trindade & Paulo Marcos
 *
 */
public class Game {

	/**
	 * Funcao 1 de movimento. Parabola Larga
	 * @param t_value Valor de X
	 * @return Valor de Y
	*/
	public static float fruitPath1(float t_value)
	{
		//System.out.println("T: " + t_value);
		//System.out.println ("Y: " + 3 * ( ( (-19/30720)*(t_value*t_value)) + (19/24)*t_value) );
		return (3*(((float)-19/30720)*(t_value*t_value) + ((float)19/24)*t_value));
		//return 384;
	}
	/**
	 * Funcao 2 de movimento. Parabola curta
	 * @param t_value Valor de X
	 * @return Valor de Y
	*/
	public static float fruitPath2(float t_value)
	{
		//System.out.println("T: " + t_value);
		//System.out.println ("Y: " + 3 * ( ( (-19/30720)*(t_value*t_value)) + (19/24)*t_value) );
		//(-38/125)*x^2 + (9728/25)x - (618792/5)
		
		return ( ((float)-38/125)*(t_value*t_value) + ((float)9728/25)*t_value - ((float)618792/5) );
	}
	
	/**
	 * Funcao 3 de movimento. Parabola larga 2
	 * @param t_value Valor de X
	 * @return Valor de Y
	*/
	public static float fruitPath3(float t_value)
	{
		//System.out.println("T: " + t_value);
		//System.out.println ("Y: " + 3 * ( ( (-19/30720)*(t_value*t_value)) + (19/24)*t_value) );
		//(-38/125)*x^2 + (9728/25)x - (618792/5)
		
		return ( ((float)-3/800)*(t_value*t_value) + ((float)24/5)*t_value - (float)1152 );
	}
	
	/**
	 * Funcao 4 de movimento. Seno
	 * @param t_value Valor de X
	 * @return Valor de Y
	*/
	public static float fruitPath4(float t_value)
	{
		//System.out.println("T: " + t_value);
		//System.out.println ("Y: " + 3 * ( ( (-19/30720)*(t_value*t_value)) + (19/24)*t_value) );
		//(-38/125)*x^2 + (9728/25)x - (618792/5)
		
		return (float) ((100*Math.sin(t_value/20))+ 100 + (t_value/1.7));
	}
	
	/**
	 * Funcao 5 de movimento. Seno com maior amplitude
	 * @param t_value Valor de X
	 * @return Valor de Y
	*/
	public static float fruitPath5(float t_value)
	{
		//System.out.println("T: " + t_value);
		//System.out.println ("Y: " + 3 * ( ( (-19/30720)*(t_value*t_value)) + (19/24)*t_value) );
		//(-38/125)*x^2 + (9728/25)x - (618792/5)
		
		return (float) ((150*Math.sin(t_value/30))+ 150 + (t_value/1.7));
	}
	
	/**
	 * Verifica a colisao de uma lista de cortes com uma lista de frutas. Altera as frutas para "cortadas".
	 * @param fruta Lista de frutas
	 * @param espada Lista de cortes
	*/
	public static void checkColisao(ArrayList<Fruta>fruta, ArrayList<Point>espada)
	{
		for(int i= 0; i < espada.size(); i++)
		{
			for(int j= 0; j < fruta.size(); j++)
			{
				if (fruta.get(j).isCutted() == false)
				{
					
				
					if ((espada.get(i).getX() <= fruta.get(j).getX() + fruta.get(j).getLargura()) && (espada.get(i).getX() >= fruta.get(j).getX() ) && (espada.get(i).getY() <= fruta.get(j).getY() + fruta.get(j).getAltura()) && (espada.get(i).getY() >= fruta.get(j).getY()))
					{
						//System.out.println("COLISAO");
						//fruta.get(j).setImagem("splash.gif");
						fruta.get(j).setCutted(true);
						GameWindow.cut_points++;
						
					}
					
					//System.out.println("Coordenadas da banana: " + fruta.get(j).getX() + " " + fruta.get(j).getY() );
					//System.out.println("Coordenadas da espada: " + espada.get(i).getX() + " " + espada.get(i).getY() );
				}
			}
		}
	}
	
	/**
	 * Atualiza as posicoes da frutas para a proxima posicao
	 * @param fruta Lista de frutas
	*/
	public static void actualizaFruta(ArrayList<Fruta>fruta,ArrayList<Splash>splash)
	{
		double real_t;
		float incremento_final;
		
		for(int i = 0; i < fruta.size(); i++)
		{
			if (fruta.get(i).isCutted() == false) 
			{
				real_t = fruta.get(i).getX();
			
				if (fruta.get(i).getDirecao() == 1) incremento_final = fruta.get(i).getIncremento(); // IF PARA DETERMINAR A DIRECAO DO MOVIMENTO
				else incremento_final = -fruta.get(i).getIncremento();
				
				
				fruta.get(i).setX(real_t+incremento_final);
				
				switch(fruta.get(i).getNumFuncao())
				{
					case 1:	fruta.get(i).setY(760+(double)-(fruitPath1((float)real_t + incremento_final)));
							break;
					case 2: fruta.get(i).setY(760+(double)-(fruitPath2((float)real_t + incremento_final)));
							break;
					case 3: fruta.get(i).setY(760+(double)-(fruitPath3((float)real_t + incremento_final)));
							break;
					case 4: fruta.get(i).setY(760+(double)-(fruitPath4((float)real_t + incremento_final)));
						break;
					case 5: fruta.get(i).setY(760+(double)-(fruitPath5((float)real_t + incremento_final)));
						break;
					
				}
			}
			else
			{
				splash.add(new Splash(fruta.get(i).getX(),fruta.get(i).getY(),false));
				//System.out.println("Fruta cortada na atualizacao");
			}

		}
	}
	/**
	 * Insere fruta gerada aleatoriamente no vetor de fruta.
	 * @param fruta ArrayList de fruta onde adicionar.
	 * @param numero Numero de frutas a adicionar
	 */
	public static void adicionaFrutaAleatoria(ArrayList<Fruta>fruta, int numero)
	{
		for(int i = 0; i < numero; i++)
		{
			int tipoFruta = new Random().nextInt(7) + 1;
			int movimento = new Random().nextInt(8) + 1;
			//int movimento = 7;
			Fruta inserir = new Fruta(tipoFruta, movimento);
			fruta.add(inserir);
		}
	}
	
	/**
	 * Remove do vetor fruta cortada e que passou o ecrã
	 * @param fruta ArrayList de onde remover a fruta
	 */
	public static void limpaVector(ArrayList<Fruta>fruta)
	{
		for(int i= 0; i < fruta.size(); i++)
		{
			if ((fruta.get(i).getY() > 760) || (fruta.get(i).isCutted() == true))
			{
				fruta.remove(i);
				i--;
			}
		}
	}
	

	
	/**
	 * Iniciar a reproducao de musica
	 * @param filename Nome do ficheiro com a musica
	 * @return Clip com a musica a ser reproduzida
	 */
	public static Clip start_music(String filename)
	{
	    try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        //clip.start();
	        clip.setLoopPoints(0,-1);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	        return clip;

	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	        return null;
	    }
		
		
	}
	
	/**
	 * Faz pause/continue ao clip da musica
	 * @param music Clip com a musica
	 */
	public static void startStopMusic(Clip music)
	{
		if (music.isRunning()) music.stop();
		else music.start();
	}
	
}
