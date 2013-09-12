package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Score;
import br.edu.ifes.sr.poo2.repository.ScoreRepository;


public class ScoreService implements CRUDService<Long, Score>{

@Autowired
ScoreRepository scoreRepository;

public void cadastrar (Long jogoId, Long jogadorId, int pontuacao) throws Exception
{	
Score score = new Score();
score.setJogoId(jogoId);
score.setJogadorId(jogadorId);
score.setPontuacao(pontuacao);
this.save(score);
}

public void save(Score t) {
scoreRepository.save(t);

}

public List<Score> getAll() {
return scoreRepository.findAll();
}

public void delete(Long id) {
scoreRepository.delete(id);

}

public Score get(Long id){
Score score = scoreRepository.findOne(id);
return score;
}

public long count() {
return scoreRepository.count();
}

}