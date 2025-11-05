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

}
