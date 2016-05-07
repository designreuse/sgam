<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 
<%@ include file="/moradorModal.jsp" %> 

    <link href="${pageContext.request.contextPath}/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">
    
    <link href="${pageContext.request.contextPath}/css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Ocorrências</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <a href="${linkTo[OcorrenciaController].listagemOcorrencias}"><strong>Ocorrências</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[OcorrenciaController].listagemOcorrencias}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<form method="post" class="form-horizontal" action="${linkTo[OcorrenciaController].cadastraOcorrencia}">
 		
 		<input type="hidden" name="ocorrencia.id" value="${ocorrencia.id }"/>
		<input type="hidden" name="ocorrencia.status" value="${ocorrencia.status }"/>
		
		<input type="hidden" id="idMorador" name="ocorrencia.morador.id" value="${ocorrencia.morador.id }"/>
 		
 		<div class="row">
	 		
	    	<div class="col-lg-7">
	    		<div class="ibox float-e-margins">
		    	<div class="ibox-content no-padding">
					<div id="descricaoOcorrencia" class="summernote wrapper p-md ">
	             		${ocorrencia.descricao}
					</div>
					<input id="descricaoOcorrenciaHidden" type="hidden" name="ocorrencia.descricao" />
	           	</div>
	           	</div>
	    	</div>

		 	<div class="col-lg-5">
		 		<div class="ibox-content">
			 		<div class="form-group">
			 			<label class="col-sm-2 control-label">Título</label>
						<div class="col-sm-10">
							<input id="titulo" type="text" class="form-control" name="ocorrencia.titulo" value="${ocorrencia.titulo}">
						</div>
					</div>
					
		            <div class="form-group">
		            	<label class="col-sm-2 control-label">Morador</label>
		                <div class="col-sm-10">
		                	<div class="input-group">
		                		<input id="nomeMorador" type="text" class="form-control" name="ocorrencia.morador.nome" value="${ocorrencia.morador.nome}">
		                		<a class="input-group-addon" data-target="#modalSelecaoMorador" data-toggle="modal"><i class="fa fa-user"></i></a>
		                	</div>
		            	</div>
		            </div>
		               
	               	<div class="form-group">
	            		<label class="col-sm-2 control-label">Local</label>
	                   	<div class="col-sm-10">
	                   		<input id="local" type="text" class="form-control" name="ocorrencia.local" value="${ocorrencia.local}" >
	                   	</div>
	               	</div>
	              
	               	<div class="form-group">
	            		<label class="col-sm-2 control-label">Refer.</label>
	                   	<div class="col-sm-10">
	                   		<input id="referencia" type="text" class="form-control" name="ocorrencia.pontoReferencia" value="${ocorrencia.pontoReferencia}" >
	                   	</div>
	               	</div>
		               
	               	<div class="form-group" id="dataInicio">
	               		<label class="col-sm-2 control-label">Data</label>
	                   	<div class="col-sm-10">
		                   	<div class="input-group date">
		                   		<input id="dataInicial" type="text" class="form-control" name="ocorrencia.dataInicio" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataInicio}" />"  data-mask="99/99/9999" >
		                   		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		                   	</div>
	                   	</div>
	               	</div>
		              
		         	<div class="form-group">
						<label class="col-sm-2 control-label">Prioridade</label>
						<div class="col-sm-10">
							<div class="radio radio-danger pull-right">
								<input id="option1" type="radio" name="ocorrencia.prioridade" value="Alta" <c:if test="${ocorrencia.prioridade eq 'Alta'}">checked="checked"</c:if> >
								<label for="option1">Alta</label>
							</div>
							
							<div class="radio radio-warning pull-right">
								<input id="option2" type="radio" name="ocorrencia.prioridade" value="Média" <c:if test="${ocorrencia.prioridade eq 'Média'}">checked="checked"</c:if> >
								<label for="option2">Média</label>
							</div>
							
							<div class="radio radio-success pull-right">
								<input id="option3" type="radio" name="ocorrencia.prioridade" value="Baixa" <c:if test="${ocorrencia.prioridade == null || ocorrencia.prioridade eq 'Baixa'}">checked="checked"</c:if> >
								<label for="option3">Baixa</label>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<div class="ibox-content">
								<div class="form-group">
				                    <div class="col-sm-12">
				                        <a class="btn btn-outline btn-default" href="${linkTo[OcorrenciaController].listagemOcorrencias}"> Cancelar</a>
				                        <button id="btnSalvar" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
				                        
				                        <ul class="errors">
											<c:forEach items="${errors}" var="error">
												<li>
													${error.category}: ${error.message}
												</li>
											</c:forEach>
										</ul>
				                    </div>
				                </div>			
							</div>
						</div>
					</div>
		 		</div>  
	 		</div> 
	    </div>

		
    </form>	
</div>

   	<script src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/summernote/summernote.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/paginas/formularioOcorrencia.js"></script>

﻿<%@ include file="/footer.jsp" %>