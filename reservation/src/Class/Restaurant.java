package Class;

public class Restaurant {
	private int id_restaurant;
	private String nom_restaurant;
	private String adresse_restaurant;
	private String tel_restaurant;
	private String login_restaurant;
	private String pass_restaurant;
	private String email_restaurant;
	
	public int getId_restaurant() {
		return id_restaurant;
	}
	public void setId_rstaurant(int id){
		this.id_restaurant=id;
	}
	public String getNom_restaurant() {
		return nom_restaurant;
	}
	public void setNom_restaurant(String nom_restaurant) {
		this.nom_restaurant = nom_restaurant;
	}
	public String getAdresse_restaurant() {
		return adresse_restaurant;
	}
	public void setAdresse_restaurant(String adresse_restaurant) {
		this.adresse_restaurant = adresse_restaurant;
	}
	public String getTel_restaurant() {
		return tel_restaurant;
	}
	public void setTel_restaurant(String tel_restaurant) {
		this.tel_restaurant = tel_restaurant;
	}
	public String getLogin_restaurant() {
		return login_restaurant;
	}
	public void setLogin_restaurant(String login_restaurant) {
		this.login_restaurant = login_restaurant;
	}
	public String getPass_restaurant() {
		return pass_restaurant;
	}
	public void setPass_restaurant(String pass_restaurant) {
		this.pass_restaurant = pass_restaurant;
	}
	public String getEmail_restaurant() {
		return email_restaurant;
	}
	public void setEmail_restaurant(String email_restaurant) {
		this.email_restaurant = email_restaurant;
	}
	

	public Restaurant() {
		super();
	}
	public Restaurant(String nom_restaurant, String adresse_restaurant, String tel_restaurant, String login_restaurant,
			String pass_restaurant, String email_restaurant) {
		super();
		this.nom_restaurant = nom_restaurant;
		this.adresse_restaurant = adresse_restaurant;
		this.tel_restaurant = tel_restaurant;
		this.login_restaurant = login_restaurant;
		this.pass_restaurant = pass_restaurant;
		this.email_restaurant = email_restaurant;
	}
	
	
	
		
}
