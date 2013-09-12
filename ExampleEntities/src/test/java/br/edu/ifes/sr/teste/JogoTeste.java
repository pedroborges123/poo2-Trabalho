package br.edu.ifes.sr.teste;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogo;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.repository.RespostaRepository;
import br.edu.ifes.sr.poo2.service.JogoService;
import br.edu.ifes.sr.poo2.service.PerguntaService;


public class JogoTeste extends AbstractTest {

	@Autowired
	JogoService jogoService;

	@Autowired
	PerguntaService perguntaService;

	@Autowired
	RespostaRepository respostaRepository;

	@Test
	public void salvar(){	
		Pergunta pergunta = new Pergunta();

		pergunta.setValor("PerguntaTeste");

		perguntaService.save(pergunta);

		Resposta resposta = new Resposta();
		resposta.setValor("RespostaTeste");
		respostaRepository.save(resposta);

		pergunta.addResposta(resposta);
		perguntaService.save(pergunta);


		List<Pergunta> lstPergunta = perguntaService.getAll();

		Jogo jogo =  new Jogo();
		jogo.setPerguntas(lstPergunta);
		jogo.setUsername("Pedro");

		jogoService.save(jogo);

		Assert.assertNotSame(0,jogo.getId());

		System.out.println(jogo.getId());
	}


}