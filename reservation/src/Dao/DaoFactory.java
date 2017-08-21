package Dao;

import java.sql.Connection;

import Class.Client;
import Class.Reservation;
import Class.Restaurant;
import db.*;

public class DaoFactory extends AbstractDAOFactory {
protected static final Connection conn = connecBdd.getConnec();   
	
	public IDao<Client> getDaoClient(){
		return new DaoClient(conn);
	} 
	
	public IDao<Reservation> getDaoReservation(){
		return new DaoReservation(conn);
	} 
	
	public IDao<Restaurant> getDaoRestaurant(){
		return new DaoRestaurant(conn);
	}
}
