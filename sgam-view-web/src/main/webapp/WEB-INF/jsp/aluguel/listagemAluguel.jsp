<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Faturamento</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <strong>Faturamento</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-primary" href="${linkTo[AluguelController].formularioAluguel}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemAluguel" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Morador</th>
								<th>Atividade</th>
								<th>Início Atividades</th>
								<th>Fim Atividades</th>
								<th>Alvará</th>
								<th>Vencimento Alvará</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="aluguel" items="${aluguelList}">
								<tr class="linhaAluguel">
									<td>${aluguel.morador.nome}</td>
									<td>${aluguel.aluguelComercio.nome}</td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataInicial}" /> </td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataFinal}" /> </td>
									<td>${aluguel.aluguelComercio.numeroAlvara}</td>
									<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.aluguelComercio.dataVencimento}" /> </td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[AluguelController].editarAluguel(aluguel.id)}"> <i class="fa fa-edit"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[AluguelController].removerAluguel(aluguel.id)}"> <i class="fa fa-trash-o"></i> </a> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	    </div>            
    </div>
</div>

	<script src="${pageContext.request.contextPath}/js/paginas/listagemAluguel.js"></script>

﻿<%@ include file="/footer.jsp" %>