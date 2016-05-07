package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.DAO.MoradorDAO;
import br.com.setaprox.sgam.DAO.OcorrenciaDAO;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.model.Ocorrencia;


@Controller
public class OcorrenciaController {
	private final Result result;

	private OcorrenciaDAO ocorrenciaDAO;
	private MoradorDAO moradorDAO;
	private Validator validator;
	
	/**
	 * @deprecated CDI eyes only
	 */
	public OcorrenciaController() {
		this(null, null, null, null);
	}
	
	@Inject
	public OcorrenciaController(Result result, OcorrenciaDAO ocorrenciaDAO, MoradorDAO moradorDAO, Validator validator) {
		this.result = result;
		this.ocorrenciaDAO = ocorrenciaDAO;
		this.moradorDAO = moradorDAO;
		this.validator = validator;
	}
	
	public void listagemOcorrencias(){
		List<Ocorrencia> ocorrenciaList = ocorrenciaDAO.findAll();
		result.include("ocorrencias", ocorrenciaList);
	}
	
	public void formularioOcorrencia(){
		//result.include(new Ocorrencia());
	}
	
	@Get("/ocorrencia/fechar/{id}")
	public void fechamentoOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaDAO.find(id);
			result.include(ocorrencia);
		}
	}
	
	@Post("/ocorrencia/cadastro")
	public void cadastraOcorrencia(Ocorrencia ocorrencia){
		validator.validate(ocorrencia);
		validator.onErrorRedirectTo(this).formularioOcorrencia();

		Morador morador = null;
		if(ocorrencia.getMorador() != null && ocorrencia.getMorador().getId() > 0){
			morador = moradorDAO.find(ocorrencia.getMorador().getId());
		}
		
		validator.validate(morador);
		validator.onErrorRedirectTo(this).formularioOcorrencia();		
		
		if(ocorrencia.getId() != null && ocorrencia.getId() > 0){
			ocorrencia.setMorador(morador);
			ocorrenciaDAO.editar(ocorrencia);
			result.redirectTo(this).listagemOcorrencias();
		}
		else {
			ocorrencia.setMorador(morador);
			ocorrencia.setStatus("Aberto");
			ocorrenciaDAO.persist(ocorrencia);
			result.redirectTo(this).formularioOcorrencia();
		}
	}
	
	@Get("/ocorrencia/editar/{id}")
	public void editarOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaDAO.find(id);
			result.include(ocorrencia);
			result.redirectTo(this).formularioOcorrencia();
		}
	}
	
	@Delete("/ocorrencia/excluir/{id}")
	public void removerOcorrencia(Long id){
		ocorrenciaDAO.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
	
	@Get("/ocorrencia/modal/{id}")
	public void abrirModalOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaDAO.find(id);
			result.use(Results.json()).from(ocorrencia, "ocorrencia").serialize();
			//result.use(Results.json()).from(new SimpleDateFormat("dd/MM/yyyy").format(ocorrencia.getDataInicio()), "dataAbertura").serialize();
		}
	}
	
	@Post("/ocorrencia/resolver")
	public void resolverOcorrencia(Ocorrencia ocorrencia){
		validator.validate(ocorrencia);
		validator.onErrorRedirectTo(this).fechamentoOcorrencia(ocorrencia.getId());
		
		if(ocorrencia.getDataFim() != null){
			ocorrencia.setStatus("Fechado");
		}
		
		Morador morador = moradorDAO.find(ocorrencia.getMorador().getId());
		ocorrencia.setMorador(morador);
		
		ocorrenciaDAO.editar(ocorrencia);
		result.redirectTo(this).listagemOcorrencias();
	}
	
}
