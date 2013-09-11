package br.edu.ifes.sr.teste;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;




import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
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
		Resposta resposta = new Resposta();
		ArrayList<Resposta> lstResposta = new ArrayList<Resposta>();
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);
		respostaRepository.save(resposta);
		lstResposta.add(resposta);
		
		pergunta.setValor("Isso é um teste?");
		pergunta.setRespostas(lstResposta);
		pergunta.setNivel(Nivel.Facil);
		
		perguntaRepository.save(pergunta);
		Assert.assertNotSame(0, pergunta.getId());
		System.out.println(pergunta.getId());
	}
	
	@Test
	public void find(){
		
		Pergunta pergunta = new Pergunta();
		Resposta resposta = new Resposta();
		ArrayList<Resposta> lstResposta = new ArrayList<Resposta>();
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);
		lstResposta.add(resposta);
		
		pergunta.setValor("Isso é um teste?");
		pergunta.setRespostas(lstResposta);
		pergunta.setNivel(Nivel.Facil);
		perguntaRepository.save(pergunta);
		
		Pergunta perguntaTeste = perguntaRepository.findByValor("Isso é um teste?");
		
		Assert.assertNotNull(perguntaTeste);
		
	}

}
