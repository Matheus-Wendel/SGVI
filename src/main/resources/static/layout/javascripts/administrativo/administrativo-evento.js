$(document).ready(function(){
	$.ajax({
		type: 'POST',
		url: "/livre/getAllEstados",
		async: true,
		success: function(data){	
			for(let aux = 0; aux < data.length; aux++){
				$('#estado-editar').append(`<option id="${data[aux].id}" value="${data[aux].id}">${data[aux].uf}</option>`)
				$('#estado').append(`<option id="${data[aux].id}" value="${data[aux].id}">${data[aux].uf}</option>`)
			}
		}
	});
	
//	----
	
	
	$('#editar-form-evento').submit(function(e){
		
		
		let idevento = $('.clicked').attr('id');
		 e.preventDefault(); 
		    
		    $.ajax({
		        type: 'POST',
		        async: false,
		        url: $('#editar-form-evento').attr('action') + "/" + idevento,
		        data: $('#editar-form-evento').serialize(),
		        success: function (data) {
		        	Swal.fire({
		      		  icon: 'success',
		      		  title: 'Edição concluída!',
		      		  text: 'O evento foi editado com sucesso',
		      		  footer: 'SourceTickets',
		      		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f'
		      		}).then(function(){
		      			window.location = "/administrativo"
		      		})
		        },
		        error: function (data) {
		        	Swal.fire({
		        		  icon: 'error',
		        		  title: 'Oops...',
		        		  text: 'A edição do evento falhou',
		        		  confirmButtonText: 'OK',
			      		  confirmButtonColor: '#4e002f',
		        		  footer: 'SourceTickets'
		        		})
		        }
		    });
		
	})
	
	
	
	
//	-----
	
	
	$('#cadastrar-form-evento').submit(function(e){
		
		 e.preventDefault(); 
		    
		    $.ajax({
		        type: 'POST',
		        url: $('#cadastrar-form-evento').attr('action'),
		        data: $('#cadastrar-form-evento').serialize(),
		        success: function (data) {
		        	Swal.fire({
		      		  icon: 'success',
		      		  title: 'Cadastro concluído!',
		      		  text: 'O evento foi cadastrado com sucesso',
		      		  footer: 'SourceTickets',
		      		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f'
		      		}).then(function(){
		      			window.location = "/administrativo"
		      		})
		        },
		        error: function (data) {
		        	Swal.fire({
		        		  icon: 'error',
		        		  title: 'Oops...',
		        		  text: 'A criação do evento falhou',
		        		  confirmButtonText: 'OK',
			      		  confirmButtonColor: '#4e002f',
		        		  footer: 'SourceTickets'
		        		})
		        }
		    });
		
	})
	
	
	
	
	$.ajax({
		type: 'GET',
		url: "/evento/getAllEventos",
		async: true,
		success: function(data){
			let aux = 0;
			for(aux = 0; aux < data.length; aux++){
				$('#lista-eventos').append(`<p class="lista-opcao" id="` + data[aux].id + `">` + `<span class="ml-3">` + data[aux].nome + `</span> </p>`)
			}
		}
	});
})


$('#btn-editar-evento').click(function(){
	
	$('#card-administracao-evento').hide();
	$('#card-administracao-evento-editar').show();
	
	
	let eventoID = $('.clicked').attr('id');
	console.log(eventoID)
	$.ajax({
		type: 'POST',
		url: `/administrativo/evento/buscaEventoId/${eventoID}`,
		success: function(data){
			console.log(data);
			
			//arrumando data e hora Inicio
			
			let dataInicioFull = data.horaInicio;
			
			let getDataHoraI = dataInicioFull.split("T");
			let dataInicio = getDataHoraI[0].split("-");
			let dataI = dataInicio[0] + "-" + dataInicio[1] + "-" + dataInicio[2];
			
			let horaInicio = getDataHoraI[1].split(":");
			let horaI = horaInicio[0] + ":" + horaInicio[1];
			
			$('#data-inicio-editar').val(dataI);
			$('#hora-inicio-editar').val(horaI);
			
			//arrumando data e hora Fim
			
			let dataTerminoFull = data.horaTermino;
			
			let getDataHoraT = dataTerminoFull.split("T");
			let dataTermino = getDataHoraT[0].split("-");
			let dataT = dataTermino[0] + "-" + dataTermino[1] + "-" + dataTermino[2];
			
			let horaTermino = getDataHoraT[1].split(":");
			let horaT = horaTermino[0] + ":" + horaTermino[1];
			
			$('#data-termino-editar').val(dataT);
			$('#hora-termino-editar').val(horaT);
			
			
			$('#evento-nome-editar').val(data.nome);
			$('#evento-descricao-editar').val(data.descricao);
			$('#customizacao-descricao-editar').val(data.customizacao.descricao);
			$('#rua-editar').val(data.endereco.rua);
			$('#numero-editar').val(data.endereco.numero);
			$('#cep-editar').val(data.endereco.cep);
			$('#bairro-editar').val(data.endereco.bairro);
			$('#estado-editar').val(data.endereco.cidade.estado.id)
			$('#lista-setores-editar').empty();
			
			for(let aux = 0; aux < (data.setor).length; aux++){
				$('#lista-setores-editar').append(
						
						`	<div class="row mt-3">

									<div class="col-md-12">
										<input type="text" class="form-control" name="setor.descricao"
											placeholder="Descrição do setor" value=${data.setor[aux].descricao}>
									</div>
								</div>
								<div class="row mt-3">
									<div class="col-md-6">
										<input type="text" class="form-control" name="setor.valor"
											placeholder="Valor do setor" value="${data.setor[aux].valor}">
									</div>

									<div class="col-md-6">
										<input type="text" class="form-control"
											name="setor.ingresosDisponiveis"
											placeholder="quantidade de ingressos" value="${data.setor[aux].ingresosDisponiveis}">
									</div>
								</div>
				`)
				
				
			}
			
			
		}
	})
	
	
})

