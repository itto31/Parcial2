package com.alvaro.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alvaro.Dao.ConsultaDao;
import com.alvaro.Dao.usuarioDAO;
import com.alvaro.entidades.Tabusuario;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServeletController
 */
public class ServeletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
	ConsultaDao conDAO= new ConsultaDao();
	
	
	Gson json = new Gson();
	
	try {
		response.getWriter().append(json.toJson(conDAO.ConsultaLista()));
		
	} catch (Exception e) {
		System.out.println(e +"no funciono");
	}
	}

}
