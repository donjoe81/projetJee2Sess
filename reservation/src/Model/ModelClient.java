package Model;

import java.util.ArrayList;
import java.util.List;

import Class.Client;
import Class.Reservation;
import Dao.AbstractDAOFactory;
import Dao.DaoClient;

public class ModelClient {
	private String nom=null;
	private String prenom=null;
	private int id;
	private List<Reservation> reservations=new ArrayList<Reservation>();
	private AbstractDAOFactory fact = null;
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

	public boolean createCli(String nom,String prenom,String adresse,String tel,String login,String pass){
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoClient dclient = (DaoClient)fact.getDaoClient();
		if(!nom.equals("") && !prenom.equals("") && !adresse.equals("") && !tel.equals("") && !login.equals("") && !pass.equals("")){
			Client cli = new Client();
			cli.setNom_client(nom);
			cli.setPrenom_client(prenom);
			cli.setAdresse_client(adresse);
			cli.setTel_client(tel);
			cli.setLogin_cli(login);
			cli.setPass_cli(pass);
			return dclient.create(cli);
		}
		return false;
			
	}
	
	public boolean log(String login,String password){
		boolean res = false;
		if(!login.equals("") && !password.equals("")){
			fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			DaoClient dclient = (DaoClient)fact.getDaoClient();
			Client cli = dclient.log(login, password);
			if(cli!=null){
				this.nom=cli.getNom_client();
				this.prenom=cli.getPrenom_client();
				this.setId(cli.getId_cli());
				findReservation(this.id);
				res=true;		
			}
		}
		return res;
	}
	public void findReservation(int id){
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoClient dclient = (DaoClient)fact.getDaoClient();
		this.reservations = dclient.rdvClient(id);
	}
	
}
