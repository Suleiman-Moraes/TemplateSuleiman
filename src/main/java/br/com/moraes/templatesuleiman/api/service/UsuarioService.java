package br.com.moraes.templatesuleiman.api.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.moraes.templatesuleiman.api.model.Usuario;
import br.com.moraes.templatesuleiman.api.util.CRUDPadraoService;

@Component
public interface UsuarioService extends CRUDPadraoService<Usuario> {

	List<String> buscarPermissoesPassandoUsuario(Usuario usuario);
}