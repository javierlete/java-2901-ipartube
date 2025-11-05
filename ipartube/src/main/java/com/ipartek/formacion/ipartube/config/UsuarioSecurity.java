package com.ipartek.formacion.ipartube.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ipartek.formacion.ipartube.entidades.Usuario;

public class UsuarioSecurity extends Usuario implements UserDetails {

	private static final long serialVersionUID = -924664933086202559L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(() -> "ROLE_USUARIO");
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

}
