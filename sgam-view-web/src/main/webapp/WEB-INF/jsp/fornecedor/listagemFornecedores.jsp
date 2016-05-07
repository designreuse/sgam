<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">

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
                 <strong>Fornecedores</strong>
             </li>

			<div class="pull-right">
            	<a class="label label-primary" href="${linkTo[FornecedorController].formularioFornecedor}">Novo</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemFornecedores" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome</th>
								<th>Celular</th>
								<th>Telefone</th>
								<th>Cidade</th>
								<th>Bairro</th>
								<th>Rua</th>
								<th>Física/Jurídica</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="fornecedor" items="${fornecedores}">
								<tr class="linhaFornecedor">
									<td>${fornecedor.nome}</td>
									<td>${fornecedor.celular}</td>
									<td>${fornecedor.telefone}</td>
									<td>${fornecedor.endereco.cidade}</td>
									<td>${fornecedor.endereco.bairro}</td>
									<td>${fornecedor.endereco.rua}</td>
									<td>Definir</td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<a title="Editar" class="editar" href="${linkTo[FornecedorController].editarFornecedor(fornecedor.id)}"> <i class="fa fa-edit"></i> </a> &nbsp; 
										<a title="Excluir" class="remover" href="${linkTo[FornecedorController].removeFornecedor(fornecedor.id)}"> <i class="fa fa-trash-o"></i> </a> 
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

	<script src="${pageContext.request.contextPath}/js/paginas/listagemFornecedores.js"></script>

﻿<%@ include file="/footer.jsp" %>