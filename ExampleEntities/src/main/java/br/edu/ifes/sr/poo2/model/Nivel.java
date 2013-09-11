package br.edu.ifes.sr.poo2.model;

public enum Nivel {

	Mix(0),Facil(1),Medio(2),Dificil(3);
	
	private int value;

	private Nivel(int valor) {
	value = valor;
	}

	public int getCode() {
	return value;
	}

}
