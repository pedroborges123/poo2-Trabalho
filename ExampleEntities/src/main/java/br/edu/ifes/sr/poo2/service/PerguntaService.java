package br.edu.ifes.sr.poo2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.repository.PerguntaRepository;

@Service
public class PerguntaService implements CRUDService<Long, Pergunta> {
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	public boolean isPergunta (String valor)
	{
		Pergunta pergunta = perguntaRepository.findByValor(valor);
		if (pergunta == null) return false;
		else return true;
	}
	

	public Pergunta cadastrar (String valor, Nivel nivel,List<Resposta> lstResposta) throws Exception
	{
		
		if (!isPergunta(valor)){
			
			Pergunta pergunta = new Pergunta();
			pergunta.setValor(valor);
			pergunta.setNivel(nivel);
		
			save(pergunta);	
			return pergunta;
		}
		else{
			throw new Exception("Pergunta já cadastrada");
		}
	}

	public void save(Pergunta t) {
		perguntaRepository.save(t);
		
	}

	public List<Pergunta> getAll() {
		return perguntaRepository.findAll();
	}

	public void delete(Long id) {
		perguntaRepository.delete(id);
		
	}

	public Pergunta get(Long id){
		Pergunta pergunta = perguntaRepository.findOne(id);
		return pergunta;
	}

	public long count() {
		return perguntaRepository.count();
	}
	
	public long countByNivel(Nivel nivel){
		return perguntaRepository.countByNivel(nivel);
	}
	
	
	public Pergunta findByValor(String valor)
	{
		return perguntaRepository.findByValor(valor);
	}
	
	public List<Pergunta> getRandom(int quantPerguntas, Nivel nivel) throws Exception{
		
		ArrayList<Pergunta> lstPergunta = new ArrayList<Pergunta>();
		long quantidadePerguntas = this.countByNivel(nivel);
		List<Pergunta> lstPerguntas = this.getAllByNivel(nivel);
		Random geradorId = new Random();
		
		if(quantPerguntas <= quantidadePerguntas){
			
			long listCount = quantidadePerguntas;
			
			for(int i = 0; i < quantPerguntas; i++){
				Pergunta perguntaRandom = new Pergunta();
			 
				long randonId = geradorId.nextInt((int)listCount);
				perguntaRandom = lstPerguntas.get((int)randonId);
				lstPergunta.add(perguntaRandom);
				lstPerguntas.remove((int)randonId);
				listCount--;
		
			}
			
			return lstPergunta;
		}
		else{
			throw new Exception("Numero de perguntas inadequado");
		}
		
	}
	
	public List<Pergunta> getAllByNivel(Nivel nivel){
		return perguntaRepository.getAllByNivel(nivel);
	}
}
