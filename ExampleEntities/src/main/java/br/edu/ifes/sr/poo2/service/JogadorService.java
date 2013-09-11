package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.repository.JogadorRepository;

@Service
public class JogadorService implements CRUDService<Long, Jogador> {
	
	@Autowired
	JogadorRepository jogadorRepository;
	
	
	public boolean isJogador (String username)
	{
		Jogador jogador = jogadorRepository.findByUsername(username);
		if (jogador == null) return false;
		else return true;
	}
	

	public Jogador cadastrar (String email, String senha, String username) throws Exception
	{	
		if(!isJogador(username)){	
			Jogador jogador = new Jogador();
			jogador.setEmail(email);
			jogador.setSenha(senha);
			jogador.setUsername(username);
			return jogador;
		}
		else{
			throw new Exception("Jogador já cadastrado");
		}
	}
	
	public void save(Jogador t) {
		jogadorRepository.save(t);
		
	}

	public List<Jogador> getAll() {
		return jogadorRepository.findAll();
	}

	public void delete(Long id) {
		jogadorRepository.delete(id);
		
	}

	public Jogador get(Long id){
		Jogador jogador = jogadorRepository.findOne(id);
		return jogador;
	}

	public long count() {
		return jogadorRepository.count();
	}
	
	public Jogador findByUsername(String username)
	{
		return jogadorRepository.findByUsername(username);
	}
	
	public Jogador findByEmail(String email)
	{
		return jogadorRepository.findByEmail(email);
	}

}