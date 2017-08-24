
import java.util.ArrayList;
import java.util.List;

import com.controle.dao.ProdutoDAO;
import com.controle.modelo.Produto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Adm {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = new ArrayList<>();

		for (Object c : dao.getTabela()) {
			System.out.println(c.toString());
			//lista.add(c);
		}
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(lista);
		
		
        

		//System.out.println(json);

	}

}
