package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelClient;

/**
 * Servlet implementation class creationClient
 */
@WebServlet("/creationClient")
public class creationClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public creationClient() {
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
		String nom =(String)request.getParameter("txtnom");
		String prenom =(String)request.getParameter("txtprenom");
		String adresse =(String)request.getParameter("txtadress");
		String tel =(String)request.getParameter("txttel");
		String login =(String)request.getParameter("txtlogin");
		String password =(String)request.getParameter("txtpass");
		String text = "erreur survenu lors de la creation du compte";
		ModelClient m_client = new ModelClient();
		if(!nom.equals("") && !prenom.equals("") && !tel.equals("") && !login.equals("") && !password.equals("") && !adresse.equals("") ){
			if(m_client.createCli(nom, prenom, adresse, tel, login, password))
				//text="compte creé avec succés";
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			else {
				text = "erreur survenu lors de la creation du compte";
				request.setAttribute("rsp", text);
				this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireClient.jsp").forward(request, response);
			}
		}
		else {
			text = "tous les champs(*) sont obligatoires.";
			request.setAttribute("rsp", text);
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/formulaireClient.jsp").forward(request, response);
		}
	}

}
