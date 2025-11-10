package com.ipartek.formacion.ipartube.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartube.entidades.projections.VideoListadoProjection;
import com.ipartek.formacion.ipartube.repositorios.VideoRepository;

@RestController
@RequestMapping("/api/v2/videos")
public class VideoRestController {
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public Iterable<VideoListadoProjection> get() {
		return videoRepository.obtenerTodos();
	}
}
