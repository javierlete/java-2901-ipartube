package com.ipartek.formacion.ipartube.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.formacion.ipartube.entidades.Comentario;
import com.ipartek.formacion.ipartube.entidades.Usuario;
import com.ipartek.formacion.ipartube.servicios.AnonimoService;

import jakarta.validation.Valid;

@Controller
public class IndexController {
	@Autowired
	private AnonimoService anonimoService;

	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("videos", anonimoService.listadoVideos());

		return "listado";
	}

	@GetMapping("canal")
	public String canal(@RequestParam("id") Long idUsuario, Model modelo) {
		modelo.addAttribute("videos", anonimoService.listadoVideos(idUsuario));
		modelo.addAttribute("usuario", anonimoService.usuarioPorId(idUsuario));

		return "canal";
	}

	@GetMapping("video")
	public String video(Long id, Integer numeroComentarios, Model modelo) {
		Page<Comentario> comentariosVideo;

		if (numeroComentarios != null) {
			comentariosVideo = anonimoService.comentariosVideo(id, numeroComentarios);
		} else {
			comentariosVideo = anonimoService.comentariosVideo(id);
		}

		modelo.addAttribute("video", anonimoService.detalleVideo(id));
		modelo.addAttribute("comentarios", comentariosVideo);
		modelo.addAttribute("primerComentarioId", comentariosVideo.getContent().getLast().getId());

		return "video";
	}

	@GetMapping("registro")
	public String registro(Usuario usuario) {
		return "registro";
	}

	@PostMapping("registro")
	public String registroPost(@Valid Usuario usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "registro";
		}

		anonimoService.registro(usuario);

		return "redirect:/";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}
}
