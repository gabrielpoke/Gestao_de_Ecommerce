package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import VO.Cliente;
import VO.Colaborador;
import VO.Pedido;
import VO.Produto;

/**
 * Servlet implementation class EditarPedido
 */
public class EditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pedido pedido = new Pedido();
		pedido.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		PedidoDAO pedidoDAO = new PedidoDAO(pedido);
		
			try{
			
				request.setAttribute("pedidoDAO", pedidoDAO.load(pedidoDAO.getPedido().getCodigo()));
			
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		
			request.getRequestDispatcher("/EditarPedido.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		Colaborador colaborador = new Colaborador();
		Produto produto = new Produto();
		
		pedido.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		cliente.setCodigo(Integer.parseInt(request.getParameter("codCliente")));
		pedido.setCliente(cliente);
		
		colaborador.setCodigo(Integer.parseInt(request.getParameter("codColaborador")));
		pedido.setColaborador(colaborador);
		
		produto.setCodigo(Integer.parseInt(request.getParameter("codProduto")));
		pedido.setProduto(produto);
		
		PedidoDAO pedidoDAO = new PedidoDAO(pedido);
		
		try{
		
			pedidoDAO.editar(pedido);
			
		}catch (Exception e) {
		
			e.printStackTrace();
		
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de pedido atualizado Sucesso");
		out.close();
	}

}
