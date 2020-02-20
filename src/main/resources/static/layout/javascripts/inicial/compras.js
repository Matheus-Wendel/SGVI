var setorID = [];
var varAux = 0;
var valorSetor = [];
var nomeSetor = [];

$(document).ready(function(){
	
	$.ajax({
		type: 'POST',
		async: false,
		url: '/usuario/getAllIngressos',
		success: function(data){
			console.log(data);
			for(let aux = 0; aux < data.length; aux++)
				{
					setorID[aux] = data[aux].setor.id;
					valorSetor[aux] = data[aux].setor.valor;
					nomeSetor[aux] = data[aux].setor.descricao;
					varAux ++;
				}
		}
		
	})
	
	preencheIngressos();
	
})


function preencheIngressos(){
	
	for(let aux=0; aux < setorID.length; aux++ )
	{
		
		let seto = setorID[aux];
	
		
		$.ajax({
			type: 'GET',
			url: '/evento/getEventoPorIdSetor/' + seto,
			success: function(data){
			
				$('#lista-ingressos-comprados').append(`
						<div class="row mt-3 ">
								<div class="ingresso col-md-12" style="background-image: url('${data.customizacao.descricao}'); 	background-position: center;
  	background-repeat: no-repeat;
  	background-size: cover; ">
									<p style="font-size: 14px;" class="badge badge-secondary badge-pill mt-2">Nome do evento: ${data.nome}</p><br>
									<p style="font-size: 14px;" class="badge badge-secondary badge-pill" >Endereço: ${data.endereco.bairro} ${data.endereco.rua} ${data.endereco.numero} ${data.endereco.cidade.nome} ${data.endereco.cidade.estado.uf}</p><br>
									<p style="font-size: 14px;" class="badge badge-secondary badge-pill" >Setor: ${nomeSetor[aux]}</p><br>
									<p style="font-size: 14px;" class="badge badge-secondary badge-pill" >Valor: ${valorSetor[aux]}</p>
								</div>
							</div>
				`)
				
				
			}
		})
	}

	
}