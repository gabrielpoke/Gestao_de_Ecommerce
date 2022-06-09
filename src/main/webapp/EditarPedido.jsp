<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Editar cadastro de Pedidos</title>
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
      <li><a href="CadastroPedido.jsp" class="active">Pedidos</a></li>
      <li><a href="CadastroColaborador.jsp">Colaboradores</a></li>
      <li><a href="CadastroClientes.jsp">Clientes</a></li>
      <li><a href="CadastroCargos.jsp">Cargos</a></li>
       <li><a href="CadastroCategoria.jsp">Categorias</a></li>
    </ul>
  </header>

  <body>
    <div class="container body-content">
      <div class="formulario">
        <form
          class="form"
          id="formularioPedidos"
          action="EditarPedido"
          method="post"
        >
          <center>
            <legend>
              <h2>Atualizar Cadastro pedidos</h2>
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
              value="<c:out value="${pedidoDAO.codigo}" />"
              required
              readonly
            />
          </div>

          <div>
            <label>* Cod. Cliente:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              placeholder="Digite o codigo do Cliente..."
              id="codCliente"
              name="codCliente"
              value="<c:out value="${pedidoDAO.cliente.codigo}" />"
              required
            />
          </div>

          <div>
            <label>* Cod. Colaborador:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              placeholder="Digite o codigo do colaborador..."
              id="codColaborador"
              name="codColaborador"
              value="<c:out value="${pedidoDAO.colaborador.codigo}" />"
              required
            />
          </div>

          <div>
            <label>* Cod. Produto:</label>
            <input
              class="input-class"
              maxlength="50"
              type="text"
              placeholder="Digite o codigo Produto..."
              id="codProduto"
              name="codProduto"
              value="<c:out value="${pedidoDAO.produto.codigo}" />"
              required
            />
          </div>

          <div class="button">
            <button type="submit" onclick="validar()">
              Atualizar
            </button>
            <button type="reset">Limpar</button>
          </div>

          <div class="button">
            <a href="ListaPedido">Listar Pedidos</a>
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

<script src="js/Valida-CadastroPedidos.js"></script>
html>