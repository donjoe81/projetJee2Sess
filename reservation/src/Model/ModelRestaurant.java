package Model;


import java.util.ArrayList;
import java.util.List;

import Class.Reservation;
import Class.Restaurant;
import Dao.AbstractDAOFactory;
import Dao.DaoRestaurant;

public class ModelRestaurant {
	private int id;
	private String nom;
	private String adresse;
	private String tel;
	private List<Reservation> reservations=new ArrayList<Reservation>();
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	private static AbstractDAOFactory fact = null;
	
	public boolean createRestorant(String nom,String adresse,String tel,String email,String login,String pass){
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dclient = (DaoRestaurant)fact.getDaoRestaurant();
			Restaurant resto = new Restaurant();
			resto.setNom_restaurant(nom);
			resto.setAdresse_restaurant(adresse);
			resto.setTel_restaurant(tel);
			resto.setEmail_restaurant(email);
			resto.setLogin_restaurant(login);
			resto.setPass_restaurant(pass);
			return dclient.create(resto);
	}
	
	public boolean log(String login, String password) {
		boolean res=false;
		Restaurant resto=null;
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dresto = (DaoRestaurant)fact.getDaoRestaurant();
		resto= dresto.log(password, password);
		if(resto!=null) {
			this.setId(resto.getId_restaurant());
			this.setNom(resto.getNom_restaurant());
			this.setAdresse(resto.getAdresse_restaurant());
			this.setTel(resto.getTel_restaurant());
			findReservations(this.id);
			res=true;
		}
		return res;
	}
	
	public static List<Restaurant> findAll() {
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dresto = (DaoRestaurant)fact.getDaoRestaurant();
		return dresto.findAll();
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void findReservations(int id) {
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dresto = (DaoRestaurant)fact.getDaoRestaurant();
		this.reservations = dresto.reservationsRestaurant(id);
	}
}
