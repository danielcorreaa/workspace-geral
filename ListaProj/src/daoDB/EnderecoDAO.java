package daoDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import modelo.Endereco;

public class EnderecoDAO {
	
	    private List<Endereco> tabelaEndereco;	 
	 
	    public EnderecoDAO() {
	    	
		   tabelaEndereco = new ArrayList<Endereco>();
		   povoarTabela();
	    }

		

	    private void povoarTabela() {
	        
	    	tabelaEndereco = new ArrayList<Endereco>();
	       
	        String qry ="select * from Endereco order by rua";
	        try{
	            
	            Connection conexao = 
	            		ConexaoDB.getInstance().getConnection();
	           
	            Statement stmt = (Statement) conexao.createStatement();
	            
	            ResultSet rst = stmt.executeQuery(qry);
	            
	            while(rst.next()){
	       
	                Endereco end  = new Endereco();
	                
	                end.setId(rst.getInt("id"));
	                end.setNumero(rst.getString("numero"));
	                end.setRua(rst.getString("rua"));
	        
	                tabelaEndereco.add(end);
	            }   
	            rst.close();
	            stmt.close();
	        } catch (SQLException ex){
	            System.err.println(ex.getMessage());
	        }
	    }
	    
	    public List<Endereco> getBanco(){
	        povoarTabela();
	        return tabelaEndereco;
	    }
	    
	    public Endereco buscar(String nome){
	        povoarTabela();
	        for (Endereco cli : tabelaEndereco) {
	            if(cli.getRua().equalsIgnoreCase(nome)){
	                return cli;
	            }
	        }
	        return null;
	    }
	    public Endereco buscarPorId(Integer id){
	        povoarTabela();
	        for (Endereco cli : tabelaEndereco) {
	            if(cli.getId()== id){
	                return cli;
	            }
	        }
	        return null;
	    }
	     public String salvar(Endereco ed) {
	        String msg = "Problemas ao salvar!";
	        String qryI = "Insert into Endereco VALUES (?,?,?)";
	        String qryU =
	                "Update Endereco set rua =? numero = ? where id = ?";
	        if (buscarPorId(ed.getId()) == null) {
	            try {
	                Connection conexao = ConexaoDB.getInstance().getConnection();
	               
	                PreparedStatement pstmt = (PreparedStatement) conexao.prepareStatement(qryI);
	                pstmt.setInt(1, geraPK());
	                pstmt.setString(2, ed.getRua());
	                pstmt.setString(3, ed.getNumero());
	               
	                int ok = pstmt.executeUpdate();
	                if (ok > 0) {
	                    msg = "Endereco inserido com sucesso!";
	                }
	                pstmt.close();
	                conexao.commit();
	            } catch (SQLException ex) {
	                System.err.println(ex.getMessage());
	            }
	        } else {
	            try {
	                Connection conexao = ConexaoDB.getInstance().getConnection();
	                
	                PreparedStatement pstmt = (PreparedStatement) conexao.prepareStatement(qryU);
	                
	                pstmt.setString(1, ed.getRua());
	                pstmt.setString(2, ed.getNumero());
	                pstmt.setInt(3, ed.getId());
	                int ok = pstmt.executeUpdate();
	                if (ok > 0) {
	                    msg = "Endereco atualizado com sucesso!";
	                }
	                pstmt.close();
	                conexao.commit();
	            } catch (SQLException ex) {
	                System.err.println(ex.getMessage());
	            }
	        }
	        return msg;
	    }

	    public String excluir(Endereco ed) {
	        String msg = "Tipo não consta no banco!";
	        String qryD = "Delete from Endereco where id =?";
	        if (buscar(ed.getRua()) != null) {
	            try {
	                Connection conexao = ConexaoDB.getInstance().getConnection();
	                PreparedStatement pstmt = (PreparedStatement) conexao.prepareStatement(qryD);
	                pstmt.setInt(1, ed.getId());
	                int ok = pstmt.executeUpdate();
	                if (ok > 0) {
	                    msg = "Tipo removido com sucesso!";
	                }
	                pstmt.close();
	                conexao.commit();
	            } catch (SQLException ex) {
	                System.err.println(ex.getMessage());
	            }
	        }
	        return msg;
	    }
	private int geraPK() {
	        int novaPK = 0;
	        String qry = "select max(id) from Endereco";
	        try {
	            Connection conexao = ConexaoDB.getInstance().getConnection();
	            Statement stmt = (Statement) conexao.createStatement();
	            ResultSet rst = stmt.executeQuery(qry);
	            while (rst.next()) {
	                novaPK = rst.getInt(1);
	                novaPK++;
	            }
	            rst.close();
	            stmt.close();
	        } catch (SQLException ex) {
	            System.err.println(ex.getMessage());
	            novaPK = 1;
	        }
	        return novaPK;
	    }
	    
	
	
}
