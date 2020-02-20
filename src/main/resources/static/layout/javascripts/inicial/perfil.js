$(document).ready(function(){
	
	$.ajax({
		type: 'POST',
		url: "/livre/getAllEstados",
		async: true,
		success: function(data){	
			for(let aux = 0; aux < data.length; aux++){
				$('#estado').append(`<option id="${data[aux].id}" value="${data[aux].id}">${data[aux].uf}</option>`)
			}
		}
	});
	
	
	$('#atualizar-cliente').submit(function(e){
		
		 e.preventDefault(); 
		    
		    $.ajax({
		        type: 'POST',
		        url: $('#atualizar-cliente').attr('action'),
		        data: $('#atualizar-cliente').serialize(),
		        success: function (data) {
		        	Swal.fire({
		      		  icon: 'success',
		      		  title: 'Conta Atualizada!',
		      		  text: 'Sua conta foi atualizada com sucesso',
		      		  footer: 'SourceTickets',
		      		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f'
		      		}).then(function(){
		      			window.location = "/"
		      		})
		        },
		        error: function (data) {
		        	Swal.fire({
		        		  icon: 'error',
		        		  title: 'Oops...',
		        		  text: 'A edição de conta falhou',
		        		  confirmButtonText: 'OK',
			      		  confirmButtonColor: '#4e002f',
		        		  footer: 'SourceTickets'
		        		})
		        }
		    });
		
	})

	
	
	
	
	
	
	
	
	$.ajax({
		
		type: 'POST',
		url: 'cliente/usuario/getCliente',
		success: function(data){
			
			$('#mensagem-bem-vindo').text(`Bem Vindo ${data[0].nome}`)
			
			
			$('#nome').val(data[0].nome);
			$('#email').val(data[0].usuario.email);
			$('#cep').val(data[0].endereco.cep);
			$('#cpf').val(data[0].cpf);
			$('#senha').val(data[0].usuario.senha);
			$('#telefone').val(data[0].telefone);
			$('#bairro').val(data[0].endereco.bairro);
			$('#rua').val(data[0].endereco.rua);
			$('#numero').val(data[0].endereco.numero);
			$('#id-cliente').val(data[0].id);
			$("#estado").val(data[0].endereco.cidade.estado.id);
			$('#data-nascimento').val(data[0].dataNascimento);
			$('#id-usuario').val(data[0].usuario.id);
			$('#ingressoBonus').val(data[0].ingressoBonus);
			$('#permissao').val(0);
			
			
			
			
		}
	})
	
})

$('#estado').click(function(){
		$('#cidade').empty();
		let estado = $( "#estado option:selected" ).val();
		
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
	