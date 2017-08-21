package Dao;

import Class.*;


public abstract class AbstractDAOFactory {
  public static final int DAO_FACTORY = 0;
  public static final int XML_DAO_FACTORY = 1;


  public abstract IDao<Client> getDaoClient();
  public abstract IDao<Restaurant> getDaoRestaurant();
  public abstract IDao<Reservation> getDaoReservation();
   
   
  //M�thode permettant de r�cup�rer les Factory
  public static DaoFactory getFactory(int type){
    switch(type){
      case DAO_FACTORY:
        return new DaoFactory();
      case XML_DAO_FACTORY: 
        return null;// new XMLDAOFactory();
      default:
        return null;
    }
  }
}
