package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PedidoDAO;
import VO.Pedido;

/**
 * Servlet implementation class ApagarPedido
 */
public class ApagarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		
		pedido.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		PedidoDAO pedidoDAO = new PedidoDAO(pedido);
		
		try {
		
			pedidoDAO.delete(pedido);;
		
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		PrintWriter out = response.getWriter();
		out.println("Registro de Pedido Excluido com Sucesso ");
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
