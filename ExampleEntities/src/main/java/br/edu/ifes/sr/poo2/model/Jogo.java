package br.edu.ifes.sr.poo2.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Jogo extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Jogador player;
	
	@OneToMany
	private List<Pergunta> listPerguntas; 
	
	public Jogador getPlayer() {
		return player;
	}

	public void setPlayer(Jogador player) {
		this.player = player;
	}

	public List<Pergunta> getListPerguntas() {
		return listPerguntas;
	}

	public void setListPerguntas(List<Pergunta> listPerguntas) {
		this.listPerguntas = listPerguntas;
	}

}
