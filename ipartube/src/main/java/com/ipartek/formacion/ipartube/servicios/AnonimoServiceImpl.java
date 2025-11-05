package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.UsuarioRepository;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

import jakarta.validation.Valid;

@Service
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Iterable<Video> listadoVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Video detalleVideo(Long id) {
		return videoRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario registro(@Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
