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

import br.edu.ifes.sr.poo2.model.Resposta;
import br.edu.ifes.sr.poo2.service.RespostaService;

@Controller
@RequestMapping("/resposta")
public class RespostaController extends AbstractController {

	@Autowired
	private RespostaService service;

	// Retornando a quantidade de Resposta
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

	// Adicionando uma Resposta
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> add(@RequestBody String valor,
			Boolean isRight, Long perguntaId) {
		try {
			Resposta resposta = new Resposta();
			resposta = service.cadastrar(valor, isRight, perguntaId);

			return new ResponseEntity<String>(resposta.getId().toString(),
					HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Retornando uma Resposta;
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resposta> get(@PathVariable Long id) {
		try {

			Resposta resposta = service.get(id);

			return new ResponseEntity<Resposta>(resposta, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<Resposta>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}