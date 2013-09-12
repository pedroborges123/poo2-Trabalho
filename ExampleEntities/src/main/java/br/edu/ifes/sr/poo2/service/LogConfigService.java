package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.LogConfig;
import br.edu.ifes.sr.poo2.repository.LogConfigRepository;

public class LogConfigService implements CRUDService<Long, LogConfig>{

@Autowired
LogConfigRepository logConfigRepository;


public LogConfig cadastrar (Long servicoId, Long gerenteId) throws Exception
{
	LogConfig	logConfig = new LogConfig();
	List<LogConfig> listlogConfig = this.getAll();
	if(listlogConfig.size() == 0){
		logConfig.setGerenteId(0);
		logConfig.setServicoId(0);
		logConfig.setGerenteId(gerenteId);
		logConfig.setServicoId(servicoId);
	}
	else{
		
		logConfig = listlogConfig.get(0);
		logConfig.setGerenteId(gerenteId);
		logConfig.setServicoId(servicoId);
	}
	
	this.save(logConfig);
	return logConfig;
}

public void save(LogConfig t) {
logConfigRepository.save(t);

}

public List<LogConfig> getAll() {
return logConfigRepository.findAll();
}

public void delete(Long id) {
logConfigRepository.delete(id);

}

public LogConfig get(Long id){
LogConfig logConfig = logConfigRepository.findOne(id);
return logConfig;
}

public long count() {
return logConfigRepository.count();
}


}