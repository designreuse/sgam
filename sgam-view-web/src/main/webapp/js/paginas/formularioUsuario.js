/*$('#btnSalvarUsuario').on('click', function(event){
	//event.preventDefault();
	var idUsuario = $('#idUsuario').val();
	var senha = $('#senha').val();
	
	alert('idUsuario: ' + idUsuario + ' senha: ' + senha);
	
	if(idUsuario != null || idUsuario != ''){
		if(senha == null || senha == ''){
			swal({
	            title: "Atenção!",
	            text: "A senha não foi alterada. Deseja manter a mesma senha?",
	            type: "warning",
	            showCancelButton: true,
	            confirmButtonColor: "#DD6B55",
	            cancelButtonText: "Cancelar",
	            confirmButtonText: "Sim",
	            closeOnConfirm: false
	        }, function () {
	            $.ajax({
					url: 'novo',
					type: 'POST',
					data: $('usuarioForm').serialize()
				}).done(function(data, textStatus, jqXHR) {
					swal("Salvo!", "O cadastro foi alterado com sucesso.", "success");
				}).fail(function(jqXHR, textStatus, errorThrown){
					swal("Erro!", "Erro ao alterar o cadastro.", "error");
				});
	        });
		}
	}
	else {
		$.ajax({
			url: 'usuario/novo',
			type: 'POST',
			data: $('usuarioForm').serialize()
		}).done(function(data, textStatus, jqXHR) {
			swal("Salvo!", "O cadastro foi alterado com sucesso.", "success");
		}).fail(function(jqXHR, textStatus, errorThrown){
			swal("Erro!", "Erro ao alterar o cadastro.", "error");
		});
	}
});*/