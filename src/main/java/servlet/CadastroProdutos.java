package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProdutoDAO;
import VO.Categoria;
import VO.Produto;

/**
 * Servlet implementation class CadastroProdutos
 */
public class CadastroProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroProdutos() {
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
		Produto produto = new Produto();
		Categoria categoria = new Categoria();
		
		produto.setNome(request.getParameter("nome"));

		categoria.setCodigo(Integer.parseInt(request.getParameter("categoria")));
		produto.setCategoria(categoria);
		
		produto.setDescricao(request.getParameter("descricao"));
		produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		produto.setPreco(Double.parseDouble(request.getParameter("preco")));
		produto.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));
		
		ProdutoDAO dao = new ProdutoDAO(produto);
		
		try{
			
			dao.save(produto);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de produto incluido Sucesso");
		out.close();
	}

}
