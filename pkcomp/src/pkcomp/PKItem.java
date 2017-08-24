package pkcomp;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PKItem implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
    @JoinColumn(name="idFilme")
	private Filme filme;
	@ManyToOne
    @JoinColumn(name="idMidia")
	private Midia midia;

	public PKItem(Filme filme, Midia midia) {
		super();
		this.filme = filme;
		this.midia = midia;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filme == null) ? 0 : filme.hashCode());
		result = prime * result + ((midia == null) ? 0 : midia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PKItem other = (PKItem) obj;
		if (filme == null) {
			if (other.filme != null)
				return false;
		} else if (!filme.equals(other.filme))
			return false;
		if (midia == null) {
			if (other.midia != null)
				return false;
		} else if (!midia.equals(other.midia))
			return false;
		return true;
	}

}
