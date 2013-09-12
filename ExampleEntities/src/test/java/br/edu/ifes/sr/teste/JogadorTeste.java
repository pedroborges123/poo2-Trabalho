package br.edu.ifes.sr.teste;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.repository.JogadorRepository;

public class JogadorTeste extends AbstractTest{
	
	@Autowired
	JogadorRepository jogadorRepository;
	
	@Test
	public void salvar(){
		
		Jogador jogador = new Jogador();
		jogador.setEmail("Teste@hotmail.com");
		jogador.setSenha("1234");
		jogador.setUsername("testeImplemt");
		jogadorRepository.save(jogador);
		Assert.assertNotSame(0, jogador.getId());
	}
	
	@Test
	public void find(){
		
		Jogador jogador = new Jogador();
		jogador.setEmail("Teste@hotmail.com");
		jogador.setSenha("1234");
		jogador.setUsername("testeImplemt");
		jogadorRepository.save(jogador);
		
		Jogador jogadorTeste = jogadorRepository.findOne(jogador.getId());
		
		Assert.assertNotNull(jogadorTeste);
		
	}

}
