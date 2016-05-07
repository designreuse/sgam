<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

    <link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Fornecedores</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <a href="${linkTo[FornecedorController].listagemFornecedores}"><strong>Fornecedores</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[FornecedorController].listagemFornecedores}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[FornecedorController].cadastraFornecedor}">
			<div class="col-lg-6">
		        <div class="ibox-content">
	         		<input type="hidden" name="fornecedor.id" value="${fornecedor.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.nome" value="${fornecedor.nome}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">CNPJ</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.cnpj" value="${fornecedor.cnpj}" data-mask="999.999.999/999-99">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">CPF</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.cpf" value="${fornecedor.cpf}" data-mask="999.999.999-99">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Telefone Fixo</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.telefone" value="${fornecedor.telefone}" data-mask="9999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Celular</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.celular" value="${fornecedor.celular}" data-mask="99999-9999">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Email</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="fornecedor.email" value="${fornecedor.email}">
	                    </div>
	                </div>
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[FornecedorController].listagemFornecedores}"> Cancelar</a>
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
		            		<input type="text" class="form-control" name="fornecedor.endereco.rua" value="${fornecedor.endereco.rua}">
		                </div>
		        	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Número</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="fornecedor.endereco.numero" value="${fornecedor.endereco.numero}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Bairro</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="fornecedor.endereco.bairro" value="${fornecedor.endereco.bairro}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Cidade</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="fornecedor.endereco.cidade" value="${fornecedor.endereco.cidade}">
		                </div>
		          	</div>
			    </div> 
			    
			    <br/>
			    
			    <div class="row">
			    	<div class="col-lg-12">
			    		<div class="ibox-content">
					    	<div class="form-group">
			                	<label class="col-sm-4 control-label">Fornecedor<br/>
			                		<small class="text-navy">Física / Jurídica</small>
			                	</label>
			                    <div class="col-sm-8">
			                        <div class="i-checks">
			                        	<label>
			                        		<input type="radio" name="" value="Física" <%-- <c:if test="${fornecedor.associado eq 'Sim' }">checked="checked"</c:if> --%> > <i></i> 
			                        		Física. 
			                        	</label>
			                        </div>
			                        
			                        <div class="i-checks">
			                        	<label> 
			                        		<input type="radio" name="" value="Jurídica" <%-- <c:if test="${fornecedor.associado == null || fornecedor.associado eq 'Não' }">checked="checked"</c:if> --%> > <i></i> 
			                        		Jurídica. 
			                        	</label>
			                        </div>
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
    
   <script src="${pageContext.request.contextPath}/js/paginas/formularioFornecedor.js"></script>

﻿<%@ include file="/footer.jsp" %>

