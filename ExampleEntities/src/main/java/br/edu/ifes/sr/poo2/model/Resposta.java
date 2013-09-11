package br.edu.ifes.sr.poo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Resposta extends Model {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @Column
    private String valor;
    
    @Column
    private Boolean respostacorreta;
    
    @Column
    private Long perguntaId;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Boolean getRespostacorreta() {
        return respostacorreta;
    }

    public Long getPerguntaId() {
		return perguntaId;
	}

	public void setPerguntaId(Long perguntaId) {
		this.perguntaId = perguntaId;
	}

	public void setRespostacorreta(Boolean respostacorreta) {
        this.respostacorreta = respostacorreta;
    }
}
