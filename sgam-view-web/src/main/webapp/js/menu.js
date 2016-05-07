function marcarMenuAtivo(menu, submenu, collapse){
	var idPadrao = "inicio";
	
	var menuAnterior = sessionStorage.getItem('menu');
	var submenuAnterior = sessionStorage.getItem('submenu');
	var collapseAnterior = sessionStorage.getItem('collapse');
	
	sessionStorage.clear();
	
	if(menuAnterior != null && submenuAnterior != null && collapseAnterior != null){
		sessionStorage.setItem("menuAnterior", menuAnterior);
		sessionStorage.setItem("submenuAnterior", submenuAnterior);
		sessionStorage.setItem("collapseAnterior", collapseAnterior);
	}
	
	sessionStorage.setItem("menu", menu);
	sessionStorage.setItem("submenu", submenu);
	sessionStorage.setItem("collapse", collapse);
}

function loadMarcacaoMenu(){
	var menuAnterior = sessionStorage.getItem('menuAnterior');
	var submenuAnterior = sessionStorage.getItem('submenuAnterior');
	var collapseAnterior = sessionStorage.getItem('collpaseAnterior');
	
	var menu = sessionStorage.getItem('menu');
	var submenu = sessionStorage.getItem('submenu');
	var collapse = sessionStorage.getItem('collapse');
	
	if(menuAnterior != null && submenuAnterior != null && collapseAnterior != null){
		$('#'+menuAnterior).removeClass('active');
		if(submenuAnterior != '' && collpaseAnterior != null){
			$('#'+submenuAnterior).removeClass('active');
			$('#'+collapseAnterior).removeClass('in');
		}
	}
	
	if(menu != null){
		$('#'+menu).addClass("active");
	}

	if(submenu != null && collapse){
		$('#'+collapse).addClass("in");
		$('#'+submenu).addClass("active");
	}
}