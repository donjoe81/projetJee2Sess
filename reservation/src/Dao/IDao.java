package Dao;

import java.sql.Connection;

public abstract class IDao<T> {
	   
	  protected Connection connect = null;
	   
	  public IDao(Connection conn){
	    this.connect = conn;
	  }
	  
	
	public abstract T log(String login, String password); 
	
	public abstract boolean create(T obj);
	
	public abstract T find(int id);
	
	public abstract boolean delete(T obj);
	
	public abstract boolean update(T obj);
}
