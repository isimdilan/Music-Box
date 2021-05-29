package classes;

public class TakipEttikleriC {
	private String kullanicisi;
	private String kullaniciid;
	private String takipedilenkullanici;
	public TakipEttikleriC() {
		super();
	}
	public TakipEttikleriC(String kullanicisi, String kullaniciid, String takipedilenkullanici) {
		super();
		this.kullanicisi = kullanicisi;
		this.kullaniciid = kullaniciid;
		this.takipedilenkullanici = takipedilenkullanici;
	}
	public String getKullanicisi() {
		return kullanicisi;
	}
	public void setKullanicisi(String kullanicisi) {
		this.kullanicisi = kullanicisi;
	}
	public String getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(String kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public String getTakipedilenkullanici() {
		return takipedilenkullanici;
	}
	public void setTakipedilenkullanici(String takipedilenkullanici) {
		this.takipedilenkullanici = takipedilenkullanici;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Tadkip Edilen : " +takipedilenkullanici+ " Kullanıcı Adı : " + kullaniciid;
	}

}
