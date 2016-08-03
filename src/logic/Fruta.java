package logic;

public class Fruta {

	/** Coordenada X da fruta no ecra */
	private double X_Cord;
	/** Coordenada Y da fruta no ecra */
	private double Y_Cord;
	/** Direcao do movimento da fruta, 1 - esquerda para direita, 2 - direita para esquerda */
	private int direcao; // 1 esquerda para direita, 2 direita para esquerda
	/** Numero da funcao de movimento da fruta */
	private int numFuncao; // Numero da funcao de direcao
	/** Valor do incremento, velocidade, do movimento da fruta */
	private float incremento;
	/** Se a fruta está cortada, ou não */
	private boolean cutted;
	/** Largura da imagem */
	private int largura;
	/** Altura da imagem*/
	private int altura;
	/**Nome da imagem da fruta*/
	private String imagem;
	
	/**Construtor de objecto fruta, com coordenadas e estado de corte */
	public Fruta(double x, double y, boolean cutted) {
		X_Cord = x;
		Y_Cord = y;
		setCutted(cutted);
	}
	
	/**Construtor de objecto fruta, com coordenada, direcao de movimento, numero da funcao de movimento, valor de incremento (velocidade) */
	public Fruta(double x, double y, int _direcao, int _numFuncao, float _incremento) {
		X_Cord = x;
		Y_Cord = y;
		direcao = _direcao;
		numFuncao = _numFuncao;
		incremento  = _incremento;
		setCutted(false);
		altura = 80; // TODO: MUDAR ISTO
		largura = 80; // TODO: MUDAR ISTO
	}
	
	//TIPO FRUTA: 1 - banana...
	//SEEDMOVIMENTO: varias configurações
	
	/**Construtor de objecto fruta, de alto nivel, tipo de fruta (1 - banana, 2-ananas, 3-manga, 4-lima), e tipo de movimento (1,2,3,4) */
	public Fruta(int tipoFruta, int seedMovimento)
	{
		switch(tipoFruta)
		{	
			//BANANA
			case 1:
			{
				altura = 93;
				largura = 68;
				imagem = "Imagens/banana.png";
				break;
			}
			//ANANAS
			case 2:
			{
				//TODO:
				altura = 94;
				largura = 66;
				imagem = "Imagens/ananas.png";
				break;
			}
			//Manga
			case 3:
			{
				//TODO:
				altura = 90;
				largura = 66;
				imagem = "Imagens/manga.png";
				break;
			}
			//Lima
			case 4:
			{
				//TODO:
				altura = 95;
				largura = 112;
				imagem = "Imagens/lima.png";
				break;
			}
			//Tangerina
			case 5:
			{
				//TODO:
				altura = 87;
				largura = 90;
				imagem = "Imagens/tangerina.png";
				break;
			}
			//Roma
			case 6:
			{
				//TODO:
				altura = 87;
				largura = 90;
				imagem = "Imagens/roma.png";
				break;
			}
			//Blueberry
			case 7:
			{
				//TODO:
				altura = 130;
				largura = 90;
				imagem = "Imagens/blueberry.png";
				break;
			}
			
		}
		
		switch(seedMovimento)
		{
			case 1:
			{
				//1,1,1,1,3
				//Movimento Esquerda para Direita, velocidade baixa , parabola larga
				X_Cord = 1;
				Y_Cord = 1;
				direcao = 1;
				numFuncao = 1;
				incremento = 2;
				break;
			}
			
			case 2:
			{
				//590,1,1,2,1
				//Movimento esquerda para direita, velocidade alta, parabola curta, INICIO CENTRAL
				X_Cord = 590;
				Y_Cord = 1;
				direcao = 1;
				numFuncao = 2;
				incremento = 2;
				break;
			}
			
			case 3:
			{
				//690,1,2,2,1
				//Movimento direita para esquerda, velocidade alta, parabola curta, INICIO CENTRAL
				X_Cord = 690;
				Y_Cord = 1;
				direcao = 2;
				numFuncao = 2;
				incremento = 2;
				break;
			}
			
			case 4:
			{
				//(200,1,1,1,3);
				//Movimento direita para esquerda, velocidade baixa, parabola larga
				X_Cord = 1280;
				Y_Cord = 1;
				direcao = 2;
				numFuncao = 1;
				incremento = 4;
				break;
			}
			
			case 5:
			{
				//(200,1,1,1,3);
				//Movimento direita para esquerda, velocidade baixa, parabola larga
				X_Cord = 320;
				Y_Cord = 1;
				direcao = 1;
				numFuncao = 3;
				incremento = 4;
				break;
			}
			
			case 6:
			{
				//(200,1,1,1,3);
				//Movimento direita para esquerda, velocidade baixa, parabola larga
				X_Cord = 960;
				Y_Cord = 1;
				direcao = 2;
				numFuncao = 3;
				incremento = 4;
				break;
			}
			
			case 7:
			{
				//(200,1,1,1,3);
				//Movimento direita para esquerda, velocidade baixa, parabola larga
				X_Cord = 0;
				Y_Cord = 1;
				direcao = 1;
				numFuncao = 4;
				incremento = 5;
				break;
			}
			
			case 8:
			{
				//(200,1,1,1,3);
				//Movimento direita para esquerda, velocidade baixa, parabola larga
				X_Cord = 0;
				Y_Cord = 1;
				direcao = 1;
				numFuncao = 5;
				incremento = 5;
				break;
			}
			
			
		}
		setCutted(false);
	}
	
