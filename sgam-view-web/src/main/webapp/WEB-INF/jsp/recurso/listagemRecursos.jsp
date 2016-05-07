<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 

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
                 <strong>Recursos</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-primary" href="${linkTo[RecursoController].formularioRecurso}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemRecursos" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome</th>
								<th>Valor</th>
								<th>Medida</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="recurso" items="${recursos}">
								<tr class="linhaRecurso">
									<td>${recurso.nome}</td>
									<td>${recurso.valor}</td>
									<td>${recurso.unidadeMedida}</td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[RecursoController].editar(recurso.id)}"> <i class="fa fa-edit"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[RecursoController].remover(recurso.id)}"> <i class="fa fa-trash-o"></i> </a> &nbsp;
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

<script src="${pageContext.request.contextPath}/js/paginas/listagemRecursos.js"></script>

﻿<%@ include file="/footer.jsp" %>