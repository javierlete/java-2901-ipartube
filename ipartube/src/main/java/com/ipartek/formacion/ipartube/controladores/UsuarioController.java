package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.entidades.Video;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;
import com.ipartek.formacion.ipartube.servicios.AutenticadoService;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("usuario")
public class UsuarioController {
	@Autowired
	private AutenticadoService autenticadoService;

	@Autowired
	private AnonimoService anonimoService;

	@GetMapping("nuevo-video")
	public String nuevoVideo(Video video) {
		return "usuario/nuevo-video";
	}

	@GetMapping("editar-video")
	public String editarVideo(Long id, Model modelo) {
		modelo.addAttribute("video", anonimoService.detalleVideo(id));

		return "usuario/nuevo-video";
	}

	@PostMapping("nuevo-video")
	public String nuevoVideoPost(@Valid Video video, BindingResult bindingResult,
			@AuthenticationPrincipal Usuario usuario) {
		if (bindingResult.hasErrors()) {
			log.warning(bindingResult.toString());

			return "usuario/nuevo-video";
		}

		video.setUsuario(usuario);

		if (video.getId() == null) {
			autenticadoService.altaVideo(video);
		} else {
			autenticadoService.modificarVideo(video);
		}

		return "redirect:/";
	}

	@GetMapping("borrar-video")
	public String borrar(Long id, @AuthenticationPrincipal Usuario usuario) {
		autenticadoService.bajaVideo(id, usuario.getId());

		return "redirect:/canal?id=" + usuario.getId();
	}
}
