package tests;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;

import logic.Fruta;

import org.junit.Test;
/**  
* Classe de testes de corte da fruta.  
* @author  Joao Trindade & Paulo Marcos
*/ 
public class CorteTestes {

	/** Teste ao corte no centro da fruta */
	@Test
	public void CortarFrutaCentro(){
		
		ArrayList<Point>listaCorte = new ArrayList<Point>();
		Point ponto1 = new Point(100,100);
		listaCorte.add(ponto1);
		
		
		ArrayList<Fruta>listaFruta = new ArrayList<Fruta>();
		
		Fruta bananaTeste = new Fruta(100,100,false);
		listaFruta.add(bananaTeste);
		
		assertFalse(listaFruta.get(0).isCutted());
		
		logic.Game.checkColisao(listaFruta,listaCorte);
		
		assertTrue(listaFruta.get(0).isCutted());
		
	}
	
	/** Teste de corte na borda da fruta */
	@Test
	public void CortarFrutaBorda(){
		
		ArrayList<Point>listaCorte = new ArrayList<Point>();
		Point ponto1 = new Point(110,110);
		listaCorte.add(ponto1);
		
		
		ArrayList<Fruta>listaFruta = new ArrayList<Fruta>();
		
		Fruta bananaTeste = new Fruta(100,100,false);
		bananaTeste.setAltura(10);
		bananaTeste.setLargura(10);
		listaFruta.add(bananaTeste);
		
		assertFalse(listaFruta.get(0).isCutted());
		
		logic.Game.checkColisao(listaFruta,listaCorte);
		
		assertTrue(listaFruta.get(0).isCutted());
		
	}
	
	
	/**Teste a um corte que não atinge a fruta */
	@Test
	public void CorteErrado(){
		
		ArrayList<Point>listaCorte = new ArrayList<Point>();
		Point ponto1 = new Point(111,111);
		listaCorte.add(ponto1);
		
		
		ArrayList<Fruta>listaFruta = new ArrayList<Fruta>();
		
		Fruta bananaTeste = new Fruta(100,100,false);
		bananaTeste.setAltura(10);
		bananaTeste.setLargura(10);
		listaFruta.add(bananaTeste);
		
		assertFalse(listaFruta.get(0).isCutted());
		
		logic.Game.checkColisao(listaFruta,listaCorte);
		
		assertFalse(listaFruta.get(0).isCutted());
		
	}

	

}
