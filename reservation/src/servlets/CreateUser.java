package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class login
 */
//@WebServlet("/login")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**CreateUser
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String compte = (String)request.getParameter("compte");
		if(compte.equals("client"))
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireClient.jsp").forward(request, response);
		else if(compte.equals("restaurant"))
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireRestaurant.jsp").forward(request, response);
		//request.getRequestDispatcher("/vues/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*response.setContentType("text/plain");  
	    response.setCharacterEncoding("UTF-8"); 
	    response.getWriter().write(text);*/
	}

}
