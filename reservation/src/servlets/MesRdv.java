package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelClient;
import Model.ModelRestaurant;


import com.google.gson.Gson;

/**
 * Servlet implementation class MesRdv
 */
@WebServlet("/MesRdv")
public class MesRdv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MesRdv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		String classe = (String) session.getAttribute("class");
		if(classe.equals("client")){
			ModelClient m_client = new ModelClient();
			m_client.findReservation(id);
			
			String json = new Gson().toJson(m_client.getReservations());
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
		else if(classe.equals("restaurant")) {
			ModelRestaurant m_resto = new ModelRestaurant();
			String json = new Gson().toJson(m_resto.getReservations());
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
