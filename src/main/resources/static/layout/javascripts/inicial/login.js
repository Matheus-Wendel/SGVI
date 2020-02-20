let cpf = false;
let dtnasc = false;
let tel = false;
let senhaQuantia = false;
let senhaIgual = false;
let usuario = false;
let email = false;
let cidade = false;
let bairro = false;
let cep = false;
let rua = false;
let numero = false;


function removererror(){
	
	removeMask();
	
	if($('#cidade').val() == ""){
		$('#cidade').addClass('has-error');
		$('.help-block-cidade').show();
		cidade = false;
	}else
		{
		$('#cidade').removeClass('has-error');
		$('.help-block-cidade').hide();
		cidade = true;
		}
	
	if($('#bairro').val() == ""){
		$('#bairro').addClass('has-error');
		$('.help-block-bairro').show();
		bairro = false;
	}else{
		$('#bairro').removeClass('has-error');
		$('.help-block-bairro').hide();
		bairro = true;
	}
	if($('#rua').val() == ""){
		$('#rua').addClass('has-error');
		$('.help-block-rua').show();
		rua = false;
	}else{
		$('#rua').removeClass('has-error');
		$('.help-block-rua').hide();
		rua = true;
	}
	if($('#numero').val() == ""){
		$('#numero').addClass('has-error');
		$('.help-block-numero').show();
		numero = false;
	}else{
		$('#numero').removeClass('has-error');
		$('.help-block-numero').hide();
		numero = true;
	}
		if($('#cep').val() == ""){
			$('#cep').addClass('has-error');
			$('.help-block-cep').show();
			cep = false;
		}else{
			$('#cep').removeClass('has-error');
			$('.help-block-cep').hide();
			cep = true;
	}
		
}

