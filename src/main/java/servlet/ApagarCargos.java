package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CargoDAO;
import VO.Cargo;

/**
 * Servlet implementation class ApagarCargos
 */
public class ApagarCargos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarCargos() {
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
		
		CargoDAO cargosDAO = new CargoDAO(cargo);
		
		try {
			cargosDAO.delete(cargosDAO.getCargo());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("Registro de Cargo Excluido com Sucesso ");
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
