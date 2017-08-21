package Class;

public class Client {
	private int id_client;
	private String nom_client;
	private String prenom_client;
	private String adresse_client;
	private String tel_client;
	private String login_cli;
	private String pass_cli;
	
	public Client(String nom_client, String prenom_client, String adresse_client, String tel_client,String login_cli,String pass_cli) {
		super();
		this.nom_client = nom_client;
		this.prenom_client = prenom_client;
		this.adresse_client = adresse_client;
		this.tel_client = tel_client;
		this.login_cli=login_cli;
		this.pass_cli=pass_cli;
	}

	public Client() {}

	public String getNom_client() {
		return nom_client;
	}

	public void setNom_client(String nom_client) {
		this.nom_client = nom_client;
	}

	public String getPrenom_client() {
		return prenom_client;
	}

	public void setPrenom_client(String prenom_client) {
		this.prenom_client = prenom_client;
	}

	public String getAdresse_client() {
		return adresse_client;
	}

	public void setAdresse_client(String adresse_client) {
		this.adresse_client = adresse_client;
	}

	public String getTel_client() {
		return tel_client;
	}

	public void setTel_client(String tel_client) {
		this.tel_client = tel_client;
	}

	public int getId_cli() {
		return id_client;
	}
	public void setId_cli(int id){
		this.id_client=id;
	}

	public String getLogin_cli() {
		return login_cli;
	}

	public void setLogin_cli(String login_cli) {
		this.login_cli = login_cli;
	}

	public String getPass_cli() {
		return pass_cli;
	}

	public void setPass_cli(String pass_cli) {
		this.pass_cli = pass_cli;
	}

}
