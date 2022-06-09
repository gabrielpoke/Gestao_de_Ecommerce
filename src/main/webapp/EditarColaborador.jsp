<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
  <head>
    <title>Editar cadastro de Colaboradores</title>
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
      <li><a href="CadastroColaborador.jsp" class="active">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
      <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <div class="formulario">
        <form class="form" id="formularioColaborador" action="EditarColaborador" method="post">
          <center>
            <legend>
              <h2>Atualizar cadastro Colaboradores</h2>
            </legend>
          </center>

          <div>
            <label>* Codigo:</label>
            <input
              class="input-class"
              maxlength="3"
              
              type="text"
              id="codigo"
              name="codigo"
              placeholder="Digite codigo..."
              value="<c:out value="${colaboradorInf.codigo}" />"
              required
              readonly
            />
          </div>

          <div>
            <label>* Nome:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              placeholder="Digite seu nome..."
              id="nome"
              name="nome"
              value="<c:out value="${colaboradorInf.nome}" />"
              required
            />
          </div>

          <div>
            <label>* Cargo:</label>
            <input
              class="input-class"
              type="text"
              id="cargo"
              placeholder="Digite seu Cargo..."
              name="cargo"
              value="<c:out value="${colaboradorInf.cargo.codigo}" />"
              required
            />
          </div>

          <div>
            <label>* E-mail:</label>
            <input
              class="input-class"
              maxlength="50"
              type="email"
              id="email"
              name="email"
              placeholder="Example@hotmail.com"
              value="<c:out value="${colaboradorInf.email}" />"
              required
            />
          </div>

          <div>
            <label>Observação:</label>
            <textarea
              class="input-class"
              maxlength="100"
              id="observacoes"
              name="observacoes"
              placeholder="Observações aqui..."
              value="<c:out value="${colaboradorInf.observacao}" />"
            > <c:out value="${colaboradorInf.observacao}" /> </textarea>
          </div>

           <div>
           	<label for="ativos">Ativo:</label>
            <select name="ativos" id="ativos">
				<option value="<c:out value="${colaboradorInf.ativo}" />"> <c:out value="${colaboradorInf.ativo}" /> </option>
				<option value=true> Sim </option>
				<option value=false> Não </option>
			</select>
           </div>

          <div class="button">
            <button type="submit" onclick="validar()">
              Atualizar 
            </button>
            <button type="reset">Limpar</button>
          </div>

          <div class="button">
            <a href="ListaColaborador"> Cancelar </a>
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

<script src="js/Valida-CadastroColaborador.js"></script>
