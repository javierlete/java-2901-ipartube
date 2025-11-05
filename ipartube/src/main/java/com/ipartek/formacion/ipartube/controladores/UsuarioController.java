package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AutenticadoService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private AutenticadoService autenticadoService;

	@GetMapping("nuevo-video")
	public String nuevoVideo(Video video) {
		return "usuario/nuevo-video";
	}

	@PostMapping("nuevo-video")
	public String nuevoVideoPost(@Valid Video video, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.warning(bindingResult.toString());
			
			return "usuario/nuevo-video";
		}

		autenticadoService.altaVideo(video);

		return "redirect:/";
	}
}
