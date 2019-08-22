package br.com.moraes.templatesuleiman.api.service.implementacao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moraes.templatesuleiman.api.model.Pessoa;
import br.com.moraes.templatesuleiman.api.repository.hql.GenericDAO;
import br.com.moraes.templatesuleiman.api.repository.jpa.PessoaDAO;
import br.com.moraes.templatesuleiman.api.service.PessoaService;
import lombok.Getter;

@Getter
@Service
public class PessoaServiceIMPL implements PessoaService{

	private static final Log logger = LogFactory.getLog(PessoaService.class);

	@Autowired
	private PessoaDAO persistencia = null;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	public Pessoa findByField(String field, Object value) {
		try {
			Pessoa objeto = genericDAO.findByField(Pessoa.class, field, value);
			return objeto;
		} catch (Exception e) {
			logger.warn("findByField " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Boolean existsByField(String field, Object value) {
		try {
			Boolean objeto = genericDAO.existsByField(Pessoa.class, field, value);
			return objeto;
		} catch (Exception e) {
			logger.warn("findByField " + e.getMessage());
			return null;
		}
	}

	@Override
	public Log getLogger() {
		return logger;
	}
}
