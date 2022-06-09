package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.CodingErrorAction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ColaboradorDAO;
import VO.Cargo;
import VO.Colaborador;

/**
 * Servlet implementation class CadastroColaborador
 */
public class CadastroColaborador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroColaborador() {
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
		Colaborador colaborador = new Colaborador();
		Cargo cargo = new Cargo();
				
		colaborador.setNome(request.getParameter("nome"));	
		
		cargo.setCodigo(Integer.parseInt(request.getParameter("cargo")));
		colaborador.setCargo(cargo);
		
		colaborador.setEmail(request.getParameter("email"));
		colaborador.setObservacao(request.getParameter("observacoes"));
		colaborador.setAtivo(Boolean.parseBoolean(request.getParameter("ativos")));

		ColaboradorDAO colaboradorDAO = new ColaboradorDAO(colaborador);
		
		try {
		
			colaboradorDAO.save(colaborador);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Registro de colaborador incluido Sucesso");
		out.close();
	}

}
