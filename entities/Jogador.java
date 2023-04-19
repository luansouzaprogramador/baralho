package entities;

public class Jogador {
	private Carta[] mao;
	
	// construtor
	public Jogador(Carta[] mao) {
		this.mao = mao;
	}

	// metodos get e set
	
	public Carta[] getMao() {
		return mao;
	}

	public void setMao(Carta[] mao) {
		this.mao = mao;
	}
	
	public Carta jogarMaiorCarta() {
		Carta maiorCarta = mao[0];
		
		for (int i = 0; i < mao.length; i++) {
			if (mao[i].getValor() > maiorCarta.getValor()) {
				maiorCarta = mao[i];
			}
		}
		
		return maiorCarta;
	}
}
