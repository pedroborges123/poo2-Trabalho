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

import br.edu.ifes.sr.poo2.model.LogConfig;
import br.edu.ifes.sr.poo2.service.LogConfigService;

@Controller
@RequestMapping("/LogConfig")
public class LogConfigController extends AbstractController {

@Autowired
private LogConfigService service;


// Retornando um LogConfig;
@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<LogConfig> get(@PathVariable Long id) {
try {

LogConfig logConfig = service.get(id);

return new ResponseEntity<LogConfig>(logConfig, HttpStatus.OK);

} catch (Exception e) {
return new ResponseEntity<LogConfig>(HttpStatus.INTERNAL_SERVER_ERROR);
}
}


// Adicionando um LogConfig
@RequestMapping(value = "/add", method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<String> add(@RequestBody LogConfig logConfig ) {
try {
LogConfig logConfigController = new LogConfig();
logConfigController = service.cadastrar(logConfig.getGerenteId(), logConfig.getServicoId());

return new ResponseEntity<String>(logConfigController.getId().toString(),
HttpStatus.OK);


} catch (Exception e) {
e.printStackTrace();
return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
}

}