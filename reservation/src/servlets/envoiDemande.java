package servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Class.Restaurant;
import Model.ModelClient;
import Model.ModelReservation;
import Model.ModelRestaurant;

/**
 * Servlet implementation class envoiDemande
 */
@WebServlet("/envoiDemande")
public class envoiDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public envoiDemande() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean test = false;
		String date="";
		int nbrPlace=0;
		int idResto=0;
		try {
			if(request.getParameter("nbrPlace")!=null && !request.getParameter("nbrPlace").equals(""))
				nbrPlace=Integer.parseInt((String)request.getParameter("nbrPlace"));
			else
				test=true;
			if(request.getParameter("date")!=null && !request.getParameter("date").equals(""))
				date =  (String)request.getParameter("date");
			else
				test=true;
			if(request.getParameter("idresto")!=null && !request.getParameter("idresto").equals(""))
				idResto=Integer.parseInt((String)request.getParameter("idresto"));
			else
				test=true;
			
			if(!test){
				HttpSession session = request.getSession();
				int idclient = (int) session.getAttribute("id");
				
				ModelReservation mreser = new ModelReservation();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate parsedDate = LocalDate.parse(date, formatter);
				Date dat = java.sql.Date.valueOf(parsedDate);
				
				if(mreser.createR((int)idclient, (int)idResto, nbrPlace, dat,0)) {
					ModelClient  m_client = (ModelClient) session.getAttribute("m_client");
					request.setAttribute("model", m_client);
					this.getServletContext().getRequestDispatcher("/WEB-INF/vues/dashboardClient.jsp").forward(request, response);
				}
				else {
					request.setAttribute("rsp", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
					this.getServletContext().getRequestDispatcher("/WEB-INF/vues/PrendreRdv.jsp").forward(request, response);
				}
			}
			else {
				List<Restaurant> listRestos = ModelRestaurant.findAll();
				request.setAttribute("restaurants", listRestos);
				
				request.setAttribute("rsp", "tous les champs sont obligaroires");
				this.getServletContext().getRequestDispatcher("/WEB-INF/vues/PrendreRdv.jsp").forward(request, response);
			}
		}catch(Exception e) {
			List<Restaurant> listRestos = ModelRestaurant.findAll();
			request.setAttribute("restaurants", listRestos);
			request.setAttribute("rsp", "le nombre de place ou la date est incorrect(e)");
			this.getServletContext().getRequestDispatcher("/WEB-INF/vues/PrendreRdv.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
