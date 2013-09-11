package br.edu.ifes.sr.teste;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Jogo;
import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.repository.JogadorRepository;
import br.edu.ifes.sr.poo2.repository.JogoRepository;
import br.edu.ifes.sr.poo2.repository.PerguntaRepository;
import br.edu.ifes.sr.poo2.repository.RespostaRepository;


public class JogoTeste extends AbstractTest {
	
	@Autowired
	JogoRepository jogoRepository;
	
	@Autowired
	JogadorRepository jogadorRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	RespostaRepository respostaRepository;
	
	@Test
	public void salvar(){
		Jogo jogo = new Jogo();
		Pergunta pergunta = new Pergunta();
		Resposta resposta = new Resposta();
		ArrayList<Resposta> lstResposta = new ArrayList<Resposta>();
		ArrayList<Pergunta> listPerguntas = new ArrayList<Pergunta>();
		
		Jogador jogador = new Jogador();
		jogador.setEmail("Teste@hotmail.com");
		jogador.setSenha("1234");
		jogador.setUsername("testeImplemt");
		jogadorRepository.save(jogador);
		
		jogo.setPlayer(jogador);
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);
		respostaRepository.save(resposta);
		lstResposta.add(resposta);
		
		pergunta.setValor("Isso é um teste?");
		pergunta.setRespostas(lstResposta);
		pergunta.setNivel(Nivel.Facil);
		
		perguntaRepository.save(pergunta);
		listPerguntas.add(pergunta);
		jogo.setListPerguntas(listPerguntas);
		
		jogoRepository.save(jogo);
		Assert.assertNotSame(0, jogo.getId());
		System.out.println(jogo.getId());
	}
	
	@Test
	public void find(){
		Jogo jogo = new Jogo();
		Pergunta pergunta = new Pergunta();
		Resposta resposta = new Resposta();
		ArrayList<Resposta> lstResposta = new ArrayList<Resposta>();
		ArrayList<Pergunta> listPerguntas = new ArrayList<Pergunta>();
		
		Jogador jogador = new Jogador();
		jogador.setEmail("Teste@hotmail.com");
		jogador.setSenha("1234");
		jogador.setUsername("testeImplemt");
		jogadorRepository.save(jogador);
		
		jogo.setPlayer(jogador);
		
		resposta.setValor("sim");
		resposta.setRespostacorreta(true);
		respostaRepository.save(resposta);
		lstResposta.add(resposta);
		
		pergunta.setValor("Isso é um teste?");
		pergunta.setRespostas(lstResposta);
		pergunta.setNivel(Nivel.Facil);
		
		perguntaRepository.save(pergunta);
		listPerguntas.add(pergunta);
		jogo.setListPerguntas(listPerguntas);
		
		jogoRepository.save(jogo);
		
		Jogo jogoTeste = jogoRepository.findOne(jogo.getId());
		
		Assert.assertNotNull(jogoTeste);
		
	}
	
	

}
