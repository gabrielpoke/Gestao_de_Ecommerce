<%@page import="java.util.ArrayList"%>
<%@page import="VO.Pedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Pedidos Cadastrados</title>
    <!-- Load an icon library -->
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
      <li><a href="CadastroPedido.jsp" class="active">Pedidos</a></li>
      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <center>
        <div class="tabela">
          <center>
            <legend>
              <h2>Listagem de pedidos</h2>
            </legend>
          </center>

          <table border="2">
            <tr>
              <th>C�digo</th>
              <th>Cliente</th>
              <th>colaborador</th>
              <th>Produto</th>
              <th>Actions</th>
            </tr>

            <c:forEach var="item" items="${lista}" varStatus="contador">
              <tr>
                <td>
                	<center>
                	  <c:out value="${item.codigo}" />
                	</center>
                </td>
                <td>
                  <c:out value="${item.cliente.nome}" />
                </td>
                <td>
                  <c:out value="${item.colaborador.nome}" />
                </td>
                <td>
                  <c:out value="${item.produto.nome}" />
                </td>
                <td>
		    		<a href="ApagarPedido?codigo=<c:out value="${item.codigo}"/>">Apagar</a>
		    		<a href="EditarPedido?codigo=<c:out value = "${item.codigo}"/>">Editar</a> 
		    	</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </center>
    </div>
  </body>

  <footer class="footer-distributed fixar-rodape">
    <div class="footer-left">
      <p>Gabriel Victor &copy; 2022</p>
    </div>
  </footer>
</html>
