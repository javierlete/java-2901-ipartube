package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

import jakarta.validation.Valid;

public interface AnonimoService {
	Iterable<Video> listadoVideos();
	Iterable<Video> listadoVideos(Long idUsuario);
	Video detalleVideo(Long id);
    Usuario registro(@Valid Usuario usuario);
	Usuario usuarioPorId(Long idUsuario);
}
