import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.servlet.modelo.Cliente;

public class TesteDAO{

	
    public static void main(String[] args) {
		Map<Integer, String> telefone = new HashMap<>();
		
		telefone.put(1, "Daniel");
		telefone.put(2, "Crlos");
		
		for (int i = 0; i < telefone.size(); i++) {
			
			
		}
		System.out.println(telefone.get(1));
	}

}
