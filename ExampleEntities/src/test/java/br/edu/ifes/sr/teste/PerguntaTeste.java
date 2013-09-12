package br.edu.ifes.sr.teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.repository.PerguntaRepository;
import br.edu.ifes.sr.poo2.repository.RespostaRepository;

public class PerguntaTeste extends AbstractTest {

	@Autowired
	PerguntaRepository perguntaRepository;

	@Autowired
	RespostaRepository respostaRepository;

	@Test
	public void salvar(){

		Pergunta pergunta = new Pergunta();
		pergunta.setValor("PerguntaTeste");
		pergunta.setNivel(Nivel.Facil);


		perguntaRepository.save(pergunta);

		Assert.assertNotSame(pergunta.getId(),0);
		Assert.assertNotNull(perguntaRepository.findOne(pergunta.getId()));
	}

	@Test
	public void find(){

		Pergunta pergunta = new Pergunta();
		pergunta.setValor("PerguntaTeste");
		pergunta.setNivel(Nivel.Facil);

		perguntaRepository.save(pergunta);

		List<Pergunta> lstPergunta = perguntaRepository.getAllByNivel(Nivel.Facil);

		Assert.assertNotNull(lstPergunta);

		Assert.assertEquals("PerguntaTeste", lstPergunta.get(0).getValor());
		Assert.assertSame(0, lstPergunta.size());

	}

}