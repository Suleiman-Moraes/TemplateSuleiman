package br.com.moraes.templatesuleiman.api.security.model;

import java.util.Collection;
import java.util.TreeSet;

import br.com.moraes.templatesuleiman.api.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentUser {
	
	private String token;
	private Usuario user;
	private Collection<String> roles;
	
	public CurrentUser(String token, Usuario user) {
		roles = new TreeSet<>();
		user.getPerfis().forEach(perfil -> perfil.getPermissoes().forEach(per -> roles.add(per.getNome())));
		this.token = token;
		this.user = user;
	}
}
