package DAO;
import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDAO {
	private static final String USUARIO = "root";
    private static final String SENHA = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/projeto_web";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private Connection conn;
     
   	public Connection getConn() {
		return conn;
	}
   	
    public  void abrir() throws Exception {       
        Class.forName(DRIVER);     
        conn = DriverManager.getConnection(URL, USUARIO, SENHA);            
    }

    public  void fechar() throws Exception {
        this.getConn().close();        
    }
       
}