package com.alvaro.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alvaro.entidades.Tabusuario;

public class usuarioDAO {

public List<Tabusuario> login(Tabusuario usu){
		
		
		List<Tabusuario> usuario = new ArrayList<>();
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Parcial2");
		em = emf.createEntityManager();
		
		try {
		
			em.getTransaction().begin();
			usuario = em.createQuery("from Tabusuario as u where u.nombre = '"+usu.getNombre()+"' and u.contrasena='"+usu.getContrasena()+"' ").getResultList();
			em.getTransaction().commit();
	
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		return usuario;
	}
	
	
}
