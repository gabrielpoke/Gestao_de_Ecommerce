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
 * Servlet implementation class ApagarCliente
 */
public class ApagarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarCliente() {
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
			
			clienteDAO.delete(cliente);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		
		PrintWriter out = response.getWriter();
		out.println("Registro de cliente Excluido com Sucesso ");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
