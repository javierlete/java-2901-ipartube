package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

import jakarta.validation.Valid;

@Service
public class AutenticadoServiceImpl implements AutenticadoService {

	@Autowired
	private VideoRepository videoRepository;
	
	@Override
	public Video altaVideo(@Valid Video video) {
		return videoRepository.save(video);
	}

	@Override
	public void bajaVideo(Long idVideo, Long idUsuario) {
		var oVideo = videoRepository.findById(idVideo);
		
		if(oVideo.isEmpty()) {
			throw new ServicioException("No se ha encontrado el video a borrar");
		}
		
		var video = oVideo.get();
		
		if(video.getUsuario().getId() != idUsuario) {
			throw new ServicioException("El usuario no es propietario del video que se quiere borrar");
		}
		
		videoRepository.deleteById(idVideo);
	}

}
