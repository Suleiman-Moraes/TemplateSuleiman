package br.com.moraes.templatesuleiman.api.security.jwt;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.moraes.templatesuleiman.api.model.Usuario;
import br.com.moraes.templatesuleiman.api.service.UsuarioService;

public class JwtUserFactory {
	private JwtUserFactory() {}
	
	public static JwtUser create(Usuario objeto, UsuarioService usuarioService) {
		return new JwtUser(objeto.getId() + "", objeto.getLogin(), objeto.getSenha(), mapToGrantedAthorities(objeto, usuarioService));
	}
	
	private static List<GrantedAuthority> mapToGrantedAthorities(Usuario usuario, UsuarioService usuarioService) {
		List<String> permissoes = usuarioService.buscarPermissoesPassandoUsuario(usuario);
		List<GrantedAuthority> listaGrantedAuthority = new LinkedList<>();
		for(String permissao : permissoes) {
			listaGrantedAuthority.add(new SimpleGrantedAuthority(permissao));
		}
		return listaGrantedAuthority;
	}
}
