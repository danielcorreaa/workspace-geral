package com.modelo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.fileupload.FileItemStream;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.sun.org.apache.regexp.internal.recompile;



@Entity
@Table(name = "filmes")
public class Filme implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 60)
	private String titulo;
	private double preco;
	protected boolean disponivel;
	private String img;

	public Filme() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public static boolean processFile(String path, FileItemStream item) {
		try {
			File f = new File(path + File.separator + "imagem");
			if (!f.exists()) {
				f.mkdir();
			}
			File savedFile = new File(f.getAbsolutePath() + File.separator + item.getName());
			FileOutputStream fos = new FileOutputStream(savedFile);
			InputStream is = item.openStream();
			int x = 0;
			byte[] b = new byte[1024];
			while ((x = is.read(b)) != -1) {
				fos.write(b, 0, x);
			}
			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getStatus(){
		
		if(disponivel){
			return "disponível";
		}else{
			return "indisponível";
		}
	 	
	}
}
