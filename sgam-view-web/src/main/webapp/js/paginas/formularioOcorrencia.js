$(document).ready(function(){
	
	$('.date').datepicker({
		format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true
    });

	 $('#descricaoOcorrencia').summernote({
		 focus: true,
		 height: 333,
		 toolbar: [
		     ['style', ['fontname', 'bold', 'italic', 'underline', 'clear']],
			 ['fontsize', ['fontsize']],
		     ['color', ['color']],
		     ['para', ['ul', 'ol', 'paragraph']],
		     ['height', ['height']],
		     ['misc', ['fullscreen']]
		]
	 });

	 $('#btnSalvar').click(function() {
	 	var textoDescricao = $('#descricaoOcorrencia').code();
	 	$('#descricaoOcorrencia').destroy();
	 	$('#descricaoOcorrenciaHidden').val(textoDescricao);

	 	/*
	 	$('#ocorrenciaForm').submit( function(e){
	 		
	 		e.preventDefault();
	 		var dados = $(this).serializeArray();
	 		var formURL = $(this).attr('action');
	 		
	 		alert(formURL);
	 		
	 		$.ajax({
				url: formURL,
				type: 'POST',
				data: dados,
			}).done(function(data, textStatus, jqXHR) {
				swal("Salvo!", "A ocorrência foi salva com sucesso.", "success");
			}).fail(function(jqXHR, textStatus, errorThrown){
				swal("Erro!", "Erro ao salvar ocorrência.", "error");
			});
	 		
	 	});*/
	 	
	 	
	 	
	 });

});