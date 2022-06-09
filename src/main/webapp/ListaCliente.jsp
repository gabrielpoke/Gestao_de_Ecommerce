<%@page import="java.util.ArrayList"%>
<%@page import="VO.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Clientes Cadastrados</title>
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
      <li><a href="CadastroPedido.jsp">Pedidos</a></li>
      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp" class="active">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
      <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <center>
        <div class="tabela">
          <center>
            <legend>
              <h2>Listagem de Clientes</h2>
            </legend>
          </center>

          <table border="2">
            <tr>
              <th>C�digo</th>
              <th>Nome</th>
              <th>Email</th>
              <th>telefone</th>
              <th>endereco</th>
              <th>bairro</th>
              <th>cidade</th>
              <th>cep</th>
              <th>cpf</th>
              <th>Ativo</th>
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
                <c:out value="${item.nome}" />
              </td>
              <td>
                <c:out value="${item.email}" />
              </td>
              <td>
                <c:out value="${item.telefone}" />
              </td>
              <td>
                <c:out value="${item.endereco}" />
              </td>
              <td>
                <c:out value="${item.bairro}" />         
              </td>
              <td>
              	<c:out value="${item.cidade}" />  
              </td>
              <td>
                <c:out value="${item.cep}" />
              </td>
              <td>
                <c:out value="${item.cpf}" />
              </td>
              <td>
                <c:out value="${item.ativo}" />
              </td>
              <td>
		    		<a href="ApagarCliente?codigo=<c:out value="${item.codigo}"/>"> Apagar </a>
		    		<a href="EditarCliente?codigo=<c:out value="${item.codigo}"/>"> Editar </a>
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