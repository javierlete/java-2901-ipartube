package com.ipartek.formacion.ipartube.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.repositorios.ComentarioRepository;
import com.ipartek.formacion.ipartube.repositorios.UsuarioRepository;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

import jakarta.validation.Valid;

@Service
public class AnonimoServiceImpl implements AnonimoService {

	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Override
	public Iterable<Video> listadoVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Iterable<Video> listadoVideos(Long idUsuario) {
		return videoRepository.findByUsuarioId(idUsuario);
	}

	@Override
	public Video detalleVideo(Long id) {
		return videoRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario usuarioPorId(Long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario registro(@Valid Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

	@Override
	public Page<Comentario> comentariosVideo(Long idVideo) {
		return comentariosVideo(idVideo, 1);
	}

	@Override
	public Page<Comentario> comentariosVideo(Long idVideo, Integer numeroComentarios) {
		return comentarioRepository.findByVideoId(idVideo, PageRequest.of(0, numeroComentarios, Direction.DESC, "fechaHora"));
	}

}
