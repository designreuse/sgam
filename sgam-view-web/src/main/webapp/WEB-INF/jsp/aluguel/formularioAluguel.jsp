<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 
<%@ include file="/moradorModal.jsp" %>

<link href="../css/plugins/datapicker/datepicker3.css" rel="stylesheet">
<link href="../css/plugins/daterangepicker/daterangepicker-bs3.css" rel="stylesheet">


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
                 <a href="${linkTo[AluguelController].listagemAluguel}"><strong>Faturamento</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[AluguelController].listagemAluguel}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[AluguelController].cadastraAluguel}">
			<div class="col-lg-6">
			<fieldset>
			    <legend>Geral</legend>
		        <div class="ibox-content">
		        
	         		<input type="hidden" name="aluguel.id" value="${aluguel.id }"/>
	         		<input id="idMorador" type="hidden" name="aluguel.morador.id" value="${aluguel.morador.id }"/>      		
	         	
	             	<div class="form-group">
		            	<label class="col-sm-4 control-label">Morador</label>
		                <div class="col-sm-8">
		                	<div class="input-group">
		                		<input id="nomeMorador" type="text" class="form-control" value="${aluguel.morador.nome}">
		                		<a class="input-group-addon" data-target="#modalSelecaoMorador" data-toggle="modal"><i class="fa fa-user"></i></a>
		                	</div>
		            	</div>
		            </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Recurso</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="aluguel.recurso.id">
	                         <option value="0">Selecione</option>
	                         <c:forEach items="${recursos}" var="recurso">
	                         	<option value="${recurso.id}" <c:if test="${aluguel.recurso.id == recurso.id}">selected="selected"</c:if> >${recurso.nome} </option>
	                         </c:forEach>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataInicial">
	             		<label class="col-sm-4 control-label">Período</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguel.dataInicial" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataInicial}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataFinal">
	             		<label class="col-sm-4 control-label"></label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguel.dataFinal" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataFinal}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Pagamento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguel.dataEmissaoFaturamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataEmissaoFaturamento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Observação</label>
	                    <div class="col-sm-8">
	                    	<textarea name="aluguel.observacao" class="form-control" rows="" cols="">${aluguel.observacao}</textarea>
	                    </div>
	                </div>
	                
				</div>
				</fieldset>
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[AluguelController].listagemAluguel}" > Cancelar</a>
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
		    <fieldset>
			    <legend>Comércio</legend>
			    <div class="ibox-content">
			    	
			    	<div class="form-group">
		            	<label class="col-sm-4 control-label">Nome</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguel.aluguelComercio.nome" value="${aluguel.aluguelComercio.nome}">
		                </div>
		        	</div>
			    	
		   			<div class="form-group">
		            	<label class="col-sm-4 control-label">Alvará</label>
		              	<div class="col-sm-8">
		            		<input type="text" class="form-control" name="aluguel.aluguelComercio.numeroAlvara" value="${aluguel.aluguelComercio.numeroAlvara}">
		                </div>
		        	</div>
		        	
		        	<div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Data Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguel.aluguelComercio.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.aluguelComercio.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group" id="dataPagamento">
	             		<label class="col-sm-4 control-label">Data Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="aluguel.aluguelComercio.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.aluguelComercio.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Largura</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguel.aluguelComercio.larguraBarraca" value="${aluguel.aluguelComercio.larguraBarraca}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Comprimento</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguel.aluguelComercio.comprimentoBarraca" value="${aluguel.aluguelComercio.comprimentoBarraca}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Quantidade Pessoas</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguel.aluguelComercio.qtdePessoas" value="${aluguel.aluguelComercio.qtdePessoas}">
		                </div>
		          	</div>
		               
		            <div class="form-group">
		            	<label class="col-sm-4 control-label">Equipamentos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguel.aluguelComercio.equipamentos" value="${aluguel.aluguelComercio.equipamentos}">
		                </div>
		          	</div>
		          	
		          	<div class="form-group">
		            	<label class="col-sm-4 control-label">Produtos</label>
		                <div class="col-sm-8">
		                	<input type="text" class="form-control" name="aluguel.aluguelComercio.produtos" value="${aluguel.aluguelComercio.produtos}">
		                </div>
		          	</div>
		          	
			    </div> 
			    </fieldset>
		   	</div> 
	   	</form>         
    </div>
</div>

   <script src="../js/plugins/jasny/jasny-bootstrap.min.js"></script>
   <script src="../js/plugins/datapicker/bootstrap-datepicker.js"></script>
    
   <script src="../js/paginas/formularioAluguel.js"></script>

﻿<%@ include file="/footer.jsp" %>

