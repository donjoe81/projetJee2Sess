package Dao;

import java.util.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import Class.Reservation;
import Class.Restaurant;
import oracle.jdbc.OracleTypes;

public class DaoRestaurant extends IDao<Restaurant>{

	public DaoRestaurant(Connection conn) {
		super(conn);
		
	}

	@Override
	public Restaurant log(String login, String password) {
		Restaurant res=null;
		try{
			String sql = "{call PKG_Restaurant.loginRestaurant(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setString(1, login);
			call.setString(2,password);
			call.registerOutParameter(3, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(3);
			while(result.next()){
				res=new Restaurant();
				res.setId_rstaurant(result.getInt(1));
				res.setNom_restaurant(result.getString(2));
				res.setTel_restaurant(result.getString(3));
				res.setEmail_restaurant(result.getString(4));
				res.setLogin_restaurant(login);
				res.setPass_restaurant(password);
				res.setAdresse_restaurant(result.getString(7));
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return res;
	}

	@Override
	public boolean create(Restaurant obj) {	
		boolean res = false;
		try{
				String sql = "{call PKG_Restaurant.createRestaurant(?,?,?,?,?,?)}"; 
				CallableStatement call = connect.prepareCall(sql); 		
				call.setString(1, obj.getNom_restaurant());
				call.setString(2,obj.getTel_restaurant());
				call.setString(3, obj.getEmail_restaurant());
				call.setString(4, obj.getLogin_restaurant());
				call.setString(5, obj.getPass_restaurant());
				call.setString(6, obj.getAdresse_restaurant());
				call.execute();
				res = true;
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return res;
	}

	@Override
	public Restaurant find(int id) {
		
		Restaurant res=null;
		try{
			String sql = "{call PKG_Restaurant.findById(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setInt(1, id);
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while(result.next()){
				res=new Restaurant();
				res.setId_rstaurant(result.getInt(1));
				res.setNom_restaurant(result.getString(2));
				res.setTel_restaurant(result.getString(4));
				res.setEmail_restaurant(result.getString(5));
				res.setAdresse_restaurant(result.getString(3));
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return res;
	}
	
	/***********************************************************************************/
	
	/***********************************************************************************/
	
	public List<Restaurant> findAll() {
		
		List<Restaurant> lisResto=new ArrayList<Restaurant>();
		try{
			String sql = "{call PKG_Restaurant.findAll(?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			while(result.next()){
				Restaurant res = new Restaurant();
				res=new Restaurant();
				res.setId_rstaurant(result.getInt(1));
				res.setNom_restaurant(result.getString(2));
				res.setTel_restaurant(result.getString(4));
				res.setEmail_restaurant(result.getString(5));
				res.setAdresse_restaurant(result.getString(3));
				lisResto.add(res);
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return lisResto;
	}

	@Override
	public boolean delete(Restaurant obj) {
		
		return false;
	}

	@Override
	public boolean update(Restaurant obj) {
		
		return false;
	}
	
	public List<Reservation> reservationsRestaurant(int id){
		List<Reservation> list = new ArrayList<Reservation>();
		AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoClient dclient = (DaoClient)fact.getDaoClient();
		try{
			String sql = "{call PKG_Restaurant.findRd(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql);
			
			call.registerOutParameter(1, Types.INTEGER);
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			
			call.setInt(1, id);
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while(result.next()){
				Reservation reser = new Reservation();
				reser.setId_reservation(result.getInt(1));
				reser.setClient(dclient.find(result.getInt(2)));
				reser.setNombrePlace(result.getInt(3));
				reser.setDate_reservation(result.getDate(4));
				list.add(reser);
			}
		
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		
		return list;
	}

}
