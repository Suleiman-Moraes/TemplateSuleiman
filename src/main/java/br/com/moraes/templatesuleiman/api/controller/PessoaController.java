package br.com.moraes.templatesuleiman.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.moraes.templatesuleiman.api.controller.abstracts.ManterControllerBeanBasic;
import br.com.moraes.templatesuleiman.api.model.Pessoa;
import br.com.moraes.templatesuleiman.api.service.PessoaService;
import lombok.Getter;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController extends ManterControllerBeanBasic<Pessoa>{

	@Getter
	@Autowired
	private PessoaService service;
}
