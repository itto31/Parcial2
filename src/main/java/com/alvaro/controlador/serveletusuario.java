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
import com.alvaro.entidades.Tblconsulta;

/**
 * Servlet implementation class serveletusuario
 */
public class serveletusuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveletusuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Tblconsulta co = new Tblconsulta();
	  ConsultaDao cod = new ConsultaDao();
		String id = null;
		String nombre = null;
		String apellido = null;
		try {
			 id = request.getParameter("Id");
			 nombre = request.getParameter("nombre");
			 apellido = request.getParameter("apellido");
			 
			 co.setIdConsulta(Integer.parseInt(id));
			co.setNombre(nombre);
			co.setApellido(apellido);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		String action = request.getParameter("btn");
		System.out.println(action);
		HttpSession seccion = (HttpSession)request.getSession();
		String usauriovariable = (String)seccion.getAttribute("Usuario");
		if(action.equals("Actualizar")) {
			if (usauriovariable == null) {
				response.sendRedirect("login.jsp");
			}else {
				
				co.setIdConsulta(Integer.parseInt(id));
				co.setNombre(nombre);
				co.setApellido(apellido);
				   cod.actualizarDatos(co);
				   response.sendRedirect("index.jsp");
			}
		}
		else if(action.equals("Eliminar")) {
			if (usauriovariable == null) {
			response.sendRedirect("login.jsp");
			}else {
				
				   co.setIdConsulta(Integer.parseInt(id));
				   cod.eliminarDatos(co);
				   response.sendRedirect("index.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usu = request.getParameter("Usuario");
		String contra = request.getParameter("contra");
		
		Tabusuario usua = new Tabusuario();
		
		usua.setNombre(usu);
		usua.setContrasena(contra);
		
		usuarioDAO usuDao = new usuarioDAO();
		
		int veri = usuDao.login(usua).size();
		
		if(veri == 1) {
			HttpSession seccion = request.getSession(true);
			seccion.setAttribute("Usuario", usu);
		 	response.sendRedirect("index.jsp");
		}
		else {
			System.out.println("no entrastes");	
		}	
		
	}

}