	/**
	 * Devolve a Coordenada X
	 * @return Coordenada X
	 */
	public double getX() {
		return X_Cord;
	}
	/**
	 * Altera coordenada X
	 * @param x_Cord nova coordenada
	 */
	public void setX(double x_Cord) {
		X_Cord = x_Cord;
	}
	/**
	 * Devolve a Coordenada Y
	 * @return Coordenada Y
	 */
	public double getY() {
		return Y_Cord;
	}
	/**
	 * Altera coordenada Y
	 * @param y_Cord nova coordenada
	 */
	public void setY(double y_Cord) {
		Y_Cord = y_Cord;
	}
	/**
	 * Devolve valor da direcao
	 * @return 1- esquerda->direita, 2- direita->esquerda
	 */
	public int getDirecao() {
		return direcao;
	}
	/**
	 * Altera a direcao da fruta
	 * @param direcao nova direcao 1- esquerda->direita, 2- direita->esquerda
	 */
	public void setDirecao(int direcao) {
		this.direcao = direcao;
	}
	/**
	 * Devolve o numero da funcao atual.
	 * @return 
	 */
	public int getNumFuncao() {
		return numFuncao;
	}
	
	/**
	 * Altera a funcao de movimento
	 * @param numFuncao 1 - parabola larga, 2- parabola curta
	 */
	public void setNumFuncao(int numFuncao) {
		this.numFuncao = numFuncao;
	}

	/**
	 * Devolve o valor do incremento (Velocidade)
	 * @return Valor de incremento (Velocidade)
	 */
	public float getIncremento() {
		return incremento;
	}

	/**
	 * Altera o incremento, velocidade do movimento
	 * @param incremento novo incremento
	 */
	public void setIncremento(float incremento) {
		this.incremento = incremento;
	}

	/**
	 * Se a fruta está cortada, ou não
	 * @return True - Cortada, False- Por cortar
	 */
	public boolean isCutted() {
		return cutted;
	}

	/**
	 * Altera o estado de corte da fruta
	 * @param cutted True - Cortada, False - Por cortar
	 */
	public void setCutted(boolean cutted) {
		this.cutted = cutted;
	}

	/**
	 * @return Valor de largura da imagem da fruta
	 */
	public int getLargura() {
		return largura;
	}
	/**
	 * Altera a largura da imagem da fruta
	 * @param largura nova largura
	 */
	public void setLargura(int largura) {
		this.largura = largura;
	}
	/**
	 * @return Valor de altura da imagem da fruta
	 */
	public int getAltura() {
		return altura;
	}
	/**
	 * Altera a altura da imagem da fruta
	 * @param altura nova altura
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	/**
	 * Devolve a localização da imagem
	 * @return localizacao da imagem
	 */
	public String getImagem() {
		return imagem;
	}
	/**
	 * Altera a imagem associada a fruta
	 * @param imagem localizacao da nova imagem
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


}
