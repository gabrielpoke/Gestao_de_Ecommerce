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

/**
 * Servlet implementation class CadastroCargos
 */
public class CadastroCargos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroCargos() {
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
		Cargo cargo = new Cargo();
	
		cargo.setNome(request.getParameter("nome"));
		cargo.setObservacao(request.getParameter("observacoes"));
		cargo.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));
		
		CargoDAO dao = new CargoDAO(cargo);
		
		try {
			dao.save(cargo);
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de Cargo Incluido Sucesso ");
		out.close();
	}

}
