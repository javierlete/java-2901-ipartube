'use strict';

const URL = '/api/v1';
const URL2 = '/api/v2';

let listado, row;

window.addEventListener('DOMContentLoaded', async () => {
	listado = document.querySelector('#listado');
	row = listado.querySelector('div');
	
	await pedirVideosConUsuarios();
});

async function pedirVideosConUsuarios() {
	const respuesta = await fetch(`${URL2}/videos`);
	const videos = await respuesta.json();
	
	videos.forEach(async (v) => {
		agregarCol(v, { id: v.usuarioId, nombre: v.usuarioNombre });
	});

}

async function pedirVideosYUsuarios() {
	const respuesta = await fetch(`${URL}/videos`);
	const videos = await respuesta.json();

	videos._embedded.videos.forEach(async (v) => {
		const respuesta = await fetch(v._links.usuario.href);
		const usuario = await respuesta.json();

		agregarCol(v, usuario);
	});
}

function agregarCol(v, usuario) {
	const col = document.createElement('div');
	col.className = 'col';
	col.innerHTML = `
		<div class="card h-100">
			<iframe src="${v.url}" class="card-img-top"></iframe>
			<div class="card-body">
				<h5 class="card-title">${v.titulo}</h5>
				<p class="card-text">${v.descripcion}</p>
				<p class="card-text">
					<a class="btn btn-primary w-100" href="video.html">Ver video</a>
				</p>

			</div>
			<div class="card-footer text-end">
				<small class="text-body-secondary"><a href="canal.html">${usuario.nombre}</a></small>
			</div>
		</div>
	`;

	row.appendChild(col);
}
