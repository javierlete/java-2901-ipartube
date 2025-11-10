package com.ipartek.formacion.ipartube.entidades.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.ipartek.formacion.ipartube.entidades.Video;

@Projection(types = { Video.class })
public interface VideoListadoProjection {
	Long getId();
	String getTitulo();
	String getUrl();
	
	@Value("#{target.usuario.id}")
	Long getUsuarioId();
	
	@Value("#{target.usuario.nombre}")
	String getUsuarioNombre();
}
