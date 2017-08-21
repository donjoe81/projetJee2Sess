package Class;

import java.sql.Date;

public class Reservation {
	private int id_reservation;
	private Client client;
	private Restaurant restaurant;
	private int nombrePlace;
	private Date date_reservation;
	private int statut_reservation;
	
	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id){
		this.id_reservation=id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public int getNombrePlace() {
		return nombrePlace;
	}
	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}
	public Date getDate_reservation() {
		return date_reservation;
	}
	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}
	public int getStatut_reservation() {
		return statut_reservation;
	}
	public void setStatut_reservation(int statut_reservation) {
		this.statut_reservation = statut_reservation;
	}
	
	public Reservation(Client client, Restaurant restaurant, int nombrePlace, Date date_reservation,
			int statut_reservation) {
		this.client = client;
		this.restaurant = restaurant;
		this.nombrePlace = nombrePlace;
		this.date_reservation = date_reservation;
		this.statut_reservation = statut_reservation;
	}
	public Reservation() {
		super();
	} 
	

}
