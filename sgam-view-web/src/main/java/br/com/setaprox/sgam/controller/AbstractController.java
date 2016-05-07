package br.com.setaprox.sgam.controller;

public abstract class AbstractController {

//	private Object objAuxiliarExclusao;
//	private boolean msgErro;
//
//	@SuppressWarnings( "unchecked" )
//	public <T> T getObjAuxiliarExclusao() {
//		return (T)objAuxiliarExclusao;
//	}
//
//	public void setObjAuxiliarExclusao( Object objAuxiliarExclusao ) {
//		this.objAuxiliarExclusao = objAuxiliarExclusao;
//	}
//
//	public boolean possuiMsgErro() {
//		return msgErro;
//	}
//
//	public String returnAction() {
//		return returnAction( null );
//	}
//
//	public String returnAction( String nmXhtml ) {
//
//		msgErro = false;
//
//		if ( nmXhtml != null ) {
//
//			return nmXhtml + ".xhtml?faces-redirect=true";
//
//		} else {
//
//			return null;
//
//		}
//
//	}
//
//	/**
//	 * Retorna o SessionMap corrente.
//	 * 
//	 * @return
//	 * @throws Exception - Lança erro quando o SessionMap não é encontrado.
//	 */
//	private Map<String, Object> getSessionMap() throws Exception {
//
//		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//
//		if ( sessionMap != null ) { return sessionMap; }
//
//		throw new Exception( "ERRO: SessionMap não encontrado" );
//
//	}
//
//	/**
//	 * Adiciona uma mensagem de informção a página. Recebe o sumário (titulo) e o detalhe da mensagem.
//	 * 
//	 * @param sumarioMessagem
//	 * @param detalheMessagem
//	 */
//	public void addMessageInfo( String idComponent, String detalheMessagem ) {
//
//		try {
//
//			this.addMessageGenerica( idComponent, detalheMessagem, FacesMessage.SEVERITY_INFO );
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	/**
//	 * Adiciona uma mensagem de aviso (warn) a página. Recebe o sumário (titulo) e o detalhe da mensagem.
//	 * 
//	 * @param sumarioMessagem
//	 * @param detalheMessagem
//	 */
//	public void addMessageWarn( String idComponent, String detalheMessagem ) {
//
//		try {
//
//			this.addMessageGenerica( idComponent, detalheMessagem, FacesMessage.SEVERITY_WARN );
//
//			this.msgErro = true;
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	/**
//	 * Adiciona uma mensagem de erro a página. Recebe o sumário (titulo) e o detalhe da mensagem.
//	 * 
//	 * @param sumarioMessagem
//	 * @param detalheMessagem
//	 */
//	public void addMessageErro( Exception exception, String detalheMessagem ) {
//
//		try {
//
//			exception.printStackTrace();
//
//			this.addMessageGenerica( null, detalheMessagem, FacesMessage.SEVERITY_ERROR );
//
//			this.msgErro = true;
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	/**
//	 * Adciona uma mensagem generica do tipo informado por parâmetro.
//	 * 
//	 * @param idComponente
//	 * @param mensagemSumario
//	 * @param mensagemDetalhe
//	 * @param facesMessage
//	 * @throws Exception
//	 */
//	private void addMessageGenerica( String idComponent, String mensagemDetalhe, FacesMessage.Severity facesMessageSeverity ) throws Exception {
//
//		String summary = null;
//
//		if ( FacesMessage.SEVERITY_INFO.equals( facesMessageSeverity ) ) {
//
//			summary = "Informações";
//
//		} else if ( FacesMessage.SEVERITY_WARN.equals( facesMessageSeverity ) ) {
//
//			summary = "Atenção";
//
//		} else if ( FacesMessage.SEVERITY_ERROR.equals( facesMessageSeverity ) ) {
//
//			summary = "Erro";
//
//		}
//
//		FacesContext.getCurrentInstance().addMessage( "", new FacesMessage( facesMessageSeverity, summary, mensagemDetalhe ) );
//
//		if ( idComponent != null ) {
//
//			Object obj = FacesContext.getCurrentInstance().getViewRoot().findComponent( ":formMaster:" + idComponent );
//
//			if ( obj instanceof UIInput ) {
//
//				( (UIInput)obj ).setValid( false );
//
//			}
//
//		}
//
//	}
//
//	/**
//	 * Seta o objeto na sessão.
//	 * 
//	 * @param <M>
//	 * @param nome
//	 * @param objeto
//	 */
//	public <M> void setObjetoSessao( String nome, M objeto ) {
//
//		try {
//
//			this.getSessionMap().put( nome, objeto );
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//	/**
//	 * Responsável por buscar o objeto na sessão do usuário corrente.
//	 * 
//	 * @param nome
//	 * @return Object - Objeto guardado na sessão do usuário corrente.
//	 */
//	public Object getObjetoSessao( String nome ) {
//
//		try {
//
//			Object obj = this.getSessionMap().get( nome );
//
//			return obj;
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//			return null;
//
//		}
//
//	}
//
//	/**
//	 * Responsável por remover o objeto da sessão do usuário corrente.
//	 * 
//	 * @param nome
//	 * @return Object - Objeto a ser removido na sessão do usuário corrente.
//	 */
//	public Object removeObjetoSessao( String nome ) {
//
//		try {
//
//			return this.getSessionMap().remove( nome );
//
//		} catch ( Exception e ) {
//
//			e.printStackTrace();
//
//			return null;
//
//		}
//
//	}
//
//	/**
//	 * Executa o comando JavaScript passado por parâmetro.
//	 * 
//	 * @param comando
//	 */
////	public void jsExecute( String comando ) {
////
////		try {
////
////			RequestContext.getCurrentInstance().execute( comando );
////
////		} catch ( Exception e ) {
////
////			e.printStackTrace();
////
////		}
////
////	}
//
//	/**
//	 * Executa o Update no campo passado por parâmetro.
//	 * 
//	 * @param IdCampo
//	 */
////	public void updateField( String IdCampo ) {
////
////		try {
////
////			RequestContext.getCurrentInstance().update( IdCampo );
////
////		} catch ( Exception e ) {
////
////			e.printStackTrace();
////		}
////
////	}
//
//	/**
//	 * Retorna o HttpServletResponse corrente.
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public HttpServletResponse getHttpServletResponse() throws Exception {
//
//		HttpServletResponse response = (HttpServletResponse)this.getExternalContext().getResponse();
//
//		if ( response != null ) { return response; }
//
//		throw new Exception( "ERRO: HttpServletResponse não encontrado" );
//	}
//
//	/**
//	 * Retorna o HttpServletRequest corrente.
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public HttpServletRequest getHttpServletRequest() throws Exception {
//
//		HttpServletRequest request = (HttpServletRequest)this.getExternalContext().getRequest();
//
//		if ( request != null ) { return request; }
//
//		throw new Exception( "ERRO: HttpServletRequest não encontrado" );
//	}
//
//	/**
//	 * Retorna o HttpSession corrente.
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	public HttpSession getHttpSession() throws Exception {
//
//		HttpSession session = this.getHttpServletRequest().getSession();
//
//		if ( session != null ) { return session; }
//
//		throw new Exception( "ERRO: HttpSession não encontrado" );
//	}
//
//	/**
//	 * Invalida sessão corrente.
//	 * 
//	 * @throws Exception
//	 */
//	public void invalidarSessao() throws Exception {
//
//		this.getHttpSession().invalidate();
//
//	}
//
//	/**
//	 * Retorna o ExternalContext corrente.
//	 * 
//	 * @return
//	 * @throws Exception - lança erro quando o ExternalContext não é encontrado.
//	 */
//	private ExternalContext getExternalContext() throws Exception {
//
//		ExternalContext ext = this.getFacesContextCurrentInstance().getExternalContext();
//
//		if ( ext != null ) { return ext; }
//
//		throw new Exception( "ERRO: ExternalContext não encontrado" );
//	}
//
//	/**
//	 * Retorna o FacesContext corrente.
//	 * 
//	 * @return
//	 * @throws Exception - lança erro quando o FacesContext não é encontrado.
//	 */
//	protected FacesContext getFacesContextCurrentInstance() throws Exception {
//
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//
//		if ( facesContext != null ) { return facesContext; }
//
//		throw new Exception( "ERRO: FacesContext não encontrado" );
//	}
//
//	@SuppressWarnings( "unchecked" )
//	public <T> T getObjetoEL( Class<T> objClass, String el ) {
//
//		FacesContext facesContext = FacesContext.getCurrentInstance();
//
//		ExpressionFactory elFactory = facesContext.getApplication().getExpressionFactory();
//
//		ValueExpression valueExp = elFactory.createValueExpression( facesContext.getELContext(), el, objClass );
//
//		T obj = (T)valueExp.getValue( facesContext.getELContext() );
//
//		return obj;
//
//	}
//
//	protected void removeView( String viewID ) {
//
//		FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove( viewID );
//
//	}
//
////	protected void addCallbackParam( String key, Object value ) {
////		RequestContext.getCurrentInstance().addCallbackParam( key, value );
////	}
//
//	protected void addMessageInfoNoDetail( String summary ) {
//
//		addMessage( summary, "", FacesMessage.SEVERITY_INFO );
//
//	}
//
//	protected void addMessageWarnNoDetail( String summary ) {
//
//		addMessage( summary, null, FacesMessage.SEVERITY_WARN );
//
//	}
//
//	protected void addMessageErrorNoDetail( String summary ) {
//
//		addMessage( summary, null, FacesMessage.SEVERITY_ERROR );
//
//	}
//
//	private void addMessage( String summary, String detail, FacesMessage.Severity severity ) {
//
//		FacesContext.getCurrentInstance().addMessage( null, new FacesMessage( severity, summary, detail ) );
//
//	}
//
//	protected Principal getUserPrincipal() {
//
//		try {
//			return getExternalContext().getUserPrincipal();
//		} catch ( Exception e ) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}
//
//	public boolean isAutorizado( String role ) {
//		try {
//			return getHttpServletRequest().isUserInRole( role );
//		} catch ( Exception e ) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//	}
//
//	public void logout() throws Exception {
//		FacesContext fc = FacesContext.getCurrentInstance();
//		HttpSession session = (HttpSession)fc.getExternalContext().getSession( false );
//		session.invalidate();
//		FacesContext.getCurrentInstance().getExternalContext().redirect( "index.jsf" );
//	}
//	
//	protected void addCallBackSucesso() {
//		
//		addCallbackParam("sucesso", true);
//		
//	}
//	
//	protected void addCallBackFracasso() {
//		
//		addCallbackParam("sucesso", false);
//		
//	}

}