$('#evento-editar-proximo').click(function(){
	
	let dataInicio = $('#data-inicio-editar').val();
	let dataFim = $('#data-termino-editar').val();
	let horaInicio = $('#hora-inicio-editar').val();
	let horaFim = $('#hora-termino-editar').val();
	
	let horaI = horaInicio.split(":");
	let horaF = horaFim.split(":");
	
	dataInicio = dataInicio + "-" + horaI[0] + ":" + horaI[1];
	dataFim = dataFim + "-" + horaF[0] + ":" + horaF[1];
	// yyyy-MM-dd-HH-mm
	
//	console.log("PADRÃO yyyy-MM-dd-HH:mm");
//	console.log(dataInicio);
//	console.log(dataFim);
	$('#horaInicio-editado').val(dataInicio);
	$('#horaTermino-editado').val(dataFim);

})

$('#btn-add-show').click(function(){
	$('#card-administracao-inicio').hide();
	$('#card-administracao-evento').show();
})

$('#btn-voltar-2-evento-4').click(function(){
	$('#card-administracao-evento-novo-2').show();
	$('#card-administracao-evento-novo-3').hide();
})

$('#btn-voltar-1-evento').click(function(){
	$('#card-administracao-inicio').show();
	$('#card-administracao-evento').hide();
})

$(document).on('keypress', '#evento-nome', function(e) {
    if(e.which == 13) {
        $('#btn-pesquisar-evento').trigger('click');
    }
});

$('#btn-pesquisar-evento').click(function(){
	let nomeEvento = " ";
	nomeEvento = $('#evento-nome').val();
	
	if(nomeEvento == "" || nomeEvento == null || nomeEvento == undefined )
		{
			nomeEvento="todos";
		}
	
	$.ajax({
		type: 'GET',
		url: `/evento/getEventos/${nomeEvento}`,
		async: true,
		success: function(data){
			
			$('#lista-eventos').empty();
			let aux = 0;
			for(aux = 0; aux < data.length; aux++){
				$('#lista-eventos').append(`<p class="lista-opcao"> <span class="ml-3">` + data[aux].nome + `</span> </p>`)
			}
		}
		
	})
	
})

$('#btn-excluir-evento').click(function(){
	
	if($('.clicked').attr('id') == null || $('.clicked').attr('id') == undefined || $('.clicked').attr('id') == ""){
		
	}else{
		let id = $('.clicked').attr('id');
		
		Swal.fire({
			  title: 'Deletar Evento',
			  text: "Você tem certeza disso?",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#4e002f',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Sim',
			  cancelButtonText: 'Não',
			  footer: 'SourceTickets'
			}).then((result) => {
			  if (result.value) {
				  $.ajax({
						type: 'POST',
						url: `/administrativo/evento/deletarEvento/${id}`,
						async: true,
						success: function(data){
							Swal.fire({
								title: 'Deletado!',
							      text: 'O evento foi deletado com sucesso',
							      icon: 'success',
							      confirmButtonColor: '#4e002f',
							      footer: 'SourceTickets'
								
							}).then(function(){
								
								window.location = "/administrativo"
								
							})	
								      
						}
					})
			  }
			})
	}
	
})

$('#btn-excluir-setor').click(function(){
	
	$('#lista-setores').empty()
	$('#lista-setores').append(`<div class="row mt-3">
								<div class="col-md-12">
								<input type="text" class="form-control" name = "setor.descricao" placeholder="Descrição do setor">
								</div>
							</div>
							<div class = "row mt-3">
								<div class="col-md-6">
								<input type="text" class="form-control" name = "setor.valor" placeholder="Valor do setor">
								</div>
								
								<div class="col-md-6">
								<input type="text" class="form-control" name = "setor.ingresosDisponiveis" placeholder="quantidade de ingressos">
								</div>
							</div>`)
	
})

$('#btn-add-setor').click(function(){
	
	$('#lista-setores').append(`<div class="row mt-3">
								<div class="col-md-12">
								<input type="text" class="form-control" name = "setor.descricao" placeholder="Descrição do setor">
								</div>
							</div>
							<div class = "row mt-3">
								<div class="col-md-6">
								<input type="text" class="form-control" name = "setor.valor" placeholder="Valor do setor">
								</div>
								
								<div class="col-md-6">
								<input type="text" class="form-control" name = "setor.ingresosDisponiveis" placeholder="quantidade de ingressos">
								</div>
							</div>`)
	
})

