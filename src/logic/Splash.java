package logic;
/**
 * Classe reponsavel pelos Splashs quando a fruta é cortada
 * @author Joao Trindade & Paulo Marcos
 *
 */
public class Splash extends Fruta {
	/** Ticks - tempo que falta para o splash desaparecer */
	private int ticks;
	
	public Splash(double x, double y, boolean cutted) {
		super(x, y, cutted);
		this.setImagem("Imagens/splash3.gif");
		this.ticks = 20;
	}

	/**
	 * 
	 * @return Numero de ticks que faltam para o splash desaparecer
	 */
	public int getTicks() {
		return ticks;
	}
	
	/**
	 * Alterar ticks em falta
	 * @param ticks Novo valor
	 */
	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
	/**
	 * Decrementar o tempo que falta em uma unidade;
	 */
	public void decTick() {this.ticks = this.ticks--;}

}
