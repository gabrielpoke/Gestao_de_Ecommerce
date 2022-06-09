<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page import="VO.Categoria"%>

<!DOCTYPE html>
<html>
<html>
		<head>
			<meta charset="ISO-8859-1">
			<title>Editar cadastro Categoria</title>
		</head>
		<link
	      rel="stylesheet"
	      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	    />
	    <link rel="stylesheet" type="text/css" href="css/form.css" />
	    <link rel="stylesheet" type="text/css" href="css/body-padrao.css" />
	    <link rel="stylesheet" type="text/css" href="css/footer.css" />
	    <link rel="stylesheet" type="text/css" href="css/navBar.css" />
	    <link rel="stylesheet" type="text/css" href="css/table.css" />
	  </head>
	
	  <header>
	    <ul>
	      <li><a href="index.jsp">Home</a></li>
	      <li><a href="CadastroProdutos.jsp">Produtos</a></li>
	      <li><a href="CadastroPedido.jsp">Pedidos</a></li>
	      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
	      <li><a href="CadastroClientes.jsp">Clientes</a></li>
	      <li><a href="CadastroCargos.jsp">Cargos</a></li>
	      <li><a href="CadastroCategoria.jsp" class="active">Categorias</a></li>
	    </ul>
	  </header>
  
	<body>
		<div class="container body-content">
     	 <div class="formulario">
			<form action="EditarCategoria" method="post">
				<center>
            		<legend>
              			<h2>Atualizar cadastro Categoria</h2>
            		</legend>
          		</center>
					
				<div>
					<label> Codigo:</label> 
					<input 
					class="input-class"
	              	maxlength="100"
	              	type="text"
	              	id="codigo"
	              	name="codigo"
	              	value="<c:out value="${categoriasI.codigo}"/>"
	              	required
	              	readonly
	              	/>
				</div>
					
          		<div>
					<label> Nome*:</label> 
					<input 
					class="input-class"
	              	maxlength="100"
	              	type="text"
	              	id="nome"
	              	name="nome"
	              	placeholder="Digite nome..."
	              	value="<c:out value="${categoriasI.nome}"/>"
	              	required
	              	/>
				</div>
			
				<div>
					<label> Descrição*: </label>
					<input class="input-class"
	              	maxlength="500"
	              	type="text"
	              	id="descricao"
	              	name="descricao"
	              	placeholder="Digite Descrição..."
	              	value="<c:out value="${categoriasI.descricao}"/>"
	              	required
	              	/>
				</div>
				
				<div class="button">
            		<button type="submit" onclick="validar()">
              			Atualizar
            		</button>
            		
            		<button type="reset">
            			Limpar
            		</button>
          		</div>
          		
          		<div class="button">		
					<a href="ListaCategoria"> Cancelar </a>
				</div>
			</form>
			</div>
		</div>
	</body>
</html>