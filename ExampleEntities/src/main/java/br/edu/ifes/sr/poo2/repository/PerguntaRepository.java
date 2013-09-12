package br.edu.ifes.sr.poo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;

@Repository
@Transactional
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

Pergunta findByValor (String valor);

Long countByNivel(Nivel nivel);

List<Pergunta> getRandom(long quantPerguntas);

List<Pergunta> getAllByNivel(Nivel nivel);
}
