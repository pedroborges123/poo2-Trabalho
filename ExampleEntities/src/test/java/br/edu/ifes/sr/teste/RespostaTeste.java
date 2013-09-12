package br.edu.ifes.sr.teste;

import java.util.List;

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
		resposta.setValor("respostaTeste");
		resposta.setRespostacorreta(false);

		respostaRepository.save(resposta);

		Assert.assertNotNull(respostaRepository.findOne(resposta.getId()));

	}

	@Test
	public void find(){
		
		Resposta resposta = new Resposta();
		resposta.setValor("respostaTeste");
		resposta.setRespostacorreta(false);

		respostaRepository.save(resposta);

		List<Resposta> lstResposta = respostaRepository.findAll();

		Assert.assertEquals(1, lstResposta.size());
		Assert.assertEquals(lstResposta.get(0).getValor(), "respostaTeste");

	}


}