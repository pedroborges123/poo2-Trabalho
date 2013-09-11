package br.sr.edu.ifes.leds.controller;

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
import br.edu.ifes.sr.poo2.service.JogadorService;;

@Controller
@RequestMapping("/jogador")
public class JogadorController extends AbstractController {

	@Autowired
	private JogadorService service;

	// Retornando a quantidade de jogadores
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

	// Adicionando um jogador
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody String email, String senha, String username) {
		try {
				Jogador jogador = new Jogador(); 
				jogador = service.cadastrar(email, senha, username);
				
				return new ResponseEntity<String>(jogador.getId().toString(),
						HttpStatus.OK);
			

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

		
	// Retornando um jogador;
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Jogador> get(@PathVariable Long id) {
		try {

			Jogador jogador = service.get(id);

			return new ResponseEntity<Jogador>(jogador, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Jogador>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
