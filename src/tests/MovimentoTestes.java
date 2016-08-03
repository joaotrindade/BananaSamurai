package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import logic.Fruta;
import logic.Game;
import logic.Splash;

import org.junit.Test;

public class MovimentoTestes {

	/**Teste à criacao de uma fruta */
	@Test
	public void CriaFruta(){
		
		Fruta bananaTeste = new Fruta(100,100,false);
		assertEquals(100,bananaTeste.getX(),0);
		assertEquals(100, bananaTeste.getY(),0);
	}
	
	/**Teste lançamento de uma fruta da esquerda para a direita */
	@Test
	public void MoveFrutaEsquerda(){
		
		ArrayList<Splash>splash = new ArrayList<Splash>();
		
		ArrayList<Fruta>listaFruta = new ArrayList<Fruta>();
		Fruta bananaTeste = new Fruta(1,1,1,1,3);
		Fruta bananaTeste2 = new Fruta(590,1,1,2,1);
		
		listaFruta.add(bananaTeste);
		listaFruta.add(bananaTeste2);
		
		Game.actualizaFruta(listaFruta,splash);
		
		assertEquals(4,listaFruta.get(0).getX(),0);
		assertEquals(750,listaFruta.get(0).getY(),1);
		
		assertEquals(listaFruta.get(1).getX(),591,0);
		assertEquals(729,listaFruta.get(1).getY(),1);
	}
	
	/**Teste ao lançamento de uma fruta da direita para esquerda */
	@Test
	public void MoveFrutaDireita(){
		
		ArrayList<Splash>splash = new ArrayList<Splash>();
		
		ArrayList<Fruta>listaFruta = new ArrayList<Fruta>();
		Fruta bananaTeste = new Fruta(690,1,2,2,1);
		Fruta bananaTeste2 = new Fruta(200,1,1,1,3);
		
		listaFruta.add(bananaTeste);
		listaFruta.add(bananaTeste2);
		
		Game.actualizaFruta(listaFruta,splash);
		
		assertEquals(689,listaFruta.get(0).getX(),0);
		assertEquals(729,listaFruta.get(0).getY(),1);
		
		assertEquals(203,listaFruta.get(1).getX(),0);
		assertEquals(354,listaFruta.get(1).getY(),1);
	}

}
