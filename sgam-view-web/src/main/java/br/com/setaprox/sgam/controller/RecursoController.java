package br.com.setaprox.sgam.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Recurso;

@Controller
public class RecursoController {
	private Result result;
	private Validator validator;
	private RecursoDAO recursoDAO;
	
	public RecursoController(){
		this(null, null, null);
	}
	
	@Inject
	public RecursoController(Result result, Validator validator, RecursoDAO recursoDAO){
		this.result = result;
		this.validator = validator;
		this.recursoDAO = recursoDAO;
	}
	
	public void cadastraRecurso(Recurso recurso){
		validator.validate(recurso);
		validator.onErrorRedirectTo(this).formularioRecurso();
		
		if(recurso.getId() != null && recurso.getId() > 0){
			recursoDAO.editar(recurso);
			result.redirectTo(this).listagemRecursos();	
		}
		else {
			recursoDAO.persist(recurso);
			result.redirectTo(this).formularioRecurso();
		}
	}
	
	public void listagemRecursos(){
		result.include("recursos", recursoDAO.findAll());
	}
	
	public void formularioRecurso(){
		
	}
	
	@Get("/recurso/editar/{id}")
	public void editar(Long id){
		if(id != null && id > 0){
			Recurso recurso = recursoDAO.find(id);
			result.include(recurso);
			result.redirectTo(this).formularioRecurso();
			//result.use(Results.json()).from(true, "alteraAba").serialize();
		}
		else {
			//result.use(Results.json()).from(false, "alteraAba").serialize();
		}
	}
	
	@Delete("/recurso/remover/{id}")
	public void remover(Long id){
		recursoDAO.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
}
