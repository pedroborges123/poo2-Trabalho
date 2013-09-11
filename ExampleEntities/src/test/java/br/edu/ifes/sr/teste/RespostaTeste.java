package br.edu.ifes.sr.teste;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.repository.RespostaRepository;;


public class RespostaTeste extends AbstractTest {
	
	@Autowired
	RespostaRepository respostaRepository;
	
	@Test
	public void salvar(){
		Resposta resposta = new Resposta();
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);
		
		respostaRepository.save(resposta);
		Assert.assertNotSame(0, resposta.getId());
		System.out.println(resposta.getId());
	}
	
	@Test
	public void find(){
		Resposta resposta = new Resposta();
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);

		respostaRepository.save(resposta);
		
		Resposta respostaTeste = respostaRepository.findByValor("sim");
		
		Assert.assertNotNull(respostaTeste);
		
	}


}
