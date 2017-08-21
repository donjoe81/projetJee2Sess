package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelRestaurant;

/**
 * Servlet implementation class creationRestaurant
 */
@WebServlet("/creationRestaurant")
public class creationRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creationRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =(String)request.getParameter("txtnom");
		String adresse =(String)request.getParameter("txtadress");
		String tel =(String)request.getParameter("txttel");
		String email =(String)request.getParameter("txtemail");
		String login =(String)request.getParameter("txtlogin");
		String password =(String)request.getParameter("txtpass");
		
		String text="";
		ModelRestaurant m_resto = new ModelRestaurant();
		if(!nom.equals("") && !email.equals("") && !tel.equals("") && !login.equals("") && !password.equals("") && !adresse.equals("") ){
			if(m_resto.createRestorant(nom, adresse, tel, email, login, password))
				//text="compte creé avec succés";
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			else {
				text = "erreur survenu lors de la creation du compte";
				request.setAttribute("rsp", text);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireRestaurant.jsp").forward(request, response);
			}
		}
		else {
			text = "tous les champs(*) sont obligatoires.";
			request.setAttribute("rsp", text);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireRestaurant.jsp").forward(request, response);
		}
	}

}
