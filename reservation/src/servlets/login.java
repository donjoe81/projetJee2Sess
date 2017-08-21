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

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**CreateUser
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//this.doPost(request, response);
		//this.getServletContext().getRequestDispatcher("/vues/dashboardClient.jsp").forward(request, response);
		//request.getRequestDispatcher("/vues/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login =(String)request.getParameter("txtlogin");
		String password =(String)request.getParameter("txtpassword");
		String text = "login/password incorrect!";
		String compte=(String)request.getParameter("compte");
		HttpSession session = request.getSession();
			if(compte.equals("client")) {
				ModelClient m_client = new ModelClient();
				if(m_client.log(login, password)) {
					request.setAttribute("model", m_client);
					session.setAttribute("id", m_client.getId());
					session.setAttribute("m_client", m_client);
					session.setAttribute("class", "client");
					this.getServletContext().getRequestDispatcher("/WEB-INF/vues/dashboardClient.jsp").forward(request, response);
				}
				else {
					request.setAttribute("rsp", text);
					this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}else 
				if(compte.equals("restaurant")) {
					ModelRestaurant m_resto = new ModelRestaurant();
					if(m_resto.log(login, password)) {
						request.setAttribute("model", m_resto);
						session.setAttribute("id", m_resto.getId());
						session.setAttribute("class", "restaurant");
						this.getServletContext().getRequestDispatcher("/WEB-INF/vues/dashboardRestaurant.jsp").forward(request, response);
					}
					else {
						request.setAttribute("rsp", text);
						this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
					}
				}
		
			
	}

}

