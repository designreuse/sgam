<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Usuários</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <strong>Usuário</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-primary" href="${linkTo[UsuarioController].formularioUsuario}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemUsuarios" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Login</th>
								<th>Nome</th>
								<th>Email</th>
								<th>Telefone</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="usuario" items="${usuarios}">
								<tr class="linhaUsuario">
									<td>${usuario.login}</td>
									<td>${usuario.nome}</td>
									<td>${usuario.email}</td>
									<td>${usuario.telefone}</td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[UsuarioController].editarUsuario(usuario.id)}"> <i class="fa fa-edit"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[UsuarioController].removerUsuario(usuario.id)}"> <i class="fa fa-trash-o"></i> </a> 
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

	<script src="${pageContext.request.contextPath}/js/paginas/listagemUsuario.js"></script>

﻿<%@ include file="/footer.jsp" %>