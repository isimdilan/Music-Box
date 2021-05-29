package classes;

public class CazC {
	private String kullanicisi;
	private String sarkiidsi;
	private String sarkitur;
	private int dinlenmesayisi;
	private String ulkesarki;
	public CazC() {
		super();
	}
	public CazC(String kullanicisi, String sarkiidsi, String sarkitur,int dinlenmesayisi,String ulkesarki) {
		super();
		this.kullanicisi = kullanicisi;
		this.sarkiidsi = sarkiidsi;
		this.sarkitur = sarkitur;
		this.dinlenmesayisi=dinlenmesayisi;
		this.ulkesarki=ulkesarki;
	}
	public String getKullanicisi() {
		return kullanicisi;
	}
	public void setKullanicisi(String kullanicisi) {
		this.kullanicisi = kullanicisi;
	}
	public String getSarkiidsi() {
		return sarkiidsi;
	}
	public void setSarkiidsi(String sarkiidsi) {
		this.sarkiidsi = sarkiidsi;
	}
	public String getSarkitur() {
		return sarkitur;
	}
	public void setSarkitur(String sarkitur) {
		this.sarkitur = sarkitur;
	}
	public int getDinlenmesayisi() {
		return dinlenmesayisi;
	}
	public void setDinlenmesayisi(int dinlenmesayisi) {
		this.dinlenmesayisi = dinlenmesayisi;
	}
	
	public String getUlkesarki() {
		return ulkesarki;
	}
	public void setUlkesarki(String ulkesarki) {
		this.ulkesarki = ulkesarki;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Şarkı ID : " + sarkiidsi + " Şarkı Tur : " + sarkitur + " Dinlenme Sayısı : " + dinlenmesayisi;
	}

}
