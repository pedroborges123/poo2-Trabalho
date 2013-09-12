package br.edu.ifes.sr.poo2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Jogo;
import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.repository.JogoRepository;;

public class JogoService implements CRUDService<Long, Jogo> {

@Autowired
JogoRepository jogoRepository;


public boolean isJogo (Long id)
{
Jogo jogo = this.get(id);
if (jogo == null) return false;
else return true;
}


public Jogo cadastrar (Jogador jogador, Nivel nivel, int quantPerguntas) throws Exception
{	
PerguntaService perguntaService = new PerguntaService();

Jogo jogo = new Jogo();
jogo.setUsername(jogador.getUsername());

List<Pergunta> lstPergunta = new ArrayList<Pergunta>();
try{
lstPergunta = perguntaService.getRandom(quantPerguntas, nivel);
jogo.setPerguntas(lstPergunta);
}
catch(Exception ex){
throw ex;
}

this.save(jogo);
return jogo;
}

public void save(Jogo t) {
jogoRepository.save(t);

}

public List<Jogo> getAll() {
return jogoRepository.findAll();
}

public void delete(Long id) {
jogoRepository.delete(id);

}

public Jogo get(Long id){
Jogo jogo = jogoRepository.findOne(id);
return jogo;
}

public long count() {
return jogoRepository.count();
}


}