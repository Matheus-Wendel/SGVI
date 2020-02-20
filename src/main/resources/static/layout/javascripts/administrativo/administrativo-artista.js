$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: "/administrativo/artista/getAllArtistas",
		async: true,
		success: function(data){
			let aux = 0;
			for(aux = 0; aux < data.length; aux++){
				$('#lista-artistas').append(`<p class="lista-opcao" id="` + data[aux].id + `">` + `<span class="ml-3">` + data[aux].nome + `</span> </p>`)
			}
		}
	});
})




$('#atualizar-artista').submit(function(e){
	
	 e.preventDefault(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: $('#atualizar-artista').attr('action'),
	        data: $('#atualizar-artista').serialize(),
	        success: function (data) {
	        	Swal.fire({
	      		  icon: 'success',
	      		  title: 'Atualização concluída!',
	      		  text: 'O artista foi atualizado com sucesso',
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
	        		  text: 'A atualização do Artista falhou',
	        		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f',
	        		  footer: 'SourceTickets'
	        		})
	        }
	    });
	
})

$('#btn-excluir-artista').click(function(){
	
	if($('.clicked').attr('id') == null || $('.clicked').attr('id') == undefined || $('.clicked').attr('id') == ""){
		
	}else{
		let id = $('.clicked').attr('id');
		
		Swal.fire({
			  title: 'Deletar Artista',
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
						url: `/administrativo/artista/deletarArtista/${id}`,
						async: true,
						success: function(data){
							Swal.fire({
								title: 'Deletado!',
							      text: 'O artista foi deletado com sucesso',
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
   


function formSubmit(e){
    e.preventDefault(); 
    
    $.ajax({
        type: 'POST',
        url: '/administrativo/artista/cadastro',
        data: $('#cadastrar-form').serialize(),
        success: function (data) {
        	Swal.fire({
      		  icon: 'success',
      		  title: 'Cadastro concluído!',
      		  text: 'O artista foi cadastrado com sucesso',
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
        		  text: 'O cadastro de Artista falhou',
        		  footer: 'SourceTickets',
        		  confirmButtonText: 'OK',
	      		  confirmButtonColor: '#4e002f'
        		})
        }
    });
}
$(document).on('keypress', '#artista-nome', function(e) {
    if(e.which == 13) {
        $('#btn-pesquisar-artista').trigger('click');
    }
});

$(document).on('click', '.lista-opcao', function(){

//	pegar o id do artista
//	$(this).attr("id");
	
	if($(this).hasClass("clicked"))
		{
		$(this).css("color", "black");
		$(this).css("background-color", "");
		$(this).removeClass("clicked");
		}else{
			$('p').removeClass("clicked");
			$('p').css("background-color", "");
			$('p').css("color", "black");
			$(this).addClass("clicked");
			$(this).css("color", "white");
			$(this).css("background-color", "#4e002f");
		}
});

$('#btn-add-artista').click(function(){
	$('#card-administracao-inicio').hide();
	$('#card-administracao-artista').show();
})

$('#btn-voltar-0').click(function(){
	window.location = "/inicial";
})

$('#btn-pesquisar-artista').click(function(){
	let nomeArtista = $('#artista-nome').val();
	if(nomeArtista == "" || nomeArtista == null || nomeArtista == undefined )
		{
			nomeArtista="todos";
		}
	
	$.ajax({
		type: 'GET',
		url: `/administrativo/artista/getArtistas/${nomeArtista}`,
		async: true,
		success: function(data){
			$('#lista-artistas').empty();
			let aux = 0;
			for(aux = 0; aux < data.length; aux++){
				$('#lista-artistas').append(`<p class="lista-opcao" id="` + data[aux].id + `">` + `<span class="ml-3">` + data[aux].nome + `</span> </p>`)
			}
		}
		
	})
	
})

$('#btn-editar-artista').click(function(){
	nomeaux = $('.clicked').text();
	let nomeArtista = nomeaux;
	$.ajax({
		type: 'GET',
		url: `/administrativo/artista/getArtistas/${nomeArtista}`, //TODO alterar para id
		async: true,
		success: function(data){
			let idArtista = data[0].id;
			$('#card-administracao-artista').hide();
			$('#artista-nome-editar').val(data[0].nome);
			$('#artista-genero-editar').val(data[0].genero);
			$('#artista-descricao-editar').val(data[0].descricao);
			$('#card-administracao-artista-editar').show();
			$('#atualizar-artista').attr('action', `/administrativo/artista/atualizarArtista/${idArtista}`);
		}
	})
})

$('#btn-editar-artista').click(function(){
//	TODO
})

$('#btn-voltar-1').click(function(){
	$('#card-administracao-inicio').show();
	$('#card-administracao-artista').hide();
})

$('#btn-voltar-2').click(function(){
	$('#card-administracao-artista').show();
	$('#card-administracao-artista-novo').hide();
})

$('#btn-voltar-3').click(function(){
	$('#card-administracao-artista').show();
	$('#card-administracao-artista-editar').hide();
	
	
})

$('#btn-adicionar-artista').click(function(){
	$('#card-administracao-artista').hide();
	$('#card-administracao-artista-novo').show();
})