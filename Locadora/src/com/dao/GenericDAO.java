package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sun.org.apache.regexp.internal.RE;



public class GenericDAO<T> {
	EntityManagerFactory emf;
	EntityManager em;
	
	
	public GenericDAO() {
		emf = Persistence.createEntityManagerFactory("loca");
		em = emf.createEntityManager();
	}
	public String inserir(T obj){
		String msg ="";
			try{
				em.getTransaction().begin();
				em.persist(obj);
				em.getTransaction().commit();
				msg = "Salvo com sucesso!";
			}catch(Exception ex){
				msg = "Erro ao Salvar!"+ex.getMessage();
				em.getTransaction().rollback();		
			}finally{
				emf.close();
			}
		return msg;
	}
	public void alterar(T obj){
		try{
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();			
		}catch(Exception ex){
			em.getTransaction().rollback();		
		}finally{
			emf.close();
		}
		
	}
	
	public void excluir(T obj){
		try{
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();			
		}catch(Exception ex){
			em.getTransaction().rollback();		
		}finally{
			emf.close();
		}
	}
	
	
	
}
