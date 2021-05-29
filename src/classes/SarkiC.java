package classes;

public class SarkiC {
	private String idsarki;
	private String tarihsarki;
	private String sanatcisarki;
	private String turalbums;
	private String suresarki;
	private int dinlenmesayisi;
	public SarkiC() {
		super();
	}
	public SarkiC(String idsarki, String tarihsarki, String sanatcisarki, String turalbums, String suresarki,
			int dinlenmesayisi) {
		super();
		this.idsarki = idsarki;
		this.tarihsarki = tarihsarki;
		this.sanatcisarki = sanatcisarki;
		this.turalbums = turalbums;
		this.suresarki = suresarki;
		this.dinlenmesayisi = dinlenmesayisi;
	}

	public String getIdsarki() {
		return idsarki;
	}
	public void setIdsarki(String idsarki) {
		this.idsarki = idsarki;
	}
	public String getTarihsarki() {
		return tarihsarki;
	}
	public void setTarihsarki(String tarihsarki) {
		this.tarihsarki = tarihsarki;
	}
	public String getSanatcisarki() {
		return sanatcisarki;
	}
	public void setSanatcisarki(String sanatcisarki) {
		this.sanatcisarki = sanatcisarki;
	}
	public String getTuralbums() {
		return turalbums;
	}
	public void setTuralbums(String turalbums) {
		this.turalbums = turalbums;
	}
	public String getSuresarki() {
		return suresarki;
	}
	public void setSuresarki(String suresarki) {
		this.suresarki = suresarki;
	}
	public int getDinlenmesayisi() {
		return dinlenmesayisi;
	}
	public void setDinlenmesayisi(int dinlenmesayisi) {
		this.dinlenmesayisi = dinlenmesayisi;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(sanatcisarki==null && turalbums==null && tarihsarki==null && suresarki==null && dinlenmesayisi==0) 
		{
			return idsarki;
		}
		return "Şarkı ID : "+idsarki + " Sanatci ID : " + sanatcisarki + " Album Tur : " + turalbums + " Şarkı Tarih : " + tarihsarki + " Şarkı Süre : " + suresarki + " Dinlenme Sayısı : " + dinlenmesayisi;
	}
	

}
