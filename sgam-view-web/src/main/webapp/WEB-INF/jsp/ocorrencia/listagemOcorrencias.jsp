<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

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
                 <strong>Ocorrências</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-primary" href="${linkTo[OcorrenciaController].formularioOcorrencia}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemOcorrencias" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Ocorrências</th>
								<th>Morador</th>
								<th>Data Inicio</th>
								<th>Data Fim</th>
								<th>Status</th>
								<th>Prioridade</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="ocorrencia" items="${ocorrencias}">
								<tr class="linhaOcorrencia">
									<td>${ocorrencia.titulo}</td>
									<td>${ocorrencia.morador.nome}</td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataInicio}" /> </td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataFim}" /> </td>
									
									<c:choose>
										<c:when test="${ocorrencia.status eq 'Aberto'}">
											<td><span class="label label-danger">${ocorrencia.status}</span></td>
										</c:when>
										
										<c:otherwise>
											<td><span class="label label-primary">${ocorrencia.status}</span></td>
										</c:otherwise>
									</c:choose>
									
									<c:choose>
										<c:when test="${ocorrencia.prioridade eq 'Baixa'}">
											<td><span class="label label-primary">${ocorrencia.prioridade}</span></td>
										</c:when>
										
										<c:when test="${ocorrencia.prioridade eq 'Média'}">
											<td><span class="label label-warning">${ocorrencia.prioridade}</span></td>
										</c:when>
										
										<c:otherwise>
											<td><span class="label label-danger">${ocorrencia.prioridade}</span></td>
										</c:otherwise>
									</c:choose>
									
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[OcorrenciaController].editarOcorrencia(ocorrencia.id)}"> <i class="fa fa-edit"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[OcorrenciaController].removerOcorrencia(ocorrencia.id)}"> <i class="fa fa-trash-o"></i> </a> &nbsp;
										<a title="Resolver" class="resolver" href="${linkTo[OcorrenciaController].fechamentoOcorrencia(ocorrencia.id)}" > <i class="fa fa-check-square-o"></i> </a>   
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	    </div>            
    </div>
    
    <div class="modal inmodal fade" id="modalResolver" tabindex="-1" role="dialog"  aria-hidden="true">
         <div class="modal-dialog modal-lg">
             <div class="modal-content">
                 <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                     <h4 class="modal-title" id="modalTituloOcorrencia"> </h4>
                     <small class="font-bold" id="modalDetalhesOcorrencia"> </small>
                 </div>
                 <div class="modal-body">
                 	<div class="container-fluid">
          				<div class="row">
          				</div>
          			</div>
                 </div>

                 <div class="modal-footer">
                     <button type="button" class="btn btn-white" data-dismiss="modal">Fechar</button>
                     <button type="button" class="btn btn-primary">Salvar</button>
                 </div>
             </div>
         </div>
     </div>
     
</div>

<script src="${pageContext.request.contextPath}/js/paginas/listagemOcorrencias.js"></script>

﻿<%@ include file="/footer.jsp" %>