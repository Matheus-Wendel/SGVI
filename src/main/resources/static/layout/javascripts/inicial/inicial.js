$(document).ready(function(){
	$('#accordion').show();
	$.ajax({
		type: 'GET',
		url: "/evento/getAllEventos",
		async: true,
		success: function(data){			
			data.forEach(function(evento){
				$('#accordion').append(`
                    <div class="card">
                        <div class="card-header">
                            <a style="color: #363636 !important;" class="card-link" data-toggle="collapse" href="#collapse` + evento.id + `">
                                Nome do Evento: ` + evento.nome + `
                            </a>
                        </div>
                        <div id="collapse` + evento.id + `" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DATA E HORÁRIO DE INÍCIO: </span>
                        				<span id="dataInicio` + evento.id + `"></span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DATA E HORÁRIO DE TÉRMINO: </span>
                                        <span id="dataTermino` + evento.id + `"></span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">LOCAL: </span>
                                        ` +
                                        	evento.endereco.rua + ` Nº ` + evento.endereco.numero + `, ` + evento.endereco.bairro + `, ` +
                                        			evento.endereco.cidade.nome + ` - ` +
                                        				evento.endereco.cidade.estado.uf
                                        + `
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DESCRIÇÃO: </span>
                                        ` + evento.descricao + `
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">VALORES DOS INGRESSOS: </span>
                                        <span id="ingressos` + evento.id + `"></span>
                                        <a class="btn btn-roxo" href="/compra/` + evento.id + `">COMPRE AGORA</a>
                                    </li>
                                </ul>
                            </div>
                        </div>			
                    </div>`
                )
                
                evento.setor.forEach(function(setor) {
                	$('#ingressos' + evento.id).append(setor.descricao + `: R$ ` + setor.valor + ` | ` )
                })
                //DATA E HORA DE INICIO
                let dataInicioFull = evento.horaInicio;
				
				let getDataHoraI = dataInicioFull.split("T");
				let dataInicio = getDataHoraI[0].split("-");
				let dataI = dataInicio[2] + "/" + dataInicio[1] + "/" + dataInicio[0];
				
				let horaInicio = getDataHoraI[1].split(":");
				let horaI = horaInicio[0] + ":" + horaInicio[1];
				
				let dataInicioEvento = dataI + " às " + horaI;
				
				$('#dataInicio' + evento.id).append(dataInicioEvento);
				
				//DATA E HORA DE TERMINO
				let dataTerminoFull = evento.horaTermino;
				
				let getDataHoraT = dataTerminoFull.split("T");
				let dataTermino = getDataHoraT[0].split("-");
				let dataT = dataTermino[2] + "/" + dataTermino[1] + "/" + dataTermino[0];
				
				let horaTermino = getDataHoraT[1].split(":");
				let horaT = horaTermino[0] + ":" + horaTermino[1];
				
				let dataTerminoEvento = dataT + " às " + horaT;
				
				$('#dataTermino' + evento.id).append(dataTerminoEvento);
                
			})
		}
	});
})

$(document).on('keypress', '#pesquisar-evento', function(e) {
    if(e.which == 13) {
        $('.search-btn').trigger('click');
    }
});

$('.search-btn').click(function(){
	$('#accordion').empty();
	let eventos = $('#pesquisar-evento').val();
	if(eventos == "" || eventos == null || eventos == undefined )
	{
			eventos = "todos";
	}
	
	$.ajax({
		type: 'GET',
		url: `/evento/getEventos/${eventos}`,
		async: true,
		success: function(data)
		{
			console.table(data);
			data.forEach(function(evento){
				$('#accordion').append(`
                    <div class="card">
                        <div class="card-header">
                            <a style="color: #363636 !important;" class="card-link" data-toggle="collapse" href="#collapse` + evento.id + `">
                                Nome do Evento: ` + evento.nome + `
                            </a>
                        </div>
                        <div id="collapse` + evento.id + `" class="collapse" data-parent="#accordion">
                            <div class="card-body">
                                <ul class="list-group">
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DATA E HORÁRIO DE INÍCIO: </span>
                                        <span id="dataInicio` + evento.id + `"></span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DATA E HORÁRIO DE TÉRMINO: </span>
                                        <span id="dataTermino` + evento.id + `"></span>
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">LOCAL: </span>
                                        ` +
                                        	evento.endereco.rua + ` Nº ` + evento.endereco.numero + `, ` + evento.endereco.bairro + `, ` +
                                        			evento.endereco.cidade.nome + ` - ` +
                                        				evento.endereco.cidade.estado.uf
                                        + `
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">DESCRIÇÃO: </span>
                                        ` + evento.descricao + `
                                    </li>
                                    <li class="list-group-item">
                                        <span class="badge badge-primary badge-pill">VALORES DOS INGRESSOS: </span>
                                        <span id="ingressos` + evento.id + `"></span>
                                        <a class="btn btn-roxo" href="/compra/` + evento.id + `">COMPRE AGORA</a>
                                    </li>
                                </ul>
                            </div>
                        </div>						
                    </div>`
                )
                
                //DATA E HORA DE INICIO
                let dataInicioFull = evento.horaInicio;
				
				let getDataHoraI = dataInicioFull.split("T");
				let dataInicio = getDataHoraI[0].split("-");
				let dataI = dataInicio[2] + "/" + dataInicio[1] + "/" + dataInicio[0];
				
				let horaInicio = getDataHoraI[1].split(":");
				let horaI = horaInicio[0] + ":" + horaInicio[1];
				
				let dataInicioEvento = dataI + " às " + horaI;
				
				$('#dataInicio' + evento.id).append(dataInicioEvento);
				
				//DATA E HORA DE TERMINO
				let dataTerminoFull = evento.horaTermino;
				
				let getDataHoraT = dataTerminoFull.split("T");
				let dataTermino = getDataHoraT[0].split("-");
				let dataT = dataTermino[2] + "/" + dataTermino[1] + "/" + dataTermino[0];
				
				let horaTermino = getDataHoraT[1].split(":");
				let horaT = horaTermino[0] + ":" + horaTermino[1];
				
				let dataTerminoEvento = dataT + " às " + horaT;
				
				$('#dataTermino' + evento.id).append(dataTerminoEvento);
                
            	evento.setor.forEach(function(setor) {
					$('#ingressos' + evento.id).append(setor.descricao + `: R$ ` + setor.valor + ` | ` )
				})
			})
		}
	})
	
	$('#accordion').show();
})