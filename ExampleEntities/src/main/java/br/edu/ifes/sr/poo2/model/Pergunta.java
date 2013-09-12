package br.edu.ifes.sr.poo2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Pergunta extends Model {

/**
*
*/
private static final long serialVersionUID = 1L;

@Column
private String valor;

@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
private Set<Resposta> respostas = new HashSet<Resposta>();

@Column
private Nivel nivel;

public Nivel getNivel() {
return nivel;
}

public void setNivel(Nivel nivel) {
this.nivel = nivel;
}

public String getValor() {
return valor;
}

public void setValor(String valor) {
this.valor = valor;
}

public Set<Resposta> getRespostas() {
return respostas;
}

public void setRespostas(Set<Resposta> respotas) {
this.respostas = respotas;
}


public Resposta getResposta() {
return (Resposta) respostas.iterator();
}

public void addResposta(Resposta r){
this.respostas.add((Resposta) r);
}



}