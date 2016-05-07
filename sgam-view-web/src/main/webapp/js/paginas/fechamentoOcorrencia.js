$(document).ready(function(){
	
	$('.height-scroll').slimscroll({
        height: '485px'
    });

	$('#dataFechamento').datepicker({
		format: 'dd/mm/yyyy',
        todayBtn: "linked",
        keyboardNavigation: false,
        forceParse: false,
        calendarWeeks: true,
        autoclose: true
    });

	$('#btnSalvar').click(function() {
		$('#descricaoFechamentoOcorrencia').summernote({focus: true});
		var descricaoFechamento = $('#descricaoFechamentoOcorrencia').code();
		var dataInicio = $('#dataInicioFechamentoOcorrencia').text();
		var dataFechamento = $('#dataFechamento').val();
		
	 	$('#dataInicioHidden').val(dataInicio);
	 	$('#dataFechamentoHidden').val(dataFechamento);
	 	$('#descricaoHidden').val(descricaoFechamento);

	 	$('#descricaoFechamentoOcorrencia').destroy();
	 });
});