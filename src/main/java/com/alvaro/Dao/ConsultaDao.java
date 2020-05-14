package com.alvaro.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alvaro.entidades.Tblconsulta;

public class ConsultaDao {
	
public List<Tblconsulta> ConsultaLista() {
		
		List<Tblconsulta> Listacon = new ArrayList<>();
		
		
		EntityManager em;
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
			
			em.getTransaction().begin();
	
			Listacon = em.createQuery("from Tblconsulta").getResultList();
			em.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);					
		}		
		return Listacon;
	}

public void eliminarDatos(Tblconsulta co) {
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("Parcial2");
	em = emf.createEntityManager();

	em.getTransaction().begin();		
	co=em.getReference(Tblconsulta.class, co.getIdConsulta());
	em.remove(co);
	em.flush();
	em.getTransaction().commit();
}

public void actualizarDatos(Tblconsulta co) {
	EntityManager em;
	EntityManagerFactory emf;
	emf = Persistence.createEntityManagerFactory("Parcial2");
	em = emf.createEntityManager();
	
	co.getIdConsulta();
	co.getNombre();
	co.getApellido();

	
	em.getTransaction().begin();
	em.merge(co);
	em.flush();
	em.getTransaction().commit();
	
	
}
}
