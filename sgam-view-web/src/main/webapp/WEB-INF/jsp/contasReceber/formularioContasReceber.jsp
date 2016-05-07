<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

    <link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Contas a Receber</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Financeiro</span>
             </li>
             <li class="active">
                 <a href="${linkTo[ContasReceberController].listagemContasReceber}"><strong>Contas a Receber</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[ContasReceberController].listagemContasReceber}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[ContasReceberController].cadastraContasReceber}">
			<div class="col-lg-12">
		        <div class="ibox-content">
	         		<input type="hidden" name="contasReceber.id" value="${contasReceber.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Número</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="contasReceber.numero" value="${contasReceber.numero}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="contasReceber.nome" value="${contasReceber.nome}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Histórico</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="contasReceber.historico" value="${contasReceber.historico}" >
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataNascimento">
	             		<label class="col-sm-4 control-label">Data de Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="contasReceber.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contasReceber.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataNascimento">
	             		<label class="col-sm-4 control-label">Data de Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="contasReceber.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contasReceber.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Espécie</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="contasReceber.especiePagamento">
	                         <option value="0">Selecione</option>
	                         <option value="5">Dinheiro</option>
	                         <option value="5">Débito</option>
	                         <option value="5">Crédito</option>
	                         <option value="5">Cheque</option>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Valor</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="morador.inicioMoradia" value="${contasReceber.valor}" >
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

	   	</form>         
    </div>
</div>

   <script src="${pageContext.request.contextPath}/js/plugins/jasny/jasny-bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    
   <script src="${pageContext.request.contextPath}/js/paginas/formularioMorador.js"></script>

﻿<%@ include file="/footer.jsp" %>

