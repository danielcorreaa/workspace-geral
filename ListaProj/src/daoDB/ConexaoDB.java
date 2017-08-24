package daoDB;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexaoDB {
	
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost/teste";
	private String usuario ="root";
	private String senha ="";
	private Connection conexao = null;
	private static ConexaoDB instance = null; 


	private ConexaoDB(){
		try{
		  Class.forName(DRIVER);
		  conexao = (Connection) DriverManager.getConnection(URL,usuario,senha);
		  System.out.println("Conexão OK!");
		} catch (ClassNotFoundException ec){
		  System.err.println("Problemas com o driver:"+ec.getMessage());
		} catch (SQLException es){
		  System.err.println("Problemas com o conexão:"+es.getMessage());
		}
	}
	public Connection getConnection(){
		return conexao;
	}
	public void closeConnection(){
		try{
		   if(conexao!=null){
		      conexao.close();
		   }
		}catch (SQLException es){
		    System.err.println("Problemas ao fechar conexão:"+
		                es.getMessage());
		}
	}
	
	public static ConexaoDB getInstance(){
		if(instance==null){
		instance = new ConexaoDB();
		}
		return instance;
	}

	public static void main(String args[]){
		ConexaoDB.getInstance();
	}







}
