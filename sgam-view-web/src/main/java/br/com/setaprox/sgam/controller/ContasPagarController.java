package br.com.setaprox.sgam.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.setaprox.sgam.model.ContasPagar;

@Controller
public class ContasPagarController {
	@SuppressWarnings("unused")
	private Result result;
	
	public ContasPagarController(){
		this(null);
	}
	
	@Inject
	public ContasPagarController(Result result){
		this.result = result;
	}
	
	public void cadastraContasPagar(ContasPagar conta){
		
	}
	
	public void listagemContasPagar(){
		/*result.include("contas", new ArrayList<ContasPagar>());*/
	}
	
	public void formularioContasPagar(){
		
	}
	
	public void editarConta(Long id){
		
	}
	
	public void removeConta(Long id){
		
	}
}
