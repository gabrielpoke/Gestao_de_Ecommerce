<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Cadastro de Cargos</title>
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
      <li><a href="CadastroProdutos.jsp">Produtos</a></li>
      <li><a href="CadastroPedido.jsp">Pedidos</a></li>
      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp">Clientes</a></li>
      <li><a href="CadastroCargos.jsp" class="active">Cargos</a></li>
      <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <div class="formulario">
        <form
          class="form"
          id="formularioCargo"
          action="CadastroCargos"
          method="post"
        >
          <center>
            <legend>
              <h2>Cadastro Cargos</h2>
            </legend>
          </center>

          <div>
            <label>* Nome:</label>
            <input
              maxlength="50"
              class="input-class"
              type="text"
              placeholder="Digite seu nome..."
              id="nome"
              name="nome"
              value="<c:out value="${cargoDAO.nome}" />"
              required
            />
          </div>

          <div>
            <label>Observação:</label>
            <textarea
              rows="5"
              maxlength="100"
              class="input-class"
              id="observacoes"
              name="observacoes"
              placeholder="Observações aqui..."
              value="<c:out value="${cargoDAO.observacao}" />"
            ></textarea>
          </div>

          <div>
            <label for="ativos">Ativo:</label>
            <select name="ativos" id="ativos">
				<option value="<c:out value="${cargoDAO.ativo}" />">...</option>
				<option value=true> Sim </option>
				<option value=false> Não </option>
			</select>
           </div>
            
          <div class="button">
            <button type="submit" onclick="validar()">
              Cadastrar novo cargo
            </button>
            <button type="reset">Limpar</button>
          </div>

          <div class="button">
            <a href="ListaCargos">Listar Cargos</a>
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

<script src="js/Valida-CadastroCargo.js"></script>
