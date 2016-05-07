package br.com.setaprox.sgam.autenticacao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.DAO.impl.UsuarioDAOImpl;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.JpaUtil;



public class AssociacaoRealm implements Realm, Authorizer {

	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermitted(PrincipalCollection subjectPrincipal, Permission permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection subjectPrincipal, String... permissions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection subjectPrincipal, List<Permission> permissions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection subjectPrincipal, String... permissions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection subjectPrincipal, Collection<Permission> permissions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkPermission(PrincipalCollection subjectPrincipal, String permission) throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermission(PrincipalCollection subjectPrincipal, Permission permission)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermissions(PrincipalCollection subjectPrincipal, String... permissions)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermissions(PrincipalCollection subjectPrincipal, Collection<Permission> permissions)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRole(PrincipalCollection subjectPrincipal, String roleIdentifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean[] hasRoles(PrincipalCollection subjectPrincipal, List<String> roleIdentifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAllRoles(PrincipalCollection subjectPrincipal, Collection<String> roleIdentifiers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkRole(PrincipalCollection subjectPrincipal, String roleIdentifier) throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRoles(PrincipalCollection subjectPrincipal, Collection<String> roleIdentifiers)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRoles(PrincipalCollection subjectPrincipal, String... roleIdentifiers)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AssociacaoWeb";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo info = null;
		
		try {
			EntityManager entityManager = JpaUtil.getEntityManager();
			UsuarioDAO usuarioDAO = new UsuarioDAOImpl(entityManager);

			String login = (String)token.getPrincipal();
			
			Usuario usuario = usuarioDAO.findByLogin(login);
			
			entityManager.close();
			JpaUtil.closeEntityManagerFactory();
			
			String credencial = usuario.getSenha(); 
			
			if (credencial != null){
				
				info = new SimpleAuthenticationInfo(login, credencial, getName());
	            SimpleCredentialsMatcher cmatcher = new SimpleCredentialsMatcher();
	            
	            boolean credentialsMatch = cmatcher.doCredentialsMatch(token, info);
	            
	            // Credenciais não corresponderam, a autenticação falhou.
	            if(!credentialsMatch) {
	            	System.out.println("Login inválido!");
	            	throw new AuthenticationException("Login inválido!");
	            }

	            Session sessao = SecurityUtils.getSubject().getSession();
	            sessao.setAttribute("usuarioLogado", usuario);		
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AuthenticationException("Erro durante autenticação: " + ex.getMessage()); 
		}

		return info;
	}

}
