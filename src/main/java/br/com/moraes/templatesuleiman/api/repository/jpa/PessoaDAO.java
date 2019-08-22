package br.com.moraes.templatesuleiman.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.moraes.templatesuleiman.api.model.Pessoa;

public interface PessoaDAO extends JpaRepository<Pessoa, Long>{

}
