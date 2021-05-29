package classes;

public class AdminC {
	private int idadmin;
	private String adadmin;
	private String emailadmin;
	private String sifreadmin;
	public AdminC() {
		super();
	}
	public AdminC(int idadmin, String adadmin, String emailadmin, String sifreadmin) {
		super();
		this.idadmin = idadmin;
		this.adadmin = adadmin;
		this.emailadmin = emailadmin;
		this.sifreadmin = sifreadmin;
	}
	public int getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}
	public String getAdadmin() {
		return adadmin;
	}
	public void setAdadmin(String adadmin) {
		this.adadmin = adadmin;
	}
	public String getEmailadmin() {
		return emailadmin;
	}
	public void setEmailadmin(String emailadmin) {
		this.emailadmin = emailadmin;
	}
	public String getSifreadmin() {
		return sifreadmin;
	}
	public void setSifreadmin(String sifreadmin) {
		this.sifreadmin = sifreadmin;
	}
	

}
