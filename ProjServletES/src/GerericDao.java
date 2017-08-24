import com.servlet.modelo.Cliente;

public interface GerericDao<T> {
	
	public void Salvar(Cliente cliente);
}
