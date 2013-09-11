package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.LogConfig;

@Repository
@Transactional
public interface LogConfigRepository extends JpaRepository<LogConfig, Long> {

}
