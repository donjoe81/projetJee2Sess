package Model;

import java.sql.Date;

import Class.Client;
import Class.Reservation;
import Dao.AbstractDAOFactory;
import Dao.DaoClient;
import Dao.DaoReservation;
import Dao.DaoRestaurant;

public class ModelReservation {

	private int nombrePlace;
	private Date dateReservation;
	private String status;
	private String nomClient;
	private String adresseResto;
	private String nomResto;
	private String telResto;
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getAdresseResto() {
		return adresseResto;
	}
	public void setAdresseResto(String adresseResto) {
		this.adresseResto = adresseResto;
	}
	public String getNomResto() {
		return nomResto;
	}
	public void setNomResto(String nomResto) {
		this.nomResto = nomResto;
	}
	public String getTelResto() {
		return telResto;
	}
	public void setTelResto(String telResto) {
		this.telResto = telResto;
	}
	private AbstractDAOFactory fact = null;
	
	public boolean createR(int idClient, int idResto, int nbrPlace, Date date,int status) {
		fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoClient dclient = (DaoClient)fact.getDaoClient();
		DaoRestaurant dresto = (DaoRestaurant)fact.getDaoRestaurant();
		DaoReservation dreser = (DaoReservation)fact.getDaoReservation();
		Client cli = dclient.find(idClient);
		System.out.println(cli.getId_cli()+"  "+cli.getAdresse_client());
		Reservation reser= new Reservation(cli,dresto.find(idResto),nbrPlace,date,status);
		try {
		return dreser.create(reser);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			 return false;
		}
	}
}
