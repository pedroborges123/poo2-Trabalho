package br.edu.ifes.sr.poo2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

@Entity
public class Jogo extends Model  {

/**
*
*/
private static final long serialVersionUID = 1L;

@Column
private String username;

@ManyToMany(fetch = FetchType.EAGER )
private List<Pergunta> perguntas = new ArrayList<Pergunta>();




public void setUsername(String username) {
// TODO Auto-generated method stub
this.username = username;
}


public String getUsername() {
// TODO Auto-generated method stub
return this.username;
}


public void setPerguntas(List<Pergunta> perguntas) {
// TODO Auto-generated method stub

this.perguntas = perguntas;

}


public void addPergunta(Pergunta p) {
// TODO Auto-generated method stub
this.perguntas.add(p);

}


public List<Pergunta> getPerguntas() {
// TODO Auto-generated method stub
return this.perguntas;
}

}