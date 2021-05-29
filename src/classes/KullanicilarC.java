package classes;

public class KullanicilarC {
	private int idkullanicilar;
	private String kullaniciemail;
	private String kullaniciadi;
	private String kullanicisifre;
	private String kullaniciaboneliktur;
	public KullanicilarC() {
		super();
	}
	
	
	public KullanicilarC(int idkullanicilar, String kullaniciemail, String kullaniciadi, String kullanicisifre,
			String kullaniciaboneliktur) {
		super();
		this.idkullanicilar = idkullanicilar;
		this.kullaniciemail = kullaniciemail;
		this.kullaniciadi = kullaniciadi;
		this.kullanicisifre = kullanicisifre;
		this.kullaniciaboneliktur = kullaniciaboneliktur;
	}


	public String getKullaniciemail() {
		return kullaniciemail;
	}
	public void setKullaniciemail(String kullaniciemail) {
		this.kullaniciemail = kullaniciemail;
	}
	public String getKullaniciadi() {
		return kullaniciadi;
	}
	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}
	public String getKullanicisifre() {
		return kullanicisifre;
	}
	public void setKullanicisifre(String kullanicisifre) {
		this.kullanicisifre = kullanicisifre;
	}
	public String getKullaniciaboneliktur() {
		return kullaniciaboneliktur;
	}
	public void setKullaniciaboneliktur(String kullaniciaboneliktur) {
		this.kullaniciaboneliktur = kullaniciaboneliktur;
	}


	public int getIdkullanicilar() {
		return idkullanicilar;
	}


	public void setIdkullanicilar(int idkullanicilar) {
		this.idkullanicilar = idkullanicilar;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Kullanıcı :   "+ kullaniciemail;
	}
	

}
