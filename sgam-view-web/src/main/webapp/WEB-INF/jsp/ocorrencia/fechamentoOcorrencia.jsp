<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

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
 
 <div class="wrapper wrapper-content  animated fadeInRight">
	 <div class="row">
	     <div class="col-sm-8">
	         <div class="ibox float-e-margins">
	             <div class="ibox-content no-padding ">
	             	<div id="descricaoFechamentoOcorrencia" class="click2edit wrapper p-md" >
	             		<div class="height-scroll">
	             			${ocorrencia.descricao}
	             		</div>
	             	</div>
	             </div>
	       	</div>
	  	</div>
	  	<div class="col-sm-4">
			<div class="ibox">
            	<div class="ibox-content">
            		<h2>${ocorrencia.morador.nome}</h2>
					<div class="table-responsive">
	           	     	<table class="table table-striped table-hover">
	           	     		<tbody>
	           	     			<tr>
	           	     				<td> <i class="fa fa-envelope"> </i> </td>
	           	     				<td> ${ocorrencia.morador.email}  </td>
	           	     			</tr>
	           	     			
	           	     			<tr>
	           	     				<td> <i class="fa fa-mobile-phone"> </i> </td>
	           	     				<td> ${ocorrencia.morador.telefoneCelular}  </td>
	           	     			</tr>
	           	     			
	           	     			<tr>
	           	     				<td> <i class="fa fa-phone"> </i> </td>
	           	     				<td> ${ocorrencia.morador.telefoneResidencial} </td>
	           	     			</tr>
	           	     		</tbody>
	           	     	</table>
           	     	</div>
                     
                     <strong>Detalhes da ocorrência</strong>

                     <ul class="list-group clear-list">
                     
                     	 <li class="list-group-item fist-item">
                             <span class="pull-right"> ${ocorrencia.titulo} </span>
                             Título
                         </li>
                         <li class="list-group-item">
                         	<c:choose>
								<c:when test="${ocorrencia.status eq 'Aberto'}">
									<span class="pull-right"> <span class="label label-danger">${ocorrencia.status}</span> </span>
								</c:when>
								
								<c:otherwise>
									<span class="pull-right"> <span class="label label-primary">${ocorrencia.status}</span> </span>
								</c:otherwise>
							</c:choose>
							
                             Status
                         </li>
                         <li class="list-group-item">
                         	<c:choose>
								<c:when test="${ocorrencia.prioridade eq 'Baixa'}">
									<span class="pull-right"> <span class="label label-primary">${ocorrencia.prioridade}</span> </span>
								</c:when>
								
								<c:when test="${ocorrencia.prioridade eq 'Média'}">
									<span class="pull-right"> <span class="label label-warning">${ocorrencia.prioridade}</span> </span>
								</c:when>
								
								<c:otherwise>
									<span class="pull-right"> <span class="label label-danger">${ocorrencia.prioridade}</span> </span>
								</c:otherwise>
							</c:choose>
							
                             Prioridade
                         </li>
                         <li class="list-group-item">
                             <span class="pull-right"> ${ocorrencia.pontoReferencia} </span>
                             Ponto referência
                         </li>
                         <li class="list-group-item">
                             <span class="pull-right" id="dataInicioFechamentoOcorrencia"> <fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataInicio}" /> </span>
                             Data abertura
                         </li>
                         <li class="list-group-item">
                             <span class="pull-right"> <input id="dataFechamento" type="text" class="form-control" size="10" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataFim}" />"  data-mask="99/99/9999" > </span>
                             Data fechamento
                         </li>
                     </ul>
                     
                     <div class="row">
						<div class="col-lg-12">
							<div class="ibox-content">
								<div class="form-group">
				                    <div class="col-sm-12">
					                    <form method="post" class="form-horizontal" action="${linkTo[OcorrenciaController].resolverOcorrencia}">
						                    
						                    <input type="hidden" name="ocorrencia.id"              value="${ocorrencia.id}" />
						                    <input type="hidden" name="ocorrencia.morador.id"      value="${ocorrencia.morador.id}" />
						                    <input type="hidden" name="ocorrencia.titulo"          value="${ocorrencia.titulo}" />
						                    <input type="hidden" name="ocorrencia.status"          value="${ocorrencia.status}" />
						                    <input type="hidden" name="ocorrencia.prioridade"      value="${ocorrencia.prioridade}" />
						                    <input type="hidden" name="ocorrencia.local"           value="${ocorrencia.local}" />
						                    <input type="hidden" name="ocorrencia.pontoReferencia" value="${ocorrencia.pontoReferencia}" />
						                    <input type="hidden" name="ocorrencia.dataInicio" id="dataInicioHidden" />
						                    <input type="hidden" name="ocorrencia.descricao"  id="descricaoHidden" />
						                    <input type="hidden" name="ocorrencia.dataFim"    id="dataFechamentoHidden" />
						                    
						                    <a class="btn btn-outline btn-default" href="${linkTo[OcorrenciaController].listagemOcorrencias}"> Cancelar</a>
					                        <button id="btnSalvar" class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
					                    </form>
				                        
				                        
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
	</div>
</div>

   	<script src="${pageContext.request.contextPath}/js/plugins/datapicker/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/summernote/summernote.min.js"></script>

	<script src="${pageContext.request.contextPath}/js/paginas/fechamentoOcorrencia.js"></script>
	
	﻿<%@ include file="/footer.jsp" %>
                       	