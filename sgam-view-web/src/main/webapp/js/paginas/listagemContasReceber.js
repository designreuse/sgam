$(document).ready(function(){
	$('#tableListagemContasReceber').dataTable({
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
		"lengthChange": false
	}); 
	
	$('.remover').on('click', function(event){
		event.preventDefault();
		var link = $(this);
		var conta = $(this).closest('.linhaContaReceber');

		swal({
            title: "Excluir Conta?",
            text: "Não será possível recuperar o cadastro dessa conta.",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            cancelButtonText: "Cancelar",
            confirmButtonText: "Sim, excluir!",
            closeOnConfirm: false
        }, function () {

            $.ajax({
				url: link.attr("href"),
				type: 'POST',
				data: { _method: "DELETE"}
			}).done(function(data, textStatus, jqXHR) {
				swal("Excluído!", "O cadastro foi excluído com sucesso.", "success");
				conta.fadeOut();
			}).fail(function(jqXHR, textStatus, errorThrown){
				swal("Erro!", jerrorThrown, "error");
				//swal("Erro!", "Erro ao excluir o cadastro.", "error");
			});
        });
	});
	
});