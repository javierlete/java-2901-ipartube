package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;

import jakarta.validation.Valid;

public interface AnonimoService {
	Iterable<Video> listadoVideos();
	Video detalleVideo(Long id);
    Usuario registro(@Valid Usuario usuario);
}
