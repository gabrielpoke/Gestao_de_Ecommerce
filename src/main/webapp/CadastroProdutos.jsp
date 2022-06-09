<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Cadastro de Produtos</title>
    <meta charset="UTF-8" />
    <!-- Load an icon library -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
    <link rel="stylesheet" type="text/css" href="css/form.css" />
    <link rel="stylesheet" type="text/css" href="css/body-padrao.css" />
    <link rel="stylesheet" type="text/css" href="css/footer.css" />
    <link rel="stylesheet" type="text/css" href="css/navBar.css" />
  </head>

  <header>
    <ul>
      <li><a href="index.jsp">Home</a></li>
      <li><a href="CadastroProdutos.jsp" class="active">Produtos</a></li>
      <li><a href="CadastroPedido.jsp">Pedidos</a></li>
      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
      <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <div class="formulario">
        <form class="form" id="formularioColaborador" action="CadastroProdutos" method="post">
          <center>
            <legend>
              <h2>Cadastro Produtos</h2>
            </legend>
          </center>

          <div>
            <label>* Nome:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              placeholder="Digite o nome do produto..."
              id="nome"
              name="nome"
              value="<c:out value="${produtoDAO.nome}" />"
              required
            />
          </div>

          <div>
            <label>* Categoria:</label>
            <input
              class="input-class"
              type="number"
              id="categoria"
              placeholder="Digite a categoria..."
              name="categoria"
              value="<c:out value="${produtoDAO.categoria}" />"
              required
            />
          </div>

          <div>
            <label>* Quantd:</label>
            <input
              class="input-class"
              type="number"
              id="quantidade"
              name="quantidade"
              placeholder="Digite a Quantidade.."
              value="<c:out value="${produtoDAO.quantidade}" />"
              required
            /> 
          </div>

          <div>
            <label>* Preço:</label>
            <input
              class="input-class"
              type="number"
              id="preco"
              name="preco"
              placeholder="Digite o valor do produto.."
              value="<c:out value="${produtoDAO.preco}" />"
              required
            />
          </div>

          <div>
            <label>* Descrição:</label>
            <textarea
              class="input-class"
              rows="5"
              maxlength="300"
              id="descricao"
              name="descricao"
              placeholder="Descrições aqui..."
              value="<c:out value="${produtoDAO.descricao}" />"
              required
            ></textarea>
          </div>

    	<div>
           	<label for="ativos">Ativo:</label>
            <select name="ativos" id="ativos">
				<option value="<c:out value="${produtoDAO.ativo}" />">...</option>
				<option value=true> Sim </option>
				<option value=false> Não </option>
			</select>
           </div>

          <div class="button">
            <button type="submit" onclick="validar()">
              Cadastrar novo produto
            </button>
            <button type="reset">Limpar</button>
          </div>

          <div class="button">
            <a href="ListaProduto">Listar Produtos</a>
          </div>
        </form>
      </div>
    </div>
  </body>

  <footer class="footer-distributed fixar-rodape">
    <div class="footer-left">
      <p>Gabriel Victor &copy; 2022</p>
    </div>
  </footer>
</html>

<script src="js/valida-CadastroProdutos.js"></script>
    