$(document).ready(function(){
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-cpf" style="color:red; font-size: 12px;">* O CPF digitado deve ser válido<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-tel" style="color:red; font-size: 12px;">* O número de telefone deve ter conter 11 dígitos<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-dtnasc" style="color:red; font-size: 12px;">* A Data de Nascimento digitada não é válida<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-usuario" style="color:red; font-size: 12px;">*O usuario deve conter no minimo 7 caracteres<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-quantia" style="color:red; font-size: 12px;">*As senhas devem conter no minimo 7 caracteres<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block-email" style="color:red; font-size: 12px;">* O E-mail digitado não é valido<br></span>`)
	$('#form-group-senhas-cadastrar').append (`<span class="help-block" style="color:red; font-size: 12px;">* As senhas digitadas não coincidem<br></span>`)
	
	
	$('#form-group-cadastro-2').append (`<span class="help-block-cidade" style="color:red; font-size: 12px;">*Nenhuma cidade foi escolhida<br></span>`)
	$('#form-group-cadastro-2').append (`<span class="help-block-bairro" style="color:red; font-size: 12px;">*Nenhum bairro foi escolhido<br></span>`)
	$('#form-group-cadastro-2').append (`<span class="help-block-rua" style="color:red; font-size: 12px;">*Nenhuma rua foi digitada<br></span>`)
	$('#form-group-cadastro-2').append (`<span class="help-block-numero" style="color:red; font-size: 12px;">*Nenhum numero foi digitado<br></span>`)
	$('#form-group-cadastro-2').append (`<span class="help-block-cep" style="color:red; font-size: 12px;">*Nenhum CEP foi digitado<br></span>`)
	
	$('.help-block-cpf').hide();
	$('.help-block-tel').hide();
	$('.help-block-dtnasc').hide();
	$('.help-block-usuario').hide();
	$('.help-block-quantia').hide();
	$('.help-block-email').hide();
	$('.help-block').hide();
	
	$('.help-block-cidade').hide();
	$('.help-block-bairro').hide();
	$('.help-block-rua').hide();
	$('.help-block-numero').hide();
	$('.help-block-cep').hide();

})

$('#cadastrar').click(function(){
		$('#usuario-login').val("");
		$('#senha-login').val("");
		$('#card-login').hide();
		$('#card-cadastro').show();
})


$('#cadastrar-form').submit(function(e){
	
	 e.preventDefault(); 
	 removererror();
	    
	    $.ajax({
	        type: 'POST',
	        url: $('#cadastrar-form').attr('action'),
	        data: $('#cadastrar-form').serialize(),
	        success: function (data) {
	        	Swal.fire({
	      		  icon: 'success',
	      		  title: 'Conta criada!',
	      		  text: 'Sua conta foi criada com sucesso',
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
	        		  text: 'A criação de conta falhou',
	        		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f',
	        		  footer: 'SourceTickets'
	        		})
	        }
	    });
	
})




$('#entrar').click(function(){		
		$('#usuario-cadastro').val("");
		$('#cpf-cadastro').val("");
		$('#tel-cadastro').val("");
		$('#data-nascimento').val("");
		$('#senha-cadastro').val("");
		$('#senha-confirmar').val("");
		$('#email').val("");
		$('#card-login').show();
		$('#card-cadastro').hide();
		$('#senha-cadastro').removeClass('has-error');
		$('#senha-confirmar').removeClass('has-error');
		$('#usuario-cadastro').removeClass('has-error');
		$('cpf-cadastro').removeClass('has-error');
		$('tel-cadastro').removeClass('has-error');
		$('data-nascimento').removeClass('has-error');
		$('#email').removeClass('has-error');
		$('.help-block-cpf').hide();
		$('.help-block-tel').hide();
		$('.help-block-dtnasc').hide();
		$('.help-block').hide();
		$('.help-block-quantia').hide();
		$('.help-block-usuario').hide();
		$('.help-block-email').hide();
})


//-------------------- Validacao --------------------

$('#btn-proximo').click(function(){
	removeMaskFirst();
	
	cpf = false;
	dtnasc = false;
	tel = false;
	senhaQuantia = false;
	senhaIgual = false;
	usuario = false;
	cidade = false;
	bairro = false;
	cep = false;
	rua = false;
	numero = false;
	
	let strCPF = $('#cpf-cadastro').val();
	if(strCPF.length == 11 && TestaCPF())
	{
		$('#cpf-cadastro').removeClass('has-error');
		$('.help-block-cpf').hide();
		cpf = true;
	}
	else
	{
		$('#cpf-cadastro').addClass('has-error');
		$('.help-block-cpf').show();
		cpf = false;
	}
	
	let strTEL = $('#tel-cadastro').val();
	if($('#tel-cadastro').val().length == 11)
	{
		$('#tel-cadastro').removeClass('has-error');
		$('.help-block-tel').hide();
		tel = true;
	}
	else
	{
		$('#tel-cadastro').addClass('has-error');
		$('.help-block-tel').show();
		tel = false;
	}
	
	let strDTNASC = $('#data-nascimento').val();
	
	if(strDTNASC.length == 10)
	{
		let ano = (new Date).getFullYear();
		let data = strDTNASC.split("-");
		if(data[0] < ano)
		{
			$('#data-nascimento').removeClass('has-error');
			$('.help-block-dtnasc').hide();
			dtnasc = true;
		}
		else
		{
			$('#data-nascimento').addClass('has-error');
			$('.help-block-dtnasc').show();
			dtnasc = false;
		}
	}
	else
	{
		$('#data-nascimento').addClass('has-error');
		$('.help-block-dtnasc').show();
		dtnasc = false;
	}
	
	if(($('#senha-cadastro').val().length < 7) || ($('#senha-confirmar').val().length < 7)){
		$('#senha-confirmar').addClass('has-error');
		$('#senha-cadastro').addClass('has-error');
		$('.help-block-quantia').show();
		senhaQuantia = false;
		}else{
			senhaQuantia = true;
			$('.help-block-quantia').hide();
		}
	
	if(($('#senha-cadastro').val() != $('#senha-confirmar').val()) || $('#senha-cadastro').val() == "" || $('#senha-confirmar').val() == "" ){
		$('#senha-confirmar').addClass('has-error');
		$('#senha-confirmar').addClass('mb-3');
		$('#senha-cadastro').addClass('has-error');
		$('.help-block').show();
		SenhaIgual = false;
	}else{	
		senhaIgual = true;
		$('.help-block').hide();
	}
	
	
	if(($('#usuario-cadastro').val().length) < 7 )
	{
		$('#usuario-cadastro').addClass('has-error');
		$('.help-block-usuario').show();
		usuario = false;
	}else{
		$('#usuario-cadastro').removeClass('has-error');
		$('.help-block-usuario').hide();
		usuario = true;
	
	
	}
	
	
	
		let sEmail = $("#email").val();
		let emailFilter=/^.+@.+\..{2,}$/;
		let illegalChars= /[\(\)\<\>\,\;\:\\\/\"\[\]]/;
		if(!(emailFilter.test(sEmail))||sEmail.match(illegalChars)){
			
			$('#email').addClass('has-error');
			$('.help-block-email').show();
			email = false;
			
		}else{
			
			$('#email').removeClass('has-error');
			$('.help-block-email').hide();
			email = true;
			
		}
	
	if(senhaIgual){
		$('.help-block').hide();
	}
	
	if(senhaQuantia){
		$('.help-block-quantia').hide();
	}
	
	if ( senhaIgual && senhaQuantia && usuario && email && cpf && dtnasc && tel){
		$('#senha-cadastro').removeClass('has-error');
		$('#senha-confirmar').removeClass('has-error');
		$('cpf-cadastro').removeClass('has-error');
		$('tel-cadastro').removeClass('has-error');
		$('data-nascimento').removeClass('has-error');
		$('.help-block-cpf').hide();
		$('.help-block-tel').hide();
		$('.help-block-dtnasc').hide();
		$('.help-block').hide();
		$('#card-cadastro').hide();
		$('#card-cadastro-2').show();
		$('#btn-anterior').click(function(){
			$('#card-cadastro-2').hide();
			$('#card-cadastro').show();
		})
	
	}
	
});
	

//------------função que aceita só numeros em campos de texto-------------

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : event.keyCode
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

//-------------------------Máscaras para os campos-----------------------------------

$(document).ready(function(){
	$('#cpf-cadastro').mask('000.000.000-00');
	$('#tel-cadastro').mask('(00) 00000-0000');
	$('#cep').mask('00000-000');
});

function removeMaskFirst()
{
	$('#cpf-cadastro').val($('#cpf-cadastro').cleanVal());
	$('#tel-cadastro').val($('#tel-cadastro').cleanVal());
}

function removeMask()
{
	$('#cpf-cadastro').val($('#cpf-cadastro').cleanVal());
	$('#tel-cadastro').val($('#tel-cadastro').cleanVal());
	$('#cep').val($('#cep').cleanVal());
}

//-----------------------------VALIDAR CPF------------------------------------------


function TestaCPF()
{
	let strCPF = $('#cpf-cadastro').val();
	let Soma;
	let Resto;
	Soma = 0;
	if(strCPF == "00000000000" || strCPF == "11111111111" || strCPF == "22222222222" || strCPF == "33333333333" ||
		strCPF == "44444444444" || strCPF == "55555555555" || strCPF == "66666666666" || strCPF == "77777777777" ||
		strCPF == "88888888888" || strCPF == "99999999999")
	{
		return false;
	}
	else
	{
		for(i = 1; i <= 9; i++)
		{
			Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
		}
		Resto = (Soma * 10) % 11;
		if((Resto == 10) || (Resto == 11))
		{
			Resto = 0;
		}
		if(Resto != parseInt(strCPF.substring(9, 10)))
		{
			return false;
		}
		Soma = 0;
		for(i = 1; i <= 10; i++)
		{
			Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
		}
		Resto = (Soma * 10) % 11;
		if((Resto == 10) || (Resto == 11))
		{
			Resto = 0;
		}
		if(Resto != parseInt(strCPF.substring(10, 11)))
		{
			return false;
		}
		return true;
	}
}

//--------------------------CIDADES E ESTADOS ---------------------------------------
//Estados
$(document).ready(function(){
	$('#estados').show();
	$.ajax({
		type: 'POST',
		url: "/livre/getAllEstados",
		async: true,
		success: function(data){			
			$('#estados').append(`<option value="" selected>Estado</option>`)
			data.forEach(function(evento){
				$('#estados').append(`<option value="` + evento.id + `">` + evento.uf + `</option>`)
			})
		}
	});
})

//Cidades
$('#estados').click(function(){
	$('#cidade').empty();
	var estado = $( "#estados option:selected" ).val();
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