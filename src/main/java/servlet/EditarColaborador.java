package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClienteDAO;
import DAO.ColaboradorDAO;
import VO.Cargo;
import VO.Cliente;
import VO.Colaborador;

/**
 * Servlet implementation class EditarColaborador
 */
public class EditarColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarColaborador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Colaborador colaborador = new Colaborador();
		colaborador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO(colaborador);
			
		try {
			request.setAttribute("colaboradorInf", colaboradorDAO.load(colaboradorDAO.getColaborador().getCodigo()));
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		request.getRequestDispatcher("/EditarColaborador.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Colaborador colaborador = new Colaborador();
		Cargo cargo = new Cargo();
				
		colaborador.setCodigo(Integer.parseInt(request.getParameter("codigo")));
		colaborador.setNome(request.getParameter("nome"));	
		
		cargo.setCodigo(Integer.parseInt(request.getParameter("cargo")));
		colaborador.setCargo(cargo);
		
		colaborador.setEmail(request.getParameter("email"));
		colaborador.setObservacao(request.getParameter("observacoes"));
		colaborador.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));
		
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO(colaborador);
		
		try {
			
			colaboradorDAO.editar(colaborador);
		
		} catch (Exception e) {
			
				e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de Colaborador atualizado com Sucesso ");
		out.close();
	}
}
