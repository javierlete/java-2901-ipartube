package com.ipartek.formacion.ipartube.servicios;

import com.ipartek.formacion.ipartube.entidades.Video;

import jakarta.validation.Valid;

public interface AutenticadoService {

	Video altaVideo(@Valid Video video);

	void bajaVideo(Long idVideo, Long idUsuario);

}
