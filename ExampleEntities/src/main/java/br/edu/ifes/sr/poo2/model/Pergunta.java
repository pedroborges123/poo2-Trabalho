package br.edu.ifes.sr.poo2.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pergunta extends Model {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @OneToMany
    private List<Resposta> respostas = new ArrayList<Resposta>();
    
    @Column
    private String valor;
    
    @OneToOne
    public Nivel nivel;

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
