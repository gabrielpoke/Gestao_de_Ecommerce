package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ColaboradorDAO;
import DAO.PedidoDAO;
import VO.Cliente;
import VO.Colaborador;
import VO.Pedido;
import VO.Produto;

/**
 * Servlet implementation class CadastroPedido
 */
public class CadastroPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPedido() {
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
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		Colaborador colaborador = new Colaborador();
		Produto produto = new Produto();
		
		cliente.setCodigo(Integer.parseInt(request.getParameter("codCliente")));
		pedido.setCliente(cliente);
		
		colaborador.setCodigo(Integer.parseInt(request.getParameter("codColaborador")));
		pedido.setColaborador(colaborador);

		pedido.setColaborador(colaborador);
		
		produto.setCodigo(Integer.parseInt(request.getParameter("codProduto")));
		pedido.setProduto(produto);

		PedidoDAO pedidoDAO = new PedidoDAO(pedido);
		
		try {
		
			pedidoDAO.save(pedido);
				
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Reegistro de pedido incluido Sucesso ");
		out.close();
	}

}
