package br.edu.ifes.sr.poo2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.repository.PerguntaRepository;
import br.edu.ifes.sr.poo2.repository.RespostaRepository;;

@Service
public class RespostaService implements CRUDService<Long, Resposta> {
	
	@Autowired
	RespostaRepository respostaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	public boolean isResposta (String valor)
	{
		
		
		Resposta resposta = respostaRepository.findByValor(valor);
		if (resposta == null) return false;
		else return true;
	}
	

	public Resposta cadastrar (String valor, Boolean isRight, Long perguntaId) throws Exception
	{
		
		if (!isResposta(valor)){
			
			Resposta resposta = new Resposta();
			resposta.setValor(valor);
			resposta.setRespostacorreta(isRight);
			resposta.setPerguntaId(perguntaId);
		
			save(resposta);	
			return resposta;
		}
		else{
			throw new Exception("Resposta já cadastrada");
		}
	}
	
	public void save(Resposta t) {
		respostaRepository.save(t);
		
	}

	public List<Resposta> getAll() {
		return respostaRepository.findAll();
	}

	public void delete(Long id) {
		respostaRepository.delete(id);
		
	}

	public Resposta get(Long id) {
		return respostaRepository.findOne(id);
	}

	public long count() {
		return respostaRepository.count();
	}
	
	public Resposta findByValor(String valor)
	{
		return respostaRepository.findByValor(valor);
	}
	
	public List<Resposta> findAllByPergunta(long perguntaId)
	{
		Resposta resposta = new Resposta();
		List<Resposta> lstRespota = this.getAll();
		ArrayList<Resposta> lstRespostaByPerguntaId = new ArrayList<Resposta>();
		
		for(int i = 0; i < lstRespota.size(); i++){
			resposta = lstRespota.get(i);
			if(resposta.getPerguntaId() == perguntaId){
				lstRespostaByPerguntaId.add(resposta);
			}
		}
		
		return lstRespostaByPerguntaId;
	}
	
	public int getPontuacao(List<Resposta> lstResposta){
		
		int potuacao = 0;
		Resposta reposta = new Resposta();
		Pergunta pergunta = new Pergunta();
		
		for(int i = 0; i < lstResposta.size(); i++){
			reposta = lstResposta.get(i);
			if(reposta.getRespostacorreta()){
				pergunta = perguntaRepository.findOne(reposta.getPerguntaId());
				potuacao += (pergunta.getNivel()).getCode();
			}
		}
		
		return potuacao;
	}


}
