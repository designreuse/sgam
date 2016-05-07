$(document).ready(function(){
	
	$('#tableListagemMoradoresModal').dataTable({
		"pageLength": 5,
		"lengthMenu": [ 5 ],
		"lengthChange": true,
		"language": {
			"search": "Pesquisar: ",
			"lengthMenu": "_MENU_",
			    "info": "Exibindo de _START_ até _END_ de um total de _MAX_ registros",
			    "paginate": {
				"first": "Primeira Página",
				"last": "Última Página",
				"previous": "Anterior",
				"next": "Próxima"
			    }
		},
		"columns": [
		    {"width": "5%"},
		    null
		]
	});

	$('#btnFiltrar').on('click', function(event){
		event.preventDefault();
		
		var link = $(this);
		
		$.ajax({
			url: link.attr("href"),
			type: 'GET'
		}).done(function(data, textStatus, jqXHR) {
			adicionarLinhasTabela(data);
		}).fail(function(jqXHR, textStatus, errorThrown){
			alert('Deu erro!');
		});
	});
	
	$('#btnSelecionarModal').on('click', function(event){
		var idMorador   = $('#idMoradorModal').val();
		var nomeMorador = $('#nomeMoradorModal').val();
		
		$('#idMorador').val(idMorador);
		$('#nomeMorador').val(nomeMorador);
		
		$('#modalSelecaoMorador').modal('hide')
	});
	
	

});

function adicionarLinhasTabela(data){
	
	var tabela = $('#tableListagemMoradoresModal').DataTable();
	
	for(var i=0; i<data.moradores.length; i++){
		var btnRadio = '';
		btnRadio += '<div class="radio radio-success" > ';
		btnRadio += '<input type="radio" name="radio" onclick="selecionarRadio()" value=\"' + data.moradores[i].id + ':' + data.moradores[i].nome + "\">";
		btnRadio += '<label for="btnRadio"></label>';
		btnRadio += '</div>';
		
		var nome = data.moradores[i].nome;

		tabela.row.add([
		    btnRadio,
		    nome
		]).draw(false);
	}
}

function selecionarRadio(){
	var info = $('input[name=radio]:checked').val();
	var morador = info.split(':');
	
	$('#idMoradorModal').val(morador[0]);
	$('#nomeMoradorModal').val(morador[1]);
}