$('#evento-novo-proximo').click(function(){
	$('#card-administracao-evento-novo').hide();
	$('#card-administracao-evento-novo-2').show();
})

$('#evento-novo-proximo-2').click(function(){
	$('#card-administracao-evento-novo-2').hide();
	$('#card-administracao-evento-novo-3').show();
})


$('#btn-voltar-3-evento').click(function(){
	$('#card-administracao-evento-novo-2').hide();
	$('#card-administracao-evento-novo').show();
})

$('#btn-voltar-2-evento').click(function(){
	$('#card-administracao-evento-novo').hide();
	$('#card-administracao-evento').show();
})

$('#btn-adicionar-evento').click(function(){
	$('#card-administracao-evento').hide();
	$('#card-administracao-evento-novo').show();
})


$('#evento-editar-proximo').click(function(){
	$('#card-administracao-evento-editar').hide();
	$('#card-administracao-evento-editar-2').show();
})

$('#btn-voltar-2-evento-editar').click(function(){
	$('#card-administracao-evento-editar').hide();
	$('#card-administracao-evento').show();
})

//----

$('#evento-editar-proximo-2').click(function(){
	$('#card-administracao-evento-editar-2').hide();
	$('#card-administracao-evento-editar-3').show();
})

$('#btn-voltar-3-evento-editar').click(function(){
	$('#card-administracao-evento-editar-2').hide();
	$('#card-administracao-evento-editar').show();
})

//---

$('#evento-editar-proximo-2').click(function(){
	$('#card-administracao-evento-editar-2').hide();
	$('#card-administracao-evento-editar-3').show();
})

$('#btn-voltar-4-evento-editar').click(function(){
	$('#card-administracao-evento-editar-3').hide();
	$('#card-administracao-evento-editar-2').show();
})

$('#btn-evento-cadastrar').click(function(){
	removeMask();
})

$('#evento-novo-proximo').click(function(){
	
	let dataInicio = $('#data-inicio').val();
	let dataFim = $('#data-termino').val();
	let horaInicio = $('#hora-inicio').val();
	let horaFim = $('#hora-termino').val();
	
	let horaI = horaInicio.split(":");
	let horaF = horaFim.split(":");
	
	dataInicio = dataInicio + "-" + horaI[0] + ":" + horaI[1];
	dataFim = dataFim + "-" + horaF[0] + ":" + horaF[1];
	// yyyy-MM-dd-HH-mm
	
//	console.log("PADRÃO yyyy-MM-dd-HH:mm");
//	console.log(dataInicio);
//	console.log(dataFim);
	$('#horaInicio').val(dataInicio);
	$('#horaTermino').val(dataFim);

})

$(document).ready(function(){
	$('#cep').mask('00000-000');
})

function removeMask()
{
	$('#cep').val($('#cep').cleanVal());
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

//--------------------------CIDADES E ESTADOS ---------------------------------------
//Estados
$(document).ready(function(){
	$('#estado').show();
	$.ajax({
		type: 'POST',
		url: "/livre/getAllEstados",
		async: true,
		success: function(data){			
			$('#estado').append(`<option value="" selected>Estado</option>`)
			data.forEach(function(evento){
				$('#estado').append(`<option value="` + evento.id + `">` + evento.uf + `</option>`)
			})
		}
	});
})

//Cidades
$('#estado').click(function(){
	$('#cidade').empty();
	var estado = $( "#estado option:selected" ).val();
	if(estado == null || estado == undefined || estado == "")
	{
		
	}
	else
	{
		$.ajax({
			type: 'POST',
			url: `/livre/getCidade/${estado}`,
			async: true,
			success: function(data){
				data.forEach(function(cidade){
					$('#cidade').append(`<option value="` + cidade.id + `">` + cidade.nome + `</option>`)
				})
			}
		})
	}
})

$('#estado').click(function(){
		$('#cidade-editar').empty();
		let estado = $( "#estado-editar option:selected" ).val();
		
		if(estado == null || estado == undefined || estado == "")
		{
			
		}
		else
		{
			$.ajax({
				type: 'POST',
				url: `/livre/getCidade/${estado}`,
				async: true,
				success: function(data){
					
					for(let aux = 0; aux < data.length; aux++){
						$('#cidade').append(`<option id="${data[aux].id}" value="${data[aux].id}">${data[aux].nome}</option>`)
					}
					
				}
			})
		}
	})



$('#estado-editar').click(function(){
		$('#cidade-editar').empty();
		let estado = $( "#estado-editar option:selected" ).val();
		
		if(estado == null || estado == undefined || estado == "")
		{
		}
		else
		{
			$.ajax({
				type: 'POST',
				url: `/livre/getCidade/${estado}`,
				async: true,
				success: function(data){
					
					for(let aux = 0; aux < data.length; aux++){
						$('#cidade-editar').append(`<option id="${data[aux].id}" value="${data[aux].id}">${data[aux].nome}</option>`)
					}
					
				}
			})
		}
	})
