package com.ipartek.formacion.ipartube.servicios;

import org.springframework.data.domain.Page;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

import jakarta.validation.Valid;

public interface AnonimoService {
	Iterable<Video> listadoVideos();
	Iterable<Video> listadoVideos(Long idUsuario);
	Video detalleVideo(Long id);
    Usuario registro(@Valid Usuario usuario);
	Usuario usuarioPorId(Long idUsuario);
	
	Page<Comentario> comentariosVideo(Long idVideo);
	Page<Comentario> comentariosVideo(Long idVideo, Integer numeroComentarios);

}
