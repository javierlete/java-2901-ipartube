package com.ipartek.formacion.ipartube.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.entidades.projections.VideoListadoProjection;

public interface VideoRepository extends CrudRepository<Video, Long> {

	Iterable<Video> findByUsuarioId(Long idUsuario);
	
	@Query("from Video v join v.usuario u")
	Iterable<VideoListadoProjection> obtenerTodos();
}
