package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoriaDAO;
import VO.Categoria;

/**
 * Servlet implementation class EditarCategoria
 */
public class EditarCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCategoria() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria categoria = new Categoria();
		categoria.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(categoria);

		try {
			request.setAttribute("categoriasI", categoriaDAO.load(categoriaDAO.getCategoria().getCodigo()));
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/EditarCategoria.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Categoria vo = new Categoria();
		
		vo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		vo.setNome(request.getParameter("nome"));
		vo.setDescricao(request.getParameter("descricao"));
		
		CategoriaDAO dao = new CategoriaDAO(vo);
		
		try {
			dao.editar(vo);
		} catch (Exception e) {
			
				e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de Categoria atualizado com Sucesso ");
		out.close();
	}
}
