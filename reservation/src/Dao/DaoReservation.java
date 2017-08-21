package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;

import Class.Reservation;
import oracle.jdbc.OracleTypes;

public class DaoReservation extends IDao<Reservation>{
	
	public DaoReservation(Connection conn) {
		super(conn);
	
	}
	
	@Override
	public Reservation log(String login, String password) {
		
		return null;
	}

	@Override
	public boolean create(Reservation obj) {
		boolean res = false;
		try{
				String sql = "{call PKG_Reservation.createReservation(?,?,?,?,?)}"; 
				CallableStatement call = connect.prepareCall(sql); 		
				call.setInt(1, obj.getClient().getId_cli());
				call.setInt(2,obj.getRestaurant().getId_restaurant());
				call.setInt(3, obj.getNombrePlace());
				call.setDate(4, obj.getDate_reservation());
				call.setInt(5, obj.getStatut_reservation());
				call.execute();
				res = true;
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public Reservation find(int id) {
		Reservation res=null;
		AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dresto = (DaoRestaurant) fact.getDaoRestaurant();
		DaoClient dclient = (DaoClient)fact.getDaoClient();
		try{
			String sql = "{call PKG_Reservation.findById(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setInt(1, id);
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while(result.next()){
				res=new Reservation();	
				res.setId_reservation(id);
				res.setClient(dclient.find(result.getInt(2)));
				res.setRestaurant(dresto.find(result.getInt(3)));
				res.setNombrePlace(result.getInt(4));
				res.setDate_reservation(result.getDate(5));
				res.setStatut_reservation(result.getInt(6));
			}
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return res;
	}

	@Override
	public boolean delete(Reservation obj) {
		
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		
		return false;
	}

	public boolean update(Reservation obj,int status) {
		Integer res=1;
		try{
			String sql = "{?=call PKG_Reservation.updateReseration(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setInt(2, obj.getId_reservation());
			call.setInt(3, status);
			call.registerOutParameter(1, Types.INTEGER);
			call.execute();
			res = call.getInt(1);
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		if(res==1)
			return false;
		else
			return true;
	}
}


