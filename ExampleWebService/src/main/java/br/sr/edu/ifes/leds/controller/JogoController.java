package br.sr.edu.ifes.leds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifes.sr.poo2.model.Jogador;
import br.edu.ifes.sr.poo2.model.Jogo;
import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.service.JogoService;
import br.edu.ifes.sr.poo2.service.RespostaService;
import br.edu.ifes.sr.poo2.service.ScoreService;

@Controller
@RequestMapping("/jogo")
public class JogoController extends AbstractController {
	
	
	@Autowired
	private JogoService service;
	
	@Autowired
	private ScoreService scoreService;
	
	@Autowired
	private RespostaService respostaService;
	
	
	// Retornando a quantidade de Jogos
			@RequestMapping(value = "/count", method = RequestMethod.GET)
			@ResponseBody
			public ResponseEntity<Long> count() {

				try {
					
					long count = service.count();
				
					return new ResponseEntity<Long>(count, HttpStatus.OK);

				} catch (Exception e) {
					return new ResponseEntity<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
				}

			}

			// Adicionando um Jogo
			@RequestMapping(value = "/add", method = RequestMethod.POST)
			@ResponseBody
			public ResponseEntity<String> add(@RequestBody Jogador jogador, Nivel nivel) {
				try {
					
						Jogo jogo = new Jogo(); 
						jogo = service.cadastrar(jogador,nivel, 5);
						
						return new ResponseEntity<String>(jogo.getId().toString(),
								HttpStatus.OK);
					

				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

			//	Finalizando um jogo
			@RequestMapping(value = "/end", method = RequestMethod.POST)
			@ResponseBody
			public ResponseEntity<String> end(@RequestBody Jogo jogo, Jogador jogador, List<Resposta> lstResposta) {
				try {
					
						int pontuacao = respostaService.getPontuacao(lstResposta);
						 
						scoreService.cadastrar(jogo.getId(), jogador.getId(),pontuacao);
						
						return new ResponseEntity<String>(Integer.toString(pontuacao),
								HttpStatus.OK);
					

				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			// Retornando um Jogo;
			@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
			@ResponseBody
			public ResponseEntity<Jogo> get(@PathVariable Long id) {
				try {

					Jogo jogo = service.get(id);

					return new ResponseEntity<Jogo>(jogo, HttpStatus.OK);

				} catch (Exception e) {
					return new ResponseEntity<Jogo>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

}
