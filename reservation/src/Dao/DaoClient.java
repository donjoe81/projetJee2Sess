package Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import Class.Client;
import Class.Reservation;
import oracle.jdbc.OracleTypes;

public class DaoClient extends IDao<Client> {

	public DaoClient(Connection conn) {
		super(conn);
	}

	@Override
	public Client log(String login, String password) {
		Client client =null;
		try{
			String sql = "{call PKG_Client.loginUser(?,?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setString(1, login);
			call.setString(2,password);
			call.registerOutParameter(3, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(3);
			while (result.next()){
				client = new Client();
				client.setId_cli(result.getInt("id_cli"));
				client.setNom_client(result.getString("nom_cli"));
				client.setPrenom_client(result.getString("prenom_cli"));
				client.setAdresse_client(result.getString("adresse_cli"));
				client.setTel_client(result.getString("tel_cli"));
				client.setLogin_cli(login);
				client.setPass_cli(password);			
			}
			
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return client;
	}

	@Override
	public boolean create(Client obj) {
		boolean res = false;
		try{
			if(log(obj.getLogin_cli(),obj.getPass_cli())==null){
				String sql = "{call PKG_Client.createClient(?,?,?,?,?,?)}"; 
				CallableStatement call = connect.prepareCall(sql); 		
				call.setString(1, obj.getNom_client());
				call.setString(2,obj.getPrenom_client());
				call.setString(3,  obj.getAdresse_client());
				call.setString(4,  obj.getTel_client());
				call.setString(5, obj.getLogin_cli());
				call.setString(6,obj.getPass_cli());
				call.execute();
				res = true;
			}

		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return res;
	}

	@Override
	public Client find(int id) {
		Client client =null;
		try{
			String sql = "{call PKG_Client.findById(?,?)}"; 
			CallableStatement call = connect.prepareCall(sql); 		
			call.setInt(1, id);
			call.registerOutParameter(2, OracleTypes.CURSOR); 
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(2);
			while (result.next()){
				client = new Client();
				client.setId_cli(id);
				client.setNom_client(result.getString(2));
				client.setPrenom_client(result.getString(3));
				client.setAdresse_client(result.getString(4));
				client.setTel_client(result.getString(5));
				client.setLogin_cli(result.getString(6));
				client.setPass_cli(result.getString(7));			
			}
			
		}
		catch (Exception e){
			e.printStackTrace();  
		}
		return client;
	}

	@Override
	public boolean delete(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Client obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public List<Reservation> rdvClient(int id){
		List<Reservation> list = new ArrayList<Reservation>();
		AbstractDAOFactory fact = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DaoRestaurant dresto = (DaoRestaurant)fact.getDaoRestaurant();
		try{
			String sql = "{?=call PKG_Client.rdvClient(?)}"; 
			CallableStatement call = connect.prepareCall(sql);
			
			call.registerOutParameter(2, Types.INTEGER);
			call.registerOutParameter(1, OracleTypes.CURSOR); 
			
			call.setInt(2,id);
			call.execute();
			ResultSet  result = (ResultSet)call.getObject(1);
			
			while(result.next()){
				Reservation reser = new Reservation();
				reser.setId_reservation(result.getInt(1));
				reser.setRestaurant(dresto.find(result.getInt(2)));
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
