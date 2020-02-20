$('#quantidadeIngressos').on('keypress', function (event) {
    var regex = new RegExp("^[a-zA-Z0-9]+$");
    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
    if (!regex.test(key)) {
       event.preventDefault();
       return false;
    }
});
	
$('#setores').change(function(){
	let valorIngresso = $("#setores option:selected").attr("id");
})

$('#setores').focusout(function(){
	let valorIngresso = $("#setores option:selected").attr("id");
	
	if($('#quantidadeIngressos').val() != "" && $('#setores').val() != ""){
			
		let total = 0;
		let ingressos = parseInt(($('#quantidadeIngressos').val()), 10);
		let valor = parseInt(valorIngresso);
//		console.log(valorIngresso);
		total = valor * ingressos;
		
		$('#valor-total').val("R$ " + total);
	}
	
})

$('#quantidadeIngressos').focusout(function(){
	let valorIngresso = $("#setores option:selected").attr("id");
	
	if($('#quantidadeIngressos').val() != "" && $('#setores').val() != ""){
			
		let total = 0;
		let ingressos = parseInt(($('#quantidadeIngressos').val()), 10);
		let valor = parseInt(valorIngresso);
//		console.log(valorIngresso);
		total = valor * ingressos;
		
		$('#valor-total').val("R$ " + total);
	}
	
})

$('#cadastrar').click(function(){
		$('#usuario-login').val("");
		$('#senha-login').val("");
		$('#card-login').hide();
		$('#card-cadastro').show();
})


$('#form-compra').submit(function(e){
	
	 e.preventDefault(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: $('#form-compra').attr('action'),
	        data: $('#form-compra').serialize(),
	        success: function (data) {
	        	Swal.fire({
	      		  icon: 'success',
	      		  title: 'Compra Concluída!',
	      		  text: 'Sua compra foi realizada com sucesso',
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
	        		  text: 'Sua compra falhou',
	        		  confirmButtonText: 'OK',
		      		  confirmButtonColor: '#4e002f',
	        		  footer: 'SourceTickets'
	        		})
	        }
	    });
	
})


//$('.btn-compra').click(function(){
//	
//	Swal.fire({
//		  type: 'success',
//		  title: 'Compra concluída',
//		  text: 'Sua compra foi realizada com sucesso. Basta acessar seu perfil para imprimir o seu ingresso!',
//		  showConfirmButton: false,
//		  showCloseButton: true,
//		  focusConfirm: false,
//		  footer: 'SourceTickets'
//		})
//		.then(function() {
//		    window.location.href = "/inicial";
//		})
//	
//})
