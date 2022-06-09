<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


    <!DOCTYPE html>
<html>
  <head>
    <title>Editar cadastro de Clientes</title>
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
      <li><a href="CadastroClientes.jsp" class="active">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
      <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <div class="formulario">
        <form class="form" id="formularioCliente" action="EditarCliente" method="post">
          <center>
            <legend>
              <h2>Atualizar cadastro Clientes</h2>
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
              value="<c:out value="${clienteInfo.codigo}" />"
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
              value="<c:out value="${clienteInfo.nome}" />"
              required
            />
          </div>

          <div>
            <label>* CPF:</label>
            <input
              class="input-class"
              maxlength="11"
              type="text"
              id="cpf"
              placeholder="Digite seu cpf..."
              name="cpf"
              value="<c:out value="${clienteInfo.cpf}" />"
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
              value="<c:out value="${clienteInfo.email}" />"
              required
            />
          </div>

          <div>
            <label>* Cidade:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              id="cidade"
              name="cidade"
              placeholder="Digite a sua cidade..."
              value="<c:out value="${clienteInfo.cidade}" />"
              required
            />
          </div>

          <div>
            <label>* Bairro:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              id="bairro"
              name="bairro"
              placeholder="Digite o seu bairro..."
              value="<c:out value="${clienteInfo.bairro}" />"
              required
            />
          </div>
          
          <div>
            <label>* Endereço:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              id="endereco"
              name="endereco"
              placeholder="Digite a sua endereço"
              value="<c:out value="${clienteInfo.endereco}" />"
              required
            />
          </div>

          <div>
            <label>* Telefone:</label>
            <input
              class="input-class"
              maxlength="13"
              type="text"
              id="telefone"
              placeholder="(xx) xxxxx-xxxx"
              name="telefone"
              value="<c:out value="${clienteInfo.telefone}" />"
              required
            />
          </div>

          <div>
            <label>* CEP:</label>
            <input
              class="input-class"
              maxlength="8"
              type="text"
              id="cep"
              name="cep"
              placeholder="00000-000"
              value="<c:out value="${clienteInfo.cep}" />"
              required
            />
          </div>

			<div>
            	<label for="ativos">Ativo:</label>
            	<select name="ativos" id="ativos">
					<option value="<c:out value="${clienteInfo.ativo}" />"> <c:out value="${clienteInfo.ativo}" /> </option>
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
            <a href="ListaCliente"
              > Cancelar </a
            >
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

<script src="js/valida-form-Clientes.js"></script>
    