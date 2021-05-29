package classes;

public class AlbumC {
	private String idalbum;
	private String adalbum;
	private String sanatciadalbum;
	private String sarkialbum;
	private String tarihalbum;
	private String turalbum;
	public AlbumC() {
		super();
	}
	public AlbumC(String idalbum, String adalbum, String sanatciadalbum, String sarkialbum, String tarihalbum,
			String turalbum) {
		super();
		this.idalbum = idalbum;
		this.adalbum = adalbum;
		this.sanatciadalbum = sanatciadalbum;
		this.sarkialbum = sarkialbum;
		this.tarihalbum = tarihalbum;
		this.turalbum = turalbum;
	}
	public String getIdalbum() {
		return idalbum;
	}
	public void setIdalbum(String idalbum) {
		this.idalbum = idalbum;
	}
	public String getAdalbum() {
		return adalbum;
	}
	public void setAdalbum(String adalbum) {
		this.adalbum = adalbum;
	}
	public String getSanatciadalbum() {
		return sanatciadalbum;
	}
	public void setSanatciadalbum(String sanatciadalbum) {
		this.sanatciadalbum = sanatciadalbum;
	}
	public String getSarkialbum() {
		return sarkialbum;
	}
	public void setSarkialbum(String sarkialbum) {
		this.sarkialbum = sarkialbum;
	}
	public String getTarihalbum() {
		return tarihalbum;
	}
	public void setTarihalbum(String tarihalbum) {
		this.tarihalbum = tarihalbum;
	}
	public String getTuralbum() {
		return turalbum;
	}
	public void setTuralbum(String turalbum) {
		this.turalbum = turalbum;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Album ID : " + idalbum + " Album Ad : " +adalbum + " Sanatçı Ad : " + sanatciadalbum + " Sarki : " + sarkialbum + " Tarih : " + tarihalbum + " Tur : " + turalbum;
	}
	

}
