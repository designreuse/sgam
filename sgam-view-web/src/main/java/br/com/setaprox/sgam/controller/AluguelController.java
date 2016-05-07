package br.com.setaprox.sgam.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.DAO.AluguelDAO;
import br.com.setaprox.sgam.DAO.RecursoDAO;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller
public class AluguelController {
	private Result result;
	private RecursoDAO recursoDAO;
	private AluguelDAO aluguelDAO;
	private Validator validator;
	
	public AluguelController(){
		this(null, null, null, null);
	}
	
	@Inject
	public AluguelController(Result result, RecursoDAO recursoDAO, AluguelDAO aluguelDAO, Validator validator){
		this.result = result;
		this.recursoDAO = recursoDAO;
		this.validator = validator;
		this.aluguelDAO = aluguelDAO;
	}
	
	public void formularioAluguel(){
		result.include("recursos", recursoDAO.findAll());
	}
	
	public void listagemAluguel(){
		List<Aluguel> aluguelList = aluguelDAO.findAll();
		result.include("aluguelList", aluguelList);
	}
	
	@SuppressWarnings("deprecation")
	@Post("aluguel/cadastro")
	public void cadastraAluguel(Aluguel aluguel){
		
		validator.validate(aluguel);
		
		validator.onErrorRedirectTo(this).formularioAluguel();

		if(aluguel.getId() != null && aluguel.getId() > 0){
			aluguelDAO.editar(aluguel);
			result.redirectTo(this).formularioAluguel();	
		}
		else {
			ContasReceber conta = new ContasReceber();
			conta.setNome(aluguel.getMorador().getNome());
			conta.setHistorico(aluguel.getAluguelComercio().getNome());
			conta.setDataEmissao(new Date());
			conta.setDataVencimento(aluguel.getDataEmissaoFaturamento());
			conta.setValor(aluguel.getRecurso().getValor());
			conta.setNumero(String.format("%d%d%d%d%d%d", conta.getDataEmissao().getDate(),conta.getDataEmissao().getMonth(),conta.getDataEmissao().getYear(), conta.getDataEmissao().getHours(), conta.getDataEmissao().getMinutes(), conta.getDataEmissao().getSeconds()));

			if(conta.getDataVencimento().compareTo(conta.getDataEmissao()) <= 0){
				conta.setStatus("Recebido");
			}
			else {
				conta.setStatus("Aberto");
			}
			
			aluguel.setContaReceber(conta);
			
			aluguelDAO.persist(aluguel);
			result.redirectTo(this).formularioAluguel();
		}
		
	}
	
	@Get("aluguel/editar/{id}")
	public void editarAluguel(Long id){
		if(id != null && id > 0){
			Aluguel aluguel = aluguelDAO.find(id);
			result.include(aluguel);
			result.redirectTo(this).formularioAluguel();
		}
	}
	
	@Delete("aluguel/remover/{id}")
	public void removerAluguel(Long id){
		aluguelDAO.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
}
