package br.edu.ifes.sr.poo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Score extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column
	private long jogoId;
	
	@Column
	private long jogadorId;
	
	@Column
	private int pontuacao;
	
	public long getJogoId() {
		return jogoId;
	}

	public void setJogoId(long jogoId) {
		this.jogoId = jogoId;
	}

	public long getJogadorId() {
		return jogadorId;
	}

	public void setJogadorId(long jogadorId) {
		this.jogadorId = jogadorId;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}


}
