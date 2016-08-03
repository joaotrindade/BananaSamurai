package logic;

import graphic.GameWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Classe de Pontuacoes/Jogador
 * @author Joao Trindade & Paulo Marcos
 *
 */
public class PlayerScore implements Comparable<PlayerScore> {
	/** Nome do jogador */
	private String playerName;
	/** Pontuacao obtida */
	private int score;
	/** Data do jogo */
	private Calendar date;
	
	public PlayerScore(String nome, int _score, Calendar data) {
		playerName = nome;
		score = _score;
		date = data;
	}
	public PlayerScore() {
		
	}
	/**
	 * @return Nome do jogador
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * Alterar nome do jogador
	 * @param playerName Novo Nome
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	/**
	 * @return Pontuacao obtida
	 */
	public int getScore() {
		return score;
	}
	/**
	 * Alterar pontuacao obtida
	 * @param score Nova pontuacao
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return Data do jogo
	 */
	public Calendar getDate() {
		return date;
	}
	/**
	 * Alterar data do jogo
	 * @param date Nova data
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	/**
	 * Fazer load do ficheiro de pontuacoes maximas
	 * @param filename Nome do ficheiro
	 * @param scores ArrayList com as pontuacoes
	 * @return 0 se ficheiro carregado. -1 se erro
	 */
	public static int loadScoreFile(String filename, ArrayList<PlayerScore>scores)
	{
		String line, nome;
		
		
		int pontos, dia, mes, ano, hora, min, segundos;
		StringBuilder sb = new StringBuilder();
		int i;
		
		scores.clear();
		
		try {
			BufferedReader infile = new BufferedReader(new FileReader(filename + ".txt"));
			
			while((line = infile.readLine()) != null)
			{
				//System.out.println("Linha : " + line);
				i = 0;
				nome = "";
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				nome = sb.toString();
				//System.out.println("Nome : " + nome);
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				pontos = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				ano = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				mes = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				dia = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				hora = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '@')
				{
					sb.append(line.charAt(i));
					i++;
				}
				min = Integer.parseInt(sb.toString());
				i++;
				sb.delete(0, sb.length());
				while (line.charAt(i) != '$')
				{
					sb.append(line.charAt(i));
					i++;
				}
				
				segundos = Integer.parseInt(sb.toString());
				//System.out.println(ano + " " + mes+ " " +dia+ " " +hora+ " " +min+ " " +segundos);
				Calendar calTemp = Calendar.getInstance();
				calTemp.set(ano, mes-1, dia, hora, min, segundos);
				PlayerScore scoreTemp = new PlayerScore(nome,pontos,calTemp);
				
				scores.add(scoreTemp);
				
			}
			infile.close();
			return 0;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
			//e.printStackTrace();
			return -1;
		} catch (IOException e) {
			
			System.out.println("INPUT END");
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	/**
	 * Save dos highscores em ficheiro
	 * @param filename Nome do ficheiro onde gravar
	 * @param scores ArrayList de pontuacoes
	 * @return 0 se ficheiro gravado. -1 se erro
	 */
	public static int saveScoreFile(String filename, ArrayList<PlayerScore>scores )
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy@MM@dd@HH@mm@ss$");
		try {
			BufferedWriter fileout = new BufferedWriter(new FileWriter(filename +".txt"));
			for(int i = 0; i < scores.size(); i++)
			{
				fileout.write(scores.get(i).playerName + "@" + scores.get(i).score + "@" + dateFormat.format(scores.get(i).date.getTime()) );
				fileout.newLine();
			}
			fileout.close();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	/** Conversao para string */
	public String toString()
	{
		return (playerName + " " + score + " " + GameWindow.dateFormat.format(date.getTime()));
	}
	/** Comparacao por pontuacao */
	@Override
	public int compareTo(PlayerScore arg0) {
		return (arg0.getScore() - this.score);
	}
	
	

}
