<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

    <link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">

<head>
	<script type="text/javascript">
	window.onload = function(){
		$('#nome').focus();
	}

	</script>
</head>
<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Moradores</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <a href="${linkTo[MoradorController].listagemMoradores}"><strong>Moradores</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[MoradorController].listagemMoradores}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[MoradorController].cadastraMorador}">
			<div class="col-lg-6">
		        <div class="ibox-content">
	         		<input type="hidden" name="morador.id" value="${morador.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input id="nome" type="text" class="form-control" name="morador.nome" value="${morador.nome}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">CPF</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.cpf" value="${morador.cpf}" data-mask="999.999.999-99">
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataNascimento">
	             		<label class="col-sm-4 control-label">Data Nascimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="morador.dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${morador.dataNascimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Anos no Bairro</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.inicioMoradia" value="${morador.inicioMoradia}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Telefone Fixo</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.telefoneResidencial" value="${morador.telefoneResidencial}" data-mask="9999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Celular</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.telefoneCelular" value="${morador.telefoneCelular}" data-mask="99999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Email</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.email" value="${morador.email}">
	                    </div>
	                </div>
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[MoradorController].listagemMoradores}"> Cancelar</a>
			                        <button class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
			                    </div>
			                </div>			
						</div>
					</div>
				</div>	
				
				<ul class="errors">
					<c:forEach items="${errors}" var="error">
						<li>
							${error.category}: ${error.message}
						</li>
					</c:forEach>
				</ul>
				
		    </div> 

		    <div class="col-lg-6">
			    <div class="ibox-content">
		   			<div class="form-group">
		            	<label class="col-sm-4 control-label">Endereço</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="morador.endereco.rua" value="${morador.endereco.rua}">
		                </div>
		        	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Número</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="morador.endereco.numero" value="${morador.endereco.numero}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Bairro</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="morador.endereco.bairro" value="${morador.endereco.bairro}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Cidade</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="morador.endereco.cidade" value="${morador.endereco.cidade}">
		                </div>
		          	</div>
			    </div> 
			    
			    <br/>
			    
			    <div class="row">
			    	<div class="col-lg-12">
			    		<div class="ibox-content">
					    	<div class="form-group">
			                	<label class="col-sm-4 control-label">Morador<br/>
			                		<small class="text-navy">Morador Associado?</small>
			                	</label>
			                    <div class="col-sm-8">
			                        <div class="i-checks">
			                        	<label>
			                        		<input type="radio" name="morador.associado" value="Sim" <c:if test="${morador.associado eq 'Sim' }">checked="checked"</c:if> > <i></i> 
			                        		Sim, associado. 
			                        	</label>
			                        </div>
			                        
			                        <div class="i-checks">
			                        	<label> 
			                        		<input type="radio" name="morador.associado" value="Não" <c:if test="${morador.associado == null || morador.associado eq 'Não' }">checked="checked"</c:if> > <i></i> 
			                        		Não, não associado. 
			                        	</label>
			                        </div>
			                    </div>
			                </div>
			                
			                <div class="form-group">
			                	<label class="col-sm-4 control-label">Vencimento</label>
			                    <div class="col-sm-8">
			                    	<select class="form-control m-b" name="morador.diaPagamento">
			                         <option value="0">Selecione</option>
			                         <option value="5"  <c:if test="${morador.diaPagamento == 5}">selected="selected"</c:if> >5</option>
			                         <option value="10" <c:if test="${morador.diaPagamento == 10}">selected="selected"</c:if> >10</option>
			                         <option value="15" <c:if test="${morador.diaPagamento == 15}">selected="selected"</c:if> >15</option>
			                         <option value="20" <c:if test="${morador.diaPagamento == 20}">selected="selected"</c:if> >20</option>
			                         <option value="25" <c:if test="${morador.diaPagamento == 25}">selected="selected"</c:if> >25</option>
			                         <option value="30" <c:if test="${morador.diaPagamento == 30}">selected="selected"</c:if> >30</option>
			                    	</select>
			                    </div>
			                </div>
		                </div>
			    	</div>
			    </div>
		   	</div> 
	   	
	   	</form>         
    </div>
</div>

   <script src="${pageContext.request.contextPath}/js/plugins/jasny/jasny-bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    
   <script src="${pageContext.request.contextPath}/js/paginas/formularioMorador.js"></script>

﻿<%@ include file="/footer.jsp" %>

