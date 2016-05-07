<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

    <link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Recursos</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <a href="${linkTo[RecursoController].listagemRecursos}"><strong>Recursos</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[RecursoController].listagemRecursos}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[RecursoController].cadastraRecurso}">
			<div class="col-lg-6">
		        <div class="ibox-content">
	         		<input type="hidden" name="recurso.id" value="${recurso.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="recurso.nome" value="${recurso.nome}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Descrição</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="recurso.descricao" value="${recurso.descricao}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Valor</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="recurso.valor" value="${recurso.valor}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Medida</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="recurso.unidadeMedida">
	                         <option value="0">Selecione</option>
	                         <option value="Hora"  <c:if test="${recurso.unidadeMedida == 'Hora'}">selected="selected"</c:if> >Hora</option>
	                         <option value="Minuto" <c:if test="${recurso.unidadeMedida == 'Minuto'}">selected="selected"</c:if> >Minuto</option>
	                         <option value="Dia" <c:if test="${recurso.unidadeMedida == 'Dia'}">selected="selected"</c:if> >Dia</option>
	                    	</select>
	                    </div>
	                </div>
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[RecursoController].listagemRecursos}"> Cancelar</a>
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
    
   <script src="${pageContext.request.contextPath}/js/paginas/formularioRecurso.js"></script>

﻿<%@ include file="/footer.jsp" %>

