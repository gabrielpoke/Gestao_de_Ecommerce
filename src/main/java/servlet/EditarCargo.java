package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import DAO.CategoriaDAO;
import VO.Cargo;
import VO.Categoria;

/**
 * Servlet implementation class EditarCargo
 */
public class EditarCargo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCargo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cargo cargo = new Cargo();
		cargo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		CargoDAO cargoDAO = new CargoDAO(cargo);
		
		try {
			
			request.setAttribute("cargoInf", cargoDAO.load(cargoDAO.getCargo().getCodigo()));
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/EditarCargo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cargo vo = new Cargo();
		
		vo.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		vo.setNome(request.getParameter("nome"));
		vo.setObservacao(request.getParameter("observacao"));
		vo.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
		
		CargoDAO dao = new CargoDAO(vo);
		
		try{
			dao.editar(vo);
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de Cargo atualizado com Sucesso ");
		out.close();

	}
}