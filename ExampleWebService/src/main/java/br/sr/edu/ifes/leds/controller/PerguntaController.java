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

import br.edu.ifes.sr.poo2.model.Nivel;
import br.edu.ifes.sr.poo2.model.Pergunta;
import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.service.PerguntaService;
import br.edu.ifes.sr.poo2.service.RespostaService;

@Controller
@RequestMapping("/pergunta")
public class PerguntaController extends AbstractController {
	
	@Autowired
	private PerguntaService service;
	
	@Autowired
	private RespostaService respostaService;
	
	// Retornando a quantidade de Perguntas
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

		// Adicionando uma Pergunta
		@RequestMapping(value = "/add", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<Long> add(@RequestBody String valor, Nivel nivel) {
			try {
					Pergunta pergunta = new Pergunta(); 
					pergunta = service.cadastrar(valor,nivel);
					
					return new ResponseEntity<Long>(pergunta.getId(),
							HttpStatus.OK);
				

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Long>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		// Adicionando Respostas a Pergunta
		@RequestMapping(value = "/addResposta", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<String> addResposta(@RequestBody Long perguntaId) {
			try {
					Pergunta pergunta = new Pergunta(); 
					pergunta = service.get(perguntaId);
				
					List<Resposta> lstResposta = respostaService.findAllByPergunta(perguntaId);
					pergunta.setRespostas(lstResposta);
							
					return new ResponseEntity<String>(pergunta.getId().toString(),
							HttpStatus.OK);
				

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		
		// Retornando uma Pergunta;
		@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
		@ResponseBody
		public ResponseEntity<Pergunta> get(@PathVariable Long id) {
			try {

				Pergunta pergunta = service.get(id);

				return new ResponseEntity<Pergunta>(pergunta, HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<Pergunta>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
}
