package br.com.setaprox.sgam.controller;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.CipherUtil;

@Controller
public class UsuarioController {
	private Result result;
	private UsuarioDAO usuarioDAO;
	private Validator validator;
	
	public UsuarioController(){
		this(null, null, null);
	}
	
	@Inject
	public UsuarioController(Result result, UsuarioDAO usuarioDAO, Validator validator){
		this.result = result;
		this.usuarioDAO = usuarioDAO;
		this.validator = validator;
	}
	
	public void listagemUsuario(){
		result.include("usuarios", usuarioDAO.findAll());
	}
	
	public void formularioUsuario(){
		
	}
	
	@Post("usuario/novo")
	public void cadastrarUsuario(Usuario usuario){
		try {
			String senha = null;
			if(usuario.getSenha() != null && !usuario.getSenha().isEmpty()){
				senha = CipherUtil.encodeSHA256(usuario.getSenha());
				usuario.setSenha(senha);
			}
			
			this.validar(usuario);
			
			validator.onErrorRedirectTo(this).formularioUsuario();
			
			if(usuario.getId() != null && usuario.getId() > 0){
				usuarioDAO.editar(usuario);
				result.redirectTo(this).listagemUsuario();	
			}
			else {
				
				
				
				usuarioDAO.persist(usuario);
				result.redirectTo(this).formularioUsuario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Get("usuario/editar/{id}")
	public void editarUsuario(Long id){
		if(id != null && id > 0){
			Usuario usuario = usuarioDAO.find(id);
			result.include(usuario);
			result.redirectTo(this).formularioUsuario();
		}
	}
	
	@Get("usuario/editar/")
	public void editarUsuarioLogado(){
		Session sessao = SecurityUtils.getSubject().getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		result.include(usuario);
		result.redirectTo(this).formularioUsuario();
		
	}
	
	@Delete("usuario/remover/{id}")
	public void removerUsuario(Long id){
		usuarioDAO.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
	
	private void validar(Usuario usuario){
		Usuario usuarioCadastrado = null;
		
		try{
			usuarioCadastrado = usuarioDAO.find(usuario.getId());	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		validator.validate(usuario);
		
		if(usuarioCadastrado != null && usuarioCadastrado.getId() != usuario.getId()){
			validator.add(new SimpleMessage("login", "Login já existente.", new Object[0]));
		}
		
		if(usuario.getId() == 0 && (usuario.getSenha() == null || usuario.getSenha().isEmpty())){
			validator.add(new SimpleMessage("senha", "Senha deve ser preenchida.", new Object[0]));
		}		
		else if(usuario.getId() > 0 && (usuario.getSenha() == null || usuario.getSenha().isEmpty())){
			try {
				usuario.setSenha(usuarioCadastrado.getSenha());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
