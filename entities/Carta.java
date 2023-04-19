package entities;

public class Carta {
	private String naipe;
	private int valor;
	
	public Carta(String naipe, int valor) {
		this.naipe = naipe;
		this.valor = valor;
	}
	
	// metodos get e set
	
	public String getNaipe() {
		return naipe;
	}
	
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public boolean comparaNaipe(Carta carta) {
		if (naipe.equals(carta.getNaipe()))
			return true;
		
		return false;
	}
	
	public int comparaValor(Carta carta) {
		if (valor > carta.getValor())
			return 1;
		else if (valor == carta.getValor())
			return 0;
		else
			return -1;
	}
}
