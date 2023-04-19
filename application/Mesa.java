package application;

import java.util.Scanner;

import entities.Baralho;
import entities.Jogador;

public class Mesa {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		boolean fimDeJogo;
		
		do {
			int quantidade;
			Baralho baralho = new Baralho();
			Jogador jogadorA, jogadorB;
			
			System.out.println("Mesa embaralhando........");
			baralho.embaralhar();
			
			do {
				System.out.println("Informe o numero de cartas a distribuir para os jogadores: ");
				quantidade = teclado.nextInt();
				
				if (quantidade < 1 || quantidade > 26)
					System.out.println("Informe um numero entre 1 e 26");
			} while (quantidade < 1 || quantidade > 26);
			
			
			
			
			System.out.println("Mesa distribui as " + quantidade + " jogador A e para o jogador B");
			jogadorA = new Jogador(baralho.retirarCartas(quantidade));
			jogadorB = new Jogador(baralho.retirarCartas(quantidade));
			
			System.out.printf("O jogador A joga a carta de naipe %s e de valor %d%n", jogadorA.jogarMaiorCarta().getNaipe(), jogadorA.jogarMaiorCarta().getValor());
			System.out.printf("O jogador B joga a carta de naipe %s e de valor %d%n", jogadorB.jogarMaiorCarta().getNaipe(), jogadorB.jogarMaiorCarta().getValor());
			
			// condicionais
			
			String resultado;
			
			if (jogadorA.jogarMaiorCarta().comparaValor(jogadorB.jogarMaiorCarta()) == 1) {
				resultado = "O jagador A venceu o jogo";
				fimDeJogo = true;
			} else if (jogadorA.jogarMaiorCarta().comparaValor(jogadorB.jogarMaiorCarta()) == -1) {
				resultado = "O jogador B venceu o jogo";
				fimDeJogo = true;
			} else {
				if (jogadorA.jogarMaiorCarta().comparaNaipe(jogadorB.jogarMaiorCarta())) {
					if (jogadorA.jogarMaiorCarta().getNaipe().equals("Ouros")) {
						resultado = "Como os valores das cartas sao iguais e ambos jogadores tem carta de Ouros, o jogo ficou empatado";
						fimDeJogo = false;
					} else {
						resultado = "Como os valores das cartas sao iguais e ambos jogadores nao tem carta de Ouros, o jogo ficou empatado";
						fimDeJogo = false;
					}
				} else {
					if (jogadorA.jogarMaiorCarta().getNaipe().equals("Ouros")) {
						resultado = "O jogador A venceu o jogo";
						fimDeJogo = true;
					} else if (jogadorB.jogarMaiorCarta().getNaipe().equals("Ouros")) {
						resultado = "O jogador B venceu o jogo";
						fimDeJogo = true;
					} else {
						resultado = "Como os valores numericos das cartas sao iguais, o naipe delas sao diferentes e ambos jogadores nao tem carta de Ouros, o jogo ficou empatado";
						fimDeJogo = false;
					}
				}
			}
			
			System.out.println(resultado);
		} while (fimDeJogo == false);
		
		teclado.close();
	}
}
