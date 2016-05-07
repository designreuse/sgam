package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller
public class ContasReceberController {
	private Result result;
	private ContasReceberDAO contasReceber;
	
	public ContasReceberController(){
		
	}
	
	@Inject
	public ContasReceberController(Result result, ContasReceberDAO contasReceber){
		this.result = result;
		this.contasReceber = contasReceber;
	}
	
	public void cadastraContasReceber(ContasReceber conta){
		
	}
	
	public void listagemContasReceber(){
		List<ContasReceber> contas = contasReceber.findAll();
		result.include("contas", contas);
	}
	
	public void formularioContasReceber(){
		
	}
	
	@Get("/contasReceber/editar/{id}")
	public void editarConta(Long id){
		if(id != null && id > 0){
			ContasReceber conta = contasReceber.find(id);
			result.include(conta);
			result.redirectTo(this).formularioContasReceber();
			//result.use(Results.json()).from(true, "alteraAba").serialize();
		}
		else {
			//result.use(Results.json()).from(false, "alteraAba").serialize();
		}
	}
	
	@Delete("/contasReceber/{id}")
	public void removeConta(Long id){
		try{
			contasReceber.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
			
		}catch(PersistenceException e){
			if(e.getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não é possível exluir, existe um faturamento vinculado à essa conta.");
				//result.use(Results.json()).from("Não é possível exluir, existe um faturamento vinculado à essa conta.", "mensagem").serialize();	
			}
			
		}catch(Exception e){
			result.use(Results.http()).sendError(-1, "Não é possível exluir, existe um faturamento vinculado à essa conta.");
		}
		
	}
}
