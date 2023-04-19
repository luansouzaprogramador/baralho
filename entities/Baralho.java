package entities;

import java.util.Random;

public class Baralho {
	private static Random gerador = new Random();
	private Carta[] cartas; // cria o baralho com 52 cartas
	private String[] nomes = {"Espadas", "Paus", "Copas", "Ouros"};

	// metodos get e set
	
	public Carta[] getCartas() {
		return cartas;
	}


	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}


	public String[] getNomes() {
		return nomes;
	}


	public void setNomes(String[] nomes) {
		this.nomes = nomes;
	}
	
	// esse construtor serve para povoar o baralho de cartas
	
	public Baralho() {
		cartas = new Carta[52];
		int posicao = 0;
		
		for (int i = 0; i < nomes.length; i++) {
			for (int valor = 0; valor < 13; valor++) {
				cartas[posicao] = new Carta(nomes[i], valor);
				posicao++;
			}
		}
	}
	
	
	public void embaralhar() {
		Carta aux;
		int posicao;
		
		for (int i = 0; i < cartas.length; i++) {
			posicao = gerador.nextInt(cartas.length);
			aux = cartas[i];
			cartas[i] = cartas[posicao];
			cartas[posicao] = aux;
		}
	}
	
	public Carta retirarUmaCarta() {
		Carta aux;
		int posicao;
		
		do {
			posicao = gerador.nextInt(cartas.length);
		} while (cartas[posicao] == null);
		
		aux = cartas[posicao];
		cartas[posicao] = null;

		return aux;
	}
	
	public Carta[] retirarCartas(int quantidade) {
		Carta[] cartasRemovidas = new Carta[quantidade];
		
		for (int i = 0; i < cartasRemovidas.length; i++) {
			cartasRemovidas[i] = retirarUmaCarta();
		}
		
		return cartasRemovidas;
	}
}
