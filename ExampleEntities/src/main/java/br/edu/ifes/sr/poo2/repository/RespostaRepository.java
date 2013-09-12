package br.edu.ifes.sr.poo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Resposta;;

@Repository
@Transactional
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

Resposta findByValor (String valor);

List<Resposta> findAllByPergunta (long perguntaId);

int getPontuacao(List<Resposta> lstResposta);

}
