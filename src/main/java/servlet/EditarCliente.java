
package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import VO.Categoria;
import VO.Cliente;

/**
 * Servlet implementation class EditarCliente
 */
public class EditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		ClienteDAO clienteDAO = new ClienteDAO(cliente);
		
		try {
			
			request.setAttribute("clienteInfo",clienteDAO.load(clienteDAO.getCliente().getCodigo()));
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		request.getRequestDispatcher("/EditarCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setBairro(request.getParameter("bairro"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setCep(Integer.parseInt(request.getParameter("cep")));
		cliente.setCpf(Integer.parseInt(request.getParameter("cpf")));
		cliente.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));
		
		ClienteDAO dao = new ClienteDAO(cliente);
		
		try {
			
			dao.editar(cliente);
		
		} catch (Exception e) {
			
				e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de Cliente atualizado com Sucesso ");
		out.close();
	}

}
