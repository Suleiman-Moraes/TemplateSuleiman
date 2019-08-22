package br.com.moraes.templatesuleiman.api.service.implementacao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.moraes.templatesuleiman.api.model.Usuario;
import br.com.moraes.templatesuleiman.api.repository.hql.GenericDAO;
import br.com.moraes.templatesuleiman.api.repository.jpa.UsuarioDAO;
import br.com.moraes.templatesuleiman.api.service.UsuarioService;
import lombok.Getter;

@Getter
@Service
public class UsuarioServiceIMPL implements UsuarioService{

	private static final Log logger = LogFactory.getLog(UsuarioService.class);

	@Autowired
	private UsuarioDAO persistencia = null;
	
	@Autowired
	private GenericDAO genericDAO;
	
	@Override
	public Usuario findByField(String field, Object value) {
		try {
			Usuario objeto = genericDAO.findByField(Usuario.class, field, value);
			return objeto;
		} catch (Exception e) {
			logger.warn("findByField " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Boolean existsByField(String field, Object value) {
		try {
			Boolean objeto = genericDAO.existsByField(Usuario.class, field, value);
			return objeto;
		} catch (Exception e) {
			logger.warn("findByField " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public List<String> buscarPermissoesPassandoUsuario(Usuario usuario) {
		try {
			return genericDAO.getEntityManager().createQuery(
					"SELECT DISTINCT per.nome FROM Usuario u INNER JOIN u.perfis p INNER JOIN p.permissoes per WHERE u = :usuario",
					String.class).setParameter("usuario", usuario).getResultList();
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}

	@Override
	public Log getLogger() {
		return logger;
	}
}
