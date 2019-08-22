package br.com.moraes.templatesuleiman.api.service;

import org.springframework.stereotype.Component;

import br.com.moraes.templatesuleiman.api.model.Pessoa;
import br.com.moraes.templatesuleiman.api.util.CRUDPadraoService;

@Component
public interface PessoaService extends CRUDPadraoService<Pessoa>{}
