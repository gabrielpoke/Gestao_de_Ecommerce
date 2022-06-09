package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import VO.Cliente;

/**
 * Servlet implementation class CadastroClientes
 */
public class CadastroClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroClientes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setBairro(request.getParameter("bairro"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setCpf(Integer.parseInt(request.getParameter("cpf")));
		cliente.setCep(Integer.parseInt(request.getParameter("cep")));
		cliente.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));

		ClienteDAO clienteDAO = new ClienteDAO(cliente);
		
		try {
			clienteDAO.save(cliente);
			
		}catch (Exception e) {
			e.printStackTrace();
			                     
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de cliente Incluido Sucesso");
		out.close();
	}

}